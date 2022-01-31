package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bhvh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import onk;
import ota;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(ota paramota, int paramInt) {}
  
  public void run()
  {
    int i;
    if (ota.a(this.this$0) != null)
    {
      if (((Integer)ota.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)ota.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = ota.a(this.this$0).size();
      long l1;
      if (j > bhvh.d(onk.a())) {
        l1 = j - bhvh.d(onk.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (ota.a(this.this$0).size() <= 1) {
            break label824;
          }
          ota.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        ota.a(this.this$0, false);
        if (j == 0) {
          ota.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ota.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ota.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        ota.a(this.this$0).add(ota.a(this.this$0));
        QLog.d(ota.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = onk.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = ota.b(this.this$0).size();
          if (k > bhvh.e(onk.a())) {
            l1 = k - bhvh.e(onk.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (ota.b(this.this$0).size() > 1)
              {
                ota.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((ota.b(this.this$0) != null) && (((Integer)ota.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                ota.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              ota.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ota.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              ota.b(this.this$0).add(ota.b(this.this$0));
              QLog.d(ota.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bhvh.b();
              if ((this.a <= j) && (!ota.a(this.this$0)) && (i == 0))
              {
                if ((ota.c(this.this$0) != null) && (ota.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)ota.c(this.this$0).get(ota.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)ota.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)ota.c(this.this$0).get(ota.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    ota.a(this.this$0, true);
                    return;
                  }
                }
                if (ota.a(this.this$0) != null) {
                  break label804;
                }
                ota.a(this.this$0, 0);
              }
              for (;;)
              {
                ota.b(this.this$0, false);
                return;
                label804:
                ota.a(this.this$0);
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