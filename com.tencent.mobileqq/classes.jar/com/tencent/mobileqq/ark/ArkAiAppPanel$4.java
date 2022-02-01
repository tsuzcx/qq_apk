package com.tencent.mobileqq.ark;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ArkAiAppPanel$4
  implements View.OnClickListener
{
  ArkAiAppPanel$4(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void onClick(View paramView)
  {
    if ((ArkAiAppPanel.d(this.a) != null) && (ArkAiAppPanel.d(this.a).size() > 0) && (ArkAiAppPanel.c(this.a) < ArkAiAppPanel.d(this.a).size()) && (ArkAiAppPanel.d(this.a).get(ArkAiAppPanel.c(this.a)) != null))
    {
      String str = ((ArkAioContainerWrapper)ArkAiAppPanel.d(this.a).get(ArkAiAppPanel.c(this.a))).getAppName();
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new ArkAiAppPanel.4.1(this, str));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.4
 * JD-Core Version:    0.7.0.1
 */