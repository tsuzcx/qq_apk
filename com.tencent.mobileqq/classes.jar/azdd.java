import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1;

public class azdd
{
  public Handler a;
  public azde a;
  
  public azdd(Handler paramHandler, azde paramazde)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Azde = paramazde;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdd
 * JD-Core Version:    0.7.0.1
 */