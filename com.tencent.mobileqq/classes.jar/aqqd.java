import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.2;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.3;

public class aqqd
  implements aqpu
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final aqpu jdField_a_of_type_Aqpu;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.1(this, paramInt));
  }
  
  public void a(aqpq paramaqpq)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.3(this, paramaqpq));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqd
 * JD-Core Version:    0.7.0.1
 */