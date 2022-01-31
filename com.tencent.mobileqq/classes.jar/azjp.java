import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class azjp
  implements QQPermissionCallback
{
  public azjp(azjq paramazjq, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Azjq != null) {
      this.jdField_a_of_type_Azjq.b();
    }
    bdcd.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Azjq != null) {
      this.jdField_a_of_type_Azjq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azjp
 * JD-Core Version:    0.7.0.1
 */