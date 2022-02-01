import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class bniz
  implements amod
{
  public bniz(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, List paramList, int paramInt, String paramString) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    bnrh.a("AECMShowRequestController", "[requestCmJoyDressInfo], apolloDressInfo=" + paramHashMap + ", errMsg=" + paramString);
    if (paramHashMap != null)
    {
      paramHashMap = AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController, this.jdField_a_of_type_JavaUtilHashMap, paramHashMap);
      paramString = AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController, this.jdField_a_of_type_JavaUtilList);
      AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController, this.jdField_a_of_type_Int, paramHashMap, this.jdField_a_of_type_JavaLangString, paramString);
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
 * Qualified Name:     bniz
 * JD-Core Version:    0.7.0.1
 */