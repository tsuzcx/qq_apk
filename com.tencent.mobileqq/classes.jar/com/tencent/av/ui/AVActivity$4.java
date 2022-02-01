package com.tencent.av.ui;

import android.os.Handler;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVActivity$4
  implements Runnable
{
  AVActivity$4(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    long l = AudioHelper.c();
    View localView = this.this$0.b(l);
    if (localView != null)
    {
      String str = this.this$0.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qav_UserGuide_for_more, 计划显示, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      localView.setAlpha(0.01F);
      localView.setVisibility(0);
      if (this.this$0.K != null) {
        this.this$0.K.I(l);
      }
      this.this$0.H.a().postDelayed(new AVActivity.4.1(this, l), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.4
 * JD-Core Version:    0.7.0.1
 */