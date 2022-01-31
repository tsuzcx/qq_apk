import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class ayaa
  extends Handler
{
  private WeakReference<axzs> a;
  
  public ayaa(axzs paramaxzs)
  {
    this.a = new WeakReference(paramaxzs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((axzs)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130844582);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayaa
 * JD-Core Version:    0.7.0.1
 */