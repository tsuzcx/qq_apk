import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;

public class bbed
  implements View.OnTouchListener
{
  public bbed(TribeVideoPreviewFragment paramTribeVideoPreviewFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.getActivity().finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbed
 * JD-Core Version:    0.7.0.1
 */