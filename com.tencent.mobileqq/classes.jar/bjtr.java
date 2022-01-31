import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bjtr
  implements Handler.Callback
{
  bjtr(bjto parambjto) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bjto.a(this.a)) {
        return false;
      }
      bjto.a(this.a, new bjea());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bjto.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bjto.a(this.a).a(paramMessage);
        bjto.a(this.a).a(this.a.a());
        bjto.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        bdid.a().a(2131698307);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtr
 * JD-Core Version:    0.7.0.1
 */