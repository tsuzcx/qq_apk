package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

public abstract interface RecyclerView$OnItemTouchListener
{
  public abstract boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
  
  public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
 * JD-Core Version:    0.7.0.1
 */