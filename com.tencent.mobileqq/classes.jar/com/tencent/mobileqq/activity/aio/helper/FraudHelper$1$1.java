package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;

class FraudHelper$1$1
  implements Runnable
{
  FraudHelper$1$1(FraudHelper.1 param1, long paramLong) {}
  
  public void run()
  {
    if ((FraudHelper.a(this.b.a) != null) && (this.a == Long.parseLong(FraudHelper.b(this.b.a).O().b))) {
      FraudHelper.a(this.b.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FraudHelper.1.1
 * JD-Core Version:    0.7.0.1
 */