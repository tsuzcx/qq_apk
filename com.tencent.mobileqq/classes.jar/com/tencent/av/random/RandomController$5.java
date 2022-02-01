package com.tencent.av.random;

import android.content.Context;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RandomController$5
  implements Runnable
{
  RandomController$5(RandomController paramRandomController) {}
  
  private void a()
  {
    if (!this.this$0.c)
    {
      Context localContext = RandomController.a(this.this$0).getApp().getApplicationContext();
      PopupDialog.b(localContext, 230, localContext.getString(2131695723), localContext.getString(2131695724), 0, 2131695607, new RandomController.5.1(this), null);
      this.this$0.c = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mRandomKickTimeoutRunnable trigger, request room owner!");
    }
    RandomController.a(this.this$0).b();
    a();
    ReportController.b(null, "CliOper", "", "", "0X8007430", "0X8007430", 0, 0, "", "", "", "");
    RandomController.a(this.this$0).a().removeCallbacks(RandomController.a(this.this$0));
    RandomController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomController.5
 * JD-Core Version:    0.7.0.1
 */