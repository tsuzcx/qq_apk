import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bbdb
  implements View.OnTouchListener
{
  public bbdb(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, FrameLayout paramFrameLayout, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdb
 * JD-Core Version:    0.7.0.1
 */