package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bmqa;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pha;
import pmy;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(pmy parampmy, int paramInt) {}
  
  public void run()
  {
    int i;
    if (pmy.a(this.this$0) != null)
    {
      if (((Integer)pmy.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)pmy.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = pmy.a(this.this$0).size();
      long l1;
      if (j > bmqa.d(pha.a())) {
        l1 = j - bmqa.d(pha.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (pmy.a(this.this$0).size() <= 1) {
            break label824;
          }
          pmy.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        pmy.a(this.this$0, false);
        if (j == 0) {
          pmy.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        pmy.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pmy.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        pmy.a(this.this$0).add(pmy.a(this.this$0));
        QLog.d(pmy.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = pha.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = pmy.b(this.this$0).size();
          if (k > bmqa.e(pha.a())) {
            l1 = k - bmqa.e(pha.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (pmy.b(this.this$0).size() > 1)
              {
                pmy.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((pmy.b(this.this$0) != null) && (((Integer)pmy.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                pmy.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              pmy.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pmy.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              pmy.b(this.this$0).add(pmy.b(this.this$0));
              QLog.d(pmy.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bmqa.a();
              if ((this.a <= j) && (!pmy.a(this.this$0)) && (i == 0))
              {
                if ((pmy.c(this.this$0) != null) && (pmy.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)pmy.c(this.this$0).get(pmy.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)pmy.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)pmy.c(this.this$0).get(pmy.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    pmy.a(this.this$0, true);
                    return;
                  }
                }
                if (pmy.a(this.this$0) != null) {
                  break label804;
                }
                pmy.a(this.this$0, 0);
              }
              for (;;)
              {
                pmy.b(this.this$0, false);
                return;
                label804:
                pmy.a(this.this$0);
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