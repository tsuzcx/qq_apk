import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class aqms
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqmi jdField_a_of_type_Aqmi;
  private final aqmk jdField_a_of_type_Aqmk;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqms
 * JD-Core Version:    0.7.0.1
 */