import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bmke
  implements Handler.Callback
{
  bmke(bmkb parambmkb) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bmkb.a(this.a)) {
        return false;
      }
      bmkb.a(this.a, new bluo());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bmkb.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bmkb.a(this.a).a(paramMessage);
        bmkb.a(this.a).a(this.a.a());
        bmkb.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        bflz.a().a(2131698619);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmke
 * JD-Core Version:    0.7.0.1
 */