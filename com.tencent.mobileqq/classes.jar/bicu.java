import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bicu
  implements Handler.Callback
{
  bicu(bicr parambicr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bicr.a(this.a)) {
        return false;
      }
      bicr.a(this.a, new bhji());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bicr.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bicr.a(this.a).a(paramMessage);
        bicr.a(this.a).a(this.a.a());
        bicr.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        bcec.a().a(2131632571);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicu
 * JD-Core Version:    0.7.0.1
 */