package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class GivingHeartItemBuilder$PokeClickListener$2
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  GivingHeartItemBuilder$PokeClickListener$2(GivingHeartItemBuilder.PokeClickListener paramPokeClickListener, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void a()
  {
    this.a.c.clearAnimation();
    this.a.c.setVisibility(8);
    this.a.c.setImageDrawable(null);
    this.a.b.setVisibility(0);
    if ((this.a.l == GivingHeartItemBuilder.h()) && (!this.b.isSend()) && (!(this.c.a.e instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.b))) {
      this.a.g.setVisibility(0);
    } else {
      this.a.g.setVisibility(8);
    }
    this.a.d.clearAnimation();
    this.a.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.PokeClickListener.2
 * JD-Core Version:    0.7.0.1
 */