import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class azny
  implements QQPermissionCallback
{
  public azny(aznz paramaznz, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Aznz != null) {
      this.jdField_a_of_type_Aznz.b();
    }
    bdgm.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Aznz != null) {
      this.jdField_a_of_type_Aznz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azny
 * JD-Core Version:    0.7.0.1
 */