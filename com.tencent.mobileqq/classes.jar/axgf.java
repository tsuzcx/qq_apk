import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;

@TargetApi(21)
public class axgf
  extends CameraCaptureSession.CaptureCallback
{
  private int jdField_a_of_type_Int = 0;
  private Camera2Control jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  
  public axgf(Camera2Control paramCamera2Control)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control = paramCamera2Control;
  }
  
  private void a(CaptureResult paramCaptureResult)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        Integer localInteger;
        do
        {
          do
          {
            return;
            localInteger = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            axgd.a(1, "[Camera2]process afState:" + localInteger);
            if (localInteger != null) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.d();
          return;
        } while ((4 != localInteger.intValue()) && (5 != localInteger.intValue()) && (localInteger.intValue() != 0) && (1 != localInteger.intValue()) && (2 != localInteger.intValue()));
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult != null) && (paramCaptureResult.intValue() != 2)) {
          break;
        }
        this.jdField_a_of_type_Int = 4;
        axgd.a(1, "[Camera2]process aeState:" + paramCaptureResult);
      } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.d();
      return;
      axgd.a(1, "[Camera2]process preCapture aeState:" + paramCaptureResult);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.d();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgf
 * JD-Core Version:    0.7.0.1
 */