import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class atdp
  implements QQPermissionCallback
{
  public atdp(MediaApiPlugin paramMediaApiPlugin, JSONObject paramJSONObject, boolean paramBoolean, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.a, 1, "User requestPermissions WRITE_EXTERNAL_STORAGE denied");
    bdcd.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdp
 * JD-Core Version:    0.7.0.1
 */