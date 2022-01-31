import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class anwp
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final anwf jdField_a_of_type_Anwf;
  private final anwh jdField_a_of_type_Anwh;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwp
 * JD-Core Version:    0.7.0.1
 */