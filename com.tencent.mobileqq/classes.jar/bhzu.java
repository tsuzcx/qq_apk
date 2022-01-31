import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;

public class bhzu
  implements View.OnTouchListener
{
  public bhzu(PinnedHeaderExpandableListView paramPinnedHeaderExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.a.a(this.a.getFirstVisiblePosition());
      if ((ExpandableListView.b(l) == 0) || (ExpandableListView.b(l) == 1))
      {
        int i = ExpandableListView.c(l);
        if ((PinnedHeaderExpandableListView.a(this.a) == null) || (!PinnedHeaderExpandableListView.a(this.a).a(this.a, paramView, i, PinnedHeaderExpandableListView.a(this.a).getGroupId(i)))) {
          this.a.b(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzu
 * JD-Core Version:    0.7.0.1
 */