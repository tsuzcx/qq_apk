package android.support.v7.widget;

import android.view.MotionEvent;

public abstract interface RecyclerView$OnItemTouchListener
{
  public abstract boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  
  public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.OnItemTouchListener
 * JD-Core Version:    0.7.0.1
 */