package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.app.ThreadManager;
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
  implements DownloadListener
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = null;
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
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +37 -> 56
    //   22: ldc 159
    //   24: iconst_2
    //   25: new 161	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   32: ldc 164
    //   34: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 169
    //   43: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_2
    //   47: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 178
    //   58: astore_3
    //   59: ldc 180
    //   61: ldc 182
    //   63: invokestatic 188	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: astore_3
    //   71: new 161	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 190
    //   84: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_1
    //   95: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +28 -> 126
    //   101: ldc 159
    //   103: iconst_2
    //   104: new 161	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   111: ldc 192
    //   113: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: new 194	java/net/URL
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 197	java/net/URL:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 201	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   137: checkcast 203	java/net/HttpURLConnection
    //   140: astore_3
    //   141: aload_3
    //   142: ldc 205
    //   144: invokevirtual 208	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: ldc 210
    //   150: ldc 212
    //   152: invokevirtual 216	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_3
    //   156: ldc 218
    //   158: ldc 220
    //   160: invokevirtual 216	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: ldc 222
    //   166: ldc 224
    //   168: invokevirtual 216	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: sipush 3000
    //   175: invokevirtual 227	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: sipush 3000
    //   182: invokevirtual 230	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: invokevirtual 234	java/net/HttpURLConnection:getResponseCode	()I
    //   189: sipush 200
    //   192: if_icmpne +120 -> 312
    //   195: aload_0
    //   196: aload_3
    //   197: invokevirtual 238	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   200: invokespecial 240	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_1
    //   205: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifne +43 -> 251
    //   211: new 242	org/json/JSONObject
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   219: astore_1
    //   220: getstatic 248	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;
    //   223: aload_1
    //   224: invokevirtual 251	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   227: astore_1
    //   228: aload_1
    //   229: astore 4
    //   231: aload_3
    //   232: ifnull -219 -> 13
    //   235: aload_3
    //   236: invokevirtual 254	java/net/HttpURLConnection:disconnect	()V
    //   239: aload_1
    //   240: areturn
    //   241: astore 6
    //   243: aload 6
    //   245: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   248: goto -177 -> 71
    //   251: ldc 159
    //   253: iconst_1
    //   254: ldc_w 259
    //   257: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 5
    //   262: astore_1
    //   263: goto -35 -> 228
    //   266: astore 5
    //   268: aload_3
    //   269: astore_1
    //   270: aload 5
    //   272: astore_3
    //   273: ldc 159
    //   275: iconst_1
    //   276: new 161	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 261
    //   286: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_3
    //   290: invokevirtual 262	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_1
    //   303: ifnull -290 -> 13
    //   306: aload_1
    //   307: invokevirtual 254	java/net/HttpURLConnection:disconnect	()V
    //   310: aconst_null
    //   311: areturn
    //   312: ldc 159
    //   314: iconst_1
    //   315: new 161	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 264
    //   325: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_3
    //   329: invokevirtual 234	java/net/HttpURLConnection:getResponseCode	()I
    //   332: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 5
    //   343: astore_1
    //   344: goto -116 -> 228
    //   347: astore 4
    //   349: aload_3
    //   350: astore_1
    //   351: aload 4
    //   353: astore_3
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 254	java/net/HttpURLConnection:disconnect	()V
    //   362: aload_3
    //   363: athrow
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_1
    //   367: goto -13 -> 354
    //   370: astore_3
    //   371: goto -17 -> 354
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: goto -104 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ADVideoAppDownloadManager
    //   0	380	1	paramString	String
    //   0	380	2	paramInt	int
    //   58	305	3	localObject1	Object
    //   364	1	3	localObject2	Object
    //   370	1	3	localObject3	Object
    //   374	1	3	localException1	java.lang.Exception
    //   4	226	4	str1	String
    //   347	5	4	localObject4	Object
    //   1	260	5	localObject5	Object
    //   266	76	5	localException2	java.lang.Exception
    //   66	3	6	str2	String
    //   241	3	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	68	241	java/lang/Exception
    //   141	228	266	java/lang/Exception
    //   251	260	266	java/lang/Exception
    //   312	341	266	java/lang/Exception
    //   141	228	347	finally
    //   251	260	347	finally
    //   312	341	347	finally
    //   126	141	364	finally
    //   273	302	370	finally
    //   126	141	374	java/lang/Exception
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
  
  public void a(VideoItemHolder paramVideoItemHolder) {}
  
  public void a(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      return;
    case 3: 
      onDownloadUpdate(new ArrayList(1));
      return;
    case 5: 
      onDownloadFinish(paramDownloadInfo);
      return;
    case 1: 
      installSucceed(paramDownloadInfo.k, paramDownloadInfo.e);
      return;
    case 4: 
      onDownloadPause(paramDownloadInfo);
      return;
    }
    onDownloadError(paramDownloadInfo, 0, "", paramInt);
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool1 = true;
    if (paramVideoInfo == null) {}
    while ((paramVideoInfo.a == null) || (paramVideoInfo == null) || (paramVideoInfo.a == null) || (paramVideoInfo.a.c != 12)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool2 = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool2) {
          return bool1;
        }
      }
      catch (JSONException paramVideoInfo)
      {
        QLog.d("ADVideoAppDownloadManager", 1, "isAppInstalled JSONException = " + paramVideoInfo.toString());
        return false;
      }
      bool1 = false;
    }
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
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
    ReadInJoyAdLog.a("ADVideoAppDownloadManager", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ReadInJoyAdLog.a("ADVideoAppDownloadManager", "onDownloadFinish " + paramDownloadInfo.e);
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
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.c(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppUIPresenter.b(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */