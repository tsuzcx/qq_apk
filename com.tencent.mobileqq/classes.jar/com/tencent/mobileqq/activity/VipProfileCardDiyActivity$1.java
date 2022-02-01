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
      if ((paramInt1 == 0) && (!TextUtils.isEmpty(this.a.g))) {
        this.a.c(this.a.g);
      }
    }
    else {
      return;
    }
    QLog.e("VipProfileCardDiyActivity", 1, "download card background failed. errorCode=" + paramInt1 + ", url=" + this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.1
 * JD-Core Version:    0.7.0.1
 */