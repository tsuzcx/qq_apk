package com.tencent.mobileqq.activity.aio.core;

import aewo;
import afqw;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$9
  implements View.OnClickListener
{
  BaseChatPie$9(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    while (aewo.b())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = this.this$0.sessionInfo.curFriendUin;
    if (this.this$0.sessionInfo.curType == 1006) {
      str = this.this$0.sessionInfo.contactUin;
    }
    int i = ((Integer)localObject).intValue();
    switch (i)
    {
    }
    for (;;)
    {
      this.this$0.helperProvider.b(i);
      break;
      BaseChatPie.access$700(this.this$0, str);
      continue;
      BaseChatPie.access$800(this.this$0, str);
      continue;
      BaseChatPie.access$900(this.this$0);
      continue;
      BaseChatPie.access$1000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.9
 * JD-Core Version:    0.7.0.1
 */