import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.DisplayUtils;
import cooperation.qzone.QzoneGiftFullScreenViewController;

public class amsq
  implements Runnable
{
  public amsq(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(QzoneGiftFullScreenViewController.a(this.a), 10.0F));
    this.a.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsq
 * JD-Core Version:    0.7.0.1
 */