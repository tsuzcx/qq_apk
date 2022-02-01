package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewOverlayApi18
  implements ViewOverlayImpl
{
  private final ViewOverlay mViewOverlay;
  
  ViewOverlayApi18(@NonNull View paramView)
  {
    this.mViewOverlay = paramView.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.mViewOverlay.add(paramDrawable);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.mViewOverlay.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewOverlayApi18
 * JD-Core Version:    0.7.0.1
 */