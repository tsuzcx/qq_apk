package com.tencent.mobileqq.activity.qwallet.report;

import ajei;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VACDReportMgr$4
  implements Runnable
{
  public VACDReportMgr$4(ajei paramajei, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized ()
    {
      try
      {
        while ((ajei.b(this.this$0).isEmpty()) && (ajei.a(this.this$0).isEmpty())) {
          ajei.a().wait();
        }
        try
        {
          synchronized (this.a)
          {
            this.a.wait(2000L);
          }
          do
          {
            synchronized (ajei.a())
            {
              ajei.b(this.this$0, 2);
              if (ajei.a(this.this$0))
              {
                ajei.c(this.this$0).post(this);
                return;
                localObject1 = finally;
                throw localObject1;
                localObject2 = finally;
                throw localObject2;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "WriteDBThread exit.");
          return;
        }
        catch (Exception localException2)
        {
          break label61;
        }
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.4
 * JD-Core Version:    0.7.0.1
 */