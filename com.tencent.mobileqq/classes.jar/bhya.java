import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.widget.WaveView;

public class bhya
  implements Handler.Callback
{
  public bhya(WaveView paramWaveView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.invalidate();
      WaveView.a(this.a, (WaveView.a(this.a) - WaveView.b(this.a)) % WaveView.c(this.a));
      WaveView.b(this.a, WaveView.d(this.a) + WaveView.b(this.a));
      if (WaveView.d(this.a) > 0) {
        WaveView.b(this.a, WaveView.d(this.a) - WaveView.c(this.a));
      }
      WaveView.a(this.a).sendEmptyMessageDelayed(1002, 40L);
      continue;
      this.a.invalidate();
      WaveView.a(this.a, (WaveView.a(this.a) - WaveView.b(this.a)) % WaveView.c(this.a));
      WaveView.b(this.a, WaveView.d(this.a) + WaveView.b(this.a));
      if (WaveView.d(this.a) > 0) {
        WaveView.b(this.a, WaveView.d(this.a) - WaveView.c(this.a));
      }
      WaveView.a(this.a).removeMessages(1002);
      WaveView.a(this.a).sendEmptyMessageDelayed(1002, 40L);
      continue;
      WaveView.a(this.a).removeMessages(1001);
      WaveView.a(this.a).removeMessages(1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhya
 * JD-Core Version:    0.7.0.1
 */