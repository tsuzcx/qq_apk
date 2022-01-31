import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class awzw
  extends Handler
{
  private WeakReference<awzo> a;
  
  public awzw(awzo paramawzo)
  {
    this.a = new WeakReference(paramawzo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((awzo)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130844498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzw
 * JD-Core Version:    0.7.0.1
 */