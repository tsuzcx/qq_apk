package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import oyq;

public class AIOGiftPanelContainer
{
  public Handler a;
  protected ViewGroup a;
  public TroopGiftAioPanelData a;
  public TroopGiftPanel a;
  public BaseChatPie a;
  protected PlusPanel a;
  
  public AIOGiftPanelContainer(BaseChatPie paramBaseChatPie, PlusPanel paramPlusPanel)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = paramPlusPanel;
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
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Boolean) && (l1 >= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a())) {}
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (paramInt != 0) {}
      for (String str1 = "1";; str1 = "0")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str2, str1, "0", "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new oyq(this, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())) {
      return;
    }
    SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
    label103:
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BaseTroopChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        }
      }
      else
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(8);
        localLayoutParams.addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, localLayoutParams);
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          break label471;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label172:
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, i);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData, true);
      }
      a(paramInt, i);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) || (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
          break label576;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setBackgroundColor(Color.parseColor("#333333"));
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a().a(0).setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a().a(1).setTextColor(-1);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label103;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label103;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 12, 7);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        break label103;
        label471:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie))
        {
          i = 6;
          break label172;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie))
        {
          i = 5;
          break label172;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie)) {
          break label624;
        }
        i = 7;
        break label172;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(8);
          localLayoutParams.addRule(12);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, localLayoutParams);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        }
      }
      label576:
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a().a(0).setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a().a(1).setTextColor(-16777216);
      return;
      label624:
      i = 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer
 * JD-Core Version:    0.7.0.1
 */