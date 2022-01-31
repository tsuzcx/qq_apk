import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class aoay
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aoao jdField_a_of_type_Aoao;
  private final aoaq jdField_a_of_type_Aoaq;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoay
 * JD-Core Version:    0.7.0.1
 */