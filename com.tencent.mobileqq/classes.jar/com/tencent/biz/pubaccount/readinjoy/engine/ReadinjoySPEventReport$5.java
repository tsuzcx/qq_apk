package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bgmq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import obz;
import ohp;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(ohp paramohp, int paramInt) {}
  
  public void run()
  {
    int i;
    if (ohp.a(this.this$0) != null)
    {
      if (((Integer)ohp.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)ohp.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = ohp.a(this.this$0).size();
      long l1;
      if (j > bgmq.d(obz.a())) {
        l1 = j - bgmq.d(obz.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (ohp.a(this.this$0).size() <= 1) {
            break label824;
          }
          ohp.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        ohp.a(this.this$0, false);
        if (j == 0) {
          ohp.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ohp.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ohp.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        ohp.a(this.this$0).add(ohp.a(this.this$0));
        QLog.d(ohp.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = obz.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = ohp.b(this.this$0).size();
          if (k > bgmq.e(obz.a())) {
            l1 = k - bgmq.e(obz.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (ohp.b(this.this$0).size() > 1)
              {
                ohp.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((ohp.b(this.this$0) != null) && (((Integer)ohp.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                ohp.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              ohp.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ohp.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              ohp.b(this.this$0).add(ohp.b(this.this$0));
              QLog.d(ohp.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bgmq.b();
              if ((this.a <= j) && (!ohp.a(this.this$0)) && (i == 0))
              {
                if ((ohp.c(this.this$0) != null) && (ohp.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)ohp.c(this.this$0).get(ohp.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)ohp.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)ohp.c(this.this$0).get(ohp.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    ohp.a(this.this$0, true);
                    return;
                  }
                }
                if (ohp.a(this.this$0) != null) {
                  break label804;
                }
                ohp.a(this.this$0, 0);
              }
              for (;;)
              {
                ohp.b(this.this$0, false);
                return;
                label804:
                ohp.a(this.this$0);
              }
            }
            l1 = l2;
          }
        }
        label824:
        l1 = l2;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5
 * JD-Core Version:    0.7.0.1
 */