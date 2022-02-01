package com.tencent.av.random;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RandomController$6
  implements Runnable
{
  RandomController$6(RandomController paramRandomController) {}
  
  public void run()
  {
    RandomController.a(this.this$0).a().removeCallbacks(RandomController.d(this.this$0));
    if (!RandomController.a(this.this$0).a()) {
      PopupDialog.a(RandomController.a(this.this$0).getApp().getApplicationContext(), RandomController.a(this.this$0).getApp().getString(2131695076), RandomController.a(this.this$0, RandomController.d(this.this$0)));
    }
    do
    {
      while (RandomController.d(this.this$0) > 60)
      {
        RandomController.a(this.this$0).a().postDelayed(RandomController.d(this.this$0), 60000L);
        RandomController.a(this.this$0, RandomController.d(this.this$0) - 60);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "background mRemainBlockTime : " + RandomController.d(this.this$0));
        }
      }
      if ((RandomController.d(this.this$0) <= 60) && (RandomController.d(this.this$0) > 0))
      {
        RandomController.a(this.this$0).a().postDelayed(RandomController.d(this.this$0), 10000L);
        RandomController.a(this.this$0, RandomController.d(this.this$0) - 10);
        return;
      }
    } while (RandomController.d(this.this$0) > 0);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.6
 * JD-Core Version:    0.7.0.1
 */