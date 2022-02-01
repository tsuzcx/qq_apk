package androidx.recyclerview.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class ItemTouchHelper$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private boolean mShouldReactToLongPress = true;
  
  ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper paramItemTouchHelper) {}
  
  void doNotReactToLongPress()
  {
    this.mShouldReactToLongPress = false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (!this.mShouldReactToLongPress) {
      return;
    }
    Object localObject = this.this$0.findChildView(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this.this$0.mRecyclerView.getChildViewHolder((View)localObject);
      if (localObject != null)
      {
        if (!this.this$0.mCallback.hasDragFlag(this.this$0.mRecyclerView, (RecyclerView.ViewHolder)localObject)) {
          return;
        }
        if (paramMotionEvent.getPointerId(0) == this.this$0.mActivePointerId)
        {
          int i = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          paramMotionEvent = this.this$0;
          paramMotionEvent.mInitialTouchX = f1;
          paramMotionEvent.mInitialTouchY = f2;
          paramMotionEvent.mDy = 0.0F;
          paramMotionEvent.mDx = 0.0F;
          if (paramMotionEvent.mCallback.isLongPressDragEnabled()) {
            this.this$0.select((RecyclerView.ViewHolder)localObject, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */