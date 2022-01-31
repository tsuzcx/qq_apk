import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class avel
  implements View.OnTouchListener
{
  public avel(QCallDetailActivity paramQCallDetailActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      QCallDetailActivity.a(this.a).setPressed(true);
    }
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    QCallDetailActivity.a(this.a).setPressed(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avel
 * JD-Core Version:    0.7.0.1
 */