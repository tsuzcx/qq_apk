package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bmqa;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pha;
import pmy;

public class ReadinjoySPEventReport$6
  implements Runnable
{
  public ReadinjoySPEventReport$6(pmy parampmy, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        int i = pmy.c(this.this$0).size();
        if (i > bmqa.f(pha.a()))
        {
          l1 = i - bmqa.f(pha.a());
          l2 = l1 - 1L;
          if (l1 > 0L)
          {
            if (pmy.c(this.this$0).size() <= 1) {
              break label301;
            }
            pmy.c(this.this$0).remove(1);
            l1 = l2;
            continue;
          }
        }
        if (i == 0) {
          pmy.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        pmy.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)pmy.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        QLog.d(pmy.class.getSimpleName(), 2, "add aio enter or out info, type : " + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          pmy.a(this.this$0, pmy.a(this.this$0, this.jdField_a_of_type_JavaUtilList));
        }
        if ((this.jdField_a_of_type_Int != 0) || (!pmy.b(this.this$0))) {
          break;
        }
        pmy.a(this.this$0, false);
        if (pmy.a(this.this$0) != null)
        {
          pmy.a(this.this$0);
          return;
        }
        pmy.a(this.this$0, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label301:
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6
 * JD-Core Version:    0.7.0.1
 */