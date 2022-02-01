package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

class ReadinjoySPEventReport$5
  implements Runnable
{
  ReadinjoySPEventReport$5(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt) {}
  
  public void run()
  {
    int i;
    if (ReadinjoySPEventReport.a(this.this$0) != null)
    {
      if (((Integer)ReadinjoySPEventReport.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)ReadinjoySPEventReport.a(this.this$0).second).intValue() < this.a) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = ReadinjoySPEventReport.a(this.this$0).size();
      long l1;
      if (j > ReadInJoyHelper.a(ReadInJoyUtils.a())) {
        l1 = j - ReadInJoyHelper.a(ReadInJoyUtils.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (ReadinjoySPEventReport.a(this.this$0).size() <= 1) {
            break label824;
          }
          ReadinjoySPEventReport.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        ReadinjoySPEventReport.a(this.this$0, false);
        if (j == 0) {
          ReadinjoySPEventReport.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ReadinjoySPEventReport.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
        ReadinjoySPEventReport.a(this.this$0).add(ReadinjoySPEventReport.a(this.this$0));
        QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.a);
        j = RIJMergeKanDianMessage.b();
        if (j < 0) {
          break;
        }
        if (j > this.a) {
          j = this.a;
        }
        for (;;)
        {
          int k = ReadinjoySPEventReport.b(this.this$0).size();
          if (k > ReadInJoyHelper.b(ReadInJoyUtils.a())) {
            l1 = k - ReadInJoyHelper.b(ReadInJoyUtils.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (ReadinjoySPEventReport.b(this.this$0).size() > 1)
              {
                ReadinjoySPEventReport.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((ReadinjoySPEventReport.b(this.this$0) != null) && (((Integer)ReadinjoySPEventReport.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                ReadinjoySPEventReport.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              ReadinjoySPEventReport.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              ReadinjoySPEventReport.b(this.this$0).add(ReadinjoySPEventReport.b(this.this$0));
              QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = ReadInJoyHelper.c();
              if ((this.a <= j) && (!ReadinjoySPEventReport.a(this.this$0)) && (i == 0))
              {
                if ((ReadinjoySPEventReport.c(this.this$0) != null) && (ReadinjoySPEventReport.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)ReadinjoySPEventReport.c(this.this$0).get(ReadinjoySPEventReport.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)ReadinjoySPEventReport.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)ReadinjoySPEventReport.c(this.this$0).get(ReadinjoySPEventReport.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    ReadinjoySPEventReport.a(this.this$0, true);
                    return;
                  }
                }
                if (ReadinjoySPEventReport.a(this.this$0) != null) {
                  break label804;
                }
                ReadinjoySPEventReport.a(this.this$0, 0);
              }
              for (;;)
              {
                ReadinjoySPEventReport.b(this.this$0, false);
                return;
                label804:
                ReadinjoySPEventReport.a(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5
 * JD-Core Version:    0.7.0.1
 */