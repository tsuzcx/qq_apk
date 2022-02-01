package com.tencent.mobileqq.ark;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ArkAiAppPanel$4
  implements View.OnClickListener
{
  ArkAiAppPanel$4(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void onClick(View paramView)
  {
    if ((ArkAiAppPanel.a(this.a) == null) || (ArkAiAppPanel.a(this.a).size() <= 0) || (ArkAiAppPanel.a(this.a) >= ArkAiAppPanel.a(this.a).size()) || (ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((ArkAioContainerWrapper)ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.4
 * JD-Core Version:    0.7.0.1
 */