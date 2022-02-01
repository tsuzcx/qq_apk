package com.tencent.mobileqq.activity.aio.core;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class BaseTroopChatPie$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseTroopChatPie$1(BaseTroopChatPie paramBaseTroopChatPie) {}
  
  public void onGlobalLayout()
  {
    if (this.a.N)
    {
      this.a.N = false;
      this.a.a.sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.1
 * JD-Core Version:    0.7.0.1
 */