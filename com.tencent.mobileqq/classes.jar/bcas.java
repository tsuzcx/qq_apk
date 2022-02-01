import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;

public class bcas
  implements View.OnTouchListener
{
  public bcas(ContactSearchComponentActivity paramContactSearchComponentActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (TextUtils.isEmpty(this.a.a)))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcas
 * JD-Core Version:    0.7.0.1
 */