package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class TroopGiftPanelHelper
  extends GiftPanelHelper
{
  protected TroopInteractGiftAnimationController g;
  
  public TroopGiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a()
  {
    this.b.d().a(this);
    this.b.d().a(this);
    this.b.d().a(this);
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.e != null) && (this.e.c()))
    {
      this.e.a();
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.d, "troop_gift_panel", false);
    }
    return super.a(paramBaseAIOContext, paramView, paramMotionEvent);
  }
  
  public void b(boolean paramBoolean)
  {
    if (SharedPreUtils.aS(this.b.b(), this.b.a().getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.f);
      SharedPreUtils.f(this.b.b(), this.b.a().getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
    f();
  }
  
  public void f()
  {
    if (((this.c instanceof SplashActivity)) && (this.f != null)) {
      this.f.d();
    }
  }
  
  public TroopInteractGiftAnimationController g()
  {
    if (this.g == null)
    {
      this.g = new TroopInteractGiftAnimationController();
      this.g.a((TroopChatPie)this.a);
    }
    return this.g;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 11, 4, 15, 12 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 12006) && (this.e != null))
    {
      TroopGiftPanel localTroopGiftPanel = this.e.d();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 12)
      {
        if (paramInt != 15) {
          return;
        }
        TroopGiftMsgItemBuilder.a(this.d);
        if (this.e != null) {
          this.e = null;
        }
      }
      else
      {
        TroopInteractGiftAnimationController localTroopInteractGiftAnimationController = this.g;
        if (localTroopInteractGiftAnimationController != null) {
          localTroopInteractGiftAnimationController.a();
        }
      }
    }
    else if (this.c.getIntent().getBooleanExtra("sendGift", false)) {
      a(true, TroopGiftPanel.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */