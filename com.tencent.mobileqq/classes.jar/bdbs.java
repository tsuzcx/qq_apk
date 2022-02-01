import android.os.Message;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1;

public class bdbs
{
  public final Object a;
  public final Runnable a;
  
  bdbs()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = new CameraProxy.WaitDoneBundle.1(this);
  }
  
  static void a(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (!(paramMessage.obj instanceof bdbs)) {
      return;
    }
    ((bdbs)paramMessage.obj).jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbs
 * JD-Core Version:    0.7.0.1
 */