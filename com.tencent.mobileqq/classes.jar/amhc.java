import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public class amhc
  extends amhm
  implements Runnable
{
  private amhc(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    int i = this.a.mMotionPosition;
    View localView = this.a.getChildAt(i - this.a.mFirstPosition);
    long l;
    if (localView != null)
    {
      i = this.a.mMotionPosition;
      l = this.a.mAdapter.getItemId(this.a.mMotionPosition);
      if ((!a()) || (this.a.mDataChanged)) {
        break label126;
      }
    }
    label126:
    for (boolean bool = this.a.performLongPress(localView, i, l);; bool = false)
    {
      if (bool)
      {
        this.a.mTouchMode = -1;
        this.a.setPressed(false);
        localView.setPressed(false);
        return;
      }
      this.a.mTouchMode = 2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */