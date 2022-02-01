package com.tencent.av.service;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class QQServiceForAV$7
  extends TroopObserver
{
  QQServiceForAV$7(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onOIDB0X899_0_Ret, isSuccess[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], troopuin[");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("], nFlag[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], lStartUin[");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("], result[");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("], strErrorMsg[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject).toString());
    paramString = (QQAppInterface)this.a.a();
    if ((paramBoolean) && (paramInt1 == 2))
    {
      if (TextUtils.isEmpty(this.a.c)) {
        this.a.c = paramString.getCurrentAccountUin();
      }
      paramLong2 = Long.valueOf(this.a.c).longValue();
      paramInt2 = 0;
      if (paramList == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramList.size();
      }
      while (paramInt2 < paramInt1)
      {
        localObject = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.get() == paramLong2)) {
          this.a.a(paramLong1, paramLong2);
        }
        paramInt2 += 1;
      }
      paramList = paramString;
      if (paramString == null) {
        paramList = (QQAppInterface)this.a.a();
      }
      paramList.removeObserver(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.7
 * JD-Core Version:    0.7.0.1
 */