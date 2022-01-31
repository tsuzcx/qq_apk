import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class areh
  implements URLDrawable.URLDrawableListener
{
  public areh(LoginWelcomeManager paramLoginWelcomeManager, arel paramarel, RecentUser paramRecentUser) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable onLoadSuccessed");
    }
    this.jdField_a_of_type_Arel.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Arel.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_Arel.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     areh
 * JD-Core Version:    0.7.0.1
 */