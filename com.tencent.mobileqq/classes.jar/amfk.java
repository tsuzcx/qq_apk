import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward.1;

public class amfk
  implements Camera.AutoFocusCallback
{
  private final amfb jdField_a_of_type_Amfb;
  private final amfh jdField_a_of_type_Amfh;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfk
 * JD-Core Version:    0.7.0.1
 */