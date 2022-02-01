import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class awbw
  extends bhyn
{
  public awbw(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(bhyo parambhyo)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (parambhyo.a == 0)
    {
      parambhyo = AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString);
      if (new File(parambhyo).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, parambhyo, 0);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbw
 * JD-Core Version:    0.7.0.1
 */