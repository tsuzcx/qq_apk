package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class StructingMsgItemBuilder$7
  implements View.OnClickListener
{
  StructingMsgItemBuilder$7(StructingMsgItemBuilder paramStructingMsgItemBuilder, ImageView paramImageView, ChatMessage paramChatMessage, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (!StructingMsgItemBuilder.a(this.e))
    {
      StructingMsgItemBuilder.a(this.e, true);
      Object localObject = this.e;
      StructingMsgItemBuilder.a((StructingMsgItemBuilder)localObject, (Activity)((StructingMsgItemBuilder)localObject).e, this.a, this.b);
      localObject = this.e.d;
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.d);
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Pb_account_lifeservice", str, "0X800631E", "0X800631E", 0, 0, localStringBuilder.toString(), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */