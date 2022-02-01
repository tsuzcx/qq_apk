package androidx.recyclerview.widget;

import android.view.View;

abstract interface ViewBoundsCheck$Callback
{
  public abstract View getChildAt(int paramInt);
  
  public abstract int getChildEnd(View paramView);
  
  public abstract int getChildStart(View paramView);
  
  public abstract int getParentEnd();
  
  public abstract int getParentStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ViewBoundsCheck.Callback
 * JD-Core Version:    0.7.0.1
 */