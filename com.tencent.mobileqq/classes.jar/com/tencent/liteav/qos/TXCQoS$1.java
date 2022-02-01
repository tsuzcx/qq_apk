package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class TXCQoS$1
  implements Runnable
{
  TXCQoS$1(TXCQoS paramTXCQoS) {}
  
  public void run()
  {
    if (TXCQoS.access$000(this.a) != null)
    {
      int i = TXCQoS.access$000(this.a).a();
      int j = TXCQoS.access$000(this.a).b();
      int k = TXCQoS.access$000(this.a).c();
      int m = TXCQoS.access$000(this.a).d();
      int n = TXCQoS.access$000(this.a).e();
      int i1 = TXCQoS.access$000(this.a).f();
      int i2 = TXCQoS.access$000(this.a).g();
      Object localObject = this.a;
      TXCQoS.access$200((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject), i);
      localObject = this.a;
      TXCQoS.access$300((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject), m, n, i1, k, j, i2);
      localObject = this.a;
      boolean bool = TXCQoS.access$400((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject));
      if (TXCQoS.access$500(this.a) != bool)
      {
        TXCQoS.access$502(this.a, bool);
        TXCQoS.access$000(this.a).a(bool);
      }
      localObject = this.a;
      i = TXCQoS.access$600((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject));
      localObject = this.a;
      j = TXCQoS.access$700((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject));
      localObject = this.a;
      k = TXCQoS.access$800((TXCQoS)localObject, TXCQoS.access$100((TXCQoS)localObject));
      StringBuilder localStringBuilder;
      if ((j == TXCQoS.access$900(this.a)) && (k == TXCQoS.access$1000(this.a)))
      {
        if (i != TXCQoS.access$1300(this.a))
        {
          TXCQoS.access$000(this.a).a(i, 0, 0);
          if (TXCQoS.access$1200(this.a) != null)
          {
            localObject = new Bundle();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Adjust encoding bitrate:new bitrate:");
            localStringBuilder.append(i);
            ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
            ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            ((Bundle)localObject).putString("EVT_USERID", TXCQoS.access$1400(this.a));
            TXCQoS.access$1200(this.a).onNotifyEvent(1006, (Bundle)localObject);
          }
        }
      }
      else if ((TXCQoS.access$1100(this.a) == 1) || (TXCQoS.access$1100(this.a) == 5))
      {
        TXCQoS.access$000(this.a).a(i, j, k);
        if (TXCQoS.access$1200(this.a) != null)
        {
          localObject = new Bundle();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adjust resolution:new bitrate:");
          localStringBuilder.append(i);
          localStringBuilder.append(" new resolution:");
          localStringBuilder.append(j);
          localStringBuilder.append("*");
          localStringBuilder.append(k);
          ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
          ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          TXCQoS.access$1200(this.a).onNotifyEvent(1005, (Bundle)localObject);
        }
      }
      TXCQoS.access$1302(this.a, i);
      TXCQoS.access$902(this.a, j);
      TXCQoS.access$1002(this.a, k);
    }
    TXCQoS.access$1600(this.a).postDelayed(this, TXCQoS.access$1500(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS.1
 * JD-Core Version:    0.7.0.1
 */