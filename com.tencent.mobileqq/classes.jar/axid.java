import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.qphone.base.util.QLog;

class axid
  implements Camera.AutoFocusCallback
{
  axid(axic paramaxic) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axid
 * JD-Core Version:    0.7.0.1
 */