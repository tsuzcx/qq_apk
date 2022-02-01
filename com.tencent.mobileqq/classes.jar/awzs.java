import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.1;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;
import mqq.os.MqqHandler;

public class awzs
  implements awzm
{
  public static int a;
  private static volatile awzs jdField_a_of_type_Awzs;
  public static String a;
  public static ConcurrentHashMap<String, String> a;
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static boolean c;
  public static String d;
  public static volatile boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  private long jdField_a_of_type_Long;
  private awzh jdField_a_of_type_Awzh;
  protected awzi a;
  private awzk jdField_a_of_type_Awzk;
  private awzl jdField_a_of_type_Awzl;
  public awzo a;
  private awzp jdField_a_of_type_Awzp = new awzp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  private axag jdField_a_of_type_Axag;
  private axcm jdField_a_of_type_Axcm = axcm.a();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  public HashSet<RecentBaseData> a;
  public CopyOnWriteArraySet<Long> a;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private AppRuntime.InterceptKickListener jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener;
  private AppRuntime.KickParams jdField_a_of_type_MqqAppAppRuntime$KickParams;
  private awzo b;
  public ConcurrentHashMap<String, axao> b;
  public ConcurrentHashMap<String, axao> c;
  private int d;
  public ConcurrentHashMap<Long, axcs> d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
  public ConcurrentHashMap<Long, axcs> e;
  private int f;
  public ConcurrentHashMap<Long, axap> f;
  public ConcurrentHashMap<Long, axap> g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_f_of_type_Boolean = true;
  }
  
  private awzs()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Awzi = new awzt(this);
    this.jdField_b_of_type_Awzo = new awzv(this);
    this.jdField_f_of_type_Int = 3;
    jdField_g_of_type_Boolean = true;
  }
  
  public static awzs a()
  {
    if (jdField_a_of_type_Awzs == null) {}
    try
    {
      if (jdField_a_of_type_Awzs == null) {
        jdField_a_of_type_Awzs = new awzs();
      }
      return jdField_a_of_type_Awzs;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aFailed: " + paramInt);
    }
    if (paramInt == 6) {
      if (this.jdField_a_of_type_Awzk != null) {
        this.jdField_a_of_type_Awzk.a();
      }
    }
    while (paramInt != 20) {
      return;
    }
  }
  
  private void a(axac paramaxac)
  {
    if (paramaxac == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    do
    {
      return;
      str1 = paramaxac.b();
      str2 = paramaxac.a();
      i = paramaxac.a();
      localObject = paramaxac.a().a();
    } while (((List)localObject).size() != 2);
    paramaxac = paramaxac.a().a();
    int j = ((Integer)((List)localObject).get(0)).intValue();
    int k = ((Integer)((List)localObject).get(1)).intValue();
    if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "pc端已经确认了，客户端收到了0x11a的push了--------> bizType= " + i);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: client ip = " + paramaxac + ", udpport = " + k + ", tcpport = " + j);
    }
    Object localObject = a();
    ((axcm)localObject).d(str1);
    a().b(str2);
    a().a(i);
    ((axcm)localObject).b(paramaxac);
    ((axcm)localObject).b(j);
    ((axcm)localObject).a(k);
    if (i == 1)
    {
      ((axcm)localObject).g(2);
      ((axcm)localObject).f(2);
    }
    for (;;)
    {
      paramaxac = new Intent();
      if (BaseActivity.sTopActivity != null) {
        break;
      }
      axcw.a("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
      return;
      if (i == 2)
      {
        ((axcm)localObject).g(1);
        ((axcm)localObject).f(1);
      }
    }
    PublicFragmentActivity.a(BaseActivity.sTopActivity, paramaxac, MsgBackupPCConfirmFragment.class, 1000);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime$KickParams != null;
  }
  
  public static void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar <=======");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134067));
        axcm.a().a(null);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar: send msg MSG_MUSIC_PLAYER_HIDE");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar app = null!");
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public awzh a()
  {
    if (this.jdField_a_of_type_Awzh == null) {
      this.jdField_a_of_type_Awzh = awzh.a();
    }
    return this.jdField_a_of_type_Awzh;
  }
  
  public axag a()
  {
    return this.jdField_a_of_type_Axag;
  }
  
  public axcm a()
  {
    if (this.jdField_a_of_type_Axcm == null) {
      this.jdField_a_of_type_Axcm = axcm.a();
    }
    return this.jdField_a_of_type_Axcm;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, awzy paramawzy, Object paramObject)
  {
    if (paramawzy.jdField_a_of_type_Int == 0) {}
    while (paramawzy.jdField_a_of_type_Int != 2) {
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Axcm.a(this.jdField_e_of_type_JavaLangString, paramInt, paramString);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt2 + ", finishedCount" + paramInt1 + ", sessionCount = " + jdField_b_of_type_Int);
    }
    this.jdField_d_of_type_Int = jdField_b_of_type_Int;
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_e_of_type_Int = paramInt1;
    int i = paramInt1;
    if (paramInt1 != jdField_b_of_type_Int) {
      i = paramInt1 + 1;
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    Message localMessage;
    String str1;
    String str2;
    if (localMqqHandler != null)
    {
      localMessage = localMqqHandler.obtainMessage(1134066);
      if (paramInt2 != 1) {
        break label266;
      }
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690547);
      str2 = i + "/" + jdField_b_of_type_Int;
    }
    for (;;)
    {
      localMessage.obj = String.format(str1, new Object[] { str2, axcw.a(paramLong) + "B/s" });
      localMessage.arg1 = paramInt2;
      awzh.a().a(paramInt2);
      localMqqHandler.sendMessage(localMessage);
      axcm.a().a(null);
      axcm.a().a(this.jdField_b_of_type_Awzo);
      a(paramBaseActivity);
      paramBaseActivity.finish();
      return;
      label266:
      if (paramInt2 == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
        str2 = i + "/" + jdField_b_of_type_Int;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
        str2 = i + "/" + jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().addFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
    }
  }
  
  public void a(awzk paramawzk)
  {
    this.jdField_a_of_type_Awzk = paramawzk;
  }
  
  public void a(awzl paramawzl)
  {
    this.jdField_a_of_type_Awzl = paramawzl;
  }
  
  public void a(awzo paramawzo)
  {
    this.jdField_a_of_type_Awzo = paramawzo;
  }
  
  public void a(awzy paramawzy)
  {
    if (paramawzy == null) {
      return;
    }
    paramawzy.jdField_a_of_type_Awzm = this;
    this.jdField_a_of_type_Awzp.a(paramawzy, 10000);
  }
  
  public void a(awzy paramawzy, Object paramObject)
  {
    if (paramawzy.jdField_a_of_type_Int == 0) {
      if ((paramObject != null) && ((paramObject instanceof axao)))
      {
        paramawzy = (axao)paramObject;
        paramObject = new File(axcw.a(paramawzy.jdField_a_of_type_JavaLangString, axcw.b(paramawzy.jdField_a_of_type_Int), paramawzy.jdField_b_of_type_JavaLangString));
        if (paramObject.exists()) {
          break label72;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
        }
      }
    }
    label72:
    while ((paramawzy.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Awzo == null))
    {
      return;
      paramawzy.jdField_a_of_type_Long = paramObject.length();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(axcw.b(paramawzy.jdField_a_of_type_JavaLangString, axcw.b(paramawzy.jdField_a_of_type_Int)), paramawzy);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! result = 0, sessionInfo.uin = " + paramawzy.jdField_a_of_type_JavaLangString);
      }
      a().i(257);
      return;
    }
    this.jdField_a_of_type_Awzo.b(paramawzy.jdField_c_of_type_Int + 1, paramawzy.jdField_b_of_type_Int);
  }
  
  public void a(axaj paramaxaj)
  {
    if (jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
    }
    while (paramaxaj == null) {
      return;
    }
    jdField_c_of_type_Boolean = true;
    Intent localIntent = new Intent();
    int i = paramaxaj.a();
    a().a(i);
    paramaxaj = paramaxaj.a();
    a().a(paramaxaj);
    localIntent.putExtra("0x11bpush_extra", paramaxaj);
    localIntent.putExtra("BIZ_TYPE", i);
    localIntent.addFlags(268435456);
    PublicFragmentActivity.a(BaseApplicationImpl.getApplication(), localIntent, MsgBackupPCConfirmFragment.class);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    paramBaseActivity.startActivity(localIntent);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt + ", hasFinishedCount = " + this.jdField_e_of_type_Int + ", sessionCount = " + jdField_b_of_type_Int);
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
      }
      if (this.jdField_d_of_type_Int == this.jdField_e_of_type_Int)
      {
        MsgBackupCompleteFragment.g(paramBaseActivity, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        return;
      }
      MsgBackupPcBaseFragment.a(paramBaseActivity, paramInt);
      return;
    }
    if (paramInt == 3)
    {
      Intent localIntent = new Intent();
      if (this.jdField_d_of_type_Int == this.jdField_e_of_type_Int)
      {
        if (axcm.a().e() == 2)
        {
          MsgBackupCompleteFragment.b(paramBaseActivity, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
          return;
        }
        MsgBackupCompleteFragment.e(paramBaseActivity, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        return;
      }
      localIntent.putExtra("param_start", 5);
      PublicFragmentActivity.a(paramBaseActivity, localIntent, MsgBackupTransportFragment.class);
      return;
    }
    if (this.jdField_d_of_type_Int == this.jdField_e_of_type_Int)
    {
      MsgBackupCompleteFragment.k(paramBaseActivity, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      return;
    }
    MsgBackupPcBaseFragment.a(paramBaseActivity, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    axct.b();
    d();
    try
    {
      e();
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof axac))
    {
      paramObject = (axac)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11a: " + paramObject);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    a(((Integer)paramObject).intValue());
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      ((awzg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).c(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 3;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      a().a(i);
      this.jdField_a_of_type_Axcm.a(this.jdField_e_of_type_JavaLangString, paramBoolean);
      return;
      this.jdField_a_of_type_Axag = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Awzi);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "clearSessionData ->>>>>>>>>>");
    }
    jdField_b_of_type_Int = 0;
    jdField_d_of_type_JavaLangString = null;
    jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Axag = null;
    i();
    jdField_e_of_type_Boolean = false;
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory update msgtab bar----------> content = " + paramString + "., bizType = " + paramInt);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(1134066);
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void b(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().clearFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
    }
  }
  
  public void b(awzy paramawzy)
  {
    if (paramawzy == null) {
      return;
    }
    paramawzy.jdField_a_of_type_Awzm = this;
    this.jdField_a_of_type_Awzp.a(paramawzy, 10001);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void c(awzy paramawzy)
  {
    if (paramawzy == null) {
      return;
    }
    paramawzy.jdField_a_of_type_Awzm = this;
    this.jdField_a_of_type_Awzp.a(paramawzy, -1);
  }
  
  public void d()
  {
    axcw.a("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
    this.jdField_a_of_type_Axcm.b();
    b();
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Awzp.a();
    axct.c();
    ThreadManager.getFileThreadHandler().post(new MsgBackupManager.1(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Awzp.b();
    jdField_g_of_type_Boolean = false;
    jdField_a_of_type_Awzs = null;
  }
  
  public void f() {}
  
  public void g()
  {
    ((awzg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).a();
  }
  
  public void h()
  {
    axcw.b("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { jdField_a_of_type_JavaLangString });
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    ((awzg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).b(jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Awzi);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Axcm.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    if (this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener == null) {
      this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener = new awzu(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setInterceptKickListener(this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener);
  }
  
  public void l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.kick(this.jdField_a_of_type_MqqAppAppRuntime$KickParams);
      this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setInterceptKickListener(null);
  }
  
  public void n()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupManager.5(this));
  }
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzs
 * JD-Core Version:    0.7.0.1
 */