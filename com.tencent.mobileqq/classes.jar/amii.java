import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class amii
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final amij jdField_a_of_type_Amij;
  private amik jdField_a_of_type_Amik;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public amii(amij paramamij)
  {
    this.jdField_a_of_type_Amij = paramamij;
    this.jdField_a_of_type_AndroidOsHandler = new bjng(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, amik paramamik)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Amik = paramamik;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Amij.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Amik != null)
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
    this.jdField_a_of_type_Amik = null;
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
      if (this.jdField_a_of_type_Amik != null)
      {
        this.jdField_a_of_type_Amik.b();
        this.jdField_a_of_type_Amik = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amii
 * JD-Core Version:    0.7.0.1
 */