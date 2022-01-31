import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class athw
  implements QQPermissionCallback
{
  public athw(MediaApiPlugin paramMediaApiPlugin, Intent paramIntent, Context paramContext, String paramString, JSONObject paramJSONObject, boolean paramBoolean, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.jdField_a_of_type_JavaLangString, 1, "User requestPermissions RECORD_AUDIO denied");
    bdgm.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, (byte)1);
      MediaApiPlugin.a(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", this.jdField_a_of_type_JavaLangString).putString("getMediaParam", this.jdField_a_of_type_OrgJsonJSONObject.toString()).putBoolean("calledFromOpenApi", this.jdField_a_of_type_Boolean).commit();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e(MediaApiPlugin.jdField_a_of_type_JavaLangString, 1, paramArrayOfString, new Object[0]);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131690645, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athw
 * JD-Core Version:    0.7.0.1
 */