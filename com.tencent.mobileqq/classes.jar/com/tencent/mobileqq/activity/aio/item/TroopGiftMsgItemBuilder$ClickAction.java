package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

class TroopGiftMsgItemBuilder$ClickAction
  implements View.OnClickListener
{
  private TroopGiftMsgItemBuilder.TroopGiftMsgHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgHolder;
  private MessageForTroopGift jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift;
  
  public TroopGiftMsgItemBuilder$ClickAction(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, MessageForTroopGift paramMessageForTroopGift, TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = paramMessageForTroopGift;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgHolder = paramTroopGiftMsgHolder;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameRoomChatPie))
    {
      ((GameRoomChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin));
      return;
    }
    Object localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin);
    ((StringBuilder)localObject2).append("");
    ((ReportTask)localObject1).a(new String[] { ((StringBuilder)localObject2).toString(), "28" }).a();
    localObject1 = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, "url");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin);
    localObject1 = ((String)localObject1).replace("{troopUin}", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin);
    localObject1 = ((String)localObject1).replace("{uin}", ((StringBuilder)localObject2).toString()).replace("{from}", "28");
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.activity_url;
    localIntent.putExtra("url", str);
    localIntent.putExtra("key_isReadModeEnabled", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, localIntent, str);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "popup_click", paramInt, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftId), "", "", "");
  }
  
  private void b()
  {
    Object localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin);
    ((StringBuilder)localObject2).append("");
    ((ReportTask)localObject1).a(new String[] { ((StringBuilder)localObject2).toString(), "28" }).a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715196));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, "wantWord");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("@");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373888, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.length());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameRoomChatPie)) {
      ((GameRoomChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).az();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new TroopGiftMsgItemBuilder.ClickAction.1(this));
  }
  
  private void b(int paramInt)
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
    int j = 1;
    Object localObject;
    if (!bool)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    else
    {
      localObject = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = (GiftPanelHelper)((ChatFragment)localObject).a().a(136);
        int i;
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isToAll())) {
          i = TroopGiftPanel.e;
        } else {
          i = TroopGiftPanel.f;
        }
        ((GiftPanelHelper)localObject).a(true, i);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop != 1000) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop != 1004))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
          paramInt = 0;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
          paramInt = j;
        } else {
          paramInt = 2;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        NearbyFlowerManager.a("gift_aio", "clk_tail", (String)localObject, localStringBuilder.toString(), "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
  }
  
  private void c(int paramInt)
  {
    boolean bool = TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject1 = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if ((localObject1 != null) && (((AIOAnimationControlManager)localObject1).b()))
      {
        localObject2 = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localObject2 != null) && (((ChatFragment)localObject2).a() != null)) {
          ((AIOAnimationControlManager)localObject1).a(((ChatFragment)localObject2).a());
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading = false;
        ((AIOAnimationControlManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgHolder);
        ((AIOAnimationControlManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading) {
          ((AIOAnimationControlManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgHolder);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) {
          ((AIOAnimationControlManager)localObject1).f();
        }
      }
    }
    else
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
      localObject3 = new StringBuilder("https://qun.qq.com/qunpay/gifts/index.html?troopUin=");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((StringBuilder)localObject3).append("&uin=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&name=");
      ((StringBuilder)localObject3).append(Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2));
      ((StringBuilder)localObject3).append("&from=obj&_wv=1031&_bid=2204");
      localObject2 = ((StringBuilder)localObject3).toString();
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, (Intent)localObject1, (String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
        i = 1;
      } else {
        i = 2;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop != 1000) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop != 1004))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_aio", "clk_obj", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", paramInt, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      int i;
      if (AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {
        i = 2;
      } else {
        i = 1;
      }
      if (paramView.getId() == 2131367687) {
        b();
      } else if (paramView.getId() == 2131367692) {
        TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder);
      } else if (paramView.getId() == 2131367691) {
        a();
      } else if (paramView.getId() == 2131363513) {
        c(i);
      } else if (paramView.getId() == 2131379226) {
        b(i);
      } else if (paramView.getId() == 2131367690) {
        a(i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.ClickAction
 * JD-Core Version:    0.7.0.1
 */