import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1;
import com.tencent.qphone.base.util.QLog;

public class atwb
  implements atvy
{
  atwb(atwa paramatwa) {}
  
  public void a(atvv paramatvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    atwa.a(this.a, paramatvv);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (atwa.a(this.a) != null) {
      atwa.a(this.a).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwb
 * JD-Core Version:    0.7.0.1
 */