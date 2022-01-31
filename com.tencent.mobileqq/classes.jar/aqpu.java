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

public class aqpu
  implements Manager
{
  private aoos jdField_a_of_type_Aoos;
  private aoot jdField_a_of_type_Aoot;
  private aoou jdField_a_of_type_Aoou;
  private aoov jdField_a_of_type_Aoov;
  private aoow jdField_a_of_type_Aoow;
  private aoox jdField_a_of_type_Aoox;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, aopc> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public aqpu(QQAppInterface paramQQAppInterface)
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
      aopb localaopb = (aopb)aogt.a(paramString, aopb.class);
      if (localaopb != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localaopb.jdField_a_of_type_JavaUtilHashMap);
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
    aopi localaopi = new aopi();
    localaopi.a(str);
    this.jdField_a_of_type_Aoou = localaopi;
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    aopg localaopg = new aopg();
    localaopg.a(str);
    this.jdField_a_of_type_Aoot = localaopg;
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    aope localaope = new aope();
    localaope.a(str);
    this.jdField_a_of_type_Aoos = localaope;
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    aopm localaopm = new aopm();
    localaopm.a(str);
    this.jdField_a_of_type_Aoow = localaopm;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    aopk localaopk = new aopk();
    localaopk.a(str);
    this.jdField_a_of_type_Aoov = localaopk;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    aopq localaopq = new aopq();
    localaopq.a(str);
    this.jdField_a_of_type_Aoox = localaopq;
  }
  
  public aoos a()
  {
    return this.jdField_a_of_type_Aoos;
  }
  
  public aoot a()
  {
    return this.jdField_a_of_type_Aoot;
  }
  
  @Deprecated
  public aoou a()
  {
    return this.jdField_a_of_type_Aoou;
  }
  
  public aoov a()
  {
    return this.jdField_a_of_type_Aoov;
  }
  
  public aoow a()
  {
    return this.jdField_a_of_type_Aoow;
  }
  
  public aoox a()
  {
    return this.jdField_a_of_type_Aoox;
  }
  
  public aopc a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (aopc)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (aopc)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      a("{}");
      localObject = (aopc)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(aoos paramaoos)
  {
    this.jdField_a_of_type_Aoos = paramaoos;
  }
  
  public void a(aoot paramaoot)
  {
    this.jdField_a_of_type_Aoot = paramaoot;
  }
  
  @Deprecated
  public void a(aoou paramaoou)
  {
    this.jdField_a_of_type_Aoou = paramaoou;
  }
  
  public void a(aoov paramaoov)
  {
    this.jdField_a_of_type_Aoov = paramaoov;
  }
  
  public void a(aoow paramaoow)
  {
    this.jdField_a_of_type_Aoow = paramaoow;
  }
  
  public void a(aoox paramaoox)
  {
    this.jdField_a_of_type_Aoox = paramaoox;
  }
  
  public void a(HashMap<String, aopc> paramHashMap)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpu
 * JD-Core Version:    0.7.0.1
 */