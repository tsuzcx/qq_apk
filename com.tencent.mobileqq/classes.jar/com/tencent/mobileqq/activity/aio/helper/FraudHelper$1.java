package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;

class FraudHelper$1
  extends FriendListObserver
{
  FraudHelper$1(FraudHelper paramFraudHelper) {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (paramInt1 != 146) {
        return;
      }
      if (paramInt2 == 0)
      {
        UinFraudInfo.a().c(paramLong);
        return;
      }
      UinFraudInfo.a().a(paramLong, paramInt2);
      FraudHelper.b(this.a).b().runOnUiThread(new FraudHelper.1.1(this, paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FraudHelper.1
 * JD-Core Version:    0.7.0.1
 */