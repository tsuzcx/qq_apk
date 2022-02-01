import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpic.HotPicTab;

public class auhl
  extends Handler
{
  public auhl(HotPicTab paramHotPicTab) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      HotPicTab.a(this.a, 0.0F);
      HotPicTab.a(this.a, (float)(HotPicTab.a(this.a) + 0.1D));
      this.a.invalidate();
      sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      HotPicTab.a(this.a, (float)(HotPicTab.a(this.a) + 0.1D));
      if (HotPicTab.a(this.a) < 1.0F)
      {
        this.a.invalidate();
        sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(2), 10L);
      return;
    }
    HotPicTab.a(this.a, 1.0F);
    HotPicTab.a(this.a, HotPicTab.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhl
 * JD-Core Version:    0.7.0.1
 */