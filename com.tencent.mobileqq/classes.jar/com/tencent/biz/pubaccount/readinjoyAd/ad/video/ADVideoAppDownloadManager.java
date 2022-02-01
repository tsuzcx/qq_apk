package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import acve;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import bhny;
import bjsz;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import nzq;
import org.json.JSONException;
import org.json.JSONObject;
import rln;
import rog;
import rol;
import rot;
import rrm;
import tkk;
import tpx;
import tpz;
import tqm;
import tqt;
import tqu;
import tqv;
import tqw;

public class ADVideoAppDownloadManager
  implements DownloadListener
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new tqv(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ADVideoAppDownloadManager.1(this);
  protected List<tqt> a;
  protected ConcurrentHashMap<String, tqt> a;
  private rog jdField_a_of_type_Rog;
  private rol jdField_a_of_type_Rol;
  private tqt jdField_a_of_type_Tqt;
  private tqw jdField_a_of_type_Tqw;
  private boolean jdField_a_of_type_Boolean;
  protected List<ADVideoAppDownloadManager.LoadTask> b;
  private boolean b;
  private boolean c;
  
  public ADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private int a(Context paramContext, tqt paramtqt)
  {
    if ((paramContext == null) || (paramtqt == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramtqt.d;
          paramtqt = paramtqt.jdField_a_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramtqt))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramtqt + " false");
        return -1;
        localDownloadInfo = bjsz.a().c(paramContext);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramtqt + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramtqt + " true");
        }
        return localDownloadInfo.f;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramtqt + " false");
    return -1;
  }
  
  private DownloadInfo a(tqt paramtqt, int paramInt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.e = paramtqt.d;
    localDownloadInfo.f = paramInt;
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramtqt.jdField_a_of_type_JavaLangString;
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
    //   7: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +37 -> 56
    //   22: ldc 103
    //   24: iconst_2
    //   25: new 105	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   32: ldc 184
    //   34: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 186
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_2
    //   47: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 191
    //   58: astore_3
    //   59: ldc 193
    //   61: ldc 195
    //   63: invokestatic 201	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: astore_3
    //   71: new 105	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 203
    //   84: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_1
    //   95: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +28 -> 126
    //   101: ldc 103
    //   103: iconst_2
    //   104: new 105	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   111: ldc 205
    //   113: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: new 207	java/net/URL
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 210	java/net/URL:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 214	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   137: checkcast 216	java/net/HttpURLConnection
    //   140: astore_3
    //   141: aload_3
    //   142: ldc 218
    //   144: invokevirtual 221	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: ldc 223
    //   150: ldc 225
    //   152: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_3
    //   156: ldc 231
    //   158: ldc 233
    //   160: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: ldc 235
    //   166: ldc 237
    //   168: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: sipush 3000
    //   175: invokevirtual 240	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: sipush 3000
    //   182: invokevirtual 243	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: invokevirtual 246	java/net/HttpURLConnection:getResponseCode	()I
    //   189: sipush 200
    //   192: if_icmpne +116 -> 308
    //   195: aload_0
    //   196: aload_3
    //   197: invokevirtual 250	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   200: invokespecial 252	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_1
    //   205: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifne +39 -> 247
    //   211: aload_0
    //   212: new 254	org/json/JSONObject
    //   215: dup
    //   216: aload_1
    //   217: invokespecial 255	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: invokespecial 258	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   223: astore_1
    //   224: aload_1
    //   225: astore 4
    //   227: aload_3
    //   228: ifnull -215 -> 13
    //   231: aload_3
    //   232: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   235: aload_1
    //   236: areturn
    //   237: astore 6
    //   239: aload 6
    //   241: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   244: goto -173 -> 71
    //   247: ldc 103
    //   249: iconst_1
    //   250: ldc_w 266
    //   253: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload 5
    //   258: astore_1
    //   259: goto -35 -> 224
    //   262: astore 5
    //   264: aload_3
    //   265: astore_1
    //   266: aload 5
    //   268: astore_3
    //   269: ldc 103
    //   271: iconst_1
    //   272: new 105	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 268
    //   282: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_3
    //   286: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   289: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_1
    //   299: ifnull -286 -> 13
    //   302: aload_1
    //   303: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   306: aconst_null
    //   307: areturn
    //   308: ldc 103
    //   310: iconst_1
    //   311: new 105	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 271
    //   321: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_3
    //   325: invokevirtual 246	java/net/HttpURLConnection:getResponseCode	()I
    //   328: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload 5
    //   339: astore_1
    //   340: goto -116 -> 224
    //   343: astore 4
    //   345: aload_3
    //   346: astore_1
    //   347: aload 4
    //   349: astore_3
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   358: aload_3
    //   359: athrow
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_1
    //   363: goto -13 -> 350
    //   366: astore_3
    //   367: goto -17 -> 350
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -104 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	ADVideoAppDownloadManager
    //   0	376	1	paramString	String
    //   0	376	2	paramInt	int
    //   58	301	3	localObject1	Object
    //   360	1	3	localObject2	Object
    //   366	1	3	localObject3	Object
    //   370	1	3	localException1	Exception
    //   4	222	4	str1	String
    //   343	5	4	localObject4	Object
    //   1	256	5	localObject5	Object
    //   262	76	5	localException2	Exception
    //   66	3	6	str2	String
    //   237	3	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   59	68	237	java/lang/Exception
    //   141	224	262	java/lang/Exception
    //   247	256	262	java/lang/Exception
    //   308	337	262	java/lang/Exception
    //   141	224	343	finally
    //   247	256	343	finally
    //   308	337	343	finally
    //   126	141	360	finally
    //   269	298	366	finally
    //   126	141	370	java/lang/Exception
  }
  
  private String a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject == null) {
          break label107;
        }
        paramJSONObject = paramJSONObject.optString("dstlink");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramJSONObject = "";
          continue;
          paramJSONObject = "";
        }
      }
      localObject = paramJSONObject;
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ADVideoAppDownloadManager", 2, " parseDestLinkJson destLink = " + paramJSONObject);
          return paramJSONObject;
        }
      }
      catch (Exception localException1) {}
    }
    localException1.printStackTrace();
    QLog.d("ADVideoAppDownloadManager", 1, "parseDestLinkJson exception :" + localException1.toString());
    return paramJSONObject;
  }
  
  private void a(Activity paramActivity, tqt paramtqt)
  {
    if ((paramActivity == null) || (paramtqt == null)) {
      return;
    }
    paramActivity = new WeakReference(paramActivity);
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.3(this, paramtqt, paramActivity));
  }
  
  private void a(boolean paramBoolean, long paramLong) {}
  
  private boolean a(Context paramContext, tqt paramtqt)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramtqt != null) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = paramtqt.d;
            str2 = paramtqt.jdField_a_of_type_JavaLangString;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = bjsz.a().c(str1);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramtqt = "";
      if (TextUtils.isEmpty(localDownloadInfo.l)) {
        break;
      }
      paramtqt = localDownloadInfo.l;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramtqt))
      {
        bool1 = bool3;
        if (new File(paramtqt).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramtqt);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bjsz.a().a(localDownloadInfo.d);
      paramContext = paramtqt;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramtqt;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramtqt = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bjsz.a().a(localDownloadInfo);
        paramtqt = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramtqt;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramtqt;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramtqt = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.l = paramContext;
      localDownloadInfo.a(4);
      bjsz.a().c(localDownloadInfo);
      paramtqt = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bjsz.a().a(localDownloadInfo);
      paramContext = paramtqt;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramtqt;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramtqt = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bjsz.a().a(localDownloadInfo.d);
        paramtqt = paramContext;
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.removeJobFromThreadPool((ADVideoAppDownloadManager.LoadTask)localIterator.next(), 128);
    }
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Rog = null;
    this.jdField_a_of_type_Tqt = null;
  }
  
  protected int a(tqt paramtqt)
  {
    if (paramtqt != null) {
      return paramtqt.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " doOnResume ");
    }
    if ((this.jdField_a_of_type_Tqt != null) && (this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a != null) && (tpz.d(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a.a))) {
      g();
    }
  }
  
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
      } while (this.jdField_a_of_type_Tqt == null);
      this.jdField_a_of_type_Tqw.d(this.jdField_a_of_type_Tqt);
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
  
  public void a(rot paramrot)
  {
    this.jdField_a_of_type_Rol = paramrot;
    if (this.jdField_a_of_type_Rog != null)
    {
      this.jdField_a_of_type_Rog.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Rog.jdField_a_of_type_Rln.a(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a);
    }
    if ((paramrot instanceof rog))
    {
      h();
      this.jdField_a_of_type_Rog = ((rog)paramrot);
      if (this.jdField_a_of_type_Rog != null)
      {
        paramrot = this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a;
        if (paramrot != null) {
          break label96;
        }
      }
    }
    label96:
    VideoAdInfo localVideoAdInfo;
    do
    {
      return;
      localVideoAdInfo = paramrot.a;
    } while ((localVideoAdInfo == null) || (!paramrot.c) || (!AdvertisementInfo.isAppAdvertisementInfo(tqm.a(localVideoAdInfo))));
    paramrot = tqt.a(localVideoAdInfo);
    if (TextUtils.isEmpty(paramrot)) {
      paramrot = "STUB_PACK_NAME_" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
    for (;;)
    {
      tqt localtqt2 = (tqt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramrot);
      tqt localtqt1 = localtqt2;
      if (localtqt2 == null) {
        localtqt1 = tqt.a(localVideoAdInfo);
      }
      if (localtqt1 == null) {
        break;
      }
      localtqt1.d = paramrot;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramrot, localtqt1);
      this.jdField_a_of_type_Tqt = localtqt1;
      this.jdField_a_of_type_Tqw = new tqw(this.jdField_a_of_type_Rog, this, this.jdField_a_of_type_AndroidContentContext);
      bjsz.a().a(this);
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " onCenterViewChanged  mState = " + this.jdField_a_of_type_Tqt.jdField_a_of_type_Int);
      }
      if ((tpz.d(localVideoAdInfo)) && ((localtqt1.jdField_a_of_type_Int == 4) || (localtqt1.jdField_a_of_type_Int == 3)))
      {
        this.jdField_a_of_type_Tqw.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Tqw.a();
        if (localtqt1.jdField_a_of_type_Int != 3) {
          break label341;
        }
        this.jdField_a_of_type_Tqw.b(localtqt1, localtqt1.b);
      }
      for (;;)
      {
        d();
        return;
        label341:
        if (localtqt1.jdField_a_of_type_Int == 4) {
          this.jdField_a_of_type_Tqw.a(localtqt1);
        }
      }
    }
  }
  
  public void a(tqt paramtqt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Tqw == null) || (paramtqt == null) || (!paramtqt.a()))
    {
      QLog.d("ADVideoAppDownloadManager", 1, "initDownloadApp return null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp begin");
    }
    if (nzq.a(this.jdField_a_of_type_AndroidContentContext, paramtqt.d))
    {
      QLog.d("ADVideoAppDownloadManager", 1, "already installed." + paramtqt.d);
      this.jdField_a_of_type_Tqw.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Tqw.a();
      this.jdField_a_of_type_Tqw.b(paramtqt);
      return;
    }
    tkk.a(paramtqt, new tqu(this, paramtqt));
  }
  
  public void a(tqt paramtqt, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + paramtqt.d + " progress " + paramInt);
    }
    paramtqt.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Tqw.b(paramtqt, paramInt);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Tqw.jdField_a_of_type_Boolean = true;
    a(localActivity, paramtqt);
  }
  
  protected void a(tqt paramtqt, int paramInt1, int paramInt2) {}
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool1 = true;
    if (paramVideoInfo == null) {}
    while ((paramVideoInfo.a == null) || (paramVideoInfo == null) || (paramVideoInfo.a == null) || (paramVideoInfo.a.jdField_c_of_type_Int != 12)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool2 = bhny.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
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
  
  public boolean a(tqt paramtqt)
  {
    if (paramtqt != null) {
      ThreadManager.excute(new ADVideoAppDownloadManager.4(this, paramtqt), 128, null, true);
    }
    return false;
  }
  
  public void b() {}
  
  void b(tqt paramtqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + paramtqt.d);
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Tqw.jdField_a_of_type_Boolean = true;
    a(localActivity, paramtqt);
  }
  
  public void c()
  {
    h();
    bjsz.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c(tqt paramtqt)
  {
    String str = paramtqt.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      bjsz.a().a(str);
      tpx.a("ADVideoAppDownloadManager", "pauseDownload : url = " + str);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.5(this, paramtqt));
  }
  
  public void d()
  {
    if ((!this.jdField_b_of_type_Boolean) && (acve.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      this.jdField_b_of_type_Boolean = true;
      ADVideoAppDownloadManager.LoadTask localLoadTask = new ADVideoAppDownloadManager.LoadTask(this, this.jdField_a_of_type_Tqt);
      this.jdField_b_of_type_JavaUtilList.add(localLoadTask);
      ThreadManager.excute(localLoadTask, 128, null, true);
    }
  }
  
  public void e()
  {
    if ((acve.a(this.jdField_a_of_type_AndroidContentContext)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Tqt == null)
    {
      this.jdField_a_of_type_Tqw.a(null, 0);
      tpx.a("ADVideoAppDownloadManager", "mADVideoAppDownloadData = null");
      return;
    }
    if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int == 5)
    {
      tpx.a("ADVideoAppDownloadManager", this.jdField_a_of_type_Tqt.d + " download finish");
      b(this.jdField_a_of_type_Tqt);
      return;
    }
    this.jdField_a_of_type_Tqw.a(this.jdField_a_of_type_Tqt, this.jdField_a_of_type_Tqt.jdField_a_of_type_Int);
  }
  
  public void g()
  {
    ThreadManager.executeOnSubThread(new ADVideoAppDownloadManager.7(this));
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    tpx.a("ADVideoAppDownloadManager", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Tqw.a(paramString1, paramString2, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Tqw.c(paramDownloadInfo, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Tqw.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    tpx.a("ADVideoAppDownloadManager", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Tqw.d(paramDownloadInfo, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    tpx.a("ADVideoAppDownloadManager", "onDownloadPause " + paramDownloadInfo.e);
    if ((paramDownloadInfo != null) && (this.jdField_a_of_type_Tqt != null) && (this.jdField_a_of_type_Tqt.d != null) && (this.jdField_a_of_type_Tqt.d.equals(paramDownloadInfo.e)) && (paramDownloadInfo.f != 0) && (paramDownloadInfo.f != 100)) {
      this.jdField_a_of_type_Tqt.b = paramDownloadInfo.f;
    }
    this.jdField_a_of_type_Tqw.a(paramDownloadInfo, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Tqw.a(paramList, this.jdField_a_of_type_Tqt);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadWait " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Tqw.b(paramDownloadInfo, this.jdField_a_of_type_Tqt);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Tqw.c(paramString1, paramString2, this.jdField_a_of_type_Tqt);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Tqw.b(paramString1, paramString2, this.jdField_a_of_type_Tqt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */