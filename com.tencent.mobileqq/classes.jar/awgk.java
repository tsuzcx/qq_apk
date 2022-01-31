import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import java.util.concurrent.Semaphore;

public class awgk
  extends CameraDevice.StateCallback
{
  public awgk(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    awgx.a(2, "[Camera2]openCamera2 onDisconnected!");
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    paramCameraDevice.close();
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, null);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a.a(-105);
    }
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    awgx.a(2, "[Camera2]openCamera2 onError, error:" + paramInt);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    paramCameraDevice.close();
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, null);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a.a(-102);
    }
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    awgx.a(1, "[Camera2]openCamera2 onOpen, cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, paramCameraDevice);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, true);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awgk
 * JD-Core Version:    0.7.0.1
 */