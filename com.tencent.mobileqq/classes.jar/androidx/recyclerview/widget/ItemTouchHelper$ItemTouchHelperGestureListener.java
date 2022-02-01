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
    if (!this.mShouldReactToLongPress) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.this$0.findChildView(paramMotionEvent);
        } while (localObject == null);
        localObject = this.this$0.mRecyclerView.getChildViewHolder((View)localObject);
      } while ((localObject == null) || (!this.this$0.mCallback.hasDragFlag(this.this$0.mRecyclerView, (RecyclerView.ViewHolder)localObject)) || (paramMotionEvent.getPointerId(0) != this.this$0.mActivePointerId));
      int i = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.this$0.mInitialTouchX = f1;
      this.this$0.mInitialTouchY = f2;
      paramMotionEvent = this.this$0;
      this.this$0.mDy = 0.0F;
      paramMotionEvent.mDx = 0.0F;
    } while (!this.this$0.mCallback.isLongPressDragEnabled());
    this.this$0.select((RecyclerView.ViewHolder)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */