import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import mqq.app.QQPermissionCallback;

public class armt
  implements QQPermissionCallback
{
  public armt(IdentificationApiPlugin.1.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(armr.a(this.a.jdField_a_of_type_Arms.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    armr.a(this.a.jdField_a_of_type_Arms.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armt
 * JD-Core Version:    0.7.0.1
 */