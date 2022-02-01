package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

abstract interface GhostView
{
  public abstract void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView);
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.GhostView
 * JD-Core Version:    0.7.0.1
 */