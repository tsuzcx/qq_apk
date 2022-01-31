import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import mqq.app.QQPermissionCallback;

public class armr
  implements QQPermissionCallback
{
  public armr(IdentificationApiPlugin.1.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbcv.a(armp.a(this.a.jdField_a_of_type_Armq.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    armp.a(this.a.jdField_a_of_type_Armq.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armr
 * JD-Core Version:    0.7.0.1
 */