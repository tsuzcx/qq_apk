package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bkwm;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pay;
import ple;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(ple parample, int paramInt) {}
  
  public void run()
  {
    int i;
    if (ple.a(this.this$0) != null)
    {
      if (((Integer)ple.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)ple.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = ple.a(this.this$0).size();
      long l1;
      if (j > bkwm.c(pay.a())) {
        l1 = j - bkwm.c(pay.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (ple.a(this.this$0).size() <= 1) {
            break label824;
          }
          ple.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        ple.a(this.this$0, false);
        if (j == 0) {
          ple.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ple.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ple.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        ple.a(this.this$0).add(ple.a(this.this$0));
        QLog.d(ple.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = pay.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = ple.b(this.this$0).size();
          if (k > bkwm.d(pay.a())) {
            l1 = k - bkwm.d(pay.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (ple.b(this.this$0).size() > 1)
              {
                ple.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((ple.b(this.this$0) != null) && (((Integer)ple.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                ple.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              ple.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ple.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              ple.b(this.this$0).add(ple.b(this.this$0));
              QLog.d(ple.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bkwm.c();
              if ((this.a <= j) && (!ple.a(this.this$0)) && (i == 0))
              {
                if ((ple.c(this.this$0) != null) && (ple.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)ple.c(this.this$0).get(ple.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)ple.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)ple.c(this.this$0).get(ple.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    ple.a(this.this$0, true);
                    return;
                  }
                }
                if (ple.a(this.this$0) != null) {
                  break label804;
                }
                ple.a(this.this$0, 0);
              }
              for (;;)
              {
                ple.b(this.this$0, false);
                return;
                label804:
                ple.a(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5
 * JD-Core Version:    0.7.0.1
 */