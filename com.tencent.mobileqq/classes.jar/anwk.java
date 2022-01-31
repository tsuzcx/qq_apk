import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward.1;

public class anwk
  implements Camera.AutoFocusCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final anwb jdField_a_of_type_Anwb;
  private final anwh jdField_a_of_type_Anwh;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwk
 * JD-Core Version:    0.7.0.1
 */