import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1;
import com.tencent.qphone.base.util.QLog;

public class atrs
  implements atrp
{
  atrs(atrr paramatrr) {}
  
  public void a(atrm paramatrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    atrr.a(this.a, paramatrm);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (atrr.a(this.a) != null) {
      atrr.a(this.a).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrs
 * JD-Core Version:    0.7.0.1
 */