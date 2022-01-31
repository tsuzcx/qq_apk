import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.AbsListView;

public final class amhd
  implements Runnable
{
  public amhd(AbsListView paramAbsListView) {}
  
  public void run()
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.a.mTouchMode == 0)
    {
      this.a.mTouchMode = 1;
      localObject = this.a.getChildAt(this.a.mMotionPosition - this.a.mFirstPosition);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        this.a.mLayoutMode = 0;
        if (this.a.mDataChanged) {
          break label249;
        }
        ((View)localObject).setPressed(true);
        this.a.setPressed(true);
        this.a.layoutChildren();
        this.a.positionSelector(this.a.mMotionPosition, (View)localObject);
        this.a.refreshDrawableState();
        i = ViewConfiguration.getLongPressTimeout();
        bool = this.a.isLongClickable();
        if (this.a.mSelector != null)
        {
          localObject = this.a.mSelector.getCurrent();
          if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label230;
            }
            ((TransitionDrawable)localObject).startTransition(i);
          }
        }
      }
    }
    while (bool)
    {
      if (AbsListView.access$700(this.a) == null) {
        AbsListView.access$702(this.a, new amhc(this.a, null));
      }
      AbsListView.access$700(this.a).a();
      this.a.postDelayed(AbsListView.access$700(this.a), i);
      return;
      label230:
      ((TransitionDrawable)localObject).resetTransition();
    }
    this.a.mTouchMode = 2;
    return;
    label249:
    this.a.mTouchMode = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhd
 * JD-Core Version:    0.7.0.1
 */