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

public class atix
  implements Manager
{
  private int jdField_a_of_type_Int;
  private aria jdField_a_of_type_Aria;
  private arib jdField_a_of_type_Arib;
  private aric jdField_a_of_type_Aric;
  private arid jdField_a_of_type_Arid;
  private arie jdField_a_of_type_Arie;
  private arii jdField_a_of_type_Arii;
  private arik jdField_a_of_type_Arik;
  private ariz jdField_a_of_type_Ariz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, arip> jdField_a_of_type_JavaUtilHashMap;
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
  
  public atix(QQAppInterface paramQQAppInterface)
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
      this.jdField_a_of_type_Arii = ((arii)aqxo.a(paramString, arii.class));
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
      this.jdField_a_of_type_Arik = ((arik)aqxo.a(paramString, arik.class));
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
      this.jdField_a_of_type_Ariz = ((ariz)aqxo.a(paramString, ariz.class));
      atua.a().a(this.jdField_a_of_type_Ariz.jdField_a_of_type_Boolean);
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
      ario localario = (ario)aqxo.a(paramString, ario.class);
      if (localario != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localario.jdField_a_of_type_JavaUtilHashMap);
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
    arit localarit = new arit();
    localarit.a(str);
    this.jdField_a_of_type_Arib = localarit;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    arir localarir = new arir();
    localarir.a(str);
    this.jdField_a_of_type_Aria = localarir;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    arix localarix = new arix();
    localarix.a(str);
    this.jdField_a_of_type_Arid = localarix;
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    ariv localariv = new ariv();
    localariv.a(str);
    this.jdField_a_of_type_Aric = localariv;
  }
  
  private void k()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    arjd localarjd = new arjd();
    localarjd.a(str);
    this.jdField_a_of_type_Arie = localarjd;
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
  
  public aria a()
  {
    return this.jdField_a_of_type_Aria;
  }
  
  public arib a()
  {
    return this.jdField_a_of_type_Arib;
  }
  
  public aric a()
  {
    return this.jdField_a_of_type_Aric;
  }
  
  public arid a()
  {
    return this.jdField_a_of_type_Arid;
  }
  
  public arie a()
  {
    return this.jdField_a_of_type_Arie;
  }
  
  public arii a()
  {
    return this.jdField_a_of_type_Arii;
  }
  
  public arik a()
  {
    return this.jdField_a_of_type_Arik;
  }
  
  public arip a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (arip)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (arip)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      d("{}");
      localObject = (arip)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public ariz a()
  {
    return this.jdField_a_of_type_Ariz;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(aria paramaria)
  {
    this.jdField_a_of_type_Aria = paramaria;
  }
  
  public void a(arib paramarib)
  {
    this.jdField_a_of_type_Arib = paramarib;
  }
  
  public void a(aric paramaric)
  {
    this.jdField_a_of_type_Aric = paramaric;
  }
  
  public void a(arid paramarid)
  {
    this.jdField_a_of_type_Arid = paramarid;
  }
  
  public void a(arie paramarie)
  {
    this.jdField_a_of_type_Arie = paramarie;
  }
  
  public void a(arii paramarii)
  {
    if (paramarii != null) {
      this.jdField_a_of_type_Arii = paramarii;
    }
  }
  
  public void a(arik paramarik)
  {
    if (paramarik != null) {
      this.jdField_a_of_type_Arik = paramarik;
    }
  }
  
  public void a(ariz paramariz)
  {
    if (paramariz != null)
    {
      this.jdField_a_of_type_Ariz = paramariz;
      atua.a().a(this.jdField_a_of_type_Ariz.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(HashMap<String, arip> paramHashMap)
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
 * Qualified Name:     atix
 * JD-Core Version:    0.7.0.1
 */