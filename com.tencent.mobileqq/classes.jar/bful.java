import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeadAndFootExpandableListView;

public class bful
  implements View.OnTouchListener
{
  public bful(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.a.a(this.a.getFirstVisiblePosition());
      if ((ExpandableListView.b(l) == 0) || (ExpandableListView.b(l) == 1))
      {
        int i = ExpandableListView.c(l);
        if ((this.a.jdField_a_of_type_Bfru == null) || (!this.a.jdField_a_of_type_Bfru.a(this.a, paramView, i, this.a.jdField_a_of_type_Bfun.getGroupId(i)))) {
          this.a.b(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bful
 * JD-Core Version:    0.7.0.1
 */