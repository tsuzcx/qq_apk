import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward.1;

public class anwq
  implements Camera.PreviewCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final anwg jdField_a_of_type_Anwg;
  private final anwh jdField_a_of_type_Anwh;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwq
 * JD-Core Version:    0.7.0.1
 */