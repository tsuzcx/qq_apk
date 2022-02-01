import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class bape
  implements View.OnTouchListener
{
  public bape(QCallDetailActivity paramQCallDetailActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bape
 * JD-Core Version:    0.7.0.1
 */