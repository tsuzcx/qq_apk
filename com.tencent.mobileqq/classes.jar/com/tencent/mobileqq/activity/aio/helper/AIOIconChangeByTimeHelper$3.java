package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;

class AIOIconChangeByTimeHelper$3
  extends RedpointObserver
{
  AIOIconChangeByTimeHelper$3(AIOIconChangeByTimeHelper paramAIOIconChangeByTimeHelper) {}
  
  public void a(boolean paramBoolean)
  {
    AIOIconChangeByTimeHelper.b(this.a).W.getPlusRedTouchAndUpdate();
    SimpleUIAIOHelper localSimpleUIAIOHelper = (SimpleUIAIOHelper)AIOIconChangeByTimeHelper.b(this.a).q(29);
    if (localSimpleUIAIOHelper != null) {
      localSimpleUIAIOHelper.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.3
 * JD-Core Version:    0.7.0.1
 */