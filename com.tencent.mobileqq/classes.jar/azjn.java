import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class azjn
  implements QQPermissionCallback
{
  public azjn(azjq paramazjq, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Azjq);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Azjq != null) {
      this.jdField_a_of_type_Azjq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azjn
 * JD-Core Version:    0.7.0.1
 */