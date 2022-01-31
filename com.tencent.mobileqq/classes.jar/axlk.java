import android.app.Activity;
import android.os.Build.VERSION;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class axlk
  implements QQPermissionCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private axll jdField_a_of_type_Axll;
  
  public axlk(Activity paramActivity, axll paramaxll)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Axll = paramaxll;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 23) {
      if (this.jdField_a_of_type_Axll != null) {
        this.jdField_a_of_type_Axll.a();
      }
    }
    label119:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidAppActivity == null);
        if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label119;
          }
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
            break;
          }
          ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
      } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity));
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    } while (this.jdField_a_of_type_Axll == null);
    this.jdField_a_of_type_Axll.a();
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axll != null) {
      this.jdField_a_of_type_Axll.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlk
 * JD-Core Version:    0.7.0.1
 */