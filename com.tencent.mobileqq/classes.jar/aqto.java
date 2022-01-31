import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class aqto
  extends batl
{
  public aqto(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(batm parambatm)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (parambatm.a == 0)
    {
      parambatm = axoa.d(this.jdField_a_of_type_JavaLangString);
      if (new File(parambatm).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, parambatm, 0);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqto
 * JD-Core Version:    0.7.0.1
 */