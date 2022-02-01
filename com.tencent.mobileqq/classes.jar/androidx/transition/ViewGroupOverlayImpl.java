package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

abstract interface ViewGroupOverlayImpl
  extends ViewOverlayImpl
{
  public abstract void add(@NonNull View paramView);
  
  public abstract void remove(@NonNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewGroupOverlayImpl
 * JD-Core Version:    0.7.0.1
 */