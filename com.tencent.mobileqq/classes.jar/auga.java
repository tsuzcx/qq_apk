import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;

public class auga
  implements View.OnTouchListener
{
  public auga(PromotionEntry paramPromotionEntry) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PromotionEntry.a(this.a) == null) {}
    do
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        PromotionEntry.a(this.a).setAlpha(255);
        return false;
      }
    } while (paramMotionEvent.getAction() != 0);
    PromotionEntry.a(this.a).setAlpha(100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auga
 * JD-Core Version:    0.7.0.1
 */