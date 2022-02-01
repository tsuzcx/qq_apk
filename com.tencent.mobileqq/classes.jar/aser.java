import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.1;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.2;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aser
  implements Manager
{
  private int jdField_a_of_type_Int;
  private aqet jdField_a_of_type_Aqet;
  private aqeu jdField_a_of_type_Aqeu;
  private aqev jdField_a_of_type_Aqev;
  private aqew jdField_a_of_type_Aqew;
  private aqex jdField_a_of_type_Aqex;
  private aqfb jdField_a_of_type_Aqfb;
  private aqfd jdField_a_of_type_Aqfd;
  private aqfs jdField_a_of_type_Aqfs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, aqfi> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public aser(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    f();
    a();
    l();
    b();
    g();
    h();
    i();
    j();
    k();
    c();
    d();
    e();
    m();
  }
  
  private void a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("troop_video_preivew", false);
    this.b = localSharedPreferences.getBoolean("troop_video_preivew_for_svip", false);
    this.c = localSharedPreferences.getBoolean("troop_video_preivew_for_yearsvip", false);
    QLog.i("QFileConfigManager", 1, "initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[" + this.jdField_a_of_type_Boolean + "] enableTroopVidePreviewForSVIP[" + this.b + "] enableTroopVidePreviewForYearSVIP[" + this.c + "]");
  }
  
  private void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadYYBPromoteActionConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Aqfb = ((aqfb)apul.a(paramString, aqfb.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
    this.g = localSharedPreferences.getBoolean("ipv6_all_switch", false);
    this.h = localSharedPreferences.getBoolean("ipv6_c2c_switch", false);
    this.i = localSharedPreferences.getBoolean("ipv6_group_switch", false);
    this.j = localSharedPreferences.getBoolean("ipv6_disc_switch", false);
    this.k = localSharedPreferences.getBoolean("ipv6_dataline_switch", false);
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("ipv6_strategy", 0);
    QLog.i("QFileConfigManager", 1, "initFileIPv6Config: load config. enableFileIPv6[" + this.g + "] enableC2CIPv6[" + this.h + "] enableGroupIPv6[" + this.i + "] enableDiscIPv6[" + this.j + "] enableDatalineIPv6[" + this.k + "] strategy[" + this.jdField_a_of_type_Int + "]");
  }
  
  private void b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadYYBPromoteDialogConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Aqfd = ((aqfd)apul.a(paramString, aqfd.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void c(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadFileReaderConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Aqfs = ((aqfs)apul.a(paramString, aqfs.class));
      aspt.a().a(this.jdField_a_of_type_Aqfs.jdField_a_of_type_Boolean);
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void d(String paramString)
  {
    try
    {
      aqfh localaqfh = (aqfh)apul.a(paramString, aqfh.class);
      if (localaqfh != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localaqfh.jdField_a_of_type_JavaUtilHashMap);
      }
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadFileDownloadConfig: load download config. " + paramString);
      }
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("file_reader_key", "{}"));
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_file_auto_download", "{}");
    QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + str + "]");
    d(str);
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    aqfm localaqfm = new aqfm();
    localaqfm.a(str);
    this.jdField_a_of_type_Aqeu = localaqfm;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    aqfk localaqfk = new aqfk();
    localaqfk.a(str);
    this.jdField_a_of_type_Aqet = localaqfk;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    aqfq localaqfq = new aqfq();
    localaqfq.a(str);
    this.jdField_a_of_type_Aqew = localaqfq;
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    aqfo localaqfo = new aqfo();
    localaqfo.a(str);
    this.jdField_a_of_type_Aqev = localaqfo;
  }
  
  private void k()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    aqfw localaqfw = new aqfw();
    localaqfw.a(str);
    this.jdField_a_of_type_Aqex = localaqfw;
  }
  
  private void l()
  {
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getBoolean("enable_file_media_platform", false);
    QLog.i("QFileConfigManager", 1, "initMediaPlatformConfig: load common config. enableFileMediaPlatform[" + this.d + "]");
  }
  
  private void m()
  {
    this.l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getBoolean("apkcheck_enable_switch", false);
    QLog.i("QFileConfigManager", 1, "initMMApkFileCheckConfig: load apkcheckconfig. enable[" + this.l + "]");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqet a()
  {
    return this.jdField_a_of_type_Aqet;
  }
  
  public aqeu a()
  {
    return this.jdField_a_of_type_Aqeu;
  }
  
  public aqev a()
  {
    return this.jdField_a_of_type_Aqev;
  }
  
  public aqew a()
  {
    return this.jdField_a_of_type_Aqew;
  }
  
  public aqex a()
  {
    return this.jdField_a_of_type_Aqex;
  }
  
  public aqfb a()
  {
    return this.jdField_a_of_type_Aqfb;
  }
  
  public aqfd a()
  {
    return this.jdField_a_of_type_Aqfd;
  }
  
  public aqfi a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (aqfi)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (aqfi)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      d("{}");
      localObject = (aqfi)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public aqfs a()
  {
    return this.jdField_a_of_type_Aqfs;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(aqet paramaqet)
  {
    this.jdField_a_of_type_Aqet = paramaqet;
  }
  
  public void a(aqeu paramaqeu)
  {
    this.jdField_a_of_type_Aqeu = paramaqeu;
  }
  
  public void a(aqev paramaqev)
  {
    this.jdField_a_of_type_Aqev = paramaqev;
  }
  
  public void a(aqew paramaqew)
  {
    this.jdField_a_of_type_Aqew = paramaqew;
  }
  
  public void a(aqex paramaqex)
  {
    this.jdField_a_of_type_Aqex = paramaqex;
  }
  
  public void a(aqfb paramaqfb)
  {
    if (paramaqfb != null) {
      this.jdField_a_of_type_Aqfb = paramaqfb;
    }
  }
  
  public void a(aqfd paramaqfd)
  {
    if (paramaqfd != null) {
      this.jdField_a_of_type_Aqfd = paramaqfd;
    }
  }
  
  public void a(aqfs paramaqfs)
  {
    if (paramaqfs != null)
    {
      this.jdField_a_of_type_Aqfs = paramaqfs;
      aspt.a().a(this.jdField_a_of_type_Aqfs.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(HashMap<String, aqfi> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.1(this, paramHashMap));
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    QLog.i("QFileConfigManager", 1, "set apkcheckConfig enable:" + paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.3(this, paramBundle));
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public boolean g()
  {
    return this.k;
  }
  
  public boolean h()
  {
    if (this.e) {
      return this.f;
    }
    return this.d;
  }
  
  public boolean i()
  {
    return this.l;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aser
 * JD-Core Version:    0.7.0.1
 */