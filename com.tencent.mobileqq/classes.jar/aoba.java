import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward.1;

public class aoba
  implements Camera.ShutterCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aoaq jdField_a_of_type_Aoaq;
  private final aoar jdField_a_of_type_Aoar;
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoba
 * JD-Core Version:    0.7.0.1
 */