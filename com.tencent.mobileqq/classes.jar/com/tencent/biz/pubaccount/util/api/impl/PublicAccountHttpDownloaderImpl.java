package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptBitmapFile;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.nearby.now.utils.IIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.util.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class PublicAccountHttpDownloaderImpl
  extends HttpDownloader
  implements IPublicAccountHttpDownloader
{
  public static final String TAG = "PubAccountHttpDownloader";
  private BaseApplicationImpl application = BaseApplicationImpl.getApplication();
  
  public PublicAccountHttpDownloaderImpl()
  {
    this.mSupportInnerIp = ((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).useInnerDns();
  }
  
  private File getBitmapFile(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null) {
      return new RIJImageOptBitmapFile(paramArrayOfByte, paramLong);
    }
    return null;
  }
  
  private byte[] getByteArrayInputStream(InputStream paramInputStream, long paramLong)
  {
    return ((IIOUtils)QRoute.api(IIOUtils.class)).readBytes(paramInputStream, (int)paramLong);
  }
  
  private String getNetIdentifier()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.getSystemNetwork(localContext));
    String str1 = str2;
    if (!StringUtil.a(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = DeviceInfoUtil.b(localContext);
      }
    }
    return str1;
  }
  
  private void hook(URL paramURL)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = InnerDns.getInstance().reqSerAddrList(paramURL.getHost(), 1002);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
        {
          Object localObject2 = new ArrayList();
          localObject1 = InetAddress.getAllByName(paramURL.getHost());
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int k = localObject1.length;
            int i = 0;
            if (i < k)
            {
              localHashMap1 = localObject1[i];
              localObject3 = new IpData();
              ((IpData)localObject3).mIp = localHashMap1.getHostAddress();
              ((IpData)localObject3).mPort = 80;
              if (!IPAddressUtil.isIPv4LiteralAddress(((IpData)localObject3).mIp)) {
                break label293;
              }
              j = 1;
              ((IpData)localObject3).mType = j;
              ((ArrayList)localObject2).add(localObject3);
              i += 1;
              continue;
            }
            localObject2 = new DomainData(paramURL.getHost(), (ArrayList)localObject2);
            HashMap localHashMap1 = (HashMap)Reflect.on(InnerDns.getInstance()).get("mNetMap");
            Object localObject3 = getNetIdentifier();
            if (localHashMap1 != null) {
              if (localHashMap1.containsKey(localObject3))
              {
                ((HashMap)localHashMap1.get(localObject3)).put(paramURL.getHost(), localObject2);
              }
              else
              {
                HashMap localHashMap2 = new HashMap();
                localHashMap2.put(paramURL.getHost(), localObject2);
                localHashMap1.put(localObject3, localHashMap2);
              }
            }
            paramURL = new StringBuilder();
            paramURL.append("hook success: ");
            paramURL.append(Arrays.toString((Object[])localObject1));
            QLog.d("PubAccountHttpDownloader", 1, paramURL.toString());
            return;
          }
        }
      }
      catch (Exception paramURL)
      {
        QLog.d("PubAccountHttpDownloader", 1, paramURL.getMessage());
      }
      return;
      label293:
      int j = 28;
    }
  }
  
  private void saveFileInSingleThread(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new PublicAccountHttpDownloaderImpl.1(this, paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong));
  }
  
  public void copyRespInfo(NetResp paramNetResp, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler))
    {
      paramURLDrawableHandler = (PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler;
      PublicAccountHttpDownloaderImpl.PubAccoutImageReporter localPubAccoutImageReporter = paramURLDrawableHandler.a();
      if (localPubAccoutImageReporter != null)
      {
        localPubAccoutImageReporter.a(paramNetResp, paramNetResp.mErrDesc);
        paramNetResp = new StringBuilder();
        paramNetResp.append("image/");
        paramNetResp.append(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.a(localPubAccoutImageReporter));
        paramURLDrawableHandler.a(paramNetResp.toString());
      }
    }
  }
  
  /* Error */
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 278	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: astore 8
    //   6: aload 8
    //   8: astore 11
    //   10: aload 8
    //   12: ldc_w 280
    //   15: invokevirtual 283	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18: ifeq +12 -> 30
    //   21: aload_2
    //   22: getfield 287	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   25: invokevirtual 290	java/net/URL:getFile	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload 11
    //   32: invokestatic 295	com/tencent/util/URLUtil:a	(Ljava/lang/String;)Ljava/util/Map;
    //   35: astore 8
    //   37: aload 8
    //   39: ldc_w 297
    //   42: invokeinterface 300 2 0
    //   47: ifnull +93 -> 140
    //   50: aload 8
    //   52: ldc_w 297
    //   55: invokeinterface 300 2 0
    //   60: checkcast 85	java/lang/String
    //   63: invokestatic 306	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   66: istore 4
    //   68: goto +75 -> 143
    //   71: astore 9
    //   73: new 197	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   80: astore 10
    //   82: aload 10
    //   84: ldc_w 308
    //   87: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 10
    //   93: aload 11
    //   95: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 10
    //   101: ldc_w 310
    //   104: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 10
    //   110: aload 8
    //   112: ldc_w 297
    //   115: invokeinterface 300 2 0
    //   120: checkcast 85	java/lang/String
    //   123: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 10
    //   129: iconst_2
    //   130: aload 10
    //   132: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aload 9
    //   137: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: iconst_m1
    //   141: istore 4
    //   143: aload_2
    //   144: new 117	java/net/URL
    //   147: dup
    //   148: aload 11
    //   150: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   153: putfield 287	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   156: aload_2
    //   157: aload 11
    //   159: putfield 278	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   162: new 254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter
    //   165: dup
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 24	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   171: iload 4
    //   173: invokespecial 319	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl;Lcom/tencent/common/app/BaseApplicationImpl;I)V
    //   176: astore 14
    //   178: aload 14
    //   180: aload_2
    //   181: aload 8
    //   183: invokevirtual 322	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/image/DownloadParams;Ljava/util/Map;)V
    //   186: aload_2
    //   187: getfield 326	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   190: astore 8
    //   192: iconst_0
    //   193: istore 5
    //   195: aload 8
    //   197: ifnull +64 -> 261
    //   200: aload_2
    //   201: getfield 326	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   204: astore 8
    //   206: aload 8
    //   208: arraylength
    //   209: istore 6
    //   211: iconst_0
    //   212: istore 4
    //   214: iload 4
    //   216: iload 6
    //   218: if_icmpge +43 -> 261
    //   221: aload 8
    //   223: iload 4
    //   225: aaload
    //   226: astore 9
    //   228: ldc_w 328
    //   231: aload 9
    //   233: invokeinterface 333 1 0
    //   238: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +11 -> 252
    //   244: aload 9
    //   246: invokeinterface 336 1 0
    //   251: pop
    //   252: iload 4
    //   254: iconst_1
    //   255: iadd
    //   256: istore 4
    //   258: goto -44 -> 214
    //   261: new 338	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$CountOutputStreamWapper
    //   264: dup
    //   265: aload_0
    //   266: aload_1
    //   267: invokespecial 341	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$CountOutputStreamWapper:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl;Ljava/io/OutputStream;)V
    //   270: astore 12
    //   272: aconst_null
    //   273: astore 8
    //   275: iconst_1
    //   276: istore 4
    //   278: iload 4
    //   280: iconst_1
    //   281: isub
    //   282: istore 6
    //   284: aload 8
    //   286: astore 9
    //   288: iload 4
    //   290: ifle +510 -> 800
    //   293: iload 5
    //   295: iconst_1
    //   296: iadd
    //   297: istore 5
    //   299: aload 8
    //   301: astore 9
    //   303: aload 14
    //   305: invokevirtual 343	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	()V
    //   308: aload 8
    //   310: astore 9
    //   312: aload_0
    //   313: getfield 40	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:mSupportInnerIp	Z
    //   316: ifeq +35 -> 351
    //   319: aload 8
    //   321: astore 9
    //   323: ldc 26
    //   325: invokestatic 32	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   328: checkcast 26	com/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig
    //   331: invokeinterface 346 1 0
    //   336: ifeq +15 -> 351
    //   339: aload 8
    //   341: astore 9
    //   343: aload_0
    //   344: aload_2
    //   345: getfield 287	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   348: invokespecial 348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:hook	(Ljava/net/URL;)V
    //   351: aload 8
    //   353: astore 10
    //   355: aload 8
    //   357: astore 9
    //   359: aload_0
    //   360: aload 12
    //   362: aload_2
    //   363: aload 14
    //   365: aload_3
    //   366: invokevirtual 351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/image/URLDrawableHandler;)Lcom/tencent/image/URLDrawableHandler;
    //   369: invokespecial 353	com/tencent/mobileqq/transfile/HttpDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   372: astore 8
    //   374: aload 8
    //   376: ifnull +27 -> 403
    //   379: aload 8
    //   381: astore 10
    //   383: aload 8
    //   385: astore 9
    //   387: aload 8
    //   389: instanceof 60
    //   392: istore 7
    //   394: iload 6
    //   396: istore 4
    //   398: iload 7
    //   400: ifeq +6 -> 406
    //   403: iconst_m1
    //   404: istore 4
    //   406: aload_0
    //   407: getfield 357	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   410: invokevirtual 361	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   413: ifeq +6 -> 419
    //   416: goto +310 -> 726
    //   419: iload 4
    //   421: iconst_m1
    //   422: if_icmpeq +30 -> 452
    //   425: iload 4
    //   427: ifne +6 -> 433
    //   430: goto +22 -> 452
    //   433: ldc2_w 362
    //   436: invokestatic 369	java/lang/Thread:sleep	(J)V
    //   439: goto +39 -> 478
    //   442: astore 9
    //   444: aload 9
    //   446: invokevirtual 372	java/lang/InterruptedException:printStackTrace	()V
    //   449: goto +29 -> 478
    //   452: aload 14
    //   454: invokestatic 375	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   457: ifeq +13 -> 470
    //   460: aload_2
    //   461: getfield 378	com/tencent/image/DownloadParams:retryCount	I
    //   464: getstatic 383	com/tencent/mobileqq/kandian/base/image/ImageRequest:g	I
    //   467: if_icmpne +11 -> 478
    //   470: aload 14
    //   472: iload 5
    //   474: aload_2
    //   475: invokevirtual 386	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   478: goto +224 -> 702
    //   481: astore 13
    //   483: aload 10
    //   485: astore 8
    //   487: goto +9 -> 496
    //   490: astore_1
    //   491: goto +221 -> 712
    //   494: astore 13
    //   496: aload 8
    //   498: astore 9
    //   500: aload 13
    //   502: invokevirtual 387	java/io/IOException:getMessage	()Ljava/lang/String;
    //   505: ldc_w 389
    //   508: invokevirtual 393	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   511: ifeq +6 -> 517
    //   514: goto +18 -> 532
    //   517: aload 8
    //   519: astore 9
    //   521: aload 14
    //   523: iconst_m1
    //   524: aload 13
    //   526: invokevirtual 387	java/io/IOException:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 396	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILjava/lang/String;)V
    //   532: iload 6
    //   534: ifeq +171 -> 705
    //   537: aload 8
    //   539: astore 9
    //   541: aload_1
    //   542: checkcast 398	java/io/FileOutputStream
    //   545: invokevirtual 402	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   548: astore 10
    //   550: aload 8
    //   552: astore 9
    //   554: aload 10
    //   556: lconst_0
    //   557: invokevirtual 408	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   560: pop
    //   561: goto +65 -> 626
    //   564: astore 10
    //   566: goto +5 -> 571
    //   569: astore 10
    //   571: aload 8
    //   573: astore 9
    //   575: new 197	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   582: astore 13
    //   584: aload 8
    //   586: astore 9
    //   588: aload 13
    //   590: ldc_w 308
    //   593: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 8
    //   599: astore 9
    //   601: aload 13
    //   603: aload 11
    //   605: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 8
    //   611: astore 9
    //   613: ldc 10
    //   615: iconst_2
    //   616: aload 13
    //   618: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: aload 10
    //   623: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: aload_0
    //   627: getfield 357	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   630: invokevirtual 361	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   633: ifeq +6 -> 639
    //   636: goto +90 -> 726
    //   639: iload 6
    //   641: iconst_m1
    //   642: if_icmpeq +30 -> 672
    //   645: iload 6
    //   647: ifne +6 -> 653
    //   650: goto +22 -> 672
    //   653: ldc2_w 362
    //   656: invokestatic 369	java/lang/Thread:sleep	(J)V
    //   659: goto +39 -> 698
    //   662: astore 9
    //   664: aload 9
    //   666: invokevirtual 372	java/lang/InterruptedException:printStackTrace	()V
    //   669: goto +29 -> 698
    //   672: aload 14
    //   674: invokestatic 375	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   677: ifeq +13 -> 690
    //   680: aload_2
    //   681: getfield 378	com/tencent/image/DownloadParams:retryCount	I
    //   684: getstatic 383	com/tencent/mobileqq/kandian/base/image/ImageRequest:g	I
    //   687: if_icmpne +11 -> 698
    //   690: aload 14
    //   692: iload 5
    //   694: aload_2
    //   695: invokevirtual 386	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   698: iload 6
    //   700: istore 4
    //   702: goto -424 -> 278
    //   705: aload 8
    //   707: astore 9
    //   709: aload 13
    //   711: athrow
    //   712: aload_0
    //   713: getfield 357	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   716: invokevirtual 361	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   719: ifeq +22 -> 741
    //   722: aload 9
    //   724: astore 8
    //   726: aload 14
    //   728: iload 5
    //   730: aload_2
    //   731: invokevirtual 386	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   734: aload 8
    //   736: astore 9
    //   738: goto +62 -> 800
    //   741: iload 6
    //   743: iconst_m1
    //   744: if_icmpeq +28 -> 772
    //   747: iload 6
    //   749: ifne +6 -> 755
    //   752: goto +20 -> 772
    //   755: ldc2_w 362
    //   758: invokestatic 369	java/lang/Thread:sleep	(J)V
    //   761: goto +37 -> 798
    //   764: astore_2
    //   765: aload_2
    //   766: invokevirtual 372	java/lang/InterruptedException:printStackTrace	()V
    //   769: goto +29 -> 798
    //   772: aload 14
    //   774: invokestatic 375	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   777: ifeq +13 -> 790
    //   780: aload_2
    //   781: getfield 378	com/tencent/image/DownloadParams:retryCount	I
    //   784: getstatic 383	com/tencent/mobileqq/kandian/base/image/ImageRequest:g	I
    //   787: if_icmpne +11 -> 798
    //   790: aload 14
    //   792: iload 5
    //   794: aload_2
    //   795: invokevirtual 386	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   798: aload_1
    //   799: athrow
    //   800: aload_0
    //   801: getfield 357	com/tencent/biz/pubaccount/util/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   804: invokevirtual 361	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   807: ifne +6 -> 813
    //   810: aload 9
    //   812: areturn
    //   813: new 271	java/io/IOException
    //   816: dup
    //   817: ldc_w 410
    //   820: invokespecial 411	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   823: astore_1
    //   824: goto +5 -> 829
    //   827: aload_1
    //   828: athrow
    //   829: goto -2 -> 827
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	PublicAccountHttpDownloaderImpl
    //   0	832	1	paramOutputStream	OutputStream
    //   0	832	2	paramDownloadParams	DownloadParams
    //   0	832	3	paramURLDrawableHandler	URLDrawableHandler
    //   66	635	4	i	int
    //   193	600	5	j	int
    //   209	539	6	k	int
    //   392	7	7	bool	boolean
    //   4	731	8	localObject1	Object
    //   71	65	9	localNumberFormatException	java.lang.NumberFormatException
    //   226	160	9	localObject2	Object
    //   442	3	9	localInterruptedException1	java.lang.InterruptedException
    //   498	114	9	localObject3	Object
    //   662	3	9	localInterruptedException2	java.lang.InterruptedException
    //   707	104	9	localObject4	Object
    //   80	475	10	localObject5	Object
    //   564	1	10	localException1	Exception
    //   569	53	10	localException2	Exception
    //   8	596	11	localObject6	Object
    //   270	91	12	localCountOutputStreamWapper	PublicAccountHttpDownloaderImpl.CountOutputStreamWapper
    //   481	1	13	localIOException1	java.io.IOException
    //   494	31	13	localIOException2	java.io.IOException
    //   582	128	13	localStringBuilder	StringBuilder
    //   176	615	14	localPubAccoutImageReporter	PublicAccountHttpDownloaderImpl.PubAccoutImageReporter
    // Exception table:
    //   from	to	target	type
    //   50	68	71	java/lang/NumberFormatException
    //   433	439	442	java/lang/InterruptedException
    //   359	374	481	java/io/IOException
    //   387	394	481	java/io/IOException
    //   303	308	490	finally
    //   312	319	490	finally
    //   323	339	490	finally
    //   343	351	490	finally
    //   359	374	490	finally
    //   387	394	490	finally
    //   500	514	490	finally
    //   521	532	490	finally
    //   541	550	490	finally
    //   554	561	490	finally
    //   575	584	490	finally
    //   588	597	490	finally
    //   601	609	490	finally
    //   613	626	490	finally
    //   709	712	490	finally
    //   303	308	494	java/io/IOException
    //   312	319	494	java/io/IOException
    //   323	339	494	java/io/IOException
    //   343	351	494	java/io/IOException
    //   554	561	564	java/lang/Exception
    //   541	550	569	java/lang/Exception
    //   653	659	662	java/lang/InterruptedException
    //   755	761	764	java/lang/InterruptedException
  }
  
  @Nullable
  protected File getDownloadFile(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    if (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isDecodeHttpStream())
    {
      byte[] arrayOfByte = getByteArrayInputStream(paramInputStream, paramLong);
      QLog.d("PubAccountHttpDownloader", 1, "read into memory done");
      if (arrayOfByte != null)
      {
        saveFileInSingleThread(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, new ByteArrayInputStream(arrayOfByte), paramLong);
        return getBitmapFile(arrayOfByte, paramLong);
      }
    }
    return super.getDownloadFile(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong);
  }
  
  public HttpDownloader getHttpDownloader()
  {
    return this;
  }
  
  protected boolean isCommitBimapFileAsyn(File paramFile)
  {
    return paramFile instanceof RIJImageOptBitmapFile;
  }
  
  public URL makeURL(String paramString, int paramInt)
  {
    return makeURL(paramString, paramInt, null);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject)
  {
    return makeURL(paramString, paramInt, paramObject, false);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject, boolean paramBoolean)
  {
    Object localObject1 = null;
    paramObject = localObject1;
    try
    {
      if (!paramString.startsWith("http"))
      {
        paramObject = localObject1;
        if (!paramString.startsWith("https"))
        {
          paramObject = localObject1;
          return new URL(paramString);
        }
      }
      paramObject = localObject1;
      Object localObject2 = URLUtil.a(paramString);
      paramObject = localObject1;
      if (((Map)localObject2).containsKey("busiType"))
      {
        paramObject = localObject1;
        StringBuilder localStringBuilder = new StringBuilder();
        paramObject = localObject1;
        localStringBuilder.append("busiType=");
        paramObject = localObject1;
        localStringBuilder.append((String)((Map)localObject2).get("busiType"));
        paramObject = localObject1;
        localObject2 = localStringBuilder.toString();
        paramObject = localObject1;
        localStringBuilder = new StringBuilder();
        paramObject = localObject1;
        localStringBuilder.append("busiType=");
        paramObject = localObject1;
        localStringBuilder.append(paramInt);
        paramObject = localObject1;
        paramString = paramString.replace((CharSequence)localObject2, localStringBuilder.toString());
      }
      else
      {
        paramObject = localObject1;
        localObject2 = new StringBuilder();
        paramObject = localObject1;
        ((StringBuilder)localObject2).append(paramInt);
        paramObject = localObject1;
        ((StringBuilder)localObject2).append("");
        paramObject = localObject1;
        paramString = URLUtil.a(paramString, "busiType", ((StringBuilder)localObject2).toString());
      }
      if (!paramBoolean)
      {
        paramObject = localObject1;
        paramString = new URL("pubaccountimage", null, paramString);
      }
      else
      {
        paramObject = localObject1;
        paramString = new URL(paramString);
      }
      paramObject = paramString;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        paramObject = paramString;
        localObject1 = new StringBuilder();
        paramObject = paramString;
        ((StringBuilder)localObject1).append("<--generateURL urlString =");
        paramObject = paramString;
        ((StringBuilder)localObject1).append(paramString.toString());
        paramObject = paramString;
        QLog.d("PubAccountHttpDownloader", 2, ((StringBuilder)localObject1).toString());
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      localObject1 = paramObject;
      if (QLog.isColorLevel())
      {
        QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramString);
        localObject1 = paramObject;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */