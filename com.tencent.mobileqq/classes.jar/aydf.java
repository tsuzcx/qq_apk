import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqmini.sdk.manager.LoginManager;
import mqq.app.Constants.PropertiesKey;

public class aydf
{
  public static aoch a(FragmentActivity paramFragmentActivity)
  {
    String str = LoginManager.getInstance().getAccount();
    Drawable localDrawable = aoch.a(1, 3);
    return aoch.a(paramFragmentActivity.app, 1, str, 3, localDrawable, localDrawable, null);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + LoginManager.getInstance().getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydf
 * JD-Core Version:    0.7.0.1
 */