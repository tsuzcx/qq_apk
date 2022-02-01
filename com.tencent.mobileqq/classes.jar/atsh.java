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

public class atsh
  implements Manager
{
  private int jdField_a_of_type_Int;
  private arkw jdField_a_of_type_Arkw;
  private arkx jdField_a_of_type_Arkx;
  private arky jdField_a_of_type_Arky;
  private arkz jdField_a_of_type_Arkz;
  private arla jdField_a_of_type_Arla;
  private arle jdField_a_of_type_Arle;
  private arlg jdField_a_of_type_Arlg;
  private arlv jdField_a_of_type_Arlv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, arll> jdField_a_of_type_JavaUtilHashMap;
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
  
  public atsh(QQAppInterface paramQQAppInterface)
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
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
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
      this.jdField_a_of_type_Arle = ((arle)arax.a(paramString, arle.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
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
      this.jdField_a_of_type_Arlg = ((arlg)arax.a(paramString, arlg.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void c(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadFileReaderConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Arlv = ((arlv)arax.a(paramString, arlv.class));
      audj.a().a(this.jdField_a_of_type_Arlv.jdField_a_of_type_Boolean);
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void d(String paramString)
  {
    try
    {
      arlk localarlk = (arlk)arax.a(paramString, arlk.class);
      if (localarlk != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localarlk.jdField_a_of_type_JavaUtilHashMap);
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
    c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("file_reader_key", "{}"));
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_auto_download", "{}");
    QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + str + "]");
    d(str);
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    arlp localarlp = new arlp();
    localarlp.a(str);
    this.jdField_a_of_type_Arkx = localarlp;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    arln localarln = new arln();
    localarln.a(str);
    this.jdField_a_of_type_Arkw = localarln;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    arlt localarlt = new arlt();
    localarlt.a(str);
    this.jdField_a_of_type_Arkz = localarlt;
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    arlr localarlr = new arlr();
    localarlr.a(str);
    this.jdField_a_of_type_Arky = localarlr;
  }
  
  private void k()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    arlz localarlz = new arlz();
    localarlz.a(str);
    this.jdField_a_of_type_Arla = localarlz;
  }
  
  private void l()
  {
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("enable_file_media_platform", false);
    QLog.i("QFileConfigManager", 1, "initMediaPlatformConfig: load common config. enableFileMediaPlatform[" + this.d + "]");
  }
  
  private void m()
  {
    this.l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("apkcheck_enable_switch", false);
    QLog.i("QFileConfigManager", 1, "initMMApkFileCheckConfig: load apkcheckconfig. enable[" + this.l + "]");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arkw a()
  {
    return this.jdField_a_of_type_Arkw;
  }
  
  public arkx a()
  {
    return this.jdField_a_of_type_Arkx;
  }
  
  public arky a()
  {
    return this.jdField_a_of_type_Arky;
  }
  
  public arkz a()
  {
    return this.jdField_a_of_type_Arkz;
  }
  
  public arla a()
  {
    return this.jdField_a_of_type_Arla;
  }
  
  public arle a()
  {
    return this.jdField_a_of_type_Arle;
  }
  
  public arlg a()
  {
    return this.jdField_a_of_type_Arlg;
  }
  
  public arll a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (arll)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (arll)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      d("{}");
      localObject = (arll)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public arlv a()
  {
    return this.jdField_a_of_type_Arlv;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(arkw paramarkw)
  {
    this.jdField_a_of_type_Arkw = paramarkw;
  }
  
  public void a(arkx paramarkx)
  {
    this.jdField_a_of_type_Arkx = paramarkx;
  }
  
  public void a(arky paramarky)
  {
    this.jdField_a_of_type_Arky = paramarky;
  }
  
  public void a(arkz paramarkz)
  {
    this.jdField_a_of_type_Arkz = paramarkz;
  }
  
  public void a(arla paramarla)
  {
    this.jdField_a_of_type_Arla = paramarla;
  }
  
  public void a(arle paramarle)
  {
    if (paramarle != null) {
      this.jdField_a_of_type_Arle = paramarle;
    }
  }
  
  public void a(arlg paramarlg)
  {
    if (paramarlg != null) {
      this.jdField_a_of_type_Arlg = paramarlg;
    }
  }
  
  public void a(arlv paramarlv)
  {
    if (paramarlv != null)
    {
      this.jdField_a_of_type_Arlv = paramarlv;
      audj.a().a(this.jdField_a_of_type_Arlv.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(HashMap<String, arll> paramHashMap)
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
 * Qualified Name:     atsh
 * JD-Core Version:    0.7.0.1
 */