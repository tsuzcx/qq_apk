import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class aqqf
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqpv jdField_a_of_type_Aqpv;
  private final aqpx jdField_a_of_type_Aqpx;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqf
 * JD-Core Version:    0.7.0.1
 */