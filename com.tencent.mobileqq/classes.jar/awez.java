import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class awez
  extends Handler
{
  WeakReference<WatchTogetherFloatingView> a;
  
  public awez(WatchTogetherFloatingView paramWatchTogetherFloatingView)
  {
    this.a = new WeakReference(paramWatchTogetherFloatingView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      sendEmptyMessageDelayed(2, 20000L);
      return;
      removeMessages(2);
      return;
      try
      {
        ((WatchTogetherFloatingView)this.a.get()).a();
        return;
      }
      catch (NullPointerException paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.d("WatchTogetherFloatingView", 2, "MESSAGE_WAIT_LOADING END, but View missing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awez
 * JD-Core Version:    0.7.0.1
 */