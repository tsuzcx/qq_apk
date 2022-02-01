package androidx.core.widget;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(@NonNull ListView paramListView)
  {
    super(paramListView);
    this.mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    ListView localListView = this.mTarget;
    int i = localListView.getCount();
    if (i == 0) {}
    int j;
    int k;
    do
    {
      return false;
      j = localListView.getChildCount();
      k = localListView.getFirstVisiblePosition();
      if (paramInt <= 0) {
        break;
      }
    } while ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()));
    do
    {
      return true;
      if (paramInt >= 0) {
        break;
      }
    } while ((k > 0) || (localListView.getChildAt(0).getTop() < 0));
    return false;
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListViewCompat.scrollListBy(this.mTarget, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.ListViewAutoScrollHelper
 * JD-Core Version:    0.7.0.1
 */