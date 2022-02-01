import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class bdhv
  implements QQPermissionCallback
{
  public bdhv(bdhy parambdhy, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdhy);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bdhy != null) {
      this.jdField_a_of_type_Bdhy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhv
 * JD-Core Version:    0.7.0.1
 */