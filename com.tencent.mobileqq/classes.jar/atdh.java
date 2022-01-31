import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import mqq.app.QQPermissionCallback;

public class atdh
  implements QQPermissionCallback
{
  public atdh(IdentificationApiPlugin.1.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(atdf.a(this.a.jdField_a_of_type_Atdg.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    atdf.a(this.a.jdField_a_of_type_Atdg.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdh
 * JD-Core Version:    0.7.0.1
 */