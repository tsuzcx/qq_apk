package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPDonateMsgItemBuilder$1
  implements View.OnClickListener
{
  VIPDonateMsgItemBuilder$1(VIPDonateMsgItemBuilder paramVIPDonateMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c())
    {
      Object localObject1 = (MessageForVIPDonate)((VIPDonateMsgItemBuilder.VIPDonateMsgHolder)AIOUtils.b(paramView)).q;
      Object localObject2 = ((MessageForVIPDonate)localObject1).donateMsg;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((VIPDonateMsg)localObject2).jumpUrl)))
      {
        localObject1 = ((MessageForVIPDonate)localObject1).donateMsg.jumpUrl;
        localObject2 = new Intent(VIPDonateMsgItemBuilder.a(this.a), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        VIPDonateMsgItemBuilder.a(this.a).startActivity((Intent)localObject2);
      }
      else
      {
        QLog.e("VIPDonateMsgItemBuilder", 1, "donatemsg jumpurl empty");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VIPDonateMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */