import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class atse
  implements View.OnHoverListener
{
  public atse(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (AccessibilityManager)this.a.getActivity().getSystemService("accessibility");
    if ((paramMotionEvent != null) && (paramMotionEvent.isTouchExplorationEnabled()))
    {
      if (paramView.requestFocus()) {
        ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).showSoftInput(paramView, 1);
      }
      if (!LocationPickFragment.a(this.a).b())
      {
        LocationPickFragment.a(this.a).setDisplayFromType(3);
        LocationPickFragment.a(this.a).a();
      }
      azqs.b(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atse
 * JD-Core Version:    0.7.0.1
 */