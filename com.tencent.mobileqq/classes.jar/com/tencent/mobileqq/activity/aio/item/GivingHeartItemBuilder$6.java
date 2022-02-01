package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class GivingHeartItemBuilder$6
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  GivingHeartItemBuilder$6(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void a()
  {
    this.a.c.clearAnimation();
    this.a.c.setVisibility(8);
    this.a.c.setImageDrawable(null);
    this.a.b.setVisibility(0);
    if ((this.a.l == GivingHeartItemBuilder.h()) && (!this.b.isSend()) && (!(this.c.e instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.b))) {
      this.a.g.setVisibility(0);
    } else {
      this.a.g.setVisibility(8);
    }
    this.a.d.clearAnimation();
    this.a.d.setVisibility(8);
    AIOUtils.o -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */