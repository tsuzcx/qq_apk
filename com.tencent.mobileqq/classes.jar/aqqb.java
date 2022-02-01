import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFMoveCallbackForward.1;

@TargetApi(16)
public class aqqb
  implements Camera.AutoFocusMoveCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqps jdField_a_of_type_Aqps;
  private final aqpx jdField_a_of_type_Aqpx;
  
  public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFMoveCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqb
 * JD-Core Version:    0.7.0.1
 */