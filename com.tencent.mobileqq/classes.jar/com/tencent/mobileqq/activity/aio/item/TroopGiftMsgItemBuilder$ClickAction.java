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
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

class TroopGiftMsgItemBuilder$ClickAction
  implements View.OnClickListener
{
  private MessageForTroopGift b;
  private TroopGiftMsgItemBuilder.TroopGiftMsgHolder c;
  
  public TroopGiftMsgItemBuilder$ClickAction(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, MessageForTroopGift paramMessageForTroopGift, TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    this.b = paramMessageForTroopGift;
    this.c = paramTroopGiftMsgHolder;
  }
  
  private void a()
  {
    if ((this.a.w instanceof GameRoomChatPie))
    {
      ((GameRoomChatPie)this.a.w).f(String.valueOf(this.b.senderUin));
      return;
    }
    Object localObject1 = new ReportTask(this.a.d).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.frienduin);
    ((StringBuilder)localObject2).append("");
    ((ReportTask)localObject1).a(new String[] { ((StringBuilder)localObject2).toString(), "28" }).a();
    localObject1 = SharedPreUtils.at(this.a.e, "url");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.b.frienduin);
    localObject1 = ((String)localObject1).replace("{troopUin}", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.b.senderUin);
    localObject1 = ((String)localObject1).replace("{uin}", ((StringBuilder)localObject2).toString()).replace("{from}", "28");
    localObject2 = new Intent(this.a.e, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    this.a.e.startActivity((Intent)localObject2);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this.a.e, QQBrowserActivity.class);
    String str = this.b.activity_url;
    localIntent.putExtra("url", str);
    localIntent.putExtra("key_isReadModeEnabled", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.b, localIntent, str);
    this.a.e.startActivity(localIntent);
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "popup_click", paramInt, 0, String.valueOf(this.b.giftId), "", "", "");
  }
  
  private void b()
  {
    Object localObject1 = new ReportTask(this.a.d).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.frienduin);
    ((StringBuilder)localObject2).append("");
    ((ReportTask)localObject1).a(new String[] { ((StringBuilder)localObject2).toString(), "28" }).a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(this.b.senderName);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912680));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = SharedPreUtils.at(this.a.e, "wantWord");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("@");
      ((StringBuilder)localObject1).append(this.b.senderName);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    this.a.w.Y.setText((CharSequence)localObject1);
    this.a.w.Y.setTag(2131441562, this.b);
    this.a.w.Y.setSelection(this.a.w.Y.length());
    this.a.w.ac.getAndSet(true);
    if ((this.a.w instanceof GameRoomChatPie)) {
      ((GameRoomChatPie)this.a.w).bP();
    }
    this.a.w.Y.addTextChangedListener(new TroopGiftMsgItemBuilder.ClickAction.1(this));
  }
  
  private void b(int paramInt)
  {
    boolean bool = TextUtils.isEmpty(this.b.jumpUrl);
    int j = 1;
    Object localObject;
    if (!bool)
    {
      localObject = new Intent(this.a.e, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.b.jumpUrl);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      this.a.e.startActivity((Intent)localObject);
    }
    else
    {
      localObject = ((BaseActivity)this.a.e).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).k() != null))
      {
        localObject = (GiftPanelHelper)((ChatFragment)localObject).k().q(136);
        int i;
        if ((!this.b.isInteract()) && (!this.b.isToAll())) {
          i = TroopGiftPanel.e;
        } else {
          i = TroopGiftPanel.f;
        }
        ((GiftPanelHelper)localObject).a(true, i);
      }
    }
    if (this.b.istroop == 0)
    {
      ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if (this.b.istroop == 3000)
    {
      ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if ((this.b.istroop != 1000) && (this.b.istroop != 1004))
    {
      if (this.b.isFromNearby)
      {
        if (this.a.d.getCurrentUin().equals(this.b.senderuin)) {
          paramInt = 0;
        } else if (this.a.d.getCurrentUin().equals(Long.valueOf(this.b.receiverUin))) {
          paramInt = j;
        } else {
          paramInt = 2;
        }
        localObject = this.a.f.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        NearbyFlowerManager.a("gift_aio", "clk_tail", (String)localObject, localStringBuilder.toString(), "", "");
        return;
      }
      ReportController.b(this.a.d, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", paramInt, 0, this.a.f.b, "", "", "");
      return;
    }
    ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
  }
  
  private void c(int paramInt)
  {
    boolean bool = TroopGiftUtil.c(this.b);
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject1 = (AIOAnimationControlManager)this.a.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if ((localObject1 != null) && (((AIOAnimationControlManager)localObject1).b()))
      {
        localObject2 = ((BaseActivity)this.a.e).getChatFragment();
        if ((localObject2 != null) && (((ChatFragment)localObject2).k() != null)) {
          ((AIOAnimationControlManager)localObject1).a(((ChatFragment)localObject2).k());
        }
        this.b.isLoading = false;
        ((AIOAnimationControlManager)localObject1).a(this.c);
        ((AIOAnimationControlManager)localObject1).b(this.b);
        if (!this.b.isLoading) {
          ((AIOAnimationControlManager)localObject1).b(this.c);
        }
        if (!this.b.isInteract()) {
          ((AIOAnimationControlManager)localObject1).j();
        }
      }
    }
    else
    {
      localObject1 = new Intent(this.a.e, QQBrowserActivity.class);
      localObject2 = this.b.senderuin;
      localObject3 = new StringBuilder("https://qun.qq.com/qunpay/gifts/index.html?troopUin=");
      ((StringBuilder)localObject3).append(this.a.f.b);
      ((StringBuilder)localObject3).append("&uin=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&name=");
      ((StringBuilder)localObject3).append(Base64Util.encodeToString(this.b.subtitle.getBytes(), 2));
      ((StringBuilder)localObject3).append("&from=obj&_wv=1031&_bid=2204");
      localObject2 = ((StringBuilder)localObject3).toString();
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.b, (Intent)localObject1, (String)localObject2);
      this.a.e.startActivity((Intent)localObject1);
    }
    if (!this.a.d.getCurrentUin().equals(this.b.senderuin)) {
      if (this.a.d.getCurrentUin().equals(Long.valueOf(this.b.receiverUin))) {
        i = 1;
      } else {
        i = 2;
      }
    }
    if (this.b.istroop == 0)
    {
      ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
      return;
    }
    if (this.b.istroop == 3000)
    {
      ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
      return;
    }
    if ((this.b.istroop != 1000) && (this.b.istroop != 1004))
    {
      if (this.b.isFromNearby)
      {
        localObject1 = this.a.f.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_aio", "clk_obj", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
        return;
      }
      localObject1 = this.a.d;
      localObject2 = this.a.f.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.giftPicId);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", paramInt, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
      return;
    }
    ReportController.b(this.a.d, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (this.a.w != null)
    {
      int i;
      if (AnonymousChatHelper.c(this.b)) {
        i = 2;
      } else {
        i = 1;
      }
      if (paramView.getId() == 2131434239) {
        b();
      } else if (paramView.getId() == 2131434244) {
        TroopGiftMsgItemBuilder.a(this.a);
      } else if (paramView.getId() == 2131434243) {
        a();
      } else if (paramView.getId() == 2131429416) {
        c(i);
      } else if (paramView.getId() == 2131447963) {
        b(i);
      } else if (paramView.getId() == 2131434242) {
        a(i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.ClickAction
 * JD-Core Version:    0.7.0.1
 */