package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$18
  extends TroopModifyObserver
{
  TroopChatPie$18(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!paramString1.equals(this.a.ah.b)) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.g(this.a.ah.b);
    if (localTroopInfo == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString3)) {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, paramString3, 0).show();
      }
    }
    else
    {
      localTroopInfo.troopname = paramString2;
      localTroopInfo.hasSetNewTroopName = true;
      if ((this.a.aY()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead)) {
        localTroopInfo.isNewTroop = false;
      }
      localTroopManager.b(localTroopInfo);
      this.a.bW();
    }
    if ((this.a.ah.b.equals(paramString1)) && (localTroopInfo != null))
    {
      this.a.ah.e = localTroopInfo.getTroopDisplayName();
      paramString1 = this.a.f.getIntent();
      paramString1.putExtra("uinname", localTroopInfo.getTroopDisplayName());
      this.a.c(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.18
 * JD-Core Version:    0.7.0.1
 */