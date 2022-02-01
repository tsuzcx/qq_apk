package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TribeShortVideoItemBuilder$1
  implements View.OnClickListener
{
  TribeShortVideoItemBuilder$1(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TribeShortVideoItemBuilder.TribeShortVideoMsgHolder localTribeShortVideoMsgHolder = (TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)AIOUtils.a(paramView);
    if (paramView == localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localTribeShortVideoMsgHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localTribeShortVideoMsgHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */