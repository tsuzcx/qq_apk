import android.app.Activity;
import android.os.Build.VERSION;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class bbhq
  implements QQPermissionCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbhr jdField_a_of_type_Bbhr;
  
  public bbhq(Activity paramActivity, bbhr parambbhr)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bbhr = parambbhr;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 23) {
      if (this.jdField_a_of_type_Bbhr != null) {
        this.jdField_a_of_type_Bbhr.onGetLocation();
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
    } while (this.jdField_a_of_type_Bbhr == null);
    this.jdField_a_of_type_Bbhr.onGetLocation();
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bbhr != null) {
      this.jdField_a_of_type_Bbhr.onGetLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhq
 * JD-Core Version:    0.7.0.1
 */