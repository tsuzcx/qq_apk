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

public class aoww
  implements Manager
{
  private amxl jdField_a_of_type_Amxl;
  private amxm jdField_a_of_type_Amxm;
  private amxn jdField_a_of_type_Amxn;
  private amxo jdField_a_of_type_Amxo;
  private amxp jdField_a_of_type_Amxp;
  private amxq jdField_a_of_type_Amxq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, amxv> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public aoww(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
    a();
    b();
    d();
    e();
    f();
    g();
    h();
    i();
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
      amxu localamxu = (amxu)ampv.a(paramString, amxu.class);
      if (localamxu != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localamxu.jdField_a_of_type_JavaUtilHashMap);
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
  
  private void b()
  {
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("ipv6_all_switch", false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_auto_download", "{}");
    QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + str + "]");
    a(str);
  }
  
  @Deprecated
  private void d()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("file_exciting_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_exciting", "{}");
    QLog.i("QFileConfigManager", 1, "initExcitingConfig: load download config [" + str + "]");
    amyb localamyb = new amyb();
    localamyb.a(str);
    this.jdField_a_of_type_Amxn = localamyb;
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    amxz localamxz = new amxz();
    localamxz.a(str);
    this.jdField_a_of_type_Amxm = localamxz;
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    amxx localamxx = new amxx();
    localamxx.a(str);
    this.jdField_a_of_type_Amxl = localamxx;
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    amyf localamyf = new amyf();
    localamyf.a(str);
    this.jdField_a_of_type_Amxp = localamyf;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    amyd localamyd = new amyd();
    localamyd.a(str);
    this.jdField_a_of_type_Amxo = localamyd;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    amyj localamyj = new amyj();
    localamyj.a(str);
    this.jdField_a_of_type_Amxq = localamyj;
  }
  
  public amxl a()
  {
    return this.jdField_a_of_type_Amxl;
  }
  
  public amxm a()
  {
    return this.jdField_a_of_type_Amxm;
  }
  
  @Deprecated
  public amxn a()
  {
    return this.jdField_a_of_type_Amxn;
  }
  
  public amxo a()
  {
    return this.jdField_a_of_type_Amxo;
  }
  
  public amxp a()
  {
    return this.jdField_a_of_type_Amxp;
  }
  
  public amxq a()
  {
    return this.jdField_a_of_type_Amxq;
  }
  
  public amxv a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (amxv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (amxv)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      a("{}");
      localObject = (amxv)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public void a(amxl paramamxl)
  {
    this.jdField_a_of_type_Amxl = paramamxl;
  }
  
  public void a(amxm paramamxm)
  {
    this.jdField_a_of_type_Amxm = paramamxm;
  }
  
  @Deprecated
  public void a(amxn paramamxn)
  {
    this.jdField_a_of_type_Amxn = paramamxn;
  }
  
  public void a(amxo paramamxo)
  {
    this.jdField_a_of_type_Amxo = paramamxo;
  }
  
  public void a(amxp paramamxp)
  {
    this.jdField_a_of_type_Amxp = paramamxp;
  }
  
  public void a(amxq paramamxq)
  {
    this.jdField_a_of_type_Amxq = paramamxq;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(HashMap<String, amxv> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.1(this, paramHashMap));
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
    return this.d;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoww
 * JD-Core Version:    0.7.0.1
 */