import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class avoq
  implements QQPermissionCallback
{
  public avoq(MediaApiPlugin paramMediaApiPlugin, Intent paramIntent, Context paramContext, String paramString, JSONObject paramJSONObject, boolean paramBoolean, BasePluginActivity paramBasePluginActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.jdField_a_of_type_JavaLangString, 1, "User requestPermissions RECORD_AUDIO denied");
    bglp.a(this.jdField_a_of_type_ComTencentMobileqqPluginsdkBasePluginActivity.getOutActivity(), paramArrayOfString, paramArrayOfInt);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131690580, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoq
 * JD-Core Version:    0.7.0.1
 */