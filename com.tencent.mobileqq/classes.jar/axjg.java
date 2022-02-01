import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDrawable;
import mqq.app.Constants.PropertiesKey;

public class axjg
{
  public static FaceDrawable a(FragmentActivity paramFragmentActivity)
  {
    String str = axjz.a();
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    return FaceDrawable.getFaceDrawable(paramFragmentActivity.app, 1, str, 3, localDrawable, localDrawable, null);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + axjz.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjg
 * JD-Core Version:    0.7.0.1
 */