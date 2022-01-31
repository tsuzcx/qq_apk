package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bhvy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import onh;
import osx;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(osx paramosx, int paramInt) {}
  
  public void run()
  {
    int i;
    if (osx.a(this.this$0) != null)
    {
      if (((Integer)osx.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)osx.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = osx.a(this.this$0).size();
      long l1;
      if (j > bhvy.d(onh.a())) {
        l1 = j - bhvy.d(onh.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (osx.a(this.this$0).size() <= 1) {
            break label824;
          }
          osx.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        osx.a(this.this$0, false);
        if (j == 0) {
          osx.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        osx.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)osx.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        osx.a(this.this$0).add(osx.a(this.this$0));
        QLog.d(osx.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = onh.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = osx.b(this.this$0).size();
          if (k > bhvy.e(onh.a())) {
            l1 = k - bhvy.e(onh.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (osx.b(this.this$0).size() > 1)
              {
                osx.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((osx.b(this.this$0) != null) && (((Integer)osx.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                osx.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              osx.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)osx.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              osx.b(this.this$0).add(osx.b(this.this$0));
              QLog.d(osx.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bhvy.b();
              if ((this.a <= j) && (!osx.a(this.this$0)) && (i == 0))
              {
                if ((osx.c(this.this$0) != null) && (osx.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)osx.c(this.this$0).get(osx.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)osx.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)osx.c(this.this$0).get(osx.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    osx.a(this.this$0, true);
                    return;
                  }
                }
                if (osx.a(this.this$0) != null) {
                  break label804;
                }
                osx.a(this.this$0, 0);
              }
              for (;;)
              {
                osx.b(this.this$0, false);
                return;
                label804:
                osx.a(this.this$0);
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