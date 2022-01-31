import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class azjo
  implements QQPermissionCallback
{
  public azjo(azjq paramazjq, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_Azjq);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Azjq != null) {
      this.jdField_a_of_type_Azjq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azjo
 * JD-Core Version:    0.7.0.1
 */