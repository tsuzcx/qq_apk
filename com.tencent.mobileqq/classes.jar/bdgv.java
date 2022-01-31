import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2.10;
import com.tencent.open.appstore.dl.DownloadManagerV2.11;
import com.tencent.open.appstore.dl.DownloadManagerV2.12;
import com.tencent.open.appstore.dl.DownloadManagerV2.13;
import com.tencent.open.appstore.dl.DownloadManagerV2.14;
import com.tencent.open.appstore.dl.DownloadManagerV2.15;
import com.tencent.open.appstore.dl.DownloadManagerV2.16;
import com.tencent.open.appstore.dl.DownloadManagerV2.19;
import com.tencent.open.appstore.dl.DownloadManagerV2.2;
import com.tencent.open.appstore.dl.DownloadManagerV2.20;
import com.tencent.open.appstore.dl.DownloadManagerV2.21;
import com.tencent.open.appstore.dl.DownloadManagerV2.22;
import com.tencent.open.appstore.dl.DownloadManagerV2.23;
import com.tencent.open.appstore.dl.DownloadManagerV2.24;
import com.tencent.open.appstore.dl.DownloadManagerV2.3;
import com.tencent.open.appstore.dl.DownloadManagerV2.4;
import com.tencent.open.appstore.dl.DownloadManagerV2.5;
import com.tencent.open.appstore.dl.DownloadManagerV2.6;
import com.tencent.open.appstore.dl.DownloadManagerV2.7;
import com.tencent.open.appstore.dl.DownloadManagerV2.8;
import com.tencent.open.appstore.dl.DownloadManagerV2.9;
import com.tencent.open.appstore.notice.NoticeReceiver;
import com.tencent.open.appstore.receiver.InstallStateReceiver;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
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

