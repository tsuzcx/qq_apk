import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class axob
  implements QQPermissionCallback
{
  public axob(axod paramaxod, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axod != null) {
      this.jdField_a_of_type_Axod.b();
    }
    bbcv.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axod != null) {
      this.jdField_a_of_type_Axod.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axob
 * JD-Core Version:    0.7.0.1
 */