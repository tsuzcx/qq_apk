import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class atnw
  implements View.OnTouchListener
{
  public atnw(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
    {
      if (!LocationPickFragment.a(this.a).b())
      {
        LocationPickFragment.a(this.a).setDisplayFromType(3);
        LocationPickFragment.a(this.a).a();
      }
      azmj.b(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnw
 * JD-Core Version:    0.7.0.1
 */