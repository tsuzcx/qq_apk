package com.tencent.mobileqq.activity.editservice;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class EditTroopMemberNickService$7
  extends TroopObserver
{
  EditTroopMemberNickService$7(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  protected void onGetTroopMemberAutoRemark(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      if ((paramString1 != null) && (paramString1.equals(this.a.k)) && (!TextUtils.isEmpty(paramString2)) && (this.a.a != null))
      {
        this.a.a.setText(paramString2);
        this.a.a.setSelection(paramString2.length());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditTroopMemberNickService", 2, new Object[] { paramString1, paramString2 });
      }
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if (!this.a.m) {
      return;
    }
    EditTroopMemberNickService localEditTroopMemberNickService = this.a;
    localEditTroopMemberNickService.m = false;
    EditTroopMemberNickService.d(localEditTroopMemberNickService).loadingProgress(false);
    if (paramBoolean) {}
    do
    {
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l == Long.parseLong(this.a.j)) {
          continue;
        }
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
      if (paramObject.memberUin != Long.parseLong(this.a.k)) {
        return;
      }
      this.a.L.postDelayed(new EditTroopMemberNickService.7.2(this, paramObject), 700L);
      return;
    } while (paramObject != null);
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (!this.a.m) {
      return;
    }
    this.a.m = false;
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() != 0))
    {
      ReportController.b(EditTroopMemberNickService.b(this.a), "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_success", 0, 0, String.valueOf(this.a.j), "", "", "");
      paramArrayList = (ITroopMemberCardHandler)EditTroopMemberNickService.b(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
    }
    try
    {
      paramArrayList.a(Long.parseLong(this.a.j), Long.parseLong(this.a.k));
      this.a.m = true;
      return;
    }
    catch (Exception paramArrayList)
    {
      label127:
      break label127;
    }
    EditTroopMemberNickService.d(this.a).loadingProgress(false);
    return;
    EditTroopMemberNickService.d(this.a).loadingProgress(false);
    paramArrayList = EditTroopMemberNickService.f(this.a);
    if (TextUtils.isEmpty(paramString)) {
      paramString = EditTroopMemberNickService.a(this.a, 2131891837);
    }
    QQToast.makeText(paramArrayList, 1, paramString, 0).show(EditTroopMemberNickService.g(this.a));
    this.a.L.postDelayed(new EditTroopMemberNickService.7.1(this), 1500L);
    ReportController.b(EditTroopMemberNickService.b(this.a), "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.a.j), "1", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.7
 * JD-Core Version:    0.7.0.1
 */