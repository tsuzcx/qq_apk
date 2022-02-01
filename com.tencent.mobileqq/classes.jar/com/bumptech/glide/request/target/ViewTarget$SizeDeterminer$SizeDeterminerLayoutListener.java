package com.bumptech.glide.request.target;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

final class ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final WeakReference<ViewTarget.SizeDeterminer> a;
  
  ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener(@NonNull ViewTarget.SizeDeterminer paramSizeDeterminer)
  {
    this.a = new WeakReference(paramSizeDeterminer);
  }
  
  public boolean onPreDraw()
  {
    if (Log.isLoggable("ViewTarget", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnGlobalLayoutListener called attachStateListener=");
      ((StringBuilder)localObject).append(this);
      Log.v("ViewTarget", ((StringBuilder)localObject).toString());
    }
    Object localObject = (ViewTarget.SizeDeterminer)this.a.get();
    if (localObject != null) {
      ((ViewTarget.SizeDeterminer)localObject).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener
 * JD-Core Version:    0.7.0.1
 */