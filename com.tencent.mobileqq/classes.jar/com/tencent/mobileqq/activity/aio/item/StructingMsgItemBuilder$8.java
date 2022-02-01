package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class StructingMsgItemBuilder$8
  implements View.OnClickListener
{
  StructingMsgItemBuilder$8(StructingMsgItemBuilder paramStructingMsgItemBuilder, TextView paramTextView, ChatMessage paramChatMessage, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!StructingMsgItemBuilder.b(this.d))
    {
      StructingMsgItemBuilder.b(this.d, true);
      Object localObject = this.d;
      StructingMsgItemBuilder.b((StructingMsgItemBuilder)localObject, (Activity)((StructingMsgItemBuilder)localObject).e, this.a, this.b);
      localObject = this.d.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.c);
      ReportController.b((AppRuntime)localObject, "dc00899", "Pb_account_lifeservice", "", "0X8006512", "0X8006512", 0, 0, "", localStringBuilder.toString(), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */