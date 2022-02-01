import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.File;
import org.json.JSONObject;

public class avyy
  implements INetEngine.INetEngineListener
{
  public avyy(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mErrCode == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 2);
      paramNetResp = AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading succeeded");
      this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramNetResp.toString() });
      if (AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.mRuntime.a())) {
        zeb.a(BaseApplicationImpl.getApplication(), new File(this.c));
      }
      return;
    }
    AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 3);
    paramNetResp = AECameraPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading failed");
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramNetResp.toString() });
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyy
 * JD-Core Version:    0.7.0.1
 */