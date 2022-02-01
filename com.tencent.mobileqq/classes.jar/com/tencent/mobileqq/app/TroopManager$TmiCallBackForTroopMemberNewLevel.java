package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

class TroopManager$TmiCallBackForTroopMemberNewLevel
  implements TroopManager.ITroopMemberInfoCallBack
{
  public String a;
  public String b;
  public int c;
  
  private TroopManager$TmiCallBackForTroopMemberNewLevel(TroopManager paramTroopManager) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)))
    {
      if (!this.a.equals(paramTroopMemberInfo.memberuin)) {
        return;
      }
      paramTroopMemberInfo.newRealLevel = this.c;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newRealLevel:");
        localStringBuilder.append(this.c);
        localStringBuilder.append(",troopUin : ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(",memberUin");
        localStringBuilder.append(this.a);
        QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
      }
      if (paramTroopMemberInfo.getStatus() == 1000) {
        this.d.a(this.b, this.a, paramTroopMemberInfo);
      }
      this.d.b(this.b, this.a, paramTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.TmiCallBackForTroopMemberNewLevel
 * JD-Core Version:    0.7.0.1
 */