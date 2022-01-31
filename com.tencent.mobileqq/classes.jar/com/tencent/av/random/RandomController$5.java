package com.tencent.av.random;

import android.content.Context;
import android.os.Handler;
import awqx;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import lik;

public class RandomController$5
  implements Runnable
{
  RandomController$5(RandomController paramRandomController) {}
  
  private void a()
  {
    if (!this.this$0.c)
    {
      Context localContext = RandomController.a(this.this$0).getApp().getApplicationContext();
      PopupDialog.b(localContext, 230, localContext.getString(2131630341), localContext.getString(2131630342), 0, 2131630233, new lik(this), null);
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
    awqx.b(null, "CliOper", "", "", "0X8007430", "0X8007430", 0, 0, "", "", "", "");
    RandomController.a(this.this$0).a().removeCallbacks(RandomController.a(this.this$0));
    RandomController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomController.5
 * JD-Core Version:    0.7.0.1
 */