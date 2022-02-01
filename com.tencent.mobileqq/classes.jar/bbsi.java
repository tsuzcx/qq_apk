import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;

public class bbsi
  extends CameraCaptureSession.CaptureCallback
{
  public bbsi(Camera2Control paramCamera2Control) {}
  
  private void a(CaptureResult paramCaptureResult, CaptureRequest paramCaptureRequest)
  {
    paramCaptureRequest = paramCaptureRequest.getTag();
    if ((!(paramCaptureRequest instanceof bbus)) || (((bbus)paramCaptureRequest).jdField_a_of_type_Boolean))
    {
      bbsr.a(1, "[Camera2] mAfCaptureCallback handled!");
      Camera2Control.d(this.a, false);
    }
    do
    {
      return;
      paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      bbsr.a(1, "[Camera2] mAfCaptureCallback:" + paramCaptureResult);
    } while ((paramCaptureResult == null) || ((4 != paramCaptureResult.intValue()) && (5 != paramCaptureResult.intValue())));
    a(true, (bbus)paramCaptureRequest);
  }
  
  private void a(boolean paramBoolean, bbus parambbus)
  {
    Camera2Control.d(this.a, false);
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try
    {
      bbsr.a(1, "[Camera2] mAfCaptureCallback run, success:" + paramBoolean);
      Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      CameraCaptureSession localCameraCaptureSession = Camera2Control.a(this.a);
      if (this.a.jdField_a_of_type_Boolean) {}
      for (CaptureRequest localCaptureRequest = Camera2Control.a(this.a).buildCaptureRequest(Camera2Control.a(this.a));; localCaptureRequest = Camera2Control.a(this.a).build())
      {
        localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
        if ((parambbus.jdField_a_of_type_Bbsp.a == null) || (parambbus.jdField_a_of_type_Boolean)) {
          break;
        }
        parambbus.jdField_a_of_type_Boolean = true;
        parambbus.jdField_a_of_type_Bbsp.a.a(1, paramBoolean);
        return;
      }
      return;
    }
    catch (Exception parambbus)
    {
      bbsr.a(2, "[Camera2] mAfCaptureCallback e:" + parambbus);
    }
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult, paramCaptureRequest);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    bbsr.a(2, "[Camera2] mAfCaptureCallback failure reason:" + paramCaptureFailure.getReason());
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if ((!(paramCameraCaptureSession instanceof bbus)) || (((bbus)paramCameraCaptureSession).jdField_a_of_type_Boolean))
    {
      bbsr.a(1, "[Camera2] mAfCaptureCallback handled!");
      Camera2Control.d(this.a, false);
      return;
    }
    a(false, (bbus)paramCameraCaptureSession);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult, paramCaptureRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsi
 * JD-Core Version:    0.7.0.1
 */