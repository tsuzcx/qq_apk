import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;

public class bcco
  implements View.OnTouchListener
{
  public bcco(SearchEntryFragment paramSearchEntryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SearchEntryFragment.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcco
 * JD-Core Version:    0.7.0.1
 */