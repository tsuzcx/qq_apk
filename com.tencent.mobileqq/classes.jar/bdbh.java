import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class bdbh
  extends Handler
{
  private WeakReference<bdaz> a;
  
  public bdbh(bdaz parambdaz)
  {
    this.a = new WeakReference(parambdaz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((bdaz)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbh
 * JD-Core Version:    0.7.0.1
 */