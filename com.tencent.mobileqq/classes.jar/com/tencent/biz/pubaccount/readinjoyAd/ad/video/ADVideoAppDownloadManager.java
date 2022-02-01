package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoAppDownloadManager
  implements IADVideoAppDownloadManager, DownloadListener
{
  private static AtomicInteger d = new AtomicInteger(0);
  protected List<ADVideoAppDownloadData> a = new CopyOnWriteArrayList();
  protected List<ADVideoAppDownloadManager.LoadTask> b = new CopyOnWriteArrayList();
  protected ConcurrentHashMap<String, ADVideoAppDownloadData> c = new ConcurrentHashMap();
  private Context e;
  private Handler f;
  private boolean g = false;
  private ADVideoAppUIPresenter h;
  private ADVideoAppDownloadData i;
  private boolean j;
  private int k = 0;
  private boolean l = false;
  private Runnable m = new ADVideoAppDownloadManager.1(this);
  private ITMAssistantDownloadClientListener n = new ADVideoAppDownloadManager.3(this);
  
  public ADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    this.e = paramContext;
    this.g = paramBoolean;
    this.f = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private DownloadInfo a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.e = paramADVideoAppDownloadData.d;
    localDownloadInfo.t = paramInt;
    localDownloadInfo.c = paramADVideoAppDownloadData.a;
    return localDownloadInfo;
  }
  
  private String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  private String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 6
    //   14: iload_3
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +53 -> 76
    //   26: new 164	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 167
    //   39: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_1
    //   46: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 172
    //   54: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: iload_2
    //   61: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 177
    //   67: iconst_2
    //   68: aload 4
    //   70: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: ldc 183
    //   78: ldc 185
    //   80: invokestatic 191	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: goto +14 -> 99
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   95: ldc 196
    //   97: astore 4
    //   99: new 164	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   106: astore 5
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 5
    //   117: ldc 198
    //   119: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 5
    //   125: aload 4
    //   127: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 5
    //   133: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_1
    //   137: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +38 -> 178
    //   143: new 164	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: ldc 200
    //   156: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: aload_1
    //   163: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 177
    //   169: iconst_2
    //   170: aload 4
    //   172: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: new 202	java/net/URL
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 205	java/net/URL:<init>	(Ljava/lang/String;)V
    //   186: invokevirtual 209	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   189: checkcast 211	java/net/HttpURLConnection
    //   192: astore 5
    //   194: aload 5
    //   196: astore 4
    //   198: aload 5
    //   200: ldc 213
    //   202: invokevirtual 216	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   205: aload 5
    //   207: astore 4
    //   209: aload 5
    //   211: ldc 218
    //   213: ldc 220
    //   215: invokevirtual 224	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 5
    //   220: astore 4
    //   222: aload 5
    //   224: ldc 226
    //   226: ldc 228
    //   228: invokevirtual 224	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 5
    //   233: astore 4
    //   235: aload 5
    //   237: ldc 230
    //   239: ldc 232
    //   241: invokevirtual 224	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 5
    //   246: astore 4
    //   248: aload 5
    //   250: sipush 3000
    //   253: invokevirtual 235	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   256: aload 5
    //   258: astore 4
    //   260: aload 5
    //   262: sipush 3000
    //   265: invokevirtual 238	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   268: aload 5
    //   270: astore 4
    //   272: aload 5
    //   274: invokevirtual 242	java/net/HttpURLConnection:getResponseCode	()I
    //   277: sipush 200
    //   280: if_icmpne +75 -> 355
    //   283: aload 5
    //   285: astore 4
    //   287: aload_0
    //   288: aload 5
    //   290: invokevirtual 246	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   293: invokespecial 248	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   296: astore_1
    //   297: aload 5
    //   299: astore 4
    //   301: aload_1
    //   302: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +31 -> 336
    //   308: aload 5
    //   310: astore 4
    //   312: new 250	org/json/JSONObject
    //   315: dup
    //   316: aload_1
    //   317: invokespecial 251	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: aload 5
    //   323: astore 4
    //   325: getstatic 256	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;
    //   328: aload_1
    //   329: invokevirtual 259	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   332: astore_1
    //   333: goto +77 -> 410
    //   336: aload 5
    //   338: astore 4
    //   340: ldc 177
    //   342: iconst_1
    //   343: ldc_w 261
    //   346: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 6
    //   351: astore_1
    //   352: goto +58 -> 410
    //   355: aload 5
    //   357: astore 4
    //   359: new 164	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   366: astore_1
    //   367: aload 5
    //   369: astore 4
    //   371: aload_1
    //   372: ldc_w 263
    //   375: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 5
    //   381: astore 4
    //   383: aload_1
    //   384: aload 5
    //   386: invokevirtual 242	java/net/HttpURLConnection:getResponseCode	()I
    //   389: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 5
    //   395: astore 4
    //   397: ldc 177
    //   399: iconst_1
    //   400: aload_1
    //   401: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 6
    //   409: astore_1
    //   410: aload_1
    //   411: astore 4
    //   413: aload 5
    //   415: ifnull +103 -> 518
    //   418: aload_1
    //   419: astore 4
    //   421: aload 5
    //   423: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   426: aload 4
    //   428: areturn
    //   429: astore 6
    //   431: aload 5
    //   433: astore_1
    //   434: goto +14 -> 448
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 4
    //   441: goto +81 -> 522
    //   444: astore 6
    //   446: aconst_null
    //   447: astore_1
    //   448: aload_1
    //   449: astore 4
    //   451: new 164	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   458: astore 5
    //   460: aload_1
    //   461: astore 4
    //   463: aload 5
    //   465: ldc_w 268
    //   468: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload_1
    //   473: astore 4
    //   475: aload 5
    //   477: aload 6
    //   479: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   482: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_1
    //   487: astore 4
    //   489: ldc 177
    //   491: iconst_1
    //   492: aload 5
    //   494: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload 8
    //   502: astore 4
    //   504: aload_1
    //   505: ifnull +13 -> 518
    //   508: aload 7
    //   510: astore 4
    //   512: aload_1
    //   513: astore 5
    //   515: goto -94 -> 421
    //   518: aload 4
    //   520: areturn
    //   521: astore_1
    //   522: aload 4
    //   524: ifnull +8 -> 532
    //   527: aload 4
    //   529: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   532: goto +5 -> 537
    //   535: aload_1
    //   536: athrow
    //   537: goto -2 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	ADVideoAppDownloadManager
    //   0	540	1	paramString	String
    //   0	540	2	paramInt	int
    //   4	11	3	bool	boolean
    //   33	51	4	localObject1	Object
    //   88	3	4	localException1	java.lang.Exception
    //   97	431	4	localObject2	Object
    //   106	408	5	localObject3	Object
    //   12	396	6	localObject4	Object
    //   429	1	6	localException2	java.lang.Exception
    //   444	34	6	localException3	java.lang.Exception
    //   6	503	7	localObject5	Object
    //   9	492	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   76	85	88	java/lang/Exception
    //   198	205	429	java/lang/Exception
    //   209	218	429	java/lang/Exception
    //   222	231	429	java/lang/Exception
    //   235	244	429	java/lang/Exception
    //   248	256	429	java/lang/Exception
    //   260	268	429	java/lang/Exception
    //   272	283	429	java/lang/Exception
    //   287	297	429	java/lang/Exception
    //   301	308	429	java/lang/Exception
    //   312	321	429	java/lang/Exception
    //   325	333	429	java/lang/Exception
    //   340	349	429	java/lang/Exception
    //   359	367	429	java/lang/Exception
    //   371	379	429	java/lang/Exception
    //   383	393	429	java/lang/Exception
    //   397	407	429	java/lang/Exception
    //   178	194	437	finally
    //   178	194	444	java/lang/Exception
    //   198	205	521	finally
    //   209	218	521	finally
    //   222	231	521	finally
    //   235	244	521	finally
    //   248	256	521	finally
    //   260	268	521	finally
    //   272	283	521	finally
    //   287	297	521	finally
    //   301	308	521	finally
    //   312	321	521	finally
    //   325	333	521	finally
    //   340	349	521	finally
    //   359	367	521	finally
    //   371	379	521	finally
    //   383	393	521	finally
    //   397	407	521	finally
    //   451	460	521	finally
    //   463	472	521	finally
    //   475	486	521	finally
    //   489	500	521	finally
  }
  
  private void a(boolean paramBoolean, long paramLong) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " doOnResume ");
    }
  }
  
  public void a(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void a(VideoItemHolder paramVideoItemHolder) {}
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return;
              }
              onDownloadError(paramDownloadInfo, 0, "", paramInt);
              return;
            }
            onDownloadFinish(paramDownloadInfo);
            return;
          }
          onDownloadPause(paramDownloadInfo);
          return;
        }
        onDownloadUpdate(new ArrayList(1));
        return;
      }
      installSucceed(paramDownloadInfo.m, paramDownloadInfo.e);
      return;
    }
    paramDownloadInfo = this.i;
    if (paramDownloadInfo != null) {
      this.h.c(paramDownloadInfo);
    }
  }
  
  public void a(Object paramObject)
  {
    a((VideoItemHolder)paramObject);
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return false;
    }
    if (paramVideoInfo.as == null) {
      return false;
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.as != null) && (paramVideoInfo.as.o == 12)) {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.as.A);
        boolean bool = PackageUtil.a(this.e, paramVideoInfo.optString("pkg_name"));
        return bool;
      }
      catch (JSONException paramVideoInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAppInstalled JSONException = ");
        localStringBuilder.append(paramVideoInfo.toString());
        QLog.d("ADVideoAppDownloadManager", 1, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void b() {}
  
  public boolean b(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return false;
  }
  
  public void c()
  {
    DownloadManagerV2.a().b(this);
    this.e = null;
  }
  
  public void c(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  protected int d(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      return paramADVideoAppDownloadData.f;
    }
    return 0;
  }
  
  public void d() {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installSucceed ");
    localStringBuilder.append(paramString2);
    ((IRIJAdLogService)localObject).d("ADVideoAppDownloadManager", localStringBuilder.toString());
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = paramString1;
    ((DownloadInfo)localObject).e = paramString2;
    this.h.a(paramString1, paramString2, this.i);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadCancel ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADVideoAppDownloadManager", 2, localStringBuilder.toString());
    }
    this.h.a(paramDownloadInfo, this.i);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADVideoAppDownloadManager", 2, localStringBuilder.toString());
    }
    this.h.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.i);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish ");
    localStringBuilder.append(paramDownloadInfo.e);
    localIRIJAdLogService.d("ADVideoAppDownloadManager", localStringBuilder.toString());
    this.h.b(paramDownloadInfo, this.i);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.h.a(paramList, this.i);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("packageReplaced ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = paramString1;
    ((DownloadInfo)localObject).e = paramString2;
    this.h.c(paramString1, paramString2, this.i);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uninstallSucceed ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = paramString1;
    ((DownloadInfo)localObject).e = paramString2;
    this.h.b(paramString1, paramString2, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */