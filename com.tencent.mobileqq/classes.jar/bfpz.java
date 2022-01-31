import android.os.Handler;
import android.os.Message;
import com.tencent.widget.CountDownProgressBar;

public class bfpz
  extends Handler
{
  public bfpz(CountDownProgressBar paramCountDownProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      CountDownProgressBar.a(this.a, CountDownProgressBar.a(this.a) + CountDownProgressBar.a(this.a));
      CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
      return;
      CountDownProgressBar.a(this.a, CountDownProgressBar.a(this.a) + CountDownProgressBar.a(this.a));
      if (CountDownProgressBar.a(this.a) <= (float)CountDownProgressBar.a(this.a)) {
        break;
      }
      CountDownProgressBar.a(this.a, (int)(CountDownProgressBar.a(this.a) / (float)CountDownProgressBar.a(this.a) * 360.0F));
      this.a.invalidate();
    } while (CountDownProgressBar.a(this.a) == null);
    CountDownProgressBar.a(this.a).a();
    return;
    CountDownProgressBar.a(this.a, (int)(CountDownProgressBar.a(this.a) / (float)CountDownProgressBar.a(this.a) * 360.0F));
    if (CountDownProgressBar.b(this.a) >= (float)CountDownProgressBar.b(this.a))
    {
      CountDownProgressBar.b(this.a, 0.0F);
      CountDownProgressBar.b(this.a, CountDownProgressBar.b(this.a) - 1);
    }
    for (;;)
    {
      this.a.invalidate();
      CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
      return;
      CountDownProgressBar.b(this.a, CountDownProgressBar.b(this.a) + CountDownProgressBar.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfpz
 * JD-Core Version:    0.7.0.1
 */