package com.tencent.aelight.camera.ae.flashshow.view;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class FlashShowSwitchLayout$TabItemHolder$1
  implements View.OnClickListener
{
  FlashShowSwitchLayout$TabItemHolder$1(FlashShowSwitchLayout.TabItemHolder paramTabItemHolder) {}
  
  public final void onClick(View paramView)
  {
    paramView = FlashShowSwitchLayout.TabItemHolder.a.a();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(Integer.valueOf(this.a.getAdapterPosition()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.TabItemHolder.1
 * JD-Core Version:    0.7.0.1
 */