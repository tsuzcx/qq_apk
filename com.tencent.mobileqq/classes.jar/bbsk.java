import android.os.Handler;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer;
import java.nio.ByteBuffer;

public class bbsk
  extends SCameraCaptureProcessor.CaptureCallback
{
  public bbsk(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onError(int paramInt)
  {
    bbsr.a(1, "[Camera2]Samsung Capture onError:" + paramInt);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, 0L);
  }
  
  public void onPictureAvailable(ByteBuffer paramByteBuffer)
  {
    bbsr.a(1, "[Camera2]Samsung Capture cost:" + (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F);
    bbsq.a(2, Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control), System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control) != null) && (Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control) != null) && (paramByteBuffer != null))
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).a = Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).a;
      Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).post(new Camera2Control.ImageSaveServer(arrayOfByte, Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control)));
    }
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, 0L);
    Camera2Control.e(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).a(0);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control);
  }
  
  public void onShutter()
  {
    bbsr.a(1, "[Camera2]samsungCapture onShutter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsk
 * JD-Core Version:    0.7.0.1
 */