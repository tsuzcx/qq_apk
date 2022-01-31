import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class awof
  implements QQPermissionCallback
{
  public awof(awog paramawog, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.jdField_a_of_type_MqqAppAppActivity);
    if (this.jdField_a_of_type_Awog != null) {
      this.jdField_a_of_type_Awog.b();
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Awog != null) {
      this.jdField_a_of_type_Awog.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awof
 * JD-Core Version:    0.7.0.1
 */