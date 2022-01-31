import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.humrecognition.humming.OriginalBgmRecognizer;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;
import java.io.File;

public class anbu
  implements Handler.Callback
{
  public anbu(EditRecognitionPart paramEditRecognitionPart) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (EditRecognitionPart.a(this.a)) {
        return false;
      }
      EditRecognitionPart.a(this.a, new OriginalBgmRecognizer());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      EditRecognitionPart.b(this.a).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.a.a();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        EditRecognitionPart.a(this.a).a(paramMessage);
        EditRecognitionPart.a(this.a).a(this.a.a());
        EditRecognitionPart.a(this.a).a();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        ToastUtil.a().a(2131439225);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anbu
 * JD-Core Version:    0.7.0.1
 */