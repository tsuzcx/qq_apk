package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import kvq;
import mqq.os.MqqHandler;

class AVActivity$9
  implements Runnable
{
  AVActivity$9(AVActivity paramAVActivity, View paramView) {}
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = this.this$0.a;
    if (localVideoAppInterface == null) {}
    for (;;)
    {
      return;
      if ((!localVideoAppInterface.a().a().c()) && (localVideoAppInterface.d("105000.105100.105120"))) {}
      for (boolean bool = true; !this.this$0.isDestroyed(); bool = false)
      {
        ThreadManager.getUIHandler().post(new AVActivity.9.1(this, bool));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.9
 * JD-Core Version:    0.7.0.1
 */