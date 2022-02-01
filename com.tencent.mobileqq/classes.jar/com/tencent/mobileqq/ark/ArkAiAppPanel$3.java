package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import java.util.ArrayList;

class ArkAiAppPanel$3
  implements ArkAppView.Callback
{
  ArkAiAppPanel$3(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void a()
  {
    boolean bool = ((ArkAioContainerWrapper)ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a))).checkShare();
    if (bool != ArkAiAppPanel.a(this.a))
    {
      ArkAiAppPanel.a(this.a, bool);
      ArkAiAppPanel.a(this.a, ArkAiAppPanel.a(this.a));
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.3
 * JD-Core Version:    0.7.0.1
 */