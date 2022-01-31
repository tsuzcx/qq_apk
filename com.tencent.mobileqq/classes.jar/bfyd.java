import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class bfyd
  extends GestureDetector.SimpleOnGestureListener
{
  bfyd(bfxw parambfxw) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a.findChildView(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this.a.mRecyclerView.getChildViewHolder((View)localObject);
      if ((localObject != null) && (this.a.mCallback.hasDragFlag(this.a.mRecyclerView, (RecyclerView.ViewHolder)localObject))) {
        break label57;
      }
    }
    label57:
    do
    {
      do
      {
        return;
      } while (paramMotionEvent.getPointerId(0) != this.a.mActivePointerId);
      int i = paramMotionEvent.findPointerIndex(this.a.mActivePointerId);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.a.mInitialTouchX = f1;
      this.a.mInitialTouchY = f2;
      paramMotionEvent = this.a;
      this.a.mDy = 0.0F;
      paramMotionEvent.mDx = 0.0F;
    } while (!this.a.mCallback.isLongPressDragEnabled());
    this.a.select((RecyclerView.ViewHolder)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfyd
 * JD-Core Version:    0.7.0.1
 */