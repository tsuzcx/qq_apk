import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import java.io.File;
import org.json.JSONObject;

public class awfz
  implements beuq
{
  public awfz(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.b == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 2);
      parambevm = AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading succeeded");
      this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { parambevm.toString() });
      if (AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.mRuntime.a())) {
        zom.a(BaseApplicationImpl.getApplication(), new File(this.c));
      }
      return;
    }
    AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 3);
    parambevm = AECameraPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading failed");
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { parambevm.toString() });
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfz
 * JD-Core Version:    0.7.0.1
 */