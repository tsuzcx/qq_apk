import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class bdhd
  implements QQPermissionCallback
{
  public bdhd(bdhi parambdhi, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_Bdhi);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Bdhi != null) {
      this.jdField_a_of_type_Bdhi.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhd
 * JD-Core Version:    0.7.0.1
 */