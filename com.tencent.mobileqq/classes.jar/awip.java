import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1;

public class awip
{
  public Handler a;
  public awiq a;
  
  public awip(Handler paramHandler, awiq paramawiq)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Awiq = paramawiq;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awip
 * JD-Core Version:    0.7.0.1
 */