import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bjui
  implements Handler.Callback
{
  bjui(bjuf parambjuf) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bjuf.a(this.a)) {
        return false;
      }
      bjuf.a(this.a, new bjer());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bjuf.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bjuf.a(this.a).a(paramMessage);
        bjuf.a(this.a).a(this.a.a());
        bjuf.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        bdis.a().a(2131698317);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjui
 * JD-Core Version:    0.7.0.1
 */