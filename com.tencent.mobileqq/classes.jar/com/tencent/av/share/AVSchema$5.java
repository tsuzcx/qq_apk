package com.tencent.av.share;

import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class AVSchema$5
  implements Runnable
{
  AVSchema$5(AVSchema paramAVSchema, long paramLong) {}
  
  public void run()
  {
    String str = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleResult_I_Known, msg[");
    localStringBuilder.append(this.this$0.isResumed());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.this$0.f != null) {}
    try
    {
      this.this$0.f.show();
      this.this$0.f.getWindow().getDecorView().requestLayout();
      this.this$0.getBaseActivity().getWindow().getDecorView().requestLayout();
      this.this$0.getBaseActivity().getWindow().getDecorView().invalidate();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.5
 * JD-Core Version:    0.7.0.1
 */