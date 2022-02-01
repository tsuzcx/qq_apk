import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class bcpd
  implements QQPermissionCallback
{
  public bcpd(bcpg parambcpg, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bcpg);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bcpg != null) {
      this.jdField_a_of_type_Bcpg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpd
 * JD-Core Version:    0.7.0.1
 */