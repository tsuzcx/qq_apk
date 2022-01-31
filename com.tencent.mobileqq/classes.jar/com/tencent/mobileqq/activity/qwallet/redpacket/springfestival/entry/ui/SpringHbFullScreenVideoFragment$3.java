package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.os.Looper;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class SpringHbFullScreenVideoFragment$3
  implements Runnable
{
  SpringHbFullScreenVideoFragment$3(SpringHbFullScreenVideoFragment paramSpringHbFullScreenVideoFragment) {}
  
  public void run()
  {
    boolean bool = false;
    if (SpringHbFullScreenVideoFragment.b(this.this$0) == 1) {
      SpringHbFullScreenVideoFragment.a(this.this$0).c();
    }
    Object localObject;
    if (SpringHbFullScreenVideoFragment.a(this.this$0) != null)
    {
      localObject = SpringHbFullScreenVideoFragment.a(this.this$0);
      if (SpringHbFullScreenVideoFragment.c(this.this$0) != 1) {
        break label119;
      }
    }
    label119:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onAnimationEnd...").append(SpringHbFullScreenVideoFragment.c(this.this$0)).append(",thread:");
        if (Looper.getMainLooper() == Looper.myLooper()) {
          bool = true;
        }
        QLog.d("QQFudaiVideoFragment", 2, bool);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbFullScreenVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */