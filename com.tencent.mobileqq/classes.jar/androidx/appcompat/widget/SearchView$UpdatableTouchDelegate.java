package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

class SearchView$UpdatableTouchDelegate
  extends TouchDelegate
{
  private final Rect mActualBounds;
  private boolean mDelegateTargeted;
  private final View mDelegateView;
  private final int mSlop;
  private final Rect mSlopBounds;
  private final Rect mTargetBounds;
  
  public SearchView$UpdatableTouchDelegate(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.mSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTargetBounds = new Rect();
    this.mSlopBounds = new Rect();
    this.mActualBounds = new Rect();
    setBounds(paramRect1, paramRect2);
    this.mDelegateView = paramView;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    int j = 1;
    boolean bool2 = false;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if (i == 3)
        {
          bool1 = this.mDelegateTargeted;
          this.mDelegateTargeted = false;
          i = j;
          break label140;
        }
      }
      else
      {
        boolean bool3 = this.mDelegateTargeted;
        bool1 = bool3;
        i = j;
        if (!bool3) {
          break label140;
        }
        bool1 = bool3;
        i = j;
        if (this.mSlopBounds.contains(k, m)) {
          break label140;
        }
        i = 0;
        bool1 = bool3;
        break label140;
      }
    }
    else if (this.mTargetBounds.contains(k, m))
    {
      this.mDelegateTargeted = true;
      bool1 = true;
      i = j;
      break label140;
    }
    boolean bool1 = false;
    i = j;
    label140:
    if (bool1)
    {
      if ((i != 0) && (!this.mActualBounds.contains(k, m))) {
        paramMotionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
      } else {
        paramMotionEvent.setLocation(k - this.mActualBounds.left, m - this.mActualBounds.top);
      }
      bool2 = this.mDelegateView.dispatchTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public void setBounds(Rect paramRect1, Rect paramRect2)
  {
    this.mTargetBounds.set(paramRect1);
    this.mSlopBounds.set(paramRect1);
    paramRect1 = this.mSlopBounds;
    int i = this.mSlop;
    paramRect1.inset(-i, -i);
    this.mActualBounds.set(paramRect2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.UpdatableTouchDelegate
 * JD-Core Version:    0.7.0.1
 */