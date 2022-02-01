import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class atli
  extends MqqHandler
{
  atli(atlh paramatlh, Looper paramLooper)
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
    this.a.a.getFileManagerRSCenter().a(true);
    this.a.a.getOnlineFileSessionCenter().b(-1);
    atma.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atli
 * JD-Core Version:    0.7.0.1
 */