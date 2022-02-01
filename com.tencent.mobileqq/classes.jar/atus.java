import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class atus
  extends MqqHandler
{
  atus(atur paramatur, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "recv Netchang event!");
    }
    this.a.a.a().a(true);
    this.a.a.a().b(-1);
    atvk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atus
 * JD-Core Version:    0.7.0.1
 */