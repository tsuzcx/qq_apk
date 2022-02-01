import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class bcam
  implements QQPermissionCallback
{
  public bcam(bcan parambcan, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bcan != null) {
      this.jdField_a_of_type_Bcan.b();
    }
    bfur.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bcan != null) {
      this.jdField_a_of_type_Bcan.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcam
 * JD-Core Version:    0.7.0.1
 */