import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;

public class awgp
  extends CameraCaptureSession.CaptureCallback
{
  public awgp(Camera2Control paramCamera2Control) {}
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    awgx.a(1, "[Camera2]captureStillPicture completed!");
    Camera2Control.a(this.a, 0L);
    Camera2Control.e(this.a, false);
    Camera2Control.a(this.a).a(0);
    Camera2Control.b(this.a);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    awgx.a(1, "[Camera2]captureStillPicture failed!");
    Camera2Control.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awgp
 * JD-Core Version:    0.7.0.1
 */