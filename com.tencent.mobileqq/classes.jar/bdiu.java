import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bdiu
  implements Manager
{
  private static String jdField_a_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
  private static String b = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String c = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
  private static String d = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bdiu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      jdField_a_of_type_JavaLangString = localSharedPreferences.getString("tencentdoc_pre_img_url_doc", "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png");
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String b()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      b = localSharedPreferences.getString("tencentdoc_pre_img_url_sheet", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return b;
  }
  
  public static String c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      c = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_doc", "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png");
    }
    return c;
  }
  
  public static String d()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      d = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_sheet", "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png");
    }
    return d;
  }
  
  public Boolean a()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    boolean bool3 = araa.a().a();
    boolean bool1 = armg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = araa.a().a();
    if ((bool1) && (str != null)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeamWorkManager", 2, "WL_DEBUG isShowTencentDocEntry isShowTencentDocEntry = " + bool3 + ", isUser = " + bool1 + ", userConfigPlusURL = " + str);
      }
      if ((bool3) || (bool1)) {
        bool2 = true;
      }
      if ((!bool3) && (bool1)) {
        armg.a("0X80094DF");
      }
      return Boolean.valueOf(bool2);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiu
 * JD-Core Version:    0.7.0.1
 */