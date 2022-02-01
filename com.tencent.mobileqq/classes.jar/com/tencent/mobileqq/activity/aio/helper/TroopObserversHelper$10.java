package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopObserversHelper$10
  extends TroopOnlinePushObserver
{
  TroopObserversHelper$10(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((TroopObserversHelper.b(this.a) != null) && (TroopObserversHelper.b(this.a).b.equals(String.valueOf(l)))) {
        TroopObserversHelper.d(this.a).z();
      }
    }
  }
  
  protected void onPushTroopEnterEffect(TroopEnterEffectData paramTroopEnterEffectData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPushTroopEnterEffect: troopUin = ");
      localStringBuilder.append(paramTroopEnterEffectData.c);
      localStringBuilder.append(", data.id = ");
      localStringBuilder.append(paramTroopEnterEffectData.a);
      QLog.d("TroopObserversHelper", 2, localStringBuilder.toString());
    }
    if (AnonymousChatHelper.a().a(TroopObserversHelper.b(this.a).b))
    {
      if (QLog.isColorLevel())
      {
        paramTroopEnterEffectData = new StringBuilder();
        paramTroopEnterEffectData.append("onPushTroopEnterEffect: troopUin = ");
        paramTroopEnterEffectData.append(TroopObserversHelper.b(this.a).b);
        paramTroopEnterEffectData.append(" isAnonymous");
        QLog.d("TroopObserversHelper", 2, paramTroopEnterEffectData.toString());
      }
      return;
    }
    paramTroopEnterEffectData = ((TroopEffectHelper)TroopObserversHelper.d(this.a).q(134)).b();
    paramTroopEnterEffectData.a(TroopObserversHelper.b(this.a).b);
    paramTroopEnterEffectData.a();
  }
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    if (TroopObserversHelper.b(this.a) != null)
    {
      if (TextUtils.isEmpty(TroopObserversHelper.b(this.a).b)) {
        return;
      }
      if (TroopObserversHelper.b(this.a).b.equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopObserversHelper", 2, String.format("onTroopBlockStatusChanged, troopUin: %s", new Object[] { TroopObserversHelper.b(this.a).b }));
        }
        paramString = (TroopBlockDialogHelper)TroopObserversHelper.d(this.a).q(76);
        if (paramString != null) {
          paramString.b();
        }
      }
    }
  }
  
  protected void onTroopMemberUpdate()
  {
    TroopObserversHelper.d(this.a).bW();
    GiftPanelHelper localGiftPanelHelper = (GiftPanelHelper)TroopObserversHelper.d(this.a).q(136);
    if ((localGiftPanelHelper.e != null) && (localGiftPanelHelper.e.d() != null)) {
      localGiftPanelHelper.e.d().b();
    }
  }
  
  protected void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTroopNewFeedsAutoPullDown, isSuc:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("troopUin");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",feedsId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",flag:");
      localStringBuilder.append(paramInt);
      QLog.d("TroopObserversHelper.troop.notification_center.auto_pull_down", 2, localStringBuilder.toString());
    }
    if (!TroopObserversHelper.b(this.a).b.equals(paramString1)) {}
  }
  
  protected void onTroopRewardChangeNotify(String paramString1, String paramString2)
  {
    if (TroopObserversHelper.b(this.a).b.equals(paramString1))
    {
      List localList = TroopObserversHelper.d(this.a).V.a();
      int i = TroopObserversHelper.d(this.a).U.getFirstVisiblePosition();
      int j = TroopObserversHelper.d(this.a).U.getLastVisiblePosition();
      paramString1 = ((TroopRewardMgr)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_REWARD_MGR)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          TroopObserversHelper.d(this.a).j(131078);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.10
 * JD-Core Version:    0.7.0.1
 */