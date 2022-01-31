import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

public class arvc
  extends arum
{
  public arvc(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean c()
  {
    Intent localIntent = aekt.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvc
 * JD-Core Version:    0.7.0.1
 */