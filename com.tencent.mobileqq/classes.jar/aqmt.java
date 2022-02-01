import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward.1;

public class aqmt
  implements Camera.PreviewCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqmj jdField_a_of_type_Aqmj;
  private final aqmk jdField_a_of_type_Aqmk;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmt
 * JD-Core Version:    0.7.0.1
 */