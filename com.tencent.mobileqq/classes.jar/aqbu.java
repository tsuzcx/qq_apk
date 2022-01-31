import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

public class aqbu
  extends aqbe
{
  public aqbu(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean c()
  {
    Intent localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqbu
 * JD-Core Version:    0.7.0.1
 */