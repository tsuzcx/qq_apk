import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.1;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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

public class asle
  implements asky
{
  public static int a;
  private static volatile asle jdField_a_of_type_Asle;
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
  private askt jdField_a_of_type_Askt;
  protected asku a;
  private askw jdField_a_of_type_Askw;
  private askx jdField_a_of_type_Askx;
  public asla a;
  private aslb jdField_a_of_type_Aslb = new aslb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  private asls jdField_a_of_type_Asls;
  private asnx jdField_a_of_type_Asnx = asnx.a();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  public HashSet<RecentBaseData> a;
  public CopyOnWriteArraySet<Long> a;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private AppRuntime.InterceptKickListener jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener;
  private AppRuntime.KickParams jdField_a_of_type_MqqAppAppRuntime$KickParams;
  private asla b;
  public ConcurrentHashMap<String, asma> b;
  public ConcurrentHashMap<String, asma> c;
  private int d;
  public ConcurrentHashMap<Long, asod> d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
  public ConcurrentHashMap<Long, asod> e;
  private int f;
  public ConcurrentHashMap<Long, asmb> f;
  public ConcurrentHashMap<Long, asmb> g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_f_of_type_Boolean = true;
  }
  
  private asle()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Asku = new aslf(this);
    this.jdField_b_of_type_Asla = new aslh(this);
    this.jdField_f_of_type_Int = 3;
    jdField_g_of_type_Boolean = true;
  }
  
  public static asle a()
  {
    if (jdField_a_of_type_Asle == null) {}
    try
    {
      if (jdField_a_of_type_Asle == null) {
        jdField_a_of_type_Asle = new asle();
      }
      return jdField_a_of_type_Asle;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aFailed: " + paramInt);
    }
    if (paramInt == 6) {
      if (this.jdField_a_of_type_Askw != null) {
        this.jdField_a_of_type_Askw.a();
      }
    }
    while (paramInt != 20) {
      return;
    }
  }
  
  private void a(aslo paramaslo)
  {
    if (paramaslo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11a, data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    List localList;
    do
    {
      return;
      str1 = paramaslo.b();
      str2 = paramaslo.a();
      i = paramaslo.a();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = asog.a(paramaslo.a().a());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localList = paramaslo.a().a();
    } while (localList.size() != 2);
    localMsgBackupEndPoint2.port = ((Integer)localList.get(0)).intValue();
    localMsgBackupEndPoint1.port = ((Integer)localList.get(1)).intValue();
    asnx localasnx = a();
    localasnx.b(str1);
    a().b(str2);
    a().a(i);
    localasnx.b(localMsgBackupEndPoint2);
    localasnx.a(localMsgBackupEndPoint1);
    if (i == 1)
    {
      localasnx.c(2);
      localasnx.b(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: client ip = " + paramaslo.a().a() + ", udpport = " + localList.get(1) + ", tcpport = " + localList.get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "pc端已经确认了，客户端收到了0x11a的push了--------> bizType= " + i);
      }
      paramaslo = new Intent();
      if (BaseActivity.sTopActivity != null) {
        break;
      }
      asog.a("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
      return;
      if (i == 2)
      {
        localasnx.c(1);
        localasnx.b(1);
      }
    }
    PublicFragmentActivity.a(BaseActivity.sTopActivity, paramaslo, MsgBackupPCConfirmFragment.class, 1000);
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
        asnx.a().a(null);
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
  
  public askt a()
  {
    if (this.jdField_a_of_type_Askt == null) {
      this.jdField_a_of_type_Askt = askt.a();
    }
    return this.jdField_a_of_type_Askt;
  }
  
  public asls a()
  {
    return this.jdField_a_of_type_Asls;
  }
  
  public asnx a()
  {
    if (this.jdField_a_of_type_Asnx == null) {
      this.jdField_a_of_type_Asnx = asnx.a();
    }
    return this.jdField_a_of_type_Asnx;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, aslk paramaslk, Object paramObject)
  {
    if (paramaslk.jdField_a_of_type_Int == 0) {}
    while (paramaslk.jdField_a_of_type_Int != 2) {
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Asnx.a(this.jdField_e_of_type_JavaLangString, paramInt, paramString);
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
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690390);
      str2 = i + "/" + jdField_b_of_type_Int;
    }
    for (;;)
    {
      localMessage.obj = String.format(str1, new Object[] { str2, asog.a(paramLong) + "B/s" });
      localMessage.arg1 = paramInt2;
      askt.a().a(paramInt2);
      localMqqHandler.sendMessage(localMessage);
      asnx.a().a(null);
      asnx.a().a(this.jdField_b_of_type_Asla);
      a(paramBaseActivity);
      paramBaseActivity.finish();
      return;
      label266:
      if (paramInt2 == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
        str2 = i + "/" + jdField_b_of_type_Int;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
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
  
  public void a(askw paramaskw)
  {
    this.jdField_a_of_type_Askw = paramaskw;
  }
  
  public void a(askx paramaskx)
  {
    this.jdField_a_of_type_Askx = paramaskx;
  }
  
  public void a(asla paramasla)
  {
    this.jdField_a_of_type_Asla = paramasla;
  }
  
  public void a(aslk paramaslk)
  {
    if (paramaslk == null) {
      return;
    }
    paramaslk.jdField_a_of_type_Asky = this;
    this.jdField_a_of_type_Aslb.a(paramaslk, 10000);
  }
  
  public void a(aslk paramaslk, Object paramObject)
  {
    if (paramaslk.jdField_a_of_type_Int == 0) {
      if ((paramObject != null) && ((paramObject instanceof asma)))
      {
        paramaslk = (asma)paramObject;
        paramObject = new File(asog.a(paramaslk.jdField_a_of_type_JavaLangString, asog.b(paramaslk.jdField_a_of_type_Int), paramaslk.jdField_b_of_type_JavaLangString));
        if (paramObject.exists()) {
          break label72;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
        }
      }
    }
    label72:
    while ((paramaslk.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Asla == null))
    {
      return;
      paramaslk.jdField_a_of_type_Long = paramObject.length();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(asog.a(paramaslk.jdField_a_of_type_JavaLangString, asog.b(paramaslk.jdField_a_of_type_Int)), paramaslk);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! result = 0, sessionInfo.uin = " + paramaslk.jdField_a_of_type_JavaLangString);
      }
      a().e(257);
      return;
    }
    this.jdField_a_of_type_Asla.b(paramaslk.jdField_c_of_type_Int + 1, paramaslk.jdField_b_of_type_Int);
  }
  
  public void a(aslv paramaslv)
  {
    if (jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
    }
    while (paramaslv == null) {
      return;
    }
    jdField_c_of_type_Boolean = true;
    Intent localIntent = new Intent();
    int i = paramaslv.a();
    a().a(i);
    paramaslv = paramaslv.a();
    a().a(paramaslv);
    localIntent.putExtra("0x11bpush_extra", paramaslv);
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
        if (asnx.a().a() == 2)
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
    asoe.b();
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
    if ((paramObject instanceof aslo))
    {
      paramObject = (aslo)paramObject;
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
      ((asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(162)).c(paramString);
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
      this.jdField_a_of_type_Asnx.a(this.jdField_e_of_type_JavaLangString, paramBoolean);
      return;
      this.jdField_a_of_type_Asls = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asku);
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
    this.jdField_a_of_type_Asls = null;
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
  
  public void b(aslk paramaslk)
  {
    if (paramaslk == null) {
      return;
    }
    paramaslk.jdField_a_of_type_Asky = this;
    this.jdField_a_of_type_Aslb.a(paramaslk, 10001);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void c(aslk paramaslk)
  {
    if (paramaslk == null) {
      return;
    }
    paramaslk.jdField_a_of_type_Asky = this;
    this.jdField_a_of_type_Aslb.a(paramaslk, -1);
  }
  
  public void d()
  {
    asog.a("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
    this.jdField_a_of_type_Asnx.b();
    b();
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Aslb.a();
    asoe.c();
    ThreadManager.getFileThreadHandler().post(new MsgBackupManager.1(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aslb.b();
    jdField_g_of_type_Boolean = false;
    jdField_a_of_type_Asle = null;
  }
  
  public void f() {}
  
  public void g()
  {
    ((asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(162)).a();
  }
  
  public void h()
  {
    asog.b("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { jdField_a_of_type_JavaLangString });
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    ((asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(162)).b(jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asku);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Asnx.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    if (this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener == null) {
      this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener = new aslg(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asle
 * JD-Core Version:    0.7.0.1
 */