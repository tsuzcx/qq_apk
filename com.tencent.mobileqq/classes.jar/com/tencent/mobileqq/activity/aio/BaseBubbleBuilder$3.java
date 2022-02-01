package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseBubbleBuilder$3
  implements View.OnClickListener
{
  BaseBubbleBuilder$3(BaseBubbleBuilder paramBaseBubbleBuilder, long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (this.c.f != null) && (this.c.f.b != null)) {
      TroopEssenceUtil.a(this.c.d, this.c.f.b, this.a, this.b, this.c.e, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.3
 * JD-Core Version:    0.7.0.1
 */