import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import cooperation.troop_homework.jsp.TroopHWVoiceController;
import cooperation.troop_homework.jsp.TroopHWVoiceController.RecordCallback;
import java.lang.ref.WeakReference;

public class ange
  extends Handler
{
  public ange(TroopHWVoiceController paramTroopHWVoiceController) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (TroopHWVoiceController.a(this.a) != null) {
            TroopHWVoiceController.a(this.a).a(1, TroopHWVoiceController.a(this.a));
          }
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
        this.a.d(paramMessage);
        this.a.c(paramMessage);
        return;
        TroopHWVoiceController.a(this.a).c();
        AudioUtil.b(2131230743, false);
      } while (this.a.a == null);
      paramMessage = (Context)this.a.a.get();
    } while (paramMessage == null);
    AudioUtil.a(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ange
 * JD-Core Version:    0.7.0.1
 */