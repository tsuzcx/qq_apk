import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class bdhx
  implements QQPermissionCallback
{
  public bdhx(bdhy parambdhy, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bdhy != null) {
      this.jdField_a_of_type_Bdhy.b();
    }
    bhlq.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bdhy != null) {
      this.jdField_a_of_type_Bdhy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhx
 * JD-Core Version:    0.7.0.1
 */