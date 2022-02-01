package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

public class DragStartHelper
{
  private boolean mDragging;
  private int mLastTouchX;
  private int mLastTouchY;
  private final DragStartHelper.OnDragStartListener mListener;
  private final View.OnLongClickListener mLongClickListener = new DragStartHelper.1(this);
  private final View.OnTouchListener mTouchListener = new DragStartHelper.2(this);
  private final View mView;
  
  public DragStartHelper(View paramView, DragStartHelper.OnDragStartListener paramOnDragStartListener)
  {
    this.mView = paramView;
    this.mListener = paramOnDragStartListener;
  }
  
  public void attach()
  {
    this.mView.setOnLongClickListener(this.mLongClickListener);
    this.mView.setOnTouchListener(this.mTouchListener);
  }
  
  public void detach()
  {
    this.mView.setOnLongClickListener(null);
    this.mView.setOnTouchListener(null);
  }
  
  public void getTouchPosition(Point paramPoint)
  {
    paramPoint.set(this.mLastTouchX, this.mLastTouchY);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.mListener.onDragStart(paramView, this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.mLastTouchX = i;
        this.mLastTouchY = j;
        return false;
      } while ((!MotionEventCompat.isFromSource(paramMotionEvent, 8194)) || ((paramMotionEvent.getButtonState() & 0x1) == 0) || (this.mDragging) || ((this.mLastTouchX == i) && (this.mLastTouchY == j)));
      this.mLastTouchX = i;
      this.mLastTouchY = j;
      this.mDragging = this.mListener.onDragStart(paramView, this);
      return this.mDragging;
    }
    this.mDragging = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.DragStartHelper
 * JD-Core Version:    0.7.0.1
 */