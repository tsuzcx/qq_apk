import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class aznw
  implements QQPermissionCallback
{
  public aznw(aznz paramaznz, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aznz);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Aznz != null) {
      this.jdField_a_of_type_Aznz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aznw
 * JD-Core Version:    0.7.0.1
 */