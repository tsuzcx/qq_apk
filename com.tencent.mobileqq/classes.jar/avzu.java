import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.2.1;
import mqq.app.QQPermissionCallback;

public class avzu
  implements QQPermissionCallback
{
  public avzu(IdentificationApiPlugin.2.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(avzr.a(this.a.jdField_a_of_type_Avzt.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    avzr.a(this.a.jdField_a_of_type_Avzt.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzu
 * JD-Core Version:    0.7.0.1
 */