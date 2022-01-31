package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bjxj;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ors;
import oxp;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(oxp paramoxp, int paramInt) {}
  
  public void run()
  {
    int i;
    if (oxp.a(this.this$0) != null)
    {
      if (((Integer)oxp.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)oxp.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = oxp.a(this.this$0).size();
      long l1;
      if (j > bjxj.d(ors.a())) {
        l1 = j - bjxj.d(ors.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (oxp.a(this.this$0).size() <= 1) {
            break label824;
          }
          oxp.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        oxp.a(this.this$0, false);
        if (j == 0) {
          oxp.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        oxp.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)oxp.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        oxp.a(this.this$0).add(oxp.a(this.this$0));
        QLog.d(oxp.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = ors.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = oxp.b(this.this$0).size();
          if (k > bjxj.e(ors.a())) {
            l1 = k - bjxj.e(ors.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (oxp.b(this.this$0).size() > 1)
              {
                oxp.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((oxp.b(this.this$0) != null) && (((Integer)oxp.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                oxp.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              oxp.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)oxp.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              oxp.b(this.this$0).add(oxp.b(this.this$0));
              QLog.d(oxp.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bjxj.b();
              if ((this.a <= j) && (!oxp.a(this.this$0)) && (i == 0))
              {
                if ((oxp.c(this.this$0) != null) && (oxp.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)oxp.c(this.this$0).get(oxp.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)oxp.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)oxp.c(this.this$0).get(oxp.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    oxp.a(this.this$0, true);
                    return;
                  }
                }
                if (oxp.a(this.this$0) != null) {
                  break label804;
                }
                oxp.a(this.this$0, 0);
              }
              for (;;)
              {
                oxp.b(this.this$0, false);
                return;
                label804:
                oxp.a(this.this$0);
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