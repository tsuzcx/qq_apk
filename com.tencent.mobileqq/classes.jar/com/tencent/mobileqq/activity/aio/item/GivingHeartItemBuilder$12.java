package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$12
  implements UnlimitedBladeWorks.UnlimitedEndListener
{
  GivingHeartItemBuilder$12(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "HIDE_PLACEHOLDER Unlimited 1");
    }
    PokeItemAnimationManager.c().a(20);
    this.a.c.clearAnimation();
    this.a.c.setVisibility(8);
    this.a.c.setImageMatrix(null);
    this.a.b.setVisibility(0);
    if ((this.a.l == GivingHeartItemBuilder.h()) && (!this.b.isSend()) && (!(this.c.e instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.b))) {
      this.a.g.setVisibility(0);
    } else {
      this.a.g.setVisibility(8);
    }
    this.a.d.clearAnimation();
    this.a.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */