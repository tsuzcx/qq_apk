package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

class ReadinjoySPEventReport$6
  implements Runnable
{
  ReadinjoySPEventReport$6(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        int i = ReadinjoySPEventReport.c(this.this$0).size();
        if (i > ReadInJoyHelper.c(ReadInJoyUtils.a()))
        {
          l1 = i - ReadInJoyHelper.c(ReadInJoyUtils.a());
          l2 = l1 - 1L;
          if (l1 > 0L)
          {
            if (ReadinjoySPEventReport.c(this.this$0).size() <= 1) {
              break label301;
            }
            ReadinjoySPEventReport.c(this.this$0).remove(1);
            l1 = l2;
            continue;
          }
        }
        if (i == 0) {
          ReadinjoySPEventReport.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ReadinjoySPEventReport.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "add aio enter or out info, type : " + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          ReadinjoySPEventReport.a(this.this$0, ReadinjoySPEventReport.a(this.this$0, this.jdField_a_of_type_JavaUtilList));
        }
        if ((this.jdField_a_of_type_Int != 0) || (!ReadinjoySPEventReport.b(this.this$0))) {
          break;
        }
        ReadinjoySPEventReport.a(this.this$0, false);
        if (ReadinjoySPEventReport.a(this.this$0) != null)
        {
          ReadinjoySPEventReport.a(this.this$0);
          return;
        }
        ReadinjoySPEventReport.a(this.this$0, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6
 * JD-Core Version:    0.7.0.1
 */