import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class amfq
  implements Camera.PictureCallback
{
  private final amfg jdField_a_of_type_Amfg;
  private final amfi jdField_a_of_type_Amfi;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfq
 * JD-Core Version:    0.7.0.1
 */