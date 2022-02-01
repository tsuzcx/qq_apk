package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

class TroopLowCreditLevelNotifyActivity$2
  extends TroopAppObserver
{
  TroopLowCreditLevelNotifyActivity$2(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity) {}
  
  protected void a(oidb_0xe83.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      paramRspBody = String.valueOf(paramRspBody.group_id.get());
      if (!TextUtils.equals(this.a.k, paramRspBody)) {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetNewTroopAppList troopUin not match. rsp uin=");
          localStringBuilder.append(paramRspBody);
          localStringBuilder.append(", current uin=");
          localStringBuilder.append(this.a.k);
          QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, localStringBuilder.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("onGetNewTroopAppList group_id lost. current uin=");
      paramRspBody.append(this.a.k);
      QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, paramRspBody.toString());
    }
    this.a.f();
    paramRspBody = this.a.a(1101236949L);
    if (paramRspBody != null) {
      this.a.a(paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity.2
 * JD-Core Version:    0.7.0.1
 */