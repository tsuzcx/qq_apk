import android.app.Activity;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class bmjl
  implements QQPermissionCallback
{
  public bmjl(TroopHWJsPlugin paramTroopHWJsPlugin, Activity paramActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.c = TroopHWJsPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjl
 * JD-Core Version:    0.7.0.1
 */