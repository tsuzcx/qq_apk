package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bnrf;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ozs;
import pfs;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(pfs parampfs, int paramInt) {}
  
  public void run()
  {
    int i;
    if (pfs.a(this.this$0) != null)
    {
      if (((Integer)pfs.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)pfs.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = pfs.a(this.this$0).size();
      long l1;
      if (j > bnrf.d(ozs.a())) {
        l1 = j - bnrf.d(ozs.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (pfs.a(this.this$0).size() <= 1) {
            break label824;
          }
          pfs.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        pfs.a(this.this$0, false);
        if (j == 0) {
          pfs.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        pfs.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pfs.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        pfs.a(this.this$0).add(pfs.a(this.this$0));
        QLog.d(pfs.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = ozs.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = pfs.b(this.this$0).size();
          if (k > bnrf.e(ozs.a())) {
            l1 = k - bnrf.e(ozs.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (pfs.b(this.this$0).size() > 1)
              {
                pfs.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((pfs.b(this.this$0) != null) && (((Integer)pfs.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                pfs.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              pfs.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pfs.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              pfs.b(this.this$0).add(pfs.b(this.this$0));
              QLog.d(pfs.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = bnrf.b();
              if ((this.a <= j) && (!pfs.a(this.this$0)) && (i == 0))
              {
                if ((pfs.c(this.this$0) != null) && (pfs.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)pfs.c(this.this$0).get(pfs.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)pfs.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)pfs.c(this.this$0).get(pfs.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    pfs.a(this.this$0, true);
                    return;
                  }
                }
                if (pfs.a(this.this$0) != null) {
                  break label804;
                }
                pfs.a(this.this$0, 0);
              }
              for (;;)
              {
                pfs.b(this.this$0, false);
                return;
                label804:
                pfs.a(this.this$0);
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