import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bjew
  extends Handler
{
  WeakReference<KSongView> a;
  
  public bjew(KSongView paramKSongView)
  {
    this.a = new WeakReference(paramKSongView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = (KSongView)this.a.get();
      if ((paramMessage != null) && (1 == paramMessage.a())) {
        break label31;
      }
    }
    label31:
    do
    {
      return;
      long l = System.currentTimeMillis() - KSongView.a(paramMessage) - paramMessage.a;
      bjes localbjes = paramMessage.a();
      paramMessage.a(l);
      if (l >= localbjes.d) {
        KSongView.a(paramMessage, l);
      }
      QLog.i("KSongView", 2, "real_duration = " + l);
      if (l < localbjes.e)
      {
        sendEmptyMessageDelayed(0, 50L);
        return;
      }
      KSongView.a(paramMessage, 3);
    } while (KSongView.a(paramMessage) == null);
    KSongView.a(paramMessage).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjew
 * JD-Core Version:    0.7.0.1
 */