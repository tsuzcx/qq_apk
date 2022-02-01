import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class bdua
  extends Handler
{
  private WeakReference<bdts> a;
  
  public bdua(bdts parambdts)
  {
    this.a = new WeakReference(parambdts);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((bdts)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdua
 * JD-Core Version:    0.7.0.1
 */