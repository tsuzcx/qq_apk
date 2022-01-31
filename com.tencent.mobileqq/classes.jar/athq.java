import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import mqq.app.QQPermissionCallback;

public class athq
  implements QQPermissionCallback
{
  public athq(IdentificationApiPlugin.1.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.a(atho.a(this.a.jdField_a_of_type_Athp.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    atho.a(this.a.jdField_a_of_type_Athp.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athq
 * JD-Core Version:    0.7.0.1
 */