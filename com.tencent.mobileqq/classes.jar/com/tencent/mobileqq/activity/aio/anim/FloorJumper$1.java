package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloorJumper$1
  implements View.OnClickListener
{
  FloorJumper$1(FloorJumper paramFloorJumper, AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    Context localContext = FloorJumper.a(this.c).getContext();
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a.l);
    localContext.startActivity(localIntent);
    FloorJumper.a(this.c, this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumper.1
 * JD-Core Version:    0.7.0.1
 */