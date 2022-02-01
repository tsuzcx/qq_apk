import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.FaceDetectionCallbackForward.1;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class aqmr
  implements Camera.FaceDetectionListener
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqmg jdField_a_of_type_Aqmg;
  private final aqmk jdField_a_of_type_Aqmk;
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    QLog.d("Q.camera.CameraManagerImpl", 2, "[onFaceDetection] faces = " + paramArrayOfFace + ", length = " + paramArrayOfFace.length);
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.FaceDetectionCallbackForward.1(this, paramArrayOfFace));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmr
 * JD-Core Version:    0.7.0.1
 */