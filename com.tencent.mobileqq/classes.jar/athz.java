import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class athz
  implements QQPermissionCallback
{
  public athz(MediaApiPlugin paramMediaApiPlugin, JSONObject paramJSONObject, boolean paramBoolean, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.a, 1, "User requestPermissions WRITE_EXTERNAL_STORAGE denied");
    bdgm.a(this.jdField_a_of_type_MqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athz
 * JD-Core Version:    0.7.0.1
 */