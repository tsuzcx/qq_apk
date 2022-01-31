import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class atch
  implements QQPermissionCallback
{
  atch(Context paramContext, String paramString, AppActivity paramAppActivity, Intent paramIntent) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions deny");
    }
    babr.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions grant");
    }
    try
    {
      atcg.a(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", this.jdField_a_of_type_JavaLangString).commit();
      this.jdField_a_of_type_MqqAppAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 1001);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, paramArrayOfString, new Object[0]);
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131625032, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atch
 * JD-Core Version:    0.7.0.1
 */