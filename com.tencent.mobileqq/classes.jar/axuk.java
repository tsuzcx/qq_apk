import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class axuk
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  
  public axuk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("Notify_on_like", true);
      this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_allow_nearby_like", true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("Notify_on_like", paramBoolean).commit();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.b != paramBoolean) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null))
    {
      this.b = paramBoolean;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_allow_nearby_like", paramBoolean).commit();
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuk
 * JD-Core Version:    0.7.0.1
 */