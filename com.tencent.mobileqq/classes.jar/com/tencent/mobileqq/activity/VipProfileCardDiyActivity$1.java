package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

class VipProfileCardDiyActivity$1
  extends CallBacker
{
  VipProfileCardDiyActivity$1(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")))
    {
      if ((paramInt1 == 0) && (!TextUtils.isEmpty(this.a.al)))
      {
        paramString1 = this.a;
        paramString1.c(paramString1.al);
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("download card background failed. errorCode=");
      paramString1.append(paramInt1);
      paramString1.append(", url=");
      paramString1.append(this.a.U);
      QLog.e("VipProfileCardDiyActivity", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.1
 * JD-Core Version:    0.7.0.1
 */