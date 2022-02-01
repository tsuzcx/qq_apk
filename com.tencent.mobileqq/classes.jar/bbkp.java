import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class bbkp
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  static String jdField_a_of_type_JavaLangString = "DataCollector";
  Handler jdField_a_of_type_AndroidOsHandler = new bbkq(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  public boolean a;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Colloector-Tasker");
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public bbkp(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  static Looper a()
  {
    return jdField_a_of_type_AndroidOsHandlerThread.getLooper();
  }
  
  protected void a(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkp
 * JD-Core Version:    0.7.0.1
 */