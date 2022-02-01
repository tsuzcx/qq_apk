import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class bcpf
  implements QQPermissionCallback
{
  public bcpf(bcpg parambcpg, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bcpg != null) {
      this.jdField_a_of_type_Bcpg.b();
    }
    bglp.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bcpg != null) {
      this.jdField_a_of_type_Bcpg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpf
 * JD-Core Version:    0.7.0.1
 */