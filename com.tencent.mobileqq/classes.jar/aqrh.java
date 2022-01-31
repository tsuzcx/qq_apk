import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import java.io.File;
import org.json.JSONObject;

public class aqrh
  implements axrt
{
  public aqrh(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.b == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 2);
      paramaxsq = AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading succeeded");
      this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramaxsq.toString() });
      vlm.a(BaseApplicationImpl.getApplication(), new File(this.c));
      return;
    }
    AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 3);
    paramaxsq = AECameraPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading failed");
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramaxsq.toString() });
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrh
 * JD-Core Version:    0.7.0.1
 */