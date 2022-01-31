import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class azvu
  extends Handler
{
  private WeakReference<azvm> a;
  
  public azvu(azvm paramazvm)
  {
    this.a = new WeakReference(paramazvm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((azvm)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130844946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvu
 * JD-Core Version:    0.7.0.1
 */