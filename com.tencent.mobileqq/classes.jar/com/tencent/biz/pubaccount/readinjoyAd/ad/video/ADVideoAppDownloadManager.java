package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.os.Handler;
import bhfn;
import bjjq;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
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
import swu;
import ukq;
import ule;
import ulf;
import ulg;

public class ADVideoAppDownloadManager
  implements DownloadListener
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new ulf(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ADVideoAppDownloadManager.1(this);
  protected List<ule> a;
  protected ConcurrentHashMap<String, ule> a;
  private ule jdField_a_of_type_Ule;
  private ulg jdField_a_of_type_Ulg;
  private boolean jdField_a_of_type_Boolean;
  protected List<ADVideoAppDownloadManager.LoadTask> b;
  private boolean b;
  
  public ADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private DownloadInfo a(ule paramule, int paramInt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.e = paramule.d;
    localDownloadInfo.f = paramInt;
    localDownloadInfo.c = paramule.jdField_a_of_type_JavaLangString;
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
    //   7: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +37 -> 56
    //   22: ldc 146
    //   24: iconst_2
    //   25: new 148	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   32: ldc 151
    //   34: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 156
    //   43: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_2
    //   47: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 165
    //   58: astore_3
    //   59: ldc 167
    //   61: ldc 169
    //   63: invokestatic 175	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: astore_3
    //   71: new 148	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 177
    //   84: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_1
    //   95: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +28 -> 126
    //   101: ldc 146
    //   103: iconst_2
    //   104: new 148	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   111: ldc 179
    //   113: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: new 181	java/net/URL
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 184	java/net/URL:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 188	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   137: checkcast 190	java/net/HttpURLConnection
    //   140: astore_3
    //   141: aload_3
    //   142: ldc 192
    //   144: invokevirtual 195	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: ldc 197
    //   150: ldc 199
    //   152: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_3
    //   156: ldc 205
    //   158: ldc 207
    //   160: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: ldc 209
    //   166: ldc 211
    //   168: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: sipush 3000
    //   175: invokevirtual 214	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: sipush 3000
    //   182: invokevirtual 217	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: invokevirtual 221	java/net/HttpURLConnection:getResponseCode	()I
    //   189: sipush 200
    //   192: if_icmpne +118 -> 310
    //   195: aload_0
    //   196: aload_3
    //   197: invokevirtual 225	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   200: invokespecial 227	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_1
    //   205: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifne +43 -> 251
    //   211: new 229	org/json/JSONObject
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 230	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   219: astore_1
    //   220: getstatic 235	ufl:a	Lufl;
    //   223: aload_1
    //   224: invokevirtual 238	ufl:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   227: astore_1
    //   228: aload_1
    //   229: astore 4
    //   231: aload_3
    //   232: ifnull -219 -> 13
    //   235: aload_3
    //   236: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   239: aload_1
    //   240: areturn
    //   241: astore 6
    //   243: aload 6
    //   245: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   248: goto -177 -> 71
    //   251: ldc 146
    //   253: iconst_1
    //   254: ldc 246
    //   256: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload 5
    //   261: astore_1
    //   262: goto -34 -> 228
    //   265: astore 5
    //   267: aload_3
    //   268: astore_1
    //   269: aload 5
    //   271: astore_3
    //   272: ldc 146
    //   274: iconst_1
    //   275: new 148	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   282: ldc 248
    //   284: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 249	java/lang/Exception:toString	()Ljava/lang/String;
    //   291: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_1
    //   301: ifnull -288 -> 13
    //   304: aload_1
    //   305: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   308: aconst_null
    //   309: areturn
    //   310: ldc 146
    //   312: iconst_1
    //   313: new 148	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   320: ldc 251
    //   322: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_3
    //   326: invokevirtual 221	java/net/HttpURLConnection:getResponseCode	()I
    //   329: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 5
    //   340: astore_1
    //   341: goto -113 -> 228
    //   344: astore 4
    //   346: aload_3
    //   347: astore_1
    //   348: aload 4
    //   350: astore_3
    //   351: aload_1
    //   352: ifnull +7 -> 359
    //   355: aload_1
    //   356: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   359: aload_3
    //   360: athrow
    //   361: astore_3
    //   362: aconst_null
    //   363: astore_1
    //   364: goto -13 -> 351
    //   367: astore_3
    //   368: goto -17 -> 351
    //   371: astore_3
    //   372: aconst_null
    //   373: astore_1
    //   374: goto -102 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	ADVideoAppDownloadManager
    //   0	377	1	paramString	String
    //   0	377	2	paramInt	int
    //   58	302	3	localObject1	Object
    //   361	1	3	localObject2	Object
    //   367	1	3	localObject3	Object
    //   371	1	3	localException1	java.lang.Exception
    //   4	226	4	str1	String
    //   344	5	4	localObject4	Object
    //   1	259	5	localObject5	Object
    //   265	74	5	localException2	java.lang.Exception
    //   66	3	6	str2	String
    //   241	3	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	68	241	java/lang/Exception
    //   141	228	265	java/lang/Exception
    //   251	259	265	java/lang/Exception
    //   310	338	265	java/lang/Exception
    //   141	228	344	finally
    //   251	259	344	finally
    //   310	338	344	finally
    //   126	141	361	finally
    //   272	300	367	finally
    //   126	141	371	java/lang/Exception
  }
  
  private void a(boolean paramBoolean, long paramLong) {}
  
  protected int a(ule paramule)
  {
    if (paramule != null) {
      return paramule.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " doOnResume ");
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
      } while (this.jdField_a_of_type_Ule == null);
      this.jdField_a_of_type_Ulg.c(this.jdField_a_of_type_Ule);
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
  
  public void a(swu paramswu) {}
  
  public void a(ule paramule) {}
  
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
        boolean bool2 = bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
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
  
  public boolean a(ule paramule)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(ule paramule) {}
  
  public void c()
  {
    bjjq.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ukq.a("ADVideoAppDownloadManager", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Ulg.a(paramString1, paramString2, this.jdField_a_of_type_Ule);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Ulg.a(paramDownloadInfo, this.jdField_a_of_type_Ule);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.e);
    }
    this.jdField_a_of_type_Ulg.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_Ule);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ukq.a("ADVideoAppDownloadManager", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Ulg.b(paramDownloadInfo, this.jdField_a_of_type_Ule);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Ulg.a(paramList, this.jdField_a_of_type_Ule);
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
    this.jdField_a_of_type_Ulg.c(paramString1, paramString2, this.jdField_a_of_type_Ule);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Ulg.b(paramString1, paramString2, this.jdField_a_of_type_Ule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */