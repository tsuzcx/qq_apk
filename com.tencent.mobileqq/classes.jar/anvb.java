import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class anvb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public anvb(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.c.getVisibility() == 0) && ((this.a.c() instanceof ReadinjoyTabFrame))) {
      this.a.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvb
 * JD-Core Version:    0.7.0.1
 */