import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward.1;

public class anwr
  implements Camera.ShutterCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final anwh jdField_a_of_type_Anwh;
  private final anwi jdField_a_of_type_Anwi;
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwr
 * JD-Core Version:    0.7.0.1
 */