import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward.1;

public class aqqg
  implements Camera.PreviewCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqpw jdField_a_of_type_Aqpw;
  private final aqpx jdField_a_of_type_Aqpx;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqg
 * JD-Core Version:    0.7.0.1
 */