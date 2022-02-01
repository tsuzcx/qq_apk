package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$8
  extends AnimatorListenerAdapter
{
  GivingHeartItemBuilder$8(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    GivingHeartItemBuilder.y = false;
    this.a.c.setVisibility(8);
    this.a.b.setVisibility(0);
    this.a.d.clearAnimation();
    this.a.d.setVisibility(8);
    if ((!this.b.isSend()) && (this.a.l == GivingHeartItemBuilder.h()) && (!(this.c.e instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.b))) {
      this.a.g.setVisibility(0);
    }
    if (!this.b.isPlayed) {
      this.b.setPlayed(this.c.w);
    }
    if ((!PokeItemHelper.a("fullscreen", this.b.subId)) && ((((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.c.w).a() ^ true)))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.c.w, "vas_poke", false);
      if (QLog.isColorLevel()) {
        QLog.i("GivingHeart.sprite", 2, "show sprite (normal) in bubble.");
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    GivingHeartItemBuilder.y = true;
    if (PokeItemHelper.a()) {
      HapticManager.b().a(String.valueOf(this.b.subId), 2);
    }
    PokeItemAnimationManager.c().a(7, this.b.subId, this.b.isSend());
    if (this.c.z.isAnimating()) {
      this.c.z.endAnimation();
    }
    if (this.b.isSend()) {
      this.c.A.setEnableXCoordinateMirrored(false);
    } else {
      this.c.A.setEnableXCoordinateMirrored(true);
    }
    PokeItemHelper.a(this.c.w, this.c.e, this.c.z, null, this.b.subId, "view_aio");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */