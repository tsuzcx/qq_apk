import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class azat
  implements View.OnTouchListener
{
  public azat(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, FrameLayout paramFrameLayout, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azat
 * JD-Core Version:    0.7.0.1
 */