public class bdgv
  implements ITMAssistantDownloadClientListener
{
  private static volatile bdgv jdField_a_of_type_Bdgv;
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  private bdkf jdField_a_of_type_Bdkf = new bdgw(this);
  private bdkg jdField_a_of_type_Bdkg;
  private bdkx jdField_a_of_type_Bdkx;
  private NoticeReceiver jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver;
  private InstallStateReceiver jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, DownloadInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<bdko> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  private bdgv()
  {
    bdht.b("DownloadManagerV2", "DownloadManagerV2 init");
    this.jdField_a_of_type_JavaLangString = "com.tencent.open.appstore.dl.DownloadManagerV2";
    Object localObject = new HashMap();
    ReplaceMonitor.get().init(bcxm.a().a(), (Map)localObject);
    this.jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver = new InstallStateReceiver();
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addDataScheme("package");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REMOVED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REPLACED");
    this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver = new NoticeReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    String str = bdey.r();
    str = "." + str.replace(":", ".");
    localIntentFilter.addAction(bdmf.jdField_a_of_type_JavaLangString + str);
    localIntentFilter.addAction(bdmf.jdField_b_of_type_JavaLangString + str);
    localIntentFilter.addAction(bdmf.jdField_c_of_type_JavaLangString + str);
    localIntentFilter.addAction(bdmf.jdField_d_of_type_JavaLangString + str);
    localIntentFilter.addAction(bdmf.e + str);
    ThreadManager.excute(new DownloadManagerV2.2(this, (IntentFilter)localObject, localIntentFilter), 16, null, true);
    bdhj.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(bdhj.a());
    a(bdlx.a());
    ThreadManager.excute(new DownloadManagerV2.3(this), 32, null, true);
    this.jdField_a_of_type_Bdkx = bdkx.a();
  }
  
  private int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_a_of_type_Bdkg != null) {
      return this.jdField_a_of_type_Bdkg.a(paramDownloadInfo.e, paramDownloadInfo.jdField_b_of_type_Int, paramDownloadInfo.l, null);
    }
    this.jdField_a_of_type_Bdkg = null;
    return -40;
  }
  
  public static bdgv a()
  {
    if (jdField_a_of_type_Bdgv == null) {}
    try
    {
      if (jdField_a_of_type_Bdgv == null)
      {
        jdField_a_of_type_Bdgv = new bdgv();
        jdField_a_of_type_Bdgv.c();
        jdField_a_of_type_Bdgv.b();
      }
      return jdField_a_of_type_Bdgv;
    }
    finally {}
  }
  
  private DownloadInfo a(String paramString, int paramInt)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  private DownloadInfo a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = b(paramString);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_f_of_type_Int = i;
      paramString.jdField_c_of_type_Long = paramLong2;
    }
    return paramString;
  }
  
  private TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKClient(this.jdField_a_of_type_JavaLangString).registerDownloadTaskListener(this);
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
        bdht.e("DownloadManagerV2", "exception: " + localException.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(bcxm.a().a()).getDownloadSDKClient(this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  private void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      bdht.e("DownloadManagerV2", "notifyListener info == null id=" + paramInt1);
      return;
    }
    finally {}
    switch (paramInt1)
    {
    default: 
      paramInt1 = 1;
    }
    while (paramInt1 != 0)
    {
      bdht.b("DownloadManagerV2", "[notifyListener] Need Save Info:" + paramDownloadInfo);
      c(paramDownloadInfo);
      break;
      bdht.b("DownloadManagerV2", "[notifyListener] STATE_WAIT:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          ((bdko)paramString.next()).onDownloadWait(paramDownloadInfo);
          continue;
          bdht.b("DownloadManagerV2", "[notifyListener] STATE_PAUSE:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((bdko)paramString.next()).onDownloadPause(paramDownloadInfo);
          }
          bdht.b("DownloadManagerV2", "[notifyListener] STATE_COMPLETE:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramDownloadInfo.jdField_f_of_type_Int = 100;
          if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
            bdhk.e(paramDownloadInfo);
          }
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((bdko)paramString.next()).onDownloadFinish(paramDownloadInfo);
          }
          bdgu.a(12, null, 100, paramDownloadInfo);
          paramInt1 = 1;
          break;
          bdht.b("DownloadManagerV2", "[notifyListener] STATE_CANCEL:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          m(paramDownloadInfo);
          bdmb.a().a(paramDownloadInfo.g);
          paramDownloadInfo.a(10);
          bdht.b("DownloadManagerV2", "downloadInfo.state = " + paramDownloadInfo.a());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((bdko)paramString.next()).onDownloadCancel(paramDownloadInfo);
          }
          if (paramDownloadInfo.jdField_c_of_type_Int == 0)
          {
            bdhk.f(paramDownloadInfo);
            paramInt1 = 0;
            break;
            if ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              bdht.b("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              paramString = a(2);
              bdht.a("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING: infos size= " + paramString.size());
              Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (localIterator.hasNext())
              {
                bdko localbdko = (bdko)localIterator.next();
                bdht.a("DownloadManagerV2", "[notifyListener] DownloadConstants.STATE_DOWNLOADING: listener name:" + localbdko.getClass().getName());
                localbdko.onDownloadUpdate(paramString);
              }
              a(paramDownloadInfo, paramInt2, paramString);
              paramInt1 = 1;
              break;
              bdht.b("DownloadManagerV2", "[notifyListener] PACKAGE_INSTALLED:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (paramString.hasNext()) {
                ((bdko)paramString.next()).installSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
              }
              bdht.b("DownloadManagerV2", "[notifyListener] PACKAGE_REPLACED:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (paramString.hasNext()) {
                ((bdko)paramString.next()).packageReplaced(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
              }
              bdht.b("DownloadManagerV2", "[notifyListener] PACKAGE_UNINSTALLED:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (paramString.hasNext()) {
                ((bdko)paramString.next()).uninstallSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
              }
              paramInt1 = 1;
              break;
            }
          }
          paramInt1 = 0;
          break;
        }
      }
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    bdht.b("DownloadManagerV2", "[writeApkCodeAsync] ");
    if (paramBundle == null)
    {
      bdht.b("DownloadManagerV2", "[writeApkCodeAsync] data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManagerV2.22(this, paramBundle), 32, null, true);
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      bdht.b("DownloadManagerV2", "[onDownloadError] info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    bdht.b("DownloadManagerV2", "[onDownloadError] errorCode = " + paramInt + " msg = " + paramString);
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramString = bcxm.a().a().getString(2131694871);
        i = 3;
        paramDownloadInfo.a(i);
        bdht.b("DownloadManagerV2", "[onDownloadError] ListenerSize:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        if (!localIterator.hasNext()) {
          break label717;
        }
        ((bdko)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
        continue;
        if (paramDownloadInfo.e == null) {
          break label530;
        }
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (paramDownloadInfo.jdField_a_of_type_Int != 1) && (a()))
      {
        j(paramDownloadInfo);
        return;
      }
      label530:
      paramDownloadInfo.a(4);
      if (paramDownloadInfo.jdField_a_of_type_Int == 1)
      {
        l(paramDownloadInfo);
        return;
      }
      i(paramDownloadInfo);
      return;
      paramString = bcxm.a().a().getString(2131694881);
      int i = 3;
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
      if (paramInt == 712) {}
      for (paramString = bcxm.a().a().getString(2131694873);; paramString = bcxm.a().a().getString(2131694874))
      {
        h(paramDownloadInfo);
        i = 10;
        break;
      }
      label717:
      if ((!TextUtils.isEmpty(paramString)) && (paramInt != 6)) {
        b(paramString);
      }
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        bdhk.a(paramDownloadInfo, paramInt, paramString);
        return;
      }
      bdht.e("DownloadManagerV2", "[onDownloadError] downloadType=DOWNLOAD_TYPE_MYAPP, shouldn't report!");
      return;
      i = 3;
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramDownloadInfo.a() != 4) && (paramDownloadInfo.jdField_d_of_type_Boolean))
    {
      bdht.b("DownloadManagerV2", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        break label30;
      }
    }
    label30:
    label252:
    for (;;)
    {
      return;
      if (new File(paramString1).exists())
      {
        if (paramBoolean)
        {
          paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
          a(paramDownloadInfo, true);
        }
        paramBoolean = bdiw.a(bcxm.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"));
        bdhk.c(paramDownloadInfo);
        for (;;)
        {
          if ((!paramBoolean) || (!"com.tencent.android.qqdownloader".equals(paramString2)) || (!"1101070898".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString))) {
            break label252;
          }
          bdht.a("DownloadManagerV2", "report yyb start install");
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
          if (paramBoolean)
          {
            paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
            a(paramDownloadInfo, true);
          }
          paramBoolean = bdiw.a(bcxm.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"));
          bdhk.c(paramDownloadInfo);
        }
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bdht.d("DownloadManagerV2", "appid is empty");
      return;
    }
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo == null)
    {
      bdht.d("DownloadManagerV2", "clearDownloadInfo info == null");
      return;
    }
    bdht.a("DownloadManagerV2", "clearDownloadInfo info =" + localDownloadInfo.toString());
    if (localDownloadInfo.jdField_c_of_type_Int == 0) {
      if (localDownloadInfo.jdField_a_of_type_Int != 1) {
        break label113;
      }
    }
    label113:
    for (paramString = localDownloadInfo.jdField_i_of_type_JavaLangString;; paramString = localDownloadInfo.jdField_d_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.15(this, paramBoolean, paramString));
      }
      m(localDownloadInfo);
      return;
    }
  }
  
  private static int b(int paramInt)
  {
    return bdkp.a(paramInt);
  }
  
  private int b(String paramString)
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
      ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.14(this, (String)localObject));
      bdht.a("DownloadManagerV2", "pause url=" + (String)localObject + ", ticket=" + paramString);
      return 0;
    }
  }
  
  private DownloadInfo b(String paramString, int paramInt)
  {
    paramString = d(paramString);
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
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.5(this), 1000L);
  }
  
  private boolean c(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      a(paramString, false);
    }
    if (localDownloadInfo != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      a(10, localDownloadInfo);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        bdmb.a().a(localDownloadInfo.g);
      }
      catch (Exception paramString)
      {
        bdht.c("DownloadManagerV2", "downloadSDKClient>>>", paramString);
      }
    }
  }
  
  private DownloadInfo d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (TextUtils.equals(localDownloadInfo.jdField_c_of_type_JavaLangString, paramString)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  private boolean d(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      a(paramString, true);
    }
    if (localDownloadInfo != null)
    {
      if (paramBoolean) {
        a(10, localDownloadInfo);
      }
    }
    else {
      return true;
    }
    try
    {
      bdmb.a().a(localDownloadInfo.g);
      return true;
    }
    catch (Exception paramString)
    {
      bdht.c("DownloadManagerV2", "downloadSDKClient>>>", paramString);
    }
    return true;
  }
  
  private void g(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.7(this, paramDownloadInfo));
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
    {
      localObject = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if ((localObject != null) && (akva.a().a() == 4)) {
        ((MqqHandler)localObject).obtainMessage(1134019).sendToTarget();
      }
    }
    if (paramDownloadInfo.jdField_a_of_type_Int == 1) {}
    for (Object localObject = paramDownloadInfo.jdField_i_of_type_JavaLangString;; localObject = paramDownloadInfo.jdField_d_of_type_JavaLangString)
    {
      if (localObject != null) {
        ThreadManager.excute(new DownloadManagerV2.8(this, (String)localObject, paramDownloadInfo), 32, null, true);
      }
      return;
    }
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new DownloadManagerV2.9(this, paramDownloadInfo), 32, null, true);
  }
  
  private void j(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.10(this, paramDownloadInfo));
  }
  
  private void k(DownloadInfo paramDownloadInfo)
  {
    bdht.b("DownloadManagerV2", ">>startDownload downloadInfo:" + paramDownloadInfo);
    Object localObject1 = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = bdgt.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      bdht.b("DownloadManagerV2", ">>startDownload get from DB:" + localObject2);
    }
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((DownloadInfo)localObject2).a() == 4)
      {
        localObject1 = localObject2;
        if (!new File(((DownloadInfo)localObject2).l).exists())
        {
          bdht.e("DownloadManagerV2", "[startDownload] info succeed, but file is deleted!info=" + localObject2);
          ((DownloadInfo)localObject2).b();
          localObject1 = null;
        }
      }
    }
    if (localObject1 != null)
    {
      ((DownloadInfo)localObject1).jdField_c_of_type_Int = 0;
      ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString = paramDownloadInfo.jdField_h_of_type_JavaLangString;
      ((DownloadInfo)localObject1).m = paramDownloadInfo.m;
      ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = paramDownloadInfo.jdField_a_of_type_Boolean;
      ((DownloadInfo)localObject1).y = paramDownloadInfo.y;
      bdht.a("DownloadManagerV2", "startDownload() downloadInfo != null>>>downloadInfo.url=" + ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString + "downloadInfo.isAutoInstall" + ((DownloadInfo)localObject1).jdField_a_of_type_Boolean + "+++++downloadInfo.downloadType=" + ((DownloadInfo)localObject1).jdField_a_of_type_Int + "  test" + a(((DownloadInfo)localObject1).jdField_b_of_type_JavaLangString));
      paramDownloadInfo = (DownloadInfo)localObject1;
      paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
      bdht.b("DownloadManagerV2", ">>startDownload record download start process flag:" + paramDownloadInfo.w);
      a(paramDownloadInfo, true);
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (a())) {
        n(paramDownloadInfo);
      }
      if (paramDownloadInfo.jdField_a_of_type_Int != 1) {
        break label602;
      }
    }
    label602:
    for (localObject2 = paramDownloadInfo.jdField_i_of_type_JavaLangString;; localObject2 = paramDownloadInfo.jdField_d_of_type_JavaLangString)
    {
      int i = paramDownloadInfo.jdField_a_of_type_Int;
      HashMap localHashMap = new HashMap();
      localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.e);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.jdField_b_of_type_Int));
      localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.jdField_h_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
      localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.n);
      localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.jdField_f_of_type_JavaLangString);
      localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.jdField_i_of_type_Int));
      localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.jdField_d_of_type_Boolean));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.jdField_d_of_type_Long));
      localHashMap.put(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID, paramDownloadInfo.m);
      ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.13(this, (String)localObject2, localHashMap, i, paramDownloadInfo, (DownloadInfo)localObject1));
      try
      {
        bdgu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramDownloadInfo);
        return;
      }
      catch (Throwable paramDownloadInfo) {}
      bdhk.a(paramDownloadInfo);
      break;
    }
  }
  
  private void l(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.16(this, paramDownloadInfo));
  }
  
  private void m(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      bdgt.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void n(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Bdkg != null)
    {
      this.jdField_a_of_type_Bdkg.a(paramDownloadInfo.e, paramDownloadInfo.jdField_b_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_Bdkg = null;
  }
  
  private void o(DownloadInfo paramDownloadInfo)
  {
    bdht.b("DownloadManagerV2", "[getApkCodeAsync]");
    if (paramDownloadInfo == null)
    {
      bdht.b("DownloadManagerV2", "[getApkCodeAsync] info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.21(this, paramDownloadInfo));
  }
  
  public int a(String paramString)
  {
    return b(DownloadInfo.b(paramString));
  }
  
  public DownloadInfo a(String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      bdht.a("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      localObject = null;
    }
    DownloadInfo localDownloadInfo;
    do
    {
      return localObject;
      localDownloadInfo = (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localDownloadInfo;
    } while (localDownloadInfo != null);
    ThreadManager.excute(new DownloadManagerV2.11(this, paramString), 16, null, true);
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bdkm.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localBundle.putString(bdkm.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(bdkm.jdField_d_of_type_JavaLangString, paramDownloadInfo.k);
    localBundle.putString(bdkm.jdField_f_of_type_JavaLangString, paramDownloadInfo.e);
    localBundle.putInt(bdkm.e, paramDownloadInfo.jdField_b_of_type_Int);
    localBundle.putString(bdkm.jdField_i_of_type_JavaLangString, paramDownloadInfo.jdField_h_of_type_JavaLangString);
    try
    {
      bdht.a("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.jdField_c_of_type_JavaLangString + " apkId=" + paramDownloadInfo.k + " taskAppId=" + paramDownloadInfo.jdField_j_of_type_JavaLangString + " packageName=" + paramDownloadInfo.e + " version=" + paramDownloadInfo.jdField_b_of_type_Int + " via=" + paramDownloadInfo.jdField_h_of_type_JavaLangString);
      paramDownloadInfo = bdlc.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        bdht.a("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      bdht.a("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    bdht.b("DownloadManagerV2", "getTaskInfoFromMyApp>>>" + localException1.getMessage());
    return paramDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = null;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    if (!TextUtils.isEmpty(paramString)) {
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      TMAssistantDownloadClient localTMAssistantDownloadClient = a();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      long l2 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      localTMAssistantDownloadTaskInfo2 = localTMAssistantDownloadClient.getDownloadTaskState(paramString);
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      long l3 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      bdht.e("NEW_QAPP_TIME_COST", "step1=" + (l2 - l1) + ",step2=" + (l3 - l2));
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdht.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
      }
    }
    if (localTMAssistantDownloadTaskInfo1 == null) {
      bdht.a("DownloadManagerV2", "getTaskInfoFromSDK null url=" + paramString);
    }
    return localTMAssistantDownloadTaskInfo1;
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
          bdht.c("DownloadManagerV2", "getQQAppInterface>>>", localException);
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
  
  public List<DownloadInfo> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((paramString.equals(localDownloadInfo.e)) && (localDownloadInfo.a() == paramInt)) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap<String, DownloadInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.4(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManagerV2.19(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
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
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        bdht.b("DownloadManagerV2", "[onDownloadComplete] info == null ");
        return;
      }
      finally {}
      if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ajuf.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      }
      bdht.b("DownloadManagerV2", "[onDownloadComplete] complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
          l(paramDownloadInfo);
        } else {
          g(paramDownloadInfo);
        }
      }
      else {
        ThreadManager.excute(new DownloadManagerV2.6(this, paramDownloadInfo), 32, null, true);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    bdht.b("DownloadManagerV2", "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
      bdhk.a(paramDownloadInfo, paramInt);
    }
    if (!"5".equals(paramDownloadInfo.m)) {
      a(paramDownloadInfo.jdField_b_of_type_JavaLangString, false);
    }
    bdmb.a().a(paramDownloadInfo.g);
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
      bdht.b("DownloadManagerV2", "reportDownloadResult info.packageName = " + paramDownloadInfo.e + ",info.urlStr = " + paramDownloadInfo.jdField_d_of_type_JavaLangString + ",info.filePath = " + paramDownloadInfo.l);
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
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +19 -> 22
    //   6: aload_1
    //   7: invokevirtual 1053	com/tencent/open/downloadnew/DownloadInfo:a	()V
    //   10: aload_1
    //   11: getfield 713	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokestatic 509	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: ldc 50
    //   27: new 118	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1055
    //   37: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 424	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 1057
    //   50: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: getfield 210	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   57: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 1010
    //   63: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: getfield 215	com/tencent/open/downloadnew/DownloadInfo:l	Ljava/lang/String;
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 57	bdht:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 34	bdgv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: aload_1
    //   84: getfield 713	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   87: aload_1
    //   88: invokevirtual 1058	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: new 1060	com/tencent/open/appstore/dl/DownloadManagerV2$17
    //   95: dup
    //   96: aload_0
    //   97: aload_1
    //   98: iload_2
    //   99: invokespecial 1063	com/tencent/open/appstore/dl/DownloadManagerV2$17:<init>	(Lbdgv;Lcom/tencent/open/downloadnew/DownloadInfo;Z)V
    //   102: bipush 32
    //   104: aconst_null
    //   105: iconst_1
    //   106: invokestatic 161	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   109: goto -87 -> 22
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	bdgv
    //   0	117	1	paramDownloadInfo	DownloadInfo
    //   0	117	2	paramBoolean	boolean
    //   17	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	18	112	finally
    //   25	109	112	finally
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt)
  {
    DownloadInfo localDownloadInfo2 = d(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = bdlc.a().a(paramTMAssistantCallYYBParamStruct, null);
      c(localDownloadInfo1);
    }
    localDownloadInfo1.jdField_f_of_type_Int = paramInt;
    localDownloadInfo1.a(2);
    a(2, localDownloadInfo1);
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, TMAssistantCallYYBTaskInfo paramTMAssistantCallYYBTaskInfo, int paramInt2, String paramString)
  {
    int i = b(paramInt1);
    DownloadInfo localDownloadInfo = b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
    if ((localDownloadInfo == null) && (paramInt1 != 6))
    {
      paramTMAssistantCallYYBTaskInfo = bdlc.a().a(paramTMAssistantCallYYBParamStruct, null);
      c(paramTMAssistantCallYYBTaskInfo);
      b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
    }
    for (paramTMAssistantCallYYBParamStruct = paramTMAssistantCallYYBTaskInfo; paramTMAssistantCallYYBParamStruct != null; paramTMAssistantCallYYBParamStruct = localDownloadInfo) {
      for (;;)
      {
        bdht.b("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + paramTMAssistantCallYYBParamStruct.toString());
        a(i, paramTMAssistantCallYYBParamStruct, paramInt2, paramString);
        return;
        if (((paramInt1 == 2) || (paramInt1 == 3)) && (bdlc.a().e()))
        {
          if (paramTMAssistantCallYYBTaskInfo != null) {}
          try
          {
            long l1 = paramTMAssistantCallYYBTaskInfo.mReceiveDataLen;
            long l2 = paramTMAssistantCallYYBTaskInfo.mTotalDataLen;
            paramInt1 = (int)((float)l1 * 100.0F / (float)l2);
            localDownloadInfo.jdField_f_of_type_Int = paramInt1;
            bdht.b("DownloadManagerV2", "onYYBDownloadTaskStateChanged info progress = " + paramInt1);
            paramTMAssistantCallYYBParamStruct = localDownloadInfo;
          }
          catch (Exception paramTMAssistantCallYYBParamStruct)
          {
            bdht.c("DownloadManagerV2", "onYYBDownloadTaskStateChanged>>>", paramTMAssistantCallYYBParamStruct);
          }
        }
      }
    }
    bdht.b("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener error dlInfo == null");
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      bdmb.a().a(paramString);
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
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 4) || (localDownloadInfo.a() == 1) || (localDownloadInfo.jdField_c_of_type_Int != 1)) {
        break label295;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (bdiw.a(localDownloadInfo.e))) {
        break label292;
      }
      str = localDownloadInfo.jdField_f_of_type_JavaLangString;
      label118:
      i += 1;
    }
    label274:
    label292:
    label295:
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
          break label274;
        }
      }
      for (str = str + ajyc.a(2131703500);; str = "")
      {
        str = str + i + ajyc.a(2131703511);
        if (!bool) {
          break;
        }
        bdid.a().a(str, 1);
        return;
      }
      bdlc.a().a(true, str);
      return;
      break label118;
    }
  }
  
  public boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
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
    return a(paramDownloadInfo, true);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    Object localObject3 = null;
    if (paramDownloadInfo == null)
    {
      bdht.a("DownloadManagerV2", "installDownload info == null");
      return false;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      bdht.a("DownloadManagerV2", "installDownload info is not apk");
      return false;
    }
    Object localObject1 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
    if (TextUtils.isEmpty(paramDownloadInfo.l)) {
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        localTMAssistantDownloadTaskInfo = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject2 = localObject1;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
          localObject1 = localObject2;
          localObject3 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            paramDownloadInfo.jdField_c_of_type_Int = 1;
            localObject3 = localTMAssistantDownloadTaskInfo;
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
            localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
          }
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramDownloadInfo.l = ((String)localObject2);
          paramDownloadInfo.a(4);
          c(paramDownloadInfo);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = paramDownloadInfo.l)
    {
      if (new File((String)localObject1).canRead()) {
        break label301;
      }
      bdht.b("DownloadManagerV2", "can't read apk file. installDownload localAPKPath=" + (String)localObject1);
      return false;
      localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
      localObject2 = localObject1;
      if (localTMAssistantDownloadTaskInfo != null)
      {
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo.mState == 4) {
          localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
        }
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject3 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      localObject1 = localObject2;
      break;
    }
    label301:
    Object localObject2 = bdiw.a((String)localObject1);
    bdht.b("DownloadManagerV2", "installDownload localAPKPath=" + (String)localObject1 + ", apkPackageName=" + (String)localObject2 + " updateType=" + paramDownloadInfo.jdField_a_of_type_Int);
    if (localObject2 != null)
    {
      bdht.c("DownloadManagerV2", "[installDownload] begin sendCheckDownloadReq pkgname=" + (String)localObject2);
      a(paramDownloadInfo, (String)localObject1, (String)localObject2, paramBoolean);
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      bdht.a("DownloadManagerV2", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label434:
      a(-2, paramDownloadInfo, -24, "");
      return false;
    }
    catch (Exception localException)
    {
      break label434;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return c(DownloadInfo.b(paramString), paramBoolean);
  }
  
  public DownloadInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bdht.a("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      return null;
    }
    return a(DownloadInfo.b(paramString));
  }
  
  public List<DownloadInfo> b(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = bdgt.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramString.next();
      if (localDownloadInfo.a() == paramInt) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.20(this), 3000L);
    }
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
    try
    {
      ThreadManager.excute(new DownloadManagerV2.12(this, paramDownloadInfo), 16, null, true);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
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
      bdht.c("DownloadManagerV2", "showToast>>>", paramString);
    }
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
  
  public boolean b(DownloadInfo paramDownloadInfo)
  {
    bdht.a("DownloadManagerV2", "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      localDownloadInfo = c(paramDownloadInfo.e);
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        bdht.a("DownloadManagerV2", "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
        Object localObject;
        if (localDownloadInfo.jdField_c_of_type_Int == 0)
        {
          bdht.a("DownloadManagerV2", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
          paramDownloadInfo.jdField_h_of_type_Int = localDownloadInfo.jdField_h_of_type_Int;
          if (localDownloadInfo.jdField_a_of_type_Int == 1)
          {
            localObject = localDownloadInfo.jdField_i_of_type_JavaLangString;
            localObject = a().a((String)localObject);
            if (localObject == null) {
              break label318;
            }
            bdht.a("DownloadManagerV2", "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
            paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
            paramDownloadInfo.a(b(((TMAssistantDownloadTaskInfo)localObject).mState));
            paramDownloadInfo.jdField_c_of_type_Int = 0;
            if (localDownloadInfo.jdField_a_of_type_Int != 1) {
              break label306;
            }
            if (!TextUtils.isEmpty(localDownloadInfo.l)) {
              break label294;
            }
            paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          for (;;)
          {
            if (paramDownloadInfo.a() == 4)
            {
              paramDownloadInfo.jdField_j_of_type_Int = localDownloadInfo.jdField_j_of_type_Int;
              if (paramDownloadInfo.jdField_j_of_type_Int != 0)
              {
                paramDownloadInfo.a(3);
                c(localDownloadInfo);
              }
            }
            return true;
            localObject = localDownloadInfo.jdField_d_of_type_JavaLangString;
            break;
            label294:
            paramDownloadInfo.l = localDownloadInfo.l;
            continue;
            label306:
            paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          label318:
          m(localDownloadInfo);
          paramDownloadInfo.a(-100);
          return true;
        }
        if (localDownloadInfo.jdField_c_of_type_Int == 1)
        {
          localObject = a(localDownloadInfo);
          if (localObject != null)
          {
            int j = b(((TMAssistantDownloadTaskInfo)localObject).mState);
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
          m(localDownloadInfo);
        }
      }
      return false;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return d(DownloadInfo.b(paramString), paramBoolean);
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (paramString.equals(localDownloadInfo.e)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    a(paramDownloadInfo, false);
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a().a(9, paramDownloadInfo);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 2);
      a().a(13, paramDownloadInfo);
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 1);
      a().a(6, paramDownloadInfo);
    }
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.24(this, paramString, paramLong1, paramLong2));
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.23(this, paramTMAssistantDownloadClient, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    bdht.e("DownloadManagerV2", "OnDwonloadSDKServiceInvalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgv
 * JD-Core Version:    0.7.0.1
 */