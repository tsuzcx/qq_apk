import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class atfg
  extends bdvu
{
  public atfg(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(bdvv parambdvv)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (parambdvv.a == 0)
    {
      parambdvv = bame.d(this.jdField_a_of_type_JavaLangString);
      if (new File(parambdvv).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, parambdvv, 0);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfg
 * JD-Core Version:    0.7.0.1
 */