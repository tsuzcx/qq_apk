import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class amfp
  implements Camera.PictureCallback
{
  private final amff jdField_a_of_type_Amff;
  private final amfh jdField_a_of_type_Amfh;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfp
 * JD-Core Version:    0.7.0.1
 */