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
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  private ADVideoAppUIPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new ADVideoAppDownloadManager.3(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ADVideoAppDownloadManager.1(this);
  protected List<ADVideoAppDownloadData> a;
  protected ConcurrentHashMap<String, ADVideoAppDownloadData> a;
  private boolean jdField_a_of_type_Boolean = false;
  protected List<ADVideoAppDownloadManager.LoadTask> b;
  private boolean b;
  private boolean c = false;
  
  public ADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private DownloadInfo a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.e = paramADVideoAppDownloadData.d;
    localDownloadInfo.f = paramInt;
    localDownloadInfo.c = paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
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
    //   1: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   20: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +53 -> 76
    //   26: new 158	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 161
    //   39: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_1
    //   46: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 166
    //   54: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: iload_2
    //   61: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 171
    //   67: iconst_2
    //   68: aload 4
    //   70: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: ldc 177
    //   78: ldc 179
    //   80: invokestatic 185	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: goto +14 -> 99
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   95: ldc 190
    //   97: astore 4
    //   99: new 158	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   106: astore 5
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 5
    //   117: ldc 192
    //   119: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 5
    //   125: aload 4
    //   127: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 5
    //   133: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_1
    //   137: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +38 -> 178
    //   143: new 158	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: ldc 194
    //   156: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: aload_1
    //   163: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 171
    //   169: iconst_2
    //   170: aload 4
    //   172: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: new 196	java/net/URL
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 199	java/net/URL:<init>	(Ljava/lang/String;)V
    //   186: invokevirtual 203	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   189: checkcast 205	java/net/HttpURLConnection
    //   192: astore 5
    //   194: aload 5
    //   196: astore 4
    //   198: aload 5
    //   200: ldc 207
    //   202: invokevirtual 210	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   205: aload 5
    //   207: astore 4
    //   209: aload 5
    //   211: ldc 212
    //   213: ldc 214
    //   215: invokevirtual 218	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 5
    //   220: astore 4
    //   222: aload 5
    //   224: ldc 220
    //   226: ldc 222
    //   228: invokevirtual 218	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 5
    //   233: astore 4
    //   235: aload 5
    //   237: ldc 224
    //   239: ldc 226
    //   241: invokevirtual 218	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 5
    //   246: astore 4
    //   248: aload 5
    //   250: sipush 3000
    //   253: invokevirtual 229	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   256: aload 5
    //   258: astore 4
    //   260: aload 5
    //   262: sipush 3000
    //   265: invokevirtual 232	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   268: aload 5
    //   270: astore 4
    //   272: aload 5
    //   274: invokevirtual 236	java/net/HttpURLConnection:getResponseCode	()I
    //   277: sipush 200
    //   280: if_icmpne +74 -> 354
    //   283: aload 5
    //   285: astore 4
    //   287: aload_0
    //   288: aload 5
    //   290: invokevirtual 240	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   293: invokespecial 242	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   296: astore_1
    //   297: aload 5
    //   299: astore 4
    //   301: aload_1
    //   302: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +31 -> 336
    //   308: aload 5
    //   310: astore 4
    //   312: new 244	org/json/JSONObject
    //   315: dup
    //   316: aload_1
    //   317: invokespecial 245	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: aload 5
    //   323: astore 4
    //   325: getstatic 250	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;
    //   328: aload_1
    //   329: invokevirtual 253	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   332: astore_1
    //   333: goto +76 -> 409
    //   336: aload 5
    //   338: astore 4
    //   340: ldc 171
    //   342: iconst_1
    //   343: ldc 255
    //   345: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload 6
    //   350: astore_1
    //   351: goto +58 -> 409
    //   354: aload 5
    //   356: astore 4
    //   358: new 158	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   365: astore_1
    //   366: aload 5
    //   368: astore 4
    //   370: aload_1
    //   371: ldc_w 257
    //   374: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 5
    //   380: astore 4
    //   382: aload_1
    //   383: aload 5
    //   385: invokevirtual 236	java/net/HttpURLConnection:getResponseCode	()I
    //   388: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 5
    //   394: astore 4
    //   396: ldc 171
    //   398: iconst_1
    //   399: aload_1
    //   400: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: aload 6
    //   408: astore_1
    //   409: aload_1
    //   410: astore 4
    //   412: aload 5
    //   414: ifnull +103 -> 517
    //   417: aload_1
    //   418: astore 4
    //   420: aload 5
    //   422: invokevirtual 260	java/net/HttpURLConnection:disconnect	()V
    //   425: aload 4
    //   427: areturn
    //   428: astore 6
    //   430: aload 5
    //   432: astore_1
    //   433: goto +14 -> 447
    //   436: astore_1
    //   437: aconst_null
    //   438: astore 4
    //   440: goto +81 -> 521
    //   443: astore 6
    //   445: aconst_null
    //   446: astore_1
    //   447: aload_1
    //   448: astore 4
    //   450: new 158	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   457: astore 5
    //   459: aload_1
    //   460: astore 4
    //   462: aload 5
    //   464: ldc_w 262
    //   467: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload_1
    //   472: astore 4
    //   474: aload 5
    //   476: aload 6
    //   478: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   481: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_1
    //   486: astore 4
    //   488: ldc 171
    //   490: iconst_1
    //   491: aload 5
    //   493: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: aload 8
    //   501: astore 4
    //   503: aload_1
    //   504: ifnull +13 -> 517
    //   507: aload 7
    //   509: astore 4
    //   511: aload_1
    //   512: astore 5
    //   514: goto -94 -> 420
    //   517: aload 4
    //   519: areturn
    //   520: astore_1
    //   521: aload 4
    //   523: ifnull +8 -> 531
    //   526: aload 4
    //   528: invokevirtual 260	java/net/HttpURLConnection:disconnect	()V
    //   531: goto +5 -> 536
    //   534: aload_1
    //   535: athrow
    //   536: goto -2 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	ADVideoAppDownloadManager
    //   0	539	1	paramString	String
    //   0	539	2	paramInt	int
    //   4	11	3	bool	boolean
    //   33	51	4	localObject1	Object
    //   88	3	4	localException1	java.lang.Exception
    //   97	430	4	localObject2	Object
    //   106	407	5	localObject3	Object
    //   12	395	6	localObject4	Object
    //   428	1	6	localException2	java.lang.Exception
    //   443	34	6	localException3	java.lang.Exception
    //   6	502	7	localObject5	Object
    //   9	491	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   76	85	88	java/lang/Exception
    //   198	205	428	java/lang/Exception
    //   209	218	428	java/lang/Exception
    //   222	231	428	java/lang/Exception
    //   235	244	428	java/lang/Exception
    //   248	256	428	java/lang/Exception
    //   260	268	428	java/lang/Exception
    //   272	283	428	java/lang/Exception
    //   287	297	428	java/lang/Exception
    //   301	308	428	java/lang/Exception
    //   312	321	428	java/lang/Exception
    //   325	333	428	java/lang/Exception
    //   340	348	428	java/lang/Exception
    //   358	366	428	java/lang/Exception
    //   370	378	428	java/lang/Exception
    //   382	392	428	java/lang/Exception
    //   396	406	428	java/lang/Exception
    //   178	194	436	finally
    //   178	194	443	java/lang/Exception
    //   198	205	520	finally
    //   209	218	520	finally
    //   222	231	520	finally
    //   235	244	520	finally
    //   248	256	520	finally
    //   260	268	520	finally
    //   272	283	520	finally
    //   287	297	520	finally
    //   301	308	520	finally
    //   312	321	520	finally
    //   325	333	520	finally
    //   340	348	520	finally
    //   358	366	520	finally
    //   370	378	520	finally
    //   382	392	520	finally
    //   396	406	520	finally
    //   450	459	520	finally
    //   462	471	520	finally
    //   474	485	520	finally
    //   488	499	520	finally
  }
  
  private void a(boolean paramBoolean, long paramLong) {}
  
  protected int a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      return paramADVideoAppDownloadData.jdField_a_of_type_Int;
    }
    return 0;
  }
  
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
      installSucceed(paramDownloadInfo.k, paramDownloadInfo.e);
      return;
    }
    paramDownloadInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (paramDownloadInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.c(paramDownloadInfo);
    }
  }
  
  public void a(Object paramObject)
  {
    a((VideoItemHolder)paramObject);
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return false;
    }
    if (paramVideoInfo.a == null) {
      return false;
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.a != null) && (paramVideoInfo.a.c == 12)) {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
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
  
  public void b(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void c()
  {
    DownloadManagerV2.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish ");
    localStringBuilder.append(paramDownloadInfo.e);
    localIRIJAdLogService.d("ADVideoAppDownloadManager", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.b(paramDownloadInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.c(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.b(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */