package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.view.View;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnInvokeView;
import com.tencent.falco.base.floatwindow.lifecycle.FloatWindowLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/falco/base/floatwindow/widget/appfloat/FWAppOperator$addView$2", "Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout$OnLayoutListener;", "onLayout", "", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWAppOperator$addView$2
  implements ParentFrameLayout.OnLayoutListener
{
  FWAppOperator$addView$2(View paramView) {}
  
  public void onLayout()
  {
    FWAppOperator.access$setGravity(this.this$0, (View)this.this$0.getFrameLayout());
    Object localObject1 = this.this$0.getConfig();
    if ((((FloatWindowConfig)localObject1).filterSelf) || ((((FloatWindowConfig)localObject1).showPattern == 3) && (FloatWindowLifecycle.isForeground())) || ((((FloatWindowConfig)localObject1).showPattern == 2) && (!FloatWindowLifecycle.isForeground())) || ((((FloatWindowConfig)localObject1).showPattern == 1) && (FloatWindowLifecycle.isForeground()))) {
      FWAppOperator.setVisible$default(this.this$0, 8, false, 2, null);
    }
    for (;;)
    {
      ((FloatWindowConfig)localObject1).layoutView = this.$floatingView;
      Object localObject2 = ((FloatWindowConfig)localObject1).invokeView;
      if (localObject2 != null) {
        ((OnInvokeView)localObject2).invoke(this.$floatingView);
      }
      localObject1 = ((FloatWindowConfig)localObject1).callbacks;
      if (localObject1 != null) {
        ((OnFloatWindowCallbacks)localObject1).createdResult(true, 0, this.$floatingView);
      }
      return;
      localObject2 = this.this$0;
      View localView = this.$floatingView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "floatingView");
      FWAppOperator.access$enterAnim((FWAppOperator)localObject2, localView);
      localObject2 = ((FloatWindowConfig)localObject1).callbacks;
      if (localObject2 != null) {
        ((OnFloatWindowCallbacks)localObject2).show(this.$floatingView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator.addView.2
 * JD-Core Version:    0.7.0.1
 */