import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class axod
  implements QQPermissionCallback
{
  public axod(axof paramaxof, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axof != null) {
      this.jdField_a_of_type_Axof.b();
    }
    bbdj.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axof != null) {
      this.jdField_a_of_type_Axof.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axod
 * JD-Core Version:    0.7.0.1
 */