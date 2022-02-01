import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import java.util.ArrayList;

public class bdnj
  extends Handler
{
  private bdni jdField_a_of_type_Bdni;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean;
  
  public bdnj(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper, Thread paramThread, bdni parambdni)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangThread = paramThread;
    this.jdField_a_of_type_Bdni = parambdni;
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    sendMessageDelayed(localMessage, 200L);
  }
  
  public void b()
  {
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangThread.getState() == Thread.State.BLOCKED)
      {
        if (this.jdField_a_of_type_Boolean == true)
        {
          SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.a());
          SuspendThreadManager.a(1);
          b();
          this.jdField_a_of_type_Bdni.a();
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        a();
        return;
      }
    } while (SuspendThreadManager.a().isEmpty());
    this.jdField_a_of_type_Boolean = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnj
 * JD-Core Version:    0.7.0.1
 */