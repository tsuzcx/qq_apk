package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class u$1
  implements View.OnClickListener
{
  u$1(u paramu) {}
  
  public final void onClick(View paramView)
  {
    Object localObject3 = this.a;
    Object localObject1 = u.a((u)localObject3);
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((MMFormVerifyCodeInputView)localObject1).getText();
    } else {
      localObject1 = null;
    }
    if (u.a((u)localObject3, String.valueOf(localObject1)))
    {
      u.b(this.a);
    }
    else
    {
      localObject3 = u.c(this.a);
      if (localObject3 != null)
      {
        MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = u.a(this.a);
        localObject1 = localObject2;
        if (localMMFormVerifyCodeInputView != null) {
          localObject1 = localMMFormVerifyCodeInputView.getText();
        }
        ((l)localObject3).a(String.valueOf(localObject1));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u.1
 * JD-Core Version:    0.7.0.1
 */