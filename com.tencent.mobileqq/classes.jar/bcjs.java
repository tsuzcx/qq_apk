import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

class bcjs
  extends Handler
{
  bcjs(bcjr parambcjr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - bcjr.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjs
 * JD-Core Version:    0.7.0.1
 */