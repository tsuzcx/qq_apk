import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class bdhw
  implements QQPermissionCallback
{
  public bdhw(bdhy parambdhy, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_Bdhy);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bdhy != null) {
      this.jdField_a_of_type_Bdhy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhw
 * JD-Core Version:    0.7.0.1
 */