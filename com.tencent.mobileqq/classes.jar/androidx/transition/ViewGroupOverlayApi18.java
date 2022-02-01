package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewGroupOverlayApi18
  implements ViewGroupOverlayImpl
{
  private final ViewGroupOverlay mViewGroupOverlay;
  
  ViewGroupOverlayApi18(@NonNull ViewGroup paramViewGroup)
  {
    this.mViewGroupOverlay = paramViewGroup.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.mViewGroupOverlay.add(paramDrawable);
  }
  
  public void add(@NonNull View paramView)
  {
    this.mViewGroupOverlay.add(paramView);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.mViewGroupOverlay.remove(paramDrawable);
  }
  
  public void remove(@NonNull View paramView)
  {
    this.mViewGroupOverlay.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ViewGroupOverlayApi18
 * JD-Core Version:    0.7.0.1
 */