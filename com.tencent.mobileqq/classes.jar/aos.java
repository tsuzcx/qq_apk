import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.im.poi.LbsStrangerPoiDialog;

public class aos
  extends Handler
{
  public aos(LbsStrangerPoiDialog paramLbsStrangerPoiDialog, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      this.a.a(this.a.a, this.a.d);
      return;
    }
    this.a.a(this.a.a, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aos
 * JD-Core Version:    0.7.0.1
 */