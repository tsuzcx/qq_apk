package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class ViewGroupOverlayApi14
  extends ViewOverlayApi14
  implements ViewGroupOverlayImpl
{
  ViewGroupOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    super(paramContext, paramViewGroup, paramView);
  }
  
  static ViewGroupOverlayApi14 createFrom(ViewGroup paramViewGroup)
  {
    return (ViewGroupOverlayApi14)ViewOverlayApi14.createFrom(paramViewGroup);
  }
  
  public void add(@NonNull View paramView)
  {
    this.mOverlayViewGroup.add(paramView);
  }
  
  public void remove(@NonNull View paramView)
  {
    this.mOverlayViewGroup.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ViewGroupOverlayApi14
 * JD-Core Version:    0.7.0.1
 */