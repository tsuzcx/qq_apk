import android.os.Message;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1;

public class awjd
{
  public final Object a;
  public final Runnable a;
  
  awjd()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = new CameraProxy.WaitDoneBundle.1(this);
  }
  
  static void a(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (!(paramMessage.obj instanceof awjd)) {
      return;
    }
    ((awjd)paramMessage.obj).jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awjd
 * JD-Core Version:    0.7.0.1
 */