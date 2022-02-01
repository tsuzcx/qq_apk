import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class bnja
  implements amoe
{
  public bnja(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, Map paramMap, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    bnrh.a("AECMShowRequestController", "[requestCmJoyRoleInfo], roleDir=" + paramString1 + ", errMsg=" + paramString2);
    if (!TextUtils.isEmpty(paramString1))
    {
      if (AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController));
      }
      if (AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController) != null)
      {
        AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController, 100);
        AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController).c(AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController));
        paramString2 = new AECMShowRequestController.CmShowDataWrapper();
        paramString2.sceneMode = AECMShowRequestController.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController);
        paramString2.namePathMap = this.jdField_a_of_type_JavaUtilHashMap;
        paramString2.rolePath = paramString1;
        paramString2.dressidMaps = this.jdField_a_of_type_JavaUtilMap;
        paramString2.cmJsonString = this.jdField_a_of_type_JavaLangString;
        AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController).a(1, paramString2);
      }
    }
    do
    {
      return;
      if (AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController));
      }
    } while (AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController) == null);
    AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnja
 * JD-Core Version:    0.7.0.1
 */