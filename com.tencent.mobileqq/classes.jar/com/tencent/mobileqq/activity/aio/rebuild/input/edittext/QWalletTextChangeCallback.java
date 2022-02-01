package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.helper.AIOAtHelper;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;

public class QWalletTextChangeCallback
  implements IEditTextChangeCallback
{
  private void a(AIOContext paramAIOContext, TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 32)))
    {
      QQAppInterface localQQAppInterface = paramAIOContext.a();
      int i;
      if (paramTroopInfo.isTroopOwner(localQQAppInterface.getCurrentAccountUin())) {
        i = 0;
      } else if (paramTroopInfo.isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
      TroopGiftUtil.a(paramAIOContext.b(), paramTroopInfo.troopuin, "input", localQQAppInterface);
    }
  }
  
  private boolean a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (paramInt2 == 1) && (a(paramCharSequence, paramInt1)) && (!paramAIOContext.t()) && (!((QWalletAIOLifeCycleHelper)paramAIOContext.a(27)).a);
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return (paramCharSequence.charAt(paramInt) == '$') || (paramCharSequence.charAt(paramInt) == 65509) || (paramCharSequence.charAt(paramInt) == '¥') || (paramCharSequence.charAt(paramInt) == 65284);
  }
  
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    QWalletAIOLifeCycleHelper localQWalletAIOLifeCycleHelper = (QWalletAIOLifeCycleHelper)paramAIOContext.a(27);
    if (localQWalletAIOLifeCycleHelper != null)
    {
      localQWalletAIOLifeCycleHelper.a(paramEditable);
      if (paramAIOContext.O().a == 1) {
        localQWalletAIOLifeCycleHelper.b();
      }
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    if ((localBaseSessionInfo.a == 1) && (!localBaseSessionInfo.z) && (localBaseSessionInfo.a == 1) && (localBaseSessionInfo.b != null) && (localBaseSessionInfo.b.length() != 0))
    {
      if (a(paramAIOContext, paramCharSequence, paramInt1, paramInt3))
      {
        TroopManager localTroopManager = (TroopManager)paramAIOContext.a().getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager.Z(localBaseSessionInfo.b)) {
          return;
        }
        paramInt2 = 0;
        while (paramInt2 < paramCharSequence.length())
        {
          if ((paramInt2 != paramInt1) && (a(paramCharSequence, paramInt2))) {
            return;
          }
          paramInt2 += 1;
        }
        a(paramAIOContext, localTroopManager.f(localBaseSessionInfo.b));
        return;
      }
      if ((!paramAIOContext.t()) && (!((QWalletAIOLifeCycleHelper)paramAIOContext.a(27)).a)) {
        ((AIOAtHelper)paramAIOContext.a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.QWalletTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */