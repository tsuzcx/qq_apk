import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class bcmm
  extends Handler
{
  private WeakReference<bcme> a;
  
  public bcmm(bcme parambcme)
  {
    this.a = new WeakReference(parambcme);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((bcme)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmm
 * JD-Core Version:    0.7.0.1
 */