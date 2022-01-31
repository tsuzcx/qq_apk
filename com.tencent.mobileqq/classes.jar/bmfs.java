import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bmfs
  implements Handler.Callback
{
  bmfs(bmfp parambmfp) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (bmfp.a(this.a)) {
        return false;
      }
      bmfp.a(this.a, new blqc());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      bmfp.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        bmfp.a(this.a).a(paramMessage);
        bmfp.a(this.a).a(this.a.a());
        bmfp.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        bfhq.a().a(2131698607);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfs
 * JD-Core Version:    0.7.0.1
 */