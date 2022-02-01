package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class ShareChat$MyTroopObserver
  extends TroopObserver
{
  String a;
  
  private ShareChat$MyTroopObserver(ShareChat paramShareChat) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return;
    }
    paramTroopInfo = paramTroopInfo.troopuin;
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    if (!TextUtils.equals(this.a, paramTroopInfo)) {
      return;
    }
    this.b.c.removeObserver(this);
    if (this == this.b.k) {
      this.b.k = null;
    }
    paramTroopInfo = new StringBuilder();
    paramTroopInfo.append("onGetSimpleTroopInfoResult, isSuc[");
    paramTroopInfo.append(paramBoolean);
    paramTroopInfo.append("]");
    QLog.w("ShareChat", 1, paramTroopInfo.toString());
    this.b.a();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateTroopList, isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */