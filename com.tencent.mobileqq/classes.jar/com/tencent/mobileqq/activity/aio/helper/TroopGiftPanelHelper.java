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
  protected TroopInteractGiftAnimationController a;
  
  public TroopGiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public TroopInteractGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = new TroopInteractGiftAnimationController();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (SharedPreUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.f);
      SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    return super.a(paramBaseAIOContext, paramView, paramMotionEvent);
  }
  
  public void c()
  {
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    c();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 11, 4, 15, 12 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 12006) && (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null))
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
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
        TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = null;
        }
      }
      else
      {
        TroopInteractGiftAnimationController localTroopInteractGiftAnimationController = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
        if (localTroopInteractGiftAnimationController != null) {
          localTroopInteractGiftAnimationController.a();
        }
      }
    }
    else if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("sendGift", false)) {
      a(true, TroopGiftPanel.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */