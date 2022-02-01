import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1;

public class bdbe
{
  public Handler a;
  public bdbf a;
  
  public bdbe(Handler paramHandler, bdbf parambdbf)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Bdbf = parambdbf;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbe
 * JD-Core Version:    0.7.0.1
 */