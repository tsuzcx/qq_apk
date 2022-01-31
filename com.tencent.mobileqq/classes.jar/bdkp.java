import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager.1;
import com.tencent.open.downloadnew.DownloadManager.11;
import com.tencent.open.downloadnew.DownloadManager.12;
import com.tencent.open.downloadnew.DownloadManager.13;
import com.tencent.open.downloadnew.DownloadManager.14;
import com.tencent.open.downloadnew.DownloadManager.15;
import com.tencent.open.downloadnew.DownloadManager.17;
import com.tencent.open.downloadnew.DownloadManager.18;
import com.tencent.open.downloadnew.DownloadManager.2;
import com.tencent.open.downloadnew.DownloadManager.20;
import com.tencent.open.downloadnew.DownloadManager.21;
import com.tencent.open.downloadnew.DownloadManager.3;
import com.tencent.open.downloadnew.DownloadManager.4;
import com.tencent.open.downloadnew.DownloadManager.6;
import com.tencent.open.downloadnew.DownloadManager.7;
import com.tencent.open.downloadnew.DownloadManager.8;
import com.tencent.open.downloadnew.DownloadManager.9;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class bdkp
{
  protected static bdkp a;
  public static final String a;
  protected static final byte[] a;
  protected final int a;
  protected long a;
  private bdkf jdField_a_of_type_Bdkf = new bdkt(this);
  private bdkg jdField_a_of_type_Bdkg;
  private bdkx jdField_a_of_type_Bdkx;
  protected PackageInstallReceiver a;
  public ITMAssistantDownloadClientListener a;
  public ITMAssistantDownloadLogListener a;
  protected TMAssistantDownloadClient a;
  protected WeakReference<AppInterface> a;
  public ConcurrentHashMap<String, DownloadInfo> a;
  protected ConcurrentLinkedQueue<bdko> a;
  public boolean a;
  protected long b;
  protected String b;
  protected boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator + "tencent" + File.separator + ".qqdownload" + File.separator;
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bdkp()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new bdkv(this);
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener = new bdku(this);
    bdht.c("DownloadManager_", "DownloadManager create QQ5.0");
    this.jdField_a_of_type_Bdkx = bdkx.a();
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    bcxm.a().a().registerReceiver(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver, localIntentFilter);
    bdmg.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(bdlx.a());
    a(bdmg.a());
    ThreadManager.excute(new DownloadManager.2(this), 32, null, true);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 20;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 6: 
      return 10;
    }
    return -2;
  }
  
  /* Error */
  public static bdkp a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +33 -> 41
    //   11: new 2	bdkp
    //   14: dup
    //   15: invokespecial 185	bdkp:<init>	()V
    //   18: putstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   21: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   24: ldc 187
    //   26: putfield 59	bdkp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   29: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   32: invokevirtual 189	bdkp:b	()V
    //   35: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   38: invokevirtual 192	bdkp:f	()V
    //   41: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 195	java/lang/Exception:printStackTrace	()V
    //   55: goto -14 -> 41
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	43	0	localbdkp	bdkp
    //   50	2	0	localException	Exception
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	41	50	java/lang/Exception
    //   3	7	58	finally
    //   11	41	58	finally
    //   41	48	58	finally
    //   51	55	58	finally
    //   59	62	58	finally
  }
  
  private void a(Bundle paramBundle)
  {
    bdht.c("DownloadManager_", "receive write code msg......");
    if (paramBundle == null)
    {
      bdht.c("DownloadManager_", "receive write code msg but data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManager.21(this, paramBundle), 32, null, true);
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2)
  {
    if ((paramDownloadInfo.jdField_e_of_type_Int != 4) && (paramDownloadInfo.jdField_d_of_type_Boolean))
    {
      bdht.b("DownloadManager_", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        break label29;
      }
    }
    label29:
    label217:
    for (;;)
    {
      return;
      if (new File(paramString1).exists())
      {
        boolean bool = bdiw.a(bcxm.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"));
        bdes.a().a(100, paramDownloadInfo);
        for (;;)
        {
          if ((!bool) || (!paramString2.equals("com.tencent.android.qqdownloader")) || (!paramDownloadInfo.jdField_c_of_type_JavaLangString.equals("1101070898"))) {
            break label217;
          }
          bdht.a("DownloadManager_", "report yyb start install");
          String str = bdjc.a(paramDownloadInfo.jdField_h_of_type_JavaLangString, "NEWYYB");
          bdlc.a().b();
          paramString2 = bdlc.a().a();
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = paramDownloadInfo.jdField_c_of_type_JavaLangString;
          }
          bdjc.a("311", str, paramString1, paramDownloadInfo.o);
          paramDownloadInfo = bcxm.a().a();
          if (paramDownloadInfo == null) {
            break;
          }
          bdjc.a(paramDownloadInfo, "312", str, paramString1);
          return;
          bool = bdiw.a(bcxm.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"));
          bdes.a().a(100, paramDownloadInfo);
        }
      }
    }
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localbdkp	bdkp
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    bdht.c("DownloadManager_", ">>startDownload downloadInfo:" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_c_of_type_Boolean) {
      ImageCache.a("app", bdhr.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, 100), new bdkq(this, paramDownloadInfo));
    }
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Object localObject;
    if (localDownloadInfo != null) {
      if (a(localDownloadInfo, paramDownloadInfo))
      {
        localObject = localDownloadInfo;
        bdht.a("DownloadManager_", "startDownload() downloadInfo != null>>>downloadInfo.url=" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "downloadInfo.isAutoInstall" + paramDownloadInfo.jdField_a_of_type_Boolean + "+++++downloadInfo.downloadType=" + paramDownloadInfo.jdField_a_of_type_Int + "  test" + a(paramDownloadInfo.jdField_c_of_type_JavaLangString));
        label155:
        e((DownloadInfo)localObject);
        if (("com.tencent.mobileqq".equals(((DownloadInfo)localObject).jdField_e_of_type_JavaLangString)) && (b())) {
          f((DownloadInfo)localObject);
        }
        if (((DownloadInfo)localObject).jdField_a_of_type_Int != 1) {
          break label515;
        }
      }
    }
    label515:
    for (String str = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;; str = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString)
    {
      int i = ((DownloadInfo)localObject).jdField_a_of_type_Int;
      HashMap localHashMap = new HashMap();
      localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, ((DownloadInfo)localObject).jdField_e_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(((DownloadInfo)localObject).jdField_b_of_type_Int));
      localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
      localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, ((DownloadInfo)localObject).n);
      localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, ((DownloadInfo)localObject).jdField_f_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(((DownloadInfo)localObject).jdField_i_of_type_Int));
      localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(((DownloadInfo)localObject).jdField_d_of_type_Boolean));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(((DownloadInfo)localObject).jdField_d_of_type_Long));
      ThreadManager.getSubThreadHandler().post(new DownloadManager.11(this, str, localHashMap, i, (DownloadInfo)localObject, localDownloadInfo, paramDownloadInfo));
      try
      {
        bdgu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (DownloadInfo)localObject);
        return;
      }
      catch (Throwable paramDownloadInfo) {}
      localObject = paramDownloadInfo;
      break;
      localObject = "900";
      if (paramDownloadInfo.jdField_g_of_type_Int == 12) {
        localObject = "2000";
      }
      bdjc.a((String)localObject, paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
      bdht.a("DownloadManager_", "+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "+++++downloadInfo.downloadType=" + paramDownloadInfo.jdField_a_of_type_Int);
      localObject = paramDownloadInfo;
      break label155;
    }
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.15(this, paramDownloadInfo));
  }
  
  private void j(DownloadInfo paramDownloadInfo)
  {
    bdht.c("DownloadManager_", "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      bdht.c("DownloadManager_", "receive get code msg but info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManager.20(this, paramDownloadInfo));
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_a_of_type_Bdkg != null) {
      return this.jdField_a_of_type_Bdkg.a(paramDownloadInfo.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, paramDownloadInfo.l, null);
    }
    this.jdField_a_of_type_Bdkg = null;
    return -40;
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int != 1) {
        break label76;
      }
    }
    label76:
    for (localObject = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadManager.12(this, (String)localObject));
      bdht.a("DownloadManager_", "pause url=" + (String)localObject + ", appid=" + paramString);
      return 0;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      bdht.a("DownloadManager_", "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bdkm.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localBundle.putString(bdkm.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(bdkm.jdField_d_of_type_JavaLangString, paramDownloadInfo.k);
    localBundle.putString(bdkm.jdField_f_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
    localBundle.putInt(bdkm.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int);
    localBundle.putString(bdkm.jdField_i_of_type_JavaLangString, paramDownloadInfo.jdField_h_of_type_JavaLangString);
    try
    {
      bdht.a("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.jdField_c_of_type_JavaLangString + " apkId=" + paramDownloadInfo.k + " taskAppId=" + paramDownloadInfo.jdField_j_of_type_JavaLangString + " packageName=" + paramDownloadInfo.jdField_e_of_type_JavaLangString + " version=" + paramDownloadInfo.jdField_b_of_type_Int + " via=" + paramDownloadInfo.jdField_h_of_type_JavaLangString);
      paramDownloadInfo = bdlc.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        bdht.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      bdht.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    bdht.a("DownloadManager_", "getTaskInfoFromMyApp>>>", localException1);
    return paramDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a().getDownloadTaskState(paramString);
        if (localTMAssistantDownloadTaskInfo == null) {
          bdht.a("DownloadManager_", "getTaskInfoFromSDK null url=" + paramString);
        }
        return localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        bdht.c("DownloadManager_", "downloadSDKClient>>>", localException);
      }
      Object localObject = null;
    }
  }
  
  public TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString).registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    if (QLog.isColorLevel())
    {
      QLog.i("DownloadManager_", 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString).registerLogListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSettingClient != null)
      {
        localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdht.e("DownloadManager_", "exception: " + localException.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.l;
    }
    return "";
  }
  
  public WeakReference<AppInterface> a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {}
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
        {
          localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bdht.c("DownloadManager_", "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      return localObject1;
    }
    finally {}
  }
  
  protected List<DownloadInfo> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo.a() == paramInt) {
          localArrayList.add(localDownloadInfo);
        }
      }
    }
    finally {}
    return localList;
  }
  
  public List<DownloadInfo> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    bdht.a("DownloadManager_", "getDownloadInfoById via == " + paramString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.jdField_h_of_type_JavaLangString)) && (localDownloadInfo.jdField_h_of_type_JavaLangString.equals(paramString))) {
        localArrayList.add(localDownloadInfo);
      }
    }
    bdht.a("DownloadManager_", "getDownloadInfoByVia result =" + localArrayList);
    return localArrayList;
  }
  
  public ConcurrentLinkedQueue<bdko> a()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.1(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        bdht.e("DownloadManager_", "notifyListener info == null id=" + paramInt1);
        return;
      }
      finally {}
      switch (paramInt1)
      {
      default: 
        break;
      case -2: 
        a(paramDownloadInfo, paramInt2, paramString);
        break;
      case 20: 
        bdht.a("DownloadManager_", ajyc.a(2131703499) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).onDownloadWait(paramDownloadInfo);
        }
      case 3: 
        bdht.a("DownloadManager_", ajyc.a(2131703487) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).onDownloadPause(paramDownloadInfo);
        }
      case 4: 
        bdht.a("DownloadManager_", ajyc.a(2131703493) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).onDownloadFinish(paramDownloadInfo);
        }
        bdgu.a(2, null, 100, paramDownloadInfo);
        break;
      case 10: 
        bdht.a("DownloadManager_", ajyc.a(2131703496) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        bdme.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        bdmb.a().a(paramDownloadInfo.jdField_g_of_type_JavaLangString);
        paramDownloadInfo.a(10);
        bdht.a("DownloadManager_", "downloadInfo.state = " + paramDownloadInfo.a());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).onDownloadCancel(paramDownloadInfo);
        }
      case 2: 
        if ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          bdht.a("DownloadManager_", ajyc.a(2131703478) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramDownloadInfo = a(2);
          bdht.a("DownloadManager_", ajyc.a(2131703486) + paramDownloadInfo.size());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext())
          {
            bdko localbdko = (bdko)paramString.next();
            bdht.a("DownloadManager_", "###下载1 listner name" + localbdko.getClass().getName());
            localbdko.onDownloadUpdate(paramDownloadInfo);
          }
        }
        break;
      case 6: 
        bdht.a("DownloadManager_", ajyc.a(2131703497) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).installSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
        }
      case 13: 
        bdht.a("DownloadManager_", ajyc.a(2131703483) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).packageReplaced(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
        }
      case 9: 
        bdht.a("DownloadManager_", ajyc.a(2131703504) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((bdko)paramString.next()).uninstallSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManager.17(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
  
  public void a(bdko parambdko)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(parambdko)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambdko);
      }
      return;
    }
    finally
    {
      parambdko = finally;
      throw parambdko;
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    try
    {
      h(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      bdht.d("DownloadManager_", "handleDownloadErrorCallBack info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    bdht.d("DownloadManager_", "handleDownloadErrorCallBack code = " + paramInt + " msg = " + paramString);
    if ((paramInt >= 400) && (paramInt <= 599)) {}
    for (;;)
    {
      try
      {
        paramString = bcxm.a().a().getString(2131694876);
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      paramString = bcxm.a().a().getString(2131694871);
      int i = 3;
      paramDownloadInfo.a(i);
      bdht.a("DownloadManager_", ajyc.a(2131703492) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((bdko)((Iterator)localObject).next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
        continue;
        bdht.a("DownloadManager_", ajyc.a(2131703481));
        if ((paramDownloadInfo.jdField_e_of_type_JavaLangString != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_e_of_type_JavaLangString)) && (paramDownloadInfo.jdField_a_of_type_Int != 1) && (b()))
        {
          bdht.a("DownloadManager_", ajyc.a(2131703482));
          ThreadManager.getSubThreadHandler().post(new DownloadManager.6(this, paramDownloadInfo));
          return;
        }
        paramDownloadInfo.a(4);
        if (paramDownloadInfo.jdField_a_of_type_Int == 1)
        {
          i(paramDownloadInfo);
          return;
        }
        ThreadManager.excute(new DownloadManager.7(this, paramDownloadInfo), 32, null, true);
        return;
        paramString = bcxm.a().a().getString(2131694881);
        i = 3;
        continue;
        paramString = bcxm.a().a().getString(2131694876);
        i = 3;
        continue;
        paramString = bcxm.a().a().getString(2131694871);
        i = 3;
        continue;
        paramString = bcxm.a().a().getString(2131694883);
        i = 3;
        continue;
        paramString = bcxm.a().a().getString(2131694880);
        i = 3;
        continue;
        paramString = bcxm.a().a().getString(2131694878);
        i = 3;
        continue;
        label459:
        int j;
        if (paramInt == 712)
        {
          localObject = bcxm.a().a().getString(2131694873);
          j = 10;
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
          {
            paramString = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
            if ((paramString != null) && (akva.a().a() == 4)) {
              paramString.obtainMessage(1134019).sendToTarget();
            }
          }
          i = j;
          paramString = (String)localObject;
          if (paramDownloadInfo == null) {
            continue;
          }
          if (paramDownloadInfo.jdField_a_of_type_Int != 1) {
            break label597;
          }
        }
        label597:
        for (String str = paramDownloadInfo.jdField_i_of_type_JavaLangString;; str = paramDownloadInfo.jdField_d_of_type_JavaLangString)
        {
          i = j;
          paramString = (String)localObject;
          if (str == null) {
            break;
          }
          ThreadManager.excute(new DownloadManager.8(this, str, paramDownloadInfo), 32, null, true);
          i = j;
          paramString = (String)localObject;
          break;
          localObject = bcxm.a().a().getString(2131694874);
          break label459;
        }
        bdht.a("DownloadManager_", ajyc.a(2131703505));
        i = 3;
      }
      else
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        b(paramString);
        return;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    if ((a() == null) || (a().get() == null)) {}
    while ((AppInterface)a().get() == null) {
      return;
    }
    int i = 14;
    if ("biz_src_yyb".equals(paramDownloadInfo.m)) {}
    for (;;)
    {
      Bundle localBundle1 = null;
      if (!TextUtils.isEmpty(paramDownloadInfo.jdField_f_of_type_JavaLangString))
      {
        localBundle1 = new Bundle();
        localBundle1.putString("appname", paramDownloadInfo.jdField_f_of_type_JavaLangString + ".apk");
      }
      bdht.c("DownloadManager_", "reportDownloadResult info.packageName = " + paramDownloadInfo.jdField_e_of_type_JavaLangString + ",info.urlStr = " + paramDownloadInfo.jdField_d_of_type_JavaLangString + ",info.filePath = " + paramDownloadInfo.l);
      Intent localIntent = new Intent("com.opensdk.downloadmanager.renameFilename");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filePath", paramDownloadInfo.l);
      localBundle2.putLong("dataLength", paramLong);
      localBundle2.putInt("fileSourceId", i);
      localBundle2.putBundle("otherData", localBundle1);
      localBundle2.putInt("peerType", -1);
      localIntent.putExtra("extraBundle", localBundle2);
      bcxm.a().a().sendBroadcast(localIntent);
      return;
      if ("biz_src_zf_games".equals(paramDownloadInfo.m)) {
        i = 15;
      } else if ("biz_src_jc_update".equals(paramDownloadInfo.m)) {
        i = 17;
      } else if ("biz_src_news".equals(paramDownloadInfo.m)) {
        i = 18;
      } else if ("biz_src_jc_vip".equals(paramDownloadInfo.m)) {
        i = 40;
      } else {
        i = 40;
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      bdht.c("DownloadManager_", "trafficReport info == null code = " + paramInt);
      return;
    }
    bdht.c("DownloadManager_", "trafficReport code = " + paramInt);
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "open appstore network error");
    }
    switch (paramInt)
    {
    default: 
      return;
    case -24: 
      a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "package invalid");
      return;
    case 0: 
    case 5: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "do not need to handle error");
      return;
    case 4: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "DownloadSDK_START_FAILED_EXISTED");
      return;
    case 1: 
    case 601: 
    case 602: 
    case 603: 
    case 605: 
    case 701: 
    case 702: 
    case 706: 
    case 707: 
    case 708: 
    case 709: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "network error");
      return;
    case 3: 
    case 600: 
    case 604: 
    case 700: 
    case 704: 
    case 705: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "download error");
      return;
    }
    a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "write file error");
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.jdField_b_of_type_Long = paramLong1;
      e(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.m);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: aload_2
    //   7: getfield 972	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   10: iconst_4
    //   11: if_icmpeq +19 -> 30
    //   14: ldc 90
    //   16: ldc_w 974
    //   19: invokestatic 98	bdht:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 976	bdkp:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_2
    //   31: getfield 979	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   34: astore 5
    //   36: aload_2
    //   37: getfield 982	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   40: i2l
    //   41: lstore_3
    //   42: aload_2
    //   43: getfield 985	com/tencent/apkupdate/logic/data/ApkUpdateDetail:fileMd5	Ljava/lang/String;
    //   46: astore_2
    //   47: ldc 90
    //   49: new 29	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 986
    //   59: invokestatic 708	ajyc:a	(I)Ljava/lang/String;
    //   62: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_3
    //   66: ldc2_w 987
    //   69: ldiv
    //   70: invokevirtual 991	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: ldc_w 993
    //   76: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 995
    //   86: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 98	bdht:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: aload 5
    //   103: putfield 369	com/tencent/open/downloadnew/DownloadInfo:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_1
    //   107: iconst_1
    //   108: putfield 351	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   111: lload_3
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle +8 -> 122
    //   117: aload_1
    //   118: lload_3
    //   119: putfield 436	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 976	bdkp:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   127: goto -100 -> 27
    //   130: astore_2
    //   131: ldc 90
    //   133: ldc_w 997
    //   136: aload_2
    //   137: invokestatic 589	bdht:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 976	bdkp:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   145: goto -118 -> 27
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	bdkp
    //   0	153	1	paramDownloadInfo	DownloadInfo
    //   0	153	2	paramApkUpdateDetail	ApkUpdateDetail
    //   41	78	3	l	long
    //   34	68	5	str	String
    // Exception table:
    //   from	to	target	type
    //   30	111	130	java/lang/Exception
    //   117	122	130	java/lang/Exception
    //   122	127	130	java/lang/Exception
    //   6	14	148	finally
    //   14	27	148	finally
    //   30	111	148	finally
    //   117	122	148	finally
    //   122	127	148	finally
    //   131	145	148	finally
  }
  
  public void a(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DownloadManager_", 2, "unregisterLogListener logListener == null");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DownloadManager_", 2, "unregisterLogListener");
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
        {
          this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterLogListener(paramITMAssistantDownloadLogListener);
          return;
        }
      }
      catch (Exception paramITMAssistantDownloadLogListener)
      {
        bdht.c("DownloadManager_", "unregisterLogListener Exception:", paramITMAssistantDownloadLogListener);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      bdmb.a().a(paramString);
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (bbev.b(BaseApplication.getContext()) == 1) {
      if ("biz_src_yyb".equals(paramString2)) {
        paramString2 = new String[] { "param_WIFIAppCenterDefaultDownloadFlow", "param_WIFIFlow", "param_Flow" };
      }
    }
    for (;;)
    {
      if ((a() == null) || (paramString2 == null))
      {
        bdht.c("DownloadManager_", "application or tags is null");
        return;
        if ("biz_src_jc_update".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterQQUpdateDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
        }
        if ("biz_src_zf_games".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterGameCenterDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
        }
        if ("biz_src_jc_vip".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterOthersDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
          if ("biz_src_yyb".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterDefaultDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_jc_update".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterQQUpdateDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_zf_games".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterGameCenterDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_jc_vip".equals(paramString2)) {
            paramString2 = new String[] { "param_XGAppCenterOthersDownloadFlow", "param_XGFlow", "param_Flow" };
          }
        }
      }
      else
      {
        AppInterface localAppInterface = (AppInterface)a().get();
        if (localAppInterface == null)
        {
          bdht.c("DownloadManager_", "appinterface is null");
          return;
        }
        try
        {
          localAppInterface.sendAppDataIncerment(localAppInterface.getCurrentAccountUin(), paramString2, paramLong);
          bdht.c("DownloadManager_", "sendAppDataIncerment logMsg: " + paramString1 + " ,fileSize : " + paramLong);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
      }
      paramString2 = null;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bdht.d("DownloadManager_", "appid is empty");
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      bdht.d("DownloadManager_", "clearDownloadInfo info == null");
      return;
    }
    bdht.a("DownloadManager_", "clearDownloadInfo info =" + ((DownloadInfo)localObject).toString());
    if (((DownloadInfo)localObject).jdField_c_of_type_Int == 0) {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int != 1) {
        break label124;
      }
    }
    label124:
    for (localObject = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManager.9(this, paramBoolean, (String)localObject));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      bdme.a().a(paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.jdField_e_of_type_Int == 4) || (localDownloadInfo.jdField_e_of_type_Int == 1) || (localDownloadInfo.jdField_c_of_type_Int != 1)) {
        break label293;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (bdiw.a(localDownloadInfo.jdField_e_of_type_JavaLangString))) {
        break label290;
      }
      str = localDownloadInfo.jdField_f_of_type_JavaLangString;
      label117:
      i += 1;
    }
    label273:
    label290:
    label293:
    for (;;)
    {
      break;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DownloadInfo)((Iterator)localObject1).next();
          ((DownloadInfo)localObject2).a(10);
          a(10, (DownloadInfo)localObject2);
        }
      }
      boolean bool = QAppCenterPluginProxyActivityTools.jdField_a_of_type_Boolean;
      if ((paramBoolean) && (i > 0))
      {
        localObject1 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
          break label273;
        }
      }
      for (str = str + ajyc.a(2131703494);; str = "")
      {
        str = str + i + ajyc.a(2131703479);
        if (!bool) {
          break;
        }
        bdid.a().a(str, 1);
        return;
      }
      bdlc.a().a(true, str);
      return;
      break label117;
    }
  }
  
  public boolean a(bdkg parambdkg)
  {
    if (parambdkg == null) {
      return false;
    }
    this.jdField_a_of_type_Bdkg = parambdkg;
    return true;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    bdht.a("DownloadManager_", "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    if (localDownloadInfo != null)
    {
      bdht.a("DownloadManager_", "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
      Object localObject;
      if (localDownloadInfo.jdField_c_of_type_Int == 0)
      {
        bdht.a("DownloadManager_", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.jdField_h_of_type_Int = localDownloadInfo.jdField_h_of_type_Int;
        if (localDownloadInfo.jdField_a_of_type_Int == 1)
        {
          localObject = localDownloadInfo.jdField_i_of_type_JavaLangString;
          localObject = a().a((String)localObject);
          if (localObject == null) {
            break label304;
          }
          bdht.a("DownloadManager_", "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(a(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.jdField_c_of_type_Int = 0;
          if (localDownloadInfo.jdField_a_of_type_Int != 1) {
            break label292;
          }
          if (!TextUtils.isEmpty(localDownloadInfo.l)) {
            break label280;
          }
          paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        for (;;)
        {
          if (paramDownloadInfo.jdField_e_of_type_Int == 4)
          {
            paramDownloadInfo.jdField_j_of_type_Int = localDownloadInfo.jdField_j_of_type_Int;
            if (paramDownloadInfo.jdField_j_of_type_Int != 0)
            {
              paramDownloadInfo.jdField_e_of_type_Int = 3;
              e(localDownloadInfo);
            }
          }
          return true;
          localObject = localDownloadInfo.jdField_d_of_type_JavaLangString;
          break;
          label280:
          paramDownloadInfo.l = localDownloadInfo.l;
          continue;
          label292:
          paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        label304:
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
        bdme.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
        paramDownloadInfo.jdField_e_of_type_Int = -100;
        return true;
      }
      if (localDownloadInfo.jdField_c_of_type_Int == 1)
      {
        localObject = a(localDownloadInfo);
        if (localObject != null)
        {
          int j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
          int i = j;
          if (j == -2) {
            i = 3;
          }
          paramDownloadInfo.a(i);
          paramDownloadInfo.jdField_c_of_type_Int = 1;
          paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
          if (!bdlc.a().e()) {
            paramDownloadInfo.jdField_f_of_type_Int = 0;
          }
          return true;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
        bdme.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
      }
    }
    return false;
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.jdField_a_of_type_Boolean = paramDownloadInfo2.jdField_a_of_type_Boolean;
    paramDownloadInfo1.jdField_b_of_type_Boolean = paramDownloadInfo2.jdField_b_of_type_Boolean;
    paramDownloadInfo1.jdField_c_of_type_Int = paramDownloadInfo2.jdField_c_of_type_Int;
    paramDownloadInfo1.jdField_h_of_type_JavaLangString = paramDownloadInfo2.jdField_h_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramDownloadInfo1.jdField_d_of_type_JavaLangString))
    {
      if (!paramDownloadInfo1.jdField_d_of_type_JavaLangString.equals(paramDownloadInfo2.jdField_d_of_type_JavaLangString))
      {
        a(paramDownloadInfo2.jdField_c_of_type_JavaLangString, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.jdField_d_of_type_JavaLangString = paramDownloadInfo2.jdField_d_of_type_JavaLangString;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = a().a(paramString);
    return (paramString != null) && (paramString.a() == 4);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, false);
    }
    if (paramString2 != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      a(10, paramString2);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        bdmb.a().a(paramString2.jdField_g_of_type_JavaLangString);
      }
      catch (Exception paramString1)
      {
        bdht.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
      }
    }
  }
  
  /* Error */
  public DownloadInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +57 -> 63
    //   9: aload_0
    //   10: getfield 64	bdkp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 661	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   16: invokeinterface 667 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 672 1 0
    //   30: ifeq +33 -> 63
    //   33: aload 4
    //   35: invokeinterface 675 1 0
    //   40: checkcast 216	com/tencent/open/downloadnew/DownloadInfo
    //   43: astore_3
    //   44: aload_1
    //   45: aload_3
    //   46: getfield 362	com/tencent/open/downloadnew/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq -31 -> 23
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bdkp
    //   0	73	1	paramString	String
    //   52	2	2	bool	boolean
    //   43	15	3	localDownloadInfo	DownloadInfo
    //   21	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	23	68	finally
    //   23	53	68	finally
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt == -2) {
        i = 3;
      }
      paramString.a(i);
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.m;
    }
    return "";
  }
  
  public List<DownloadInfo> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo != null) {
          if (localDownloadInfo.jdField_c_of_type_Int == 0)
          {
            if (localDownloadInfo.jdField_a_of_type_Int == 1)
            {
              paramString = localDownloadInfo.jdField_i_of_type_JavaLangString;
              label82:
              paramString = a().a(paramString);
              if (paramString == null) {
                break label230;
              }
              bdht.a("DownloadManager_", "queryDownloadInfosByVia sdk getReceiveDataLen=" + paramString.mReceiveDataLen + " getTotalDataLen=" + paramString.mTotalDataLen);
              localDownloadInfo.jdField_f_of_type_Int = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.a(a(paramString.mState));
              if (localDownloadInfo.jdField_a_of_type_Int != 1) {
                break label218;
              }
              if (!TextUtils.isEmpty(localDownloadInfo.l)) {}
            }
            label218:
            for (localDownloadInfo.l = paramString.mSavePath;; localDownloadInfo.l = paramString.mSavePath)
            {
              localArrayList.add(localDownloadInfo);
              break;
              paramString = localDownloadInfo.jdField_d_of_type_JavaLangString;
              break label82;
            }
            label230:
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
            bdme.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
            bdme.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.3(this), 5000L);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.4(this), 10000L);
  }
  
  public void b(bdko parambdko)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(parambdko)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(parambdko);
      }
      return;
    }
    finally
    {
      parambdko = finally;
      throw parambdko;
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        bdht.c("DownloadManager_", "complete info == null ");
        return;
      }
      finally {}
      if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_e_of_type_JavaLangString)) && (ajuf.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      }
      bdht.a("DownloadManager_", "onDownload complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
          i(paramDownloadInfo);
        } else {
          ThreadManager.getSubThreadHandler().post(new DownloadManager.13(this, paramDownloadInfo));
        }
      }
      else {
        ThreadManager.excute(new DownloadManager.14(this, paramDownloadInfo), 32, null, true);
      }
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        bdid.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      bdht.c("DownloadManager_", "showToast>>>", paramString);
    }
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public boolean b(bdkg parambdkg)
  {
    if (parambdkg == null) {}
    while ((this.jdField_a_of_type_Bdkg == null) || (parambdkg != this.jdField_a_of_type_Bdkg)) {
      return false;
    }
    this.jdField_a_of_type_Bdkg = null;
    return true;
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, true);
    }
    if (paramString2 != null)
    {
      if (paramBoolean) {
        a(10, paramString2);
      }
    }
    else {
      return true;
    }
    try
    {
      bdmb.a().a(paramString2.jdField_g_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramString1)
    {
      bdht.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
    }
    return true;
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.jdField_a_of_type_Int == 0) && (paramString.equals(localDownloadInfo.jdField_d_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 1) && (paramString.equals(localDownloadInfo.jdField_i_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 2) && (paramString.equals(localDownloadInfo.jdField_d_of_type_JavaLangString)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_f_of_type_Int = paramInt;
    }
    return paramString;
  }
  
  public void c()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20))) {
          a(localDownloadInfo.jdField_c_of_type_JavaLangString);
        }
      }
    }
    finally {}
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    if (paramDownloadInfo == null)
    {
      bdht.a("DownloadManager_", "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      bdht.a("DownloadManager_", "installDownload info is not apk");
      return;
    }
    Object localObject2 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.l)) {
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        localTMAssistantDownloadTaskInfo2 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo2 != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo2.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localTMAssistantDownloadTaskInfo1 = a(paramDownloadInfo);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo1 != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo1.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramDownloadInfo.l = ((String)localObject1);
          paramDownloadInfo.a(4);
          e(paramDownloadInfo);
        }
      }
    }
    for (localObject2 = localObject1;; localObject2 = paramDownloadInfo.l)
    {
      localObject1 = bdiw.a((String)localObject2);
      bdht.a("DownloadManager_", "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_a_of_type_Int);
      Log.v("DownloadManager_", "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_a_of_type_Int);
      if (localObject1 == null) {
        break label356;
      }
      bdht.c("DownloadManager_", "[installDownload] begin sendCheckDownloadReq pkgname=" + (String)localObject1);
      a(paramDownloadInfo, (String)localObject2, (String)localObject1);
      return;
      localTMAssistantDownloadTaskInfo2 = a(paramDownloadInfo);
      localObject1 = localObject2;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localTMAssistantDownloadTaskInfo1 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      localObject2 = localObject1;
      break;
    }
    label356:
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      bdht.a("DownloadManager_", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label392:
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      break label392;
    }
  }
  
  public void d()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20)))
        {
          localDownloadInfo.a(3);
          a(3, localDownloadInfo);
        }
      }
    }
    finally {}
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    bdht.c("DownloadManager_", "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
      bdjc.a("310", paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
    }
    if (!"5".equals(paramDownloadInfo.m)) {
      a(paramDownloadInfo.jdField_c_of_type_JavaLangString, false);
    }
    bdmb.a().a(paramDownloadInfo.jdField_g_of_type_JavaLangString);
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	bdkp:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   4: invokevirtual 712	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
    //   7: astore_1
    //   8: aload_1
    //   9: invokeinterface 672 1 0
    //   14: ifeq +40 -> 54
    //   17: aload_0
    //   18: aload_1
    //   19: invokeinterface 675 1 0
    //   24: checkcast 714	bdko
    //   27: invokevirtual 1226	bdkp:b	(Lbdko;)V
    //   30: goto -22 -> 8
    //   33: astore_1
    //   34: ldc 90
    //   36: ldc_w 1228
    //   39: aload_1
    //   40: invokestatic 574	bdht:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: ldc 2
    //   45: monitorenter
    //   46: aconst_null
    //   47: putstatic 184	bdkp:jdField_a_of_type_Bdkp	Lbdkp;
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: invokestatic 153	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   57: new 1230	com/tencent/open/downloadnew/DownloadManager$16
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 1231	com/tencent/open/downloadnew/DownloadManager$16:<init>	(Lbdkp;)V
    //   65: invokevirtual 448	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   68: pop
    //   69: goto -26 -> 43
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	bdkp
    //   7	12	1	localIterator	Iterator
    //   33	7	1	localException	Exception
    //   72	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	33	java/lang/Exception
    //   8	30	33	java/lang/Exception
    //   54	69	33	java/lang/Exception
    //   46	53	72	finally
    //   73	76	72	finally
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString))
      {
        bdht.c("DownloadManager_", "addDownloadInfo info.appId = " + paramDownloadInfo.jdField_c_of_type_JavaLangString + ",info.packageName = " + paramDownloadInfo.jdField_e_of_type_JavaLangString + ",info.filePath = " + paramDownloadInfo.l);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo);
        bdme.a().a(paramDownloadInfo);
      }
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.18(this), 3000L);
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Bdkg != null)
    {
      this.jdField_a_of_type_Bdkg.a(paramDownloadInfo.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_Bdkg = null;
  }
  
  public void g(DownloadInfo paramDownloadInfo)
  {
    bdht.c("DownloadManager_", "patchNewApkSuccess DownloadInfo|" + paramDownloadInfo);
    j(paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdkp
 * JD-Core Version:    0.7.0.1
 */