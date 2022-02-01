import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1;
import com.tencent.qphone.base.util.QLog;

public class awpm
  implements awpj
{
  awpm(awpl paramawpl) {}
  
  public void a(awpg paramawpg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    awpl.a(this.a, paramawpg);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (awpl.a(this.a) != null) {
      awpl.a(this.a).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpm
 * JD-Core Version:    0.7.0.1
 */