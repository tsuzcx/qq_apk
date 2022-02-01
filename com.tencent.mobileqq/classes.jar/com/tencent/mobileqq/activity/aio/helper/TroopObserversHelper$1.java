package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$1
  extends TroopSettingObserver
{
  TroopObserversHelper$1(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ((TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      TroopObserversHelper.a(this.a, paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((TroopObserversHelper.a(this.a).a.equals(paramString1)) && (TroopObserversHelper.a(this.a).getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onOIDB0XA80_0_Ret: cmd==1,");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(",");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",");
        localStringBuilder.append(TroopObserversHelper.a(this.a));
        QLog.d(".troop.closeRcvMsgTmp", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        TroopObserversHelper.a(this.a).getMessageFacade().a(TroopObserversHelper.a(this.a).a);
        ReportController.b(TroopObserversHelper.a(this.a), "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
        }
      }
      else if (TroopObserversHelper.a(this.a) > 0)
      {
        TroopObserversHelper.a(this.a).n(1);
        TroopObserversHelper.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.1
 * JD-Core Version:    0.7.0.1
 */