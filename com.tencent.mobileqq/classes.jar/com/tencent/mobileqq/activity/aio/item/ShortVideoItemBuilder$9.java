package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoItemBuilder$9
  implements View.OnClickListener
{
  ShortVideoItemBuilder$9(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      ShortVideoMsgTailHelper.a(paramView.getContext(), this.a.a.a, ((MessageForShortVideo)localObject).msgTailType);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */