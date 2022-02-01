package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;

class FTSDBManager$1
  implements Runnable
{
  FTSDBManager$1(FTSDBManager paramFTSDBManager) {}
  
  public void run()
  {
    if (this.this$0.a()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (SQLiteFTSUtils.g(FTSDBManager.a(this.this$0)))
          {
            FTSDBManager.a(this.this$0);
            return;
          }
        } while ((!SQLiteFTSUtils.h(FTSDBManager.a(this.this$0))) || (this.this$0.b));
        FTSDBManager.a(this.this$0);
        ThreadRegulator.a().b();
      } while (FTSDBManager.a(this.this$0));
      if ((FTSDBManager.b(this.this$0) > 10) || (FTSDBManager.c(this.this$0) == 1))
      {
        FTSDBManager.a(this.this$0);
        return;
      }
    } while (FTSDBManager.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */