package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.qphone.base.util.QLog;

class QRDisplayActivity$2
  extends TroopModifyObserver
{
  QRDisplayActivity$2(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.equals(this.a.n, paramString)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
      }
      paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramString != null)
      {
        paramString = paramString.f(this.a.n);
        if ((paramString != null) && (!paramString.isNewTroop)) {
          ((TextView)this.a.findViewById(2131434449)).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.2
 * JD-Core Version:    0.7.0.1
 */