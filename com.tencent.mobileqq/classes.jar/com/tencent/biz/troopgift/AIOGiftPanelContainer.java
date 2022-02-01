package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
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
    TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
    if ((localTroopGiftPanel != null) && (localTroopGiftPanel.a()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
    if ((localObject != null) && (paramInt == ((PlusPanel)localObject).a()))
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) {
        return;
      }
      int i = 0;
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long;
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Boolean)
      {
        paramInt = i;
        if (l1 >= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long)
        {
          paramInt = i;
          if (l1 <= l2 + 2592000000L)
          {
            paramInt = i;
            if (!((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a()) {
              paramInt = 1;
            }
          }
        }
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (paramInt != 0) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str, (String)localObject, "0", localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadGiftExtraInfo() , mHasGiftExtraInfo = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("AIOGiftPanelContainer", 1, localStringBuilder.toString());
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.1(this, paramInt1));
      }
      return;
    }
    ThreadManager.post(new AIOGiftPanelContainer.2(this, l, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
    if ((localObject1 != null) && (((TroopGiftPanel)localObject1).a())) {
      return;
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.Q();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject1 instanceof BaseTroopChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        }
        else if ((localObject1 instanceof DiscussChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        }
        else if ((localObject1 instanceof FriendChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        }
        else if ((localObject1 instanceof StrangerChatPie))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 12, 7);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        }
        else
        {
          return;
        }
      }
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
      int i;
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
      {
        i = 4;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject1 instanceof DiscussChatPie)) {
          i = 6;
        } else if ((localObject1 instanceof FriendChatPie)) {
          i = 5;
        } else if ((localObject1 instanceof StrangerChatPie)) {
          i = 7;
        } else {
          i = 1;
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData((TroopGiftAioPanelData)localObject1, true);
      } else {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
      }
      a(paramInt, i);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
    }
    else if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
    {
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
    {
      paramBoolean = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      Object localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
      if (paramBoolean) {
        localObject1 = "#333333";
      } else {
        localObject1 = "#FFFFFF";
      }
      ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e;
        if (paramBoolean) {
          localObject1 = "#878B99";
        } else {
          localObject1 = "#000000";
        }
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
    }
  }
  
  public boolean a()
  {
    TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
    if (localTroopGiftPanel != null) {
      return localTroopGiftPanel.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer
 * JD-Core Version:    0.7.0.1
 */