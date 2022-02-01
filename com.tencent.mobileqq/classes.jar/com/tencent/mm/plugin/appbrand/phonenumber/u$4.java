package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class u$4
  implements View.OnClickListener
{
  u$4(u paramu) {}
  
  public final void onClick(View paramView)
  {
    l locall = u.c(this.a);
    if (locall != null)
    {
      Object localObject1 = u.f(this.a);
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = Boolean.valueOf(((MMSwitchBtn)localObject1).isCheck());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = u.a(this.a);
      if (localObject1 != null) {
        localObject1 = ((MMFormVerifyCodeInputView)localObject1).getText();
      } else {
        localObject1 = null;
      }
      String str = String.valueOf(localObject1);
      MMFormInputView localMMFormInputView = u.e(this.a);
      localObject1 = localObject2;
      if (localMMFormInputView != null) {
        localObject1 = localMMFormInputView.getText();
      }
      locall.a(bool, str, String.valueOf(localObject1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u.4
 * JD-Core Version:    0.7.0.1
 */