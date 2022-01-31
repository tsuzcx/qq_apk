import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class axxk
  extends axxg
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public axxk(QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      this.ctrl.a(this);
    }
    return true;
  }
  
  protected void realCancel()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void realStart()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Long);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_JavaLangRunnable + ", " + this.jdField_a_of_type_Long + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxk
 * JD-Core Version:    0.7.0.1
 */