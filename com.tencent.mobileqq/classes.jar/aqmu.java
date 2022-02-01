import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward.1;

public class aqmu
  implements Camera.ShutterCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqmk jdField_a_of_type_Aqmk;
  private final aqml jdField_a_of_type_Aqml;
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmu
 * JD-Core Version:    0.7.0.1
 */