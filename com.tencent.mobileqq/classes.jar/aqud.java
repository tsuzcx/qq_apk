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

public class aqud
  implements Manager
{
  private aotb jdField_a_of_type_Aotb;
  private aotc jdField_a_of_type_Aotc;
  private aotd jdField_a_of_type_Aotd;
  private aote jdField_a_of_type_Aote;
  private aotf jdField_a_of_type_Aotf;
  private aotg jdField_a_of_type_Aotg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, aotl> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public aqud(QQAppInterface paramQQAppInterface)
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
      aotk localaotk = (aotk)aolc.a(paramString, aotk.class);
      if (localaotk != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.putAll(localaotk.jdField_a_of_type_JavaUtilHashMap);
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
    aotr localaotr = new aotr();
    localaotr.a(str);
    this.jdField_a_of_type_Aotd = localaotr;
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    aotp localaotp = new aotp();
    localaotp.a(str);
    this.jdField_a_of_type_Aotc = localaotp;
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    aotn localaotn = new aotn();
    localaotn.a(str);
    this.jdField_a_of_type_Aotb = localaotn;
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    aotv localaotv = new aotv();
    localaotv.a(str);
    this.jdField_a_of_type_Aotf = localaotv;
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    aott localaott = new aott();
    localaott.a(str);
    this.jdField_a_of_type_Aote = localaott;
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    aotz localaotz = new aotz();
    localaotz.a(str);
    this.jdField_a_of_type_Aotg = localaotz;
  }
  
  public aotb a()
  {
    return this.jdField_a_of_type_Aotb;
  }
  
  public aotc a()
  {
    return this.jdField_a_of_type_Aotc;
  }
  
  @Deprecated
  public aotd a()
  {
    return this.jdField_a_of_type_Aotd;
  }
  
  public aote a()
  {
    return this.jdField_a_of_type_Aote;
  }
  
  public aotf a()
  {
    return this.jdField_a_of_type_Aotf;
  }
  
  public aotg a()
  {
    return this.jdField_a_of_type_Aotg;
  }
  
  public aotl a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (aotl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (aotl)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      a("{}");
      localObject = (aotl)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(aotb paramaotb)
  {
    this.jdField_a_of_type_Aotb = paramaotb;
  }
  
  public void a(aotc paramaotc)
  {
    this.jdField_a_of_type_Aotc = paramaotc;
  }
  
  @Deprecated
  public void a(aotd paramaotd)
  {
    this.jdField_a_of_type_Aotd = paramaotd;
  }
  
  public void a(aote paramaote)
  {
    this.jdField_a_of_type_Aote = paramaote;
  }
  
  public void a(aotf paramaotf)
  {
    this.jdField_a_of_type_Aotf = paramaotf;
  }
  
  public void a(aotg paramaotg)
  {
    this.jdField_a_of_type_Aotg = paramaotg;
  }
  
  public void a(HashMap<String, aotl> paramHashMap)
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
 * Qualified Name:     aqud
 * JD-Core Version:    0.7.0.1
 */