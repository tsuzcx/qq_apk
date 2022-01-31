import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.2;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.3;

public class amfo
  implements amff
{
  private final amff jdField_a_of_type_Amff;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.1(this, paramInt));
  }
  
  public void a(amfb paramamfb)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.3(this, paramamfb));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfo
 * JD-Core Version:    0.7.0.1
 */