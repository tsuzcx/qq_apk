package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "event", "Landroid/view/MotionEvent;", "onFloatWindowTouch"}, k=3, mv={1, 1, 15})
final class FWAppOperator$addView$1
  implements OnFloatWindowTouchListener
{
  FWAppOperator$addView$1(FWAppOperator paramFWAppOperator) {}
  
  public final void onFloatWindowTouch(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    FWTouchUtils localFWTouchUtils = FWAppOperator.access$getTouchUtils$p(this.this$0);
    ParentFrameLayout localParentFrameLayout = this.this$0.getFrameLayout();
    if (localParentFrameLayout == null) {
      Intrinsics.throwNpe();
    }
    localFWTouchUtils.updateFloat((View)localParentFrameLayout, paramMotionEvent, this.this$0.getWindowManager(), this.this$0.getParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator.addView.1
 * JD-Core Version:    0.7.0.1
 */