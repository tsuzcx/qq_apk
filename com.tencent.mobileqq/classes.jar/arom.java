import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class arom
  extends bbwt
{
  public arom(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(bbwu parambbwu)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (parambbwu.a == 0)
    {
      parambbwu = ayoi.d(this.jdField_a_of_type_JavaLangString);
      if (new File(parambbwu).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, parambbwu, 0);
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
 * Qualified Name:     arom
 * JD-Core Version:    0.7.0.1
 */