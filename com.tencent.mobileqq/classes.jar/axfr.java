import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.support.annotation.NonNull;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import java.util.concurrent.Semaphore;

public class axfr
  extends CameraCaptureSession.StateCallback
{
  public axfr(Camera2Control paramCamera2Control) {}
  
  public void onConfigureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    axgd.a(2, "[Camera2]startPreview onConfigureFailed!");
    Camera2Control.c(this.a, false);
    Camera2Control.a(this.a).release();
    if (this.a.jdField_a_of_type_Axfy != null) {
      this.a.jdField_a_of_type_Axfy.a(-202);
    }
  }
  
  public void onConfigured(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    axgd.a(1, "[Camera2]startPreview onConfigured!");
    Camera2Control.c(this.a, true);
    Camera2Control.a(this.a, paramCameraCaptureSession);
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Camera2Control.a(this.a));
    if (this.a.jdField_a_of_type_Boolean)
    {
      Camera2Control.a(this.a, Camera2Control.a(this.a).buildCaptureRequest(Camera2Control.a(this.a)));
      this.a.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = Camera2Control.a(this.a).createCaptureCallback(Camera2Control.a(this.a), Camera2Control.a(this.a));
    }
    for (;;)
    {
      Camera2Control.a(this.a);
      Camera2Control.a(this.a).release();
      return;
      Camera2Control.b(this.a, Camera2Control.a(this.a).build());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfr
 * JD-Core Version:    0.7.0.1
 */