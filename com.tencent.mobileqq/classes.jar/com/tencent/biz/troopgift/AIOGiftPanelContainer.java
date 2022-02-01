package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.QLog;

public class AIOGiftPanelContainer
{
  protected Handler a;
  protected ViewGroup a;
  protected TroopGiftAioPanelData a;
  protected TroopGiftPanel a;
  protected BaseChatPie a;
  protected PlusPanel a;
  private boolean a;
  
  public AIOGiftPanelContainer(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel = ((PlusPanel)paramBaseChatPie.a().b(8));
  }
  
  public TroopGiftAioPanelData a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
  }
  
  public TroopGiftPanel a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel.a()) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Boolean) && (l1 >= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a())) {}
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (paramInt != 0) {}
      for (String str1 = "1";; str1 = "0")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str2, str1, "0", "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null))
    {
      QLog.i("AIOGiftPanelContainer", 1, "downloadGiftExtraInfo() , mHasGiftExtraInfo = " + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.1(this, paramInt1));
      }
      return;
    }
    ThreadManager.post(new AIOGiftPanelContainer.2(this, l, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {
      return;
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.an();
    label113:
    Object localObject1;
    int i;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        }
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          break label516;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label182:
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      label226:
      label240:
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData, true);
        a(paramInt, i);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label629;
        }
        paramBoolean = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        if (!paramBoolean) {
          break label631;
        }
        localObject1 = "#333333";
        label279:
        ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
        if (!(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e instanceof TextView)) {
          break;
        }
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e;
        if (!paramBoolean) {
          break label639;
        }
      }
      label516:
      label629:
      label631:
      label639:
      for (localObject1 = "#878B99";; localObject1 = "#000000")
      {
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DiscussChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label113;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label113;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof StrangerChatPie)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 12, 7);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        break label113;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DiscussChatPie))
        {
          i = 6;
          break label182;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie))
        {
          i = 5;
          break label182;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof StrangerChatPie)) {
          break label647;
        }
        i = 7;
        break label182;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
        break label226;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label240;
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        break label240;
        break;
        localObject1 = "#FFFFFF";
        break label279;
      }
      label647:
      i = 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer
 * JD-Core Version:    0.7.0.1
 */