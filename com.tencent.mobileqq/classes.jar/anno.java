import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class anno
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final annp jdField_a_of_type_Annp;
  private annq jdField_a_of_type_Annq;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public anno(annp paramannp)
  {
    this.jdField_a_of_type_Annp = paramannp;
    this.jdField_a_of_type_AndroidOsHandler = new blhq(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, annq paramannq)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Annq = paramannq;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Annp.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Annq != null)
          {
            paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, this.jdField_a_of_type_Int);
          }
          break;
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    this.b = true;
    this.jdField_a_of_type_Annq = null;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.b) {
        a(paramMessage.getData());
      }
      return true;
      if (this.jdField_a_of_type_Annq != null)
      {
        this.jdField_a_of_type_Annq.b();
        this.jdField_a_of_type_Annq = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anno
 * JD-Core Version:    0.7.0.1
 */