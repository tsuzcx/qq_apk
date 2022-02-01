package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MixedMsgItemBuilder$1
  implements View.OnClickListener
{
  MixedMsgItemBuilder$1(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    if (this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MixedMsgItemBuilder.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */