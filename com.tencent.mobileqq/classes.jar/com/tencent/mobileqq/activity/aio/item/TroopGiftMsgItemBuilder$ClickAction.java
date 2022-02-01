package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
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
      ((GameRoomChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).j(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin));
      return;
    }
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
    String str = SharedPreUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, "url");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      str = str.replace("{troopUin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin).replace("{uin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin).replace("{from}", "28");
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
    }
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
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
    String str1 = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + HardCodeUtil.a(2131715273);
    String str2 = SharedPreUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, "wantWord");
    if (!TextUtils.isEmpty(str2)) {
      str1 = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + str2;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374332, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.length());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameRoomChatPie)) {
      ((GameRoomChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).bt();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new TroopGiftMsgItemBuilder.ClickAction.1(this));
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
      return;
      localObject = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isToAll())) {}
        for (int i = TroopGiftPanel.f;; i = TroopGiftPanel.e)
        {
          ((BaseChatPie)localObject).a(true, i);
          break;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      NearbyFlowerManager.a("gift_aio", "clk_tail", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramInt + "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin)))
      {
        paramInt = 1;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      }
      else
      {
        paramInt = 2;
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))
    {
      localObject1 = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if ((localObject1 != null) && (((AIOAnimationControlManager)localObject1).b()))
      {
        localObject2 = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
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
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
        break label344;
      }
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
        return;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
        localObject2 = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "&uin=" + (String)localObject2 + "&name=" + Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2) + "&from=obj&_wv=1031&_bid=2204";
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, (Intent)localObject1, (String)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        break;
        label344:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
          break label614;
        }
        i = 1;
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
      {
        NearbyFlowerManager.a("gift_aio", "clk_obj", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "", "");
      return;
      label614:
      i = 2;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
      for (int i = 2;; i = 1)
      {
        if (paramView.getId() != 2131367928) {
          break label52;
        }
        b();
        break;
      }
      label52:
      if (paramView.getId() == 2131367933) {
        TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder);
      } else if (paramView.getId() == 2131367932) {
        a();
      } else if (paramView.getId() == 2131363590) {
        c(i);
      } else if (paramView.getId() == 2131379897) {
        b(i);
      } else if (paramView.getId() == 2131367931) {
        a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.ClickAction
 * JD-Core Version:    0.7.0.1
 */