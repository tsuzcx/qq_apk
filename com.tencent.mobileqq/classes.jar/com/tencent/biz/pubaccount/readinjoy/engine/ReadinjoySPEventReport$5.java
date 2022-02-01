package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bmhv;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pkh;
import prr;
import pwb;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(pwb parampwb, int paramInt) {}
  
  public void run()
  {
    int i;
    if (pwb.a(this.this$0) != null)
    {
      if (((Integer)pwb.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)pwb.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = pwb.a(this.this$0).size();
      long l1;
      if (j > bmhv.c(pkh.a())) {
        l1 = j - bmhv.c(pkh.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (pwb.a(this.this$0).size() <= 1) {
            break label824;
          }
          pwb.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        pwb.a(this.this$0, false);
        if (j == 0) {
          pwb.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        pwb.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pwb.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        pwb.a(this.this$0).add(pwb.a(this.this$0));
        QLog.d(pwb.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = prr.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = pwb.b(this.this$0).size();
          if (k > bmhv.d(pkh.a())) {
            l1 = k - bmhv.d(pkh.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (pwb.b(this.this$0).size() > 1)
              {
                pwb.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((pwb.b(this.this$0) != null) && (((Integer)pwb.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                pwb.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              pwb.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pwb.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              pwb.b(this.this$0).add(pwb.b(this.this$0));
              QLog.d(pwb.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bmhv.c();
              if ((this.a <= j) && (!pwb.a(this.this$0)) && (i == 0))
              {
                if ((pwb.c(this.this$0) != null) && (pwb.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)pwb.c(this.this$0).get(pwb.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)pwb.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)pwb.c(this.this$0).get(pwb.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    pwb.a(this.this$0, true);
                    return;
                  }
                }
                if (pwb.a(this.this$0) != null) {
                  break label804;
                }
                pwb.a(this.this$0, 0);
              }
              for (;;)
              {
                pwb.b(this.this$0, false);
                return;
                label804:
                pwb.a(this.this$0);
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