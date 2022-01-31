package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import bbfd;
import bdgv;
import bdko;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
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
import nmf;
import oat;
import oay;
import org.json.JSONException;
import org.json.JSONObject;
import qjf;
import qjg;
import qjh;
import qjr;
import qmd;
import qmi;
import qms;
import qqo;
import yxu;
import yyq;

public class ADVideoAppDownloadManager
  implements bdko
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new qjg(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ADVideoAppDownloadManager.1(this);
  protected List<qjf> a;
  protected ConcurrentHashMap<String, qjf> a;
  private qjf jdField_a_of_type_Qjf;
  private qjh jdField_a_of_type_Qjh;
  private qmd jdField_a_of_type_Qmd;
  private qmi jdField_a_of_type_Qmi;
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
  
  private int a(Context paramContext, qjf paramqjf)
  {
    if ((paramContext == null) || (paramqjf == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramqjf.d;
          paramqjf = paramqjf.jdField_a_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramqjf))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramqjf + " false");
        return -1;
        localDownloadInfo = bdgv.a().c(paramContext);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramqjf + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramqjf + " true");
        }
        return localDownloadInfo.f;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramqjf + " false");
    return -1;
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
    //   32: ldc 174
    //   34: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 176
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_2
    //   47: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 105	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 181
    //   69: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_1
    //   76: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +28 -> 107
    //   82: ldc 103
    //   84: iconst_2
    //   85: new 105	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   92: ldc 183
    //   94: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: new 185	java/net/URL
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 188	java/net/URL:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 192	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   118: checkcast 194	java/net/HttpURLConnection
    //   121: astore_3
    //   122: aload_3
    //   123: ldc 196
    //   125: invokevirtual 199	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   128: aload_3
    //   129: ldc 201
    //   131: ldc 203
    //   133: invokevirtual 207	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ldc 209
    //   139: ldc 211
    //   141: invokevirtual 207	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_3
    //   145: ldc 213
    //   147: ldc 215
    //   149: invokevirtual 207	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_3
    //   153: sipush 3000
    //   156: invokevirtual 218	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   159: aload_3
    //   160: sipush 3000
    //   163: invokevirtual 221	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   166: aload_3
    //   167: invokevirtual 224	java/net/HttpURLConnection:getResponseCode	()I
    //   170: sipush 200
    //   173: if_icmpne +104 -> 277
    //   176: aload_0
    //   177: aload_3
    //   178: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   181: invokespecial 230	com/tencent/biz/pubaccount/readinjoy/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   184: astore_1
    //   185: aload_1
    //   186: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +29 -> 218
    //   192: aload_0
    //   193: new 232	org/json/JSONObject
    //   196: dup
    //   197: aload_1
    //   198: invokespecial 233	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: invokespecial 236	com/tencent/biz/pubaccount/readinjoy/video/ADVideoAppDownloadManager:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   204: astore_1
    //   205: aload_1
    //   206: astore 4
    //   208: aload_3
    //   209: ifnull -196 -> 13
    //   212: aload_3
    //   213: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   216: aload_1
    //   217: areturn
    //   218: ldc 103
    //   220: iconst_1
    //   221: ldc 241
    //   223: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload 5
    //   228: astore_1
    //   229: goto -24 -> 205
    //   232: astore 5
    //   234: aload_3
    //   235: astore_1
    //   236: aload 5
    //   238: astore_3
    //   239: ldc 103
    //   241: iconst_1
    //   242: new 105	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   249: ldc 243
    //   251: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_3
    //   255: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload_1
    //   268: ifnull -255 -> 13
    //   271: aload_1
    //   272: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   275: aconst_null
    //   276: areturn
    //   277: ldc 103
    //   279: iconst_1
    //   280: new 105	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   287: ldc 246
    //   289: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_3
    //   293: invokevirtual 224	java/net/HttpURLConnection:getResponseCode	()I
    //   296: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload 5
    //   307: astore_1
    //   308: goto -103 -> 205
    //   311: astore 4
    //   313: aload_3
    //   314: astore_1
    //   315: aload 4
    //   317: astore_3
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   326: aload_3
    //   327: athrow
    //   328: astore_3
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -13 -> 318
    //   334: astore_3
    //   335: goto -17 -> 318
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_1
    //   341: goto -102 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ADVideoAppDownloadManager
    //   0	344	1	paramString	String
    //   0	344	2	paramInt	int
    //   121	206	3	localObject1	Object
    //   328	1	3	localObject2	Object
    //   334	1	3	localObject3	Object
    //   338	1	3	localException1	Exception
    //   4	203	4	str	String
    //   311	5	4	localObject4	Object
    //   1	226	5	localObject5	Object
    //   232	74	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   122	205	232	java/lang/Exception
    //   218	226	232	java/lang/Exception
    //   277	305	232	java/lang/Exception
    //   122	205	311	finally
    //   218	226	311	finally
    //   277	305	311	finally
    //   107	122	328	finally
    //   239	267	334	finally
    //   107	122	338	java/lang/Exception
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
          break label106;
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
  
  private void a(Activity paramActivity, qjf paramqjf)
  {
    if ((paramActivity == null) || (paramqjf == null)) {
      return;
    }
    paramActivity = new WeakReference(paramActivity);
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.2(this, paramqjf, paramActivity));
  }
  
  private void a(boolean paramBoolean, long paramLong) {}
  
  private boolean a(Context paramContext, qjf paramqjf)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramqjf != null) {
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
            str1 = paramqjf.d;
            str2 = paramqjf.jdField_a_of_type_JavaLangString;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = bdgv.a().c(str1);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramqjf = "";
      if (TextUtils.isEmpty(localDownloadInfo.l)) {
        break;
      }
      paramqjf = localDownloadInfo.l;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramqjf))
      {
        bool1 = bool3;
        if (new File(paramqjf).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramqjf);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bdgv.a().a(localDownloadInfo.d);
      paramContext = paramqjf;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramqjf;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramqjf = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bdgv.a().a(localDownloadInfo);
        paramqjf = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramqjf;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramqjf;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramqjf = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.l = paramContext;
      localDownloadInfo.a(4);
      bdgv.a().c(localDownloadInfo);
      paramqjf = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bdgv.a().a(localDownloadInfo);
      paramContext = paramqjf;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramqjf;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramqjf = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bdgv.a().a(localDownloadInfo.d);
        paramqjf = paramContext;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.removeJobFromThreadPool((ADVideoAppDownloadManager.LoadTask)localIterator.next(), 128);
    }
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Qmd = null;
    this.jdField_a_of_type_Qjf = null;
  }
  
  protected int a(qjf paramqjf)
  {
    if (paramqjf != null) {
      return paramqjf.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " doOnResume ");
    }
    if ((this.jdField_a_of_type_Qjf != null) && (this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a != null) && (oat.d(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a.a))) {
      b(this.jdField_a_of_type_Qjf, this.jdField_a_of_type_Qjf.jdField_a_of_type_Int);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Qjh.d(this.jdField_a_of_type_Qjf);
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
  
  public void a(qjf paramqjf)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Qjh == null) || (paramqjf == null) || (!paramqjf.a())) {
      QLog.d("ADVideoAppDownloadManager", 1, "initDownloadApp return null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp begin");
            }
            if (nmf.a(this.jdField_a_of_type_AndroidContentContext, paramqjf.d))
            {
              QLog.d("ADVideoAppDownloadManager", 1, "already installed." + paramqjf.d);
              this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_Qjh.a();
              this.jdField_a_of_type_Qjh.b(paramqjf);
              return;
            }
            if (a(this.jdField_a_of_type_AndroidContentContext, paramqjf))
            {
              QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + paramqjf.d);
              this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_Qjh.a();
              this.jdField_a_of_type_Qjh.c(paramqjf);
              return;
            }
            int j = a(this.jdField_a_of_type_AndroidContentContext, paramqjf);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (paramqjf.b > 0) {
                i = paramqjf.b;
              }
            }
            if ((i < 0) || ((paramqjf.jdField_a_of_type_Int != 3) && (paramqjf.jdField_a_of_type_Int != 4))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + paramqjf.d + " " + i);
            }
            if (paramqjf.jdField_a_of_type_Int == 3)
            {
              this.jdField_a_of_type_Qjh.b(paramqjf, i);
              return;
            }
          } while (paramqjf.jdField_a_of_type_Int != 4);
          this.jdField_a_of_type_Qjh.a(paramqjf);
          return;
          if ((!this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean) && ((!this.jdField_a_of_type_Boolean) || (!yyq.a()))) {
            break;
          }
          if (this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "autodownload not by userClick");
            }
            a(paramqjf, 0);
            return;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (!yyq.a()));
        if (!this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ADVideoAppDownloadManager", 2, "autodownload for getAppData <1s");
          }
          a(paramqjf, 0);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "dont autodownload for getAppData >1s");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
  
  public void a(qjf paramqjf, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + paramqjf.d + " progress " + paramInt);
    }
    paramqjf.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Qjh.b(paramqjf, paramInt);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean = true;
    a(localActivity, paramqjf);
  }
  
  protected void a(qjf paramqjf, int paramInt1, int paramInt2) {}
  
  public void a(qms paramqms)
  {
    this.jdField_a_of_type_Qmi = paramqms;
    if (this.jdField_a_of_type_Qmd != null)
    {
      this.jdField_a_of_type_Qmd.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Qmd.c.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_Qjr.a(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a);
    }
    if ((paramqms instanceof qmd))
    {
      g();
      this.jdField_a_of_type_Qmd = ((qmd)paramqms);
      if (this.jdField_a_of_type_Qmd != null)
      {
        paramqms = this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a;
        if (paramqms != null) {
          break label96;
        }
      }
    }
    label96:
    VideoAdInfo localVideoAdInfo;
    do
    {
      return;
      localVideoAdInfo = paramqms.a;
    } while ((localVideoAdInfo == null) || (!paramqms.c) || (!oat.d(localVideoAdInfo)) || (!AdvertisementInfo.isAppAdvertisementInfo(oay.a(localVideoAdInfo))));
    paramqms = qjf.a(localVideoAdInfo);
    if (TextUtils.isEmpty(paramqms)) {
      paramqms = "STUB_PACK_NAME_" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
    for (;;)
    {
      qjf localqjf2 = (qjf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramqms);
      qjf localqjf1 = localqjf2;
      if (localqjf2 == null) {
        localqjf1 = qjf.a(localVideoAdInfo);
      }
      if (localqjf1 == null) {
        break;
      }
      localqjf1.d = paramqms;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramqms, localqjf1);
      this.jdField_a_of_type_Qjf = localqjf1;
      this.jdField_a_of_type_Qjh = new qjh(this.jdField_a_of_type_Qmd, this, this.jdField_a_of_type_AndroidContentContext);
      bdgv.a().a(this);
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " onCenterViewChanged  mState = " + this.jdField_a_of_type_Qjf.jdField_a_of_type_Int);
      }
      if ((localqjf1.jdField_a_of_type_Int == 4) || (localqjf1.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Qjh.a();
        if (localqjf1.jdField_a_of_type_Int != 3) {
          break label341;
        }
        this.jdField_a_of_type_Qjh.b(localqjf1, localqjf1.b);
      }
      for (;;)
      {
        d();
        return;
        label341:
        if (localqjf1.jdField_a_of_type_Int == 4) {
          this.jdField_a_of_type_Qjh.a(localqjf1);
        }
      }
    }
  }
  
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
        boolean bool2 = bbfd.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
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
  
  public boolean a(qjf paramqjf)
  {
    if (paramqjf != null) {
      ThreadManager.excute(new ADVideoAppDownloadManager.3(this, paramqjf), 128, null, true);
    }
    return false;
  }
  
  public void b() {}
  
  void b(qjf paramqjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + paramqjf.d);
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Qjh.jdField_a_of_type_Boolean = true;
    a(localActivity, paramqjf);
  }
  
  public void b(qjf paramqjf, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ADVideoAppDownloadManager.6(this, paramqjf, paramInt));
  }
  
  public void c()
  {
    g();
    bdgv.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c(qjf paramqjf)
  {
    String str = paramqjf.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      bdgv.a().a(str);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.4(this, paramqjf));
  }
  
  public void d()
  {
    if ((!this.jdField_b_of_type_Boolean) && (yxu.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      this.jdField_b_of_type_Boolean = true;
      ADVideoAppDownloadManager.LoadTask localLoadTask = new ADVideoAppDownloadManager.LoadTask(this, this.jdField_a_of_type_Qjf);
      this.jdField_b_of_type_JavaUtilList.add(localLoadTask);
      ThreadManager.excute(localLoadTask, 128, null, true);
    }
  }
  
  public void e()
  {
    if ((yxu.a(this.jdField_a_of_type_AndroidContentContext)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Qjf == null)
    {
      this.jdField_a_of_type_Qjh.a(null, 0);
      return;
    }
    if (this.jdField_a_of_type_Qjf.jdField_a_of_type_Int == 5)
    {
      b(this.jdField_a_of_type_Qjf);
      return;
    }
    this.jdField_a_of_type_Qjh.a(this.jdField_a_of_type_Qjf, this.jdField_a_of_type_Qjf.jdField_a_of_type_Int);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "installSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Qjh.a(paramString1, paramString2, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Qjh.c(paramDownloadInfo, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Qjh.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadFinish " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Qjh.d(paramDownloadInfo, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadPause " + paramDownloadInfo.e);
    }
    if ((paramDownloadInfo != null) && (this.jdField_a_of_type_Qjf != null) && (this.jdField_a_of_type_Qjf.d != null) && (this.jdField_a_of_type_Qjf.d.equals(paramDownloadInfo.e)) && (paramDownloadInfo.f != 0) && (paramDownloadInfo.f != 100)) {
      this.jdField_a_of_type_Qjf.b = paramDownloadInfo.f;
    }
    this.jdField_a_of_type_Qjh.a(paramDownloadInfo, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Qjh.a(paramList, this.jdField_a_of_type_Qjf);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadWait " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Qjh.b(paramDownloadInfo, this.jdField_a_of_type_Qjf);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Qjh.c(paramString1, paramString2, this.jdField_a_of_type_Qjf);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Qjh.b(paramString1, paramString2, this.jdField_a_of_type_Qjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */