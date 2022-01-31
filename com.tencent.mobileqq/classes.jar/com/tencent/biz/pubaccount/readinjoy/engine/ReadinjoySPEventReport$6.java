package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import bhvy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import onh;
import osx;

public class ReadinjoySPEventReport$6
  implements Runnable
{
  public ReadinjoySPEventReport$6(osx paramosx, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        int i = osx.c(this.this$0).size();
        if (i > bhvy.f(onh.a()))
        {
          l1 = i - bhvy.f(onh.a());
          l2 = l1 - 1L;
          if (l1 > 0L)
          {
            if (osx.c(this.this$0).size() <= 1) {
              break label301;
            }
            osx.c(this.this$0).remove(1);
            l1 = l2;
            continue;
          }
        }
        if (i == 0) {
          osx.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        osx.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)osx.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        QLog.d(osx.class.getSimpleName(), 2, "add aio enter or out info, type : " + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          osx.a(this.this$0, osx.a(this.this$0, this.jdField_a_of_type_JavaUtilList));
        }
        if ((this.jdField_a_of_type_Int != 0) || (!osx.b(this.this$0))) {
          break;
        }
        osx.a(this.this$0, false);
        if (osx.a(this.this$0) != null)
        {
          osx.a(this.this$0);
          return;
        }
        osx.a(this.this$0, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6
 * JD-Core Version:    0.7.0.1
 */