import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bpbk
  implements Handler.Callback
{
  bpbk(bpbh parambpbh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bpbh.a(this.a)) {
        return false;
      }
      bpbh.a(this.a, new bons());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bpbh.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bpbh.a(this.a).a(paramMessage);
        bpbh.a(this.a).a(this.a.a());
        bpbh.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        biti.a().a(2131697512);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbk
 * JD-Core Version:    0.7.0.1
 */