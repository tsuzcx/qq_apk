import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class atwc
  implements Manager
{
  public static String a;
  private QQAppInterface a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TimUpgradeHongdianManager";
  }
  
  public atwc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit();
      localEditor.putBoolean("tim_upgrade_hongdian_switch", false);
      localEditor.putString("tim_upgrade_hongdian_title", null);
      localEditor.putString("tim_upgrade_hongdian_sub_title", null);
      localEditor.putString("tim_upgrade_hongdian_url", null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearHondianSP done");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "clearHondianSP " + localException.toString());
    }
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("tim_upgrade_hongdian_switch", false);
        this.b = localSharedPreferences.getString("tim_upgrade_hongdian_title", null);
        this.c = localSharedPreferences.getString("tim_upgrade_hongdian_sub_title", null);
        this.d = localSharedPreferences.getString("tim_upgrade_hongdian_url", null);
        long l2 = System.currentTimeMillis();
        boolean bool2;
        if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)))
        {
          bool1 = TextUtils.isEmpty(this.d);
          if (!bool1)
          {
            bool1 = true;
            bool2 = bool1;
          }
        }
        boolean bool1 = false;
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "checkIfShowTimHongdian , switchKey = " + this.jdField_a_of_type_Boolean + ", mTitle = " + this.b + ", mSubTitle =" + this.c + ", url=" + this.d + ", sp time cost = " + (l2 - l1) + ", ifShow= " + bool1);
            bool2 = bool1;
          }
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool1 = false;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "checkIfShowTimHongdian " + localException1.toString());
          return bool1;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwc
 * JD-Core Version:    0.7.0.1
 */