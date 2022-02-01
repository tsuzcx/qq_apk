import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1;
import com.tencent.qphone.base.util.QLog;

public class awwc
  implements awvz
{
  awwc(awwb paramawwb) {}
  
  public void a(awvw paramawvw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    awwb.a(this.a, paramawvw);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (awwb.a(this.a) != null) {
      awwb.a(this.a).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwc
 * JD-Core Version:    0.7.0.1
 */