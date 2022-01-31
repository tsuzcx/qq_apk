import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class axzy
  extends Handler
{
  private WeakReference<axzq> a;
  
  public axzy(axzq paramaxzq)
  {
    this.a = new WeakReference(paramaxzq);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((axzq)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130844581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzy
 * JD-Core Version:    0.7.0.1
 */