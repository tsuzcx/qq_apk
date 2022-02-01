import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class bqgy
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public HandlerThread a;
  private bqgz jdField_a_of_type_Bqgz;
  private int b;
  private int c;
  
  public bqgy(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = (1000 / paramInt1);
    this.b = ((int)(paramInt2 / 1000.0F * paramInt1) + 1);
    this.c = 0;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("shortvideo_Timer");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private boolean a(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (bqhu.jdField_a_of_type_Boolean)
    {
      paramMessage = RMVideoStateMgr.a();
      if (!paramMessage.jdField_a_of_type_Boolean) {
        break label179;
      }
      paramMessage.jdField_a_of_type_Double = (System.currentTimeMillis() - paramMessage.jdField_a_of_type_Long);
      if (paramMessage.jdField_a_of_type_Double >= bcjb.c) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        if (bool1)
        {
          QLog.d("TCTimer", 2, "handleLooperEvent startTime=" + paramMessage.jdField_a_of_type_Long + " total=" + paramMessage.jdField_a_of_type_Double);
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      if (bool2) {
        this.c = this.b;
      }
      int i = this.c;
      int j = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Bqgz != null) {
        this.jdField_a_of_type_Bqgz.a(this.jdField_a_of_type_Bqgz, bool2, i * j, this.c);
      }
      this.c += 1;
      return true;
      label179:
      if (this.c >= this.b) {
        bool2 = true;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1398036036);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_Int);
    }
    return a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgy
 * JD-Core Version:    0.7.0.1
 */