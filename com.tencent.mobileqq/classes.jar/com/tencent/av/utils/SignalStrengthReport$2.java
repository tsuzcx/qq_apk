package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.av.AVLog;

class SignalStrengthReport$2
  implements Runnable
{
  SignalStrengthReport$2(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((SignalStrengthReport)localObject1).i = 0;
    if (((SignalStrengthReport)localObject1).f != -1)
    {
      if (SignalStrengthReport.h() == 1) {
        try
        {
          localObject1 = SignalStrengthReport.a(this.this$0);
          localObject2 = this.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append((String)localObject1);
          ((SignalStrengthReport)localObject2).i = SignalStrengthReport.PingUtil.a(localStringBuilder.toString());
          if (this.this$0.i < 0) {
            this.this$0.i = 0;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mPingTask gatewayIP:");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" | avgRtt:");
          ((StringBuilder)localObject2).append(this.this$0.i);
          AVLog.printColorLog("SignalStrengthReport", ((StringBuilder)localObject2).toString());
        }
        catch (Exception localException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mPingTask e:");
          ((StringBuilder)localObject2).append(localException);
          AVLog.printColorLog("SignalStrengthReport", ((StringBuilder)localObject2).toString());
        }
      }
      if (this.this$0.h != null) {
        this.this$0.h.postDelayed(this, this.this$0.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */