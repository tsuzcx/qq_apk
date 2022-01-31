import android.os.Handler;
import android.os.Message;
import dov.com.qq.im.capture.view.CountDownView;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

public final class blzy
  extends Handler
{
  private WeakReference<CountDownView> a;
  
  public blzy(CountDownView paramCountDownView)
  {
    this.a = new WeakReference(paramCountDownView);
  }
  
  public void a(CountDownView paramCountDownView, @NotNull Message paramMessage)
  {
    if (paramMessage.what == 1) {
      CountDownView.a(paramCountDownView, CountDownView.a(paramCountDownView) - 1);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() == null)
    {
      removeCallbacksAndMessages(null);
      return;
    }
    try
    {
      a((CountDownView)this.a.get(), paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzy
 * JD-Core Version:    0.7.0.1
 */