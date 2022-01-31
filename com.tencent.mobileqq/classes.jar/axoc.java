import android.app.Activity;
import mqq.app.QQPermissionCallback;

public final class axoc
  implements QQPermissionCallback
{
  public axoc(axod paramaxod, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Axod);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Axod != null) {
      this.jdField_a_of_type_Axod.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axoc
 * JD-Core Version:    0.7.0.1
 */