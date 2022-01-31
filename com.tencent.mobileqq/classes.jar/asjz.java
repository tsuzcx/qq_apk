import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.gamecenter.view.ScrollTextView;
import java.lang.ref.WeakReference;

public class asjz
  extends Handler
{
  private WeakReference<ScrollTextView> a;
  
  public asjz(ScrollTextView paramScrollTextView)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramScrollTextView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ScrollTextView localScrollTextView = (ScrollTextView)this.a.get();
    if (localScrollTextView == null)
    {
      removeCallbacksAndMessages(null);
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (ScrollTextView.a(localScrollTextView) != null)
    {
      localScrollTextView.b();
      ScrollTextView.a(localScrollTextView);
      if (ScrollTextView.b(localScrollTextView) >= ScrollTextView.a(localScrollTextView).length) {
        ScrollTextView.a(localScrollTextView, 0);
      }
      localScrollTextView.setText(ScrollTextView.a(localScrollTextView)[ScrollTextView.b(localScrollTextView)]);
    }
    removeMessages(9001);
    sendEmptyMessageDelayed(9001, ScrollTextView.a(localScrollTextView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjz
 * JD-Core Version:    0.7.0.1
 */