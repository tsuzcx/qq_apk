import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1;

public class axhx
{
  public Handler a;
  public axhy a;
  
  public axhx(Handler paramHandler, axhy paramaxhy)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Axhy = paramaxhy;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axhx
 * JD-Core Version:    0.7.0.1
 */