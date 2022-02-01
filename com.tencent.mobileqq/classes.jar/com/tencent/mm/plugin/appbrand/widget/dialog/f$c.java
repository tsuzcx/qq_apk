package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f$c
  extends FrameLayout
{
  f$c(Context paramContext)
  {
    super(localContext);
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      f.a(this.a, MotionEvent.obtain(paramMotionEvent));
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.c
 * JD-Core Version:    0.7.0.1
 */