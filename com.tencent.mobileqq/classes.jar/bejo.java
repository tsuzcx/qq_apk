import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class bejo
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final bejp jdField_a_of_type_Bejp;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public bejo(bejp parambejp)
  {
    this.jdField_a_of_type_Bejp = parambejp;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Bejp.a(paramBundle))
        {
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.b) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejo
 * JD-Core Version:    0.7.0.1
 */