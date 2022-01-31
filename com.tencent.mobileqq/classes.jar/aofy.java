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

public class aofy
  implements Manager
{
  private amhi jdField_a_of_type_Amhi;
  private amhj jdField_a_of_type_Amhj;
  private amhk jdField_a_of_type_Amhk;
  private amhl jdField_a_of_type_Amhl;
  private amhm jdField_a_of_type_Amhm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, amhq> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public aofy(QQAppInterface paramQQAppInterface)
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
      amhp localamhp = (amhp)amaf.a(paramString, amhp.class);
      if (localamhp != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localamhp.jdField_a_of_type_JavaUtilHashMap);
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
    amhw localamhw = new amhw();
    localamhw.a(str);
    this.jdField_a_of_type_Amhk = localamhw;
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    amhu localamhu = new amhu();
    localamhu.a(str);
    this.jdField_a_of_type_Amhj = localamhu;
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    amhs localamhs = new amhs();
    localamhs.a(str);
    this.jdField_a_of_type_Amhi = localamhs;
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    amia localamia = new amia();
    localamia.a(str);
    this.jdField_a_of_type_Amhm = localamia;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    amhy localamhy = new amhy();
    localamhy.a(str);
    this.jdField_a_of_type_Amhl = localamhy;
  }
  
  public amhi a()
  {
    return this.jdField_a_of_type_Amhi;
  }
  
  public amhj a()
  {
    return this.jdField_a_of_type_Amhj;
  }
  
  @Deprecated
  public amhk a()
  {
    return this.jdField_a_of_type_Amhk;
  }
  
  public amhl a()
  {
    return this.jdField_a_of_type_Amhl;
  }
  
  public amhm a()
  {
    return this.jdField_a_of_type_Amhm;
  }
  
  public amhq a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (amhq)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (amhq)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      a("{}");
      localObject = (amhq)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public void a(amhi paramamhi)
  {
    this.jdField_a_of_type_Amhi = paramamhi;
  }
  
  public void a(amhj paramamhj)
  {
    this.jdField_a_of_type_Amhj = paramamhj;
  }
  
  @Deprecated
  public void a(amhk paramamhk)
  {
    this.jdField_a_of_type_Amhk = paramamhk;
  }
  
  public void a(amhl paramamhl)
  {
    this.jdField_a_of_type_Amhl = paramamhl;
  }
  
  public void a(amhm paramamhm)
  {
    this.jdField_a_of_type_Amhm = paramamhm;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(HashMap<String, amhq> paramHashMap)
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
 * Qualified Name:     aofy
 * JD-Core Version:    0.7.0.1
 */