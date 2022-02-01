package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.AIOOnTouchListener;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;

public class GiftPanelHelper
  implements AIOOnTouchListener, OnFinishListener, ILifeCycleHelper, OnActivityResultCallback
{
  protected Activity a;
  public AIOGiftPanelContainer a;
  protected AIOContext a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  protected TroopGiftAnimationController a;
  
  public GiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    a();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1))
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          localTroopGiftPanel.a(paramIntent.getLong("duration_time"), paramIntent.getLong("elapsed_time"), paramIntent.getBoolean("profitable_flag", false));
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if (localObject != null)
    {
      localObject = ((AIOGiftPanelContainer)localObject).a();
      if (localObject != null) {
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if (localObject != null)
    {
      localObject = ((AIOGiftPanelContainer)localObject).a();
      if (localObject != null) {
        ((TroopGiftPanel)localObject).a(null);
      }
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (((localObject instanceof LimitChatPie)) || ((localObject instanceof QCircleChatPie)) || ((localObject instanceof RobotChatPie)))
    {
      localObject = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
      if ((localObject != null) && (((AIOGiftPanelContainer)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        return 1;
      }
    }
    return 0;
  }
  
  public TroopGiftAioPanelData a()
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if (localAIOGiftPanelContainer != null) {
      return localAIOGiftPanelContainer.a();
    }
    return null;
  }
  
  public TroopGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = new TroopGiftAnimationController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  }
  
  protected void a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((!(localBaseChatPie instanceof HotChatPie)) && (!(localBaseChatPie instanceof TroopChatPie)) && (!(localBaseChatPie instanceof NearbyChatPie)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
    }
  }
  
  public void a(int paramInt)
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if (localAIOGiftPanelContainer != null) {
      localAIOGiftPanelContainer.a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QVipGiftProcessor.a().isEnable())
    {
      GiftJsPlugin.openGiftBrowser(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = new AIOGiftPanelContainer(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if ((localAIOGiftPanelContainer != null) && (localAIOGiftPanelContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      if (paramInt == 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    b();
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    if (localAIOGiftPanelContainer != null) {
      localAIOGiftPanelContainer.a();
    }
  }
  
  public void d(int paramInt) {}
  
  @NonNull
  public String getTag()
  {
    return "GiftPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 11 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 12008) {
      a(paramInt2, paramIntent);
    } else if (paramInt1 == 12007) {
      c();
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DiscussChatPie)) && (paramInt2 == -1) && (paramInt1 == 12006)) {
      a(paramIntent);
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      Object localObject;
      if (paramInt != 10)
      {
        if (paramInt != 11) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
        if (localObject != null) {
          ((TroopGiftAnimationController)localObject).c();
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (!(localObject instanceof TroopChatPie)) {
          AIOAnimationControlManager.a((BaseChatPie)localObject, true);
        }
      }
    }
    else
    {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */