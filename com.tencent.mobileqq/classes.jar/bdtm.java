import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class bdtm
  extends Handler
{
  private WeakReference<bdte> a;
  
  public bdtm(bdte parambdte)
  {
    this.a = new WeakReference(parambdte);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((bdte)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtm
 * JD-Core Version:    0.7.0.1
 */