import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.TabBarView;

public class bcrz
  extends Handler
{
  public bcrz(TabBarView paramTabBarView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a = 0.0F;
      paramMessage = this.a;
      paramMessage.a = ((float)(paramMessage.a + 0.1D));
      this.a.invalidate();
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      if (this.a.a < 1.0F)
      {
        paramMessage = this.a;
        paramMessage.a = ((float)(paramMessage.a + 0.1D));
        this.a.invalidate();
        sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(2), 10L);
      return;
    }
    TabBarView.a(this.a, this.a.o, this.a.n);
    this.a.a = 1.0F;
    TabBarView.b(this.a, this.a.o, this.a.n);
    this.a.o = this.a.n;
    this.a.invalidate();
    TabBarView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcrz
 * JD-Core Version:    0.7.0.1
 */