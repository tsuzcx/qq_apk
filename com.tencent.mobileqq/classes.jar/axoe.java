import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class axoe
  implements QQPermissionCallback
{
  public axoe(axof paramaxof, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Axof);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axof != null) {
      this.jdField_a_of_type_Axof.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axoe
 * JD-Core Version:    0.7.0.1
 */