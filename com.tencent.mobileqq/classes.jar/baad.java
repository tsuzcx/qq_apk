import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class baad
  extends Handler
{
  private WeakReference<azzv> a;
  
  public baad(azzv paramazzv)
  {
    this.a = new WeakReference(paramazzv);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((azzv)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baad
 * JD-Core Version:    0.7.0.1
 */