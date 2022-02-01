import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.qqprotect.qsec.QSecFramework;

public class aumz
  implements View.OnTouchListener
{
  public aumz(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (QSecFramework.a().a(1001).booleanValue())) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(83), Integer.valueOf(1), Integer.valueOf(6), "clickWeb", null }, null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumz
 * JD-Core Version:    0.7.0.1
 */