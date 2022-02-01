package com.tencent.av.ui;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class AVActivity$4$1
  implements Runnable
{
  AVActivity$4$1(AVActivity.4 param4, long paramLong) {}
  
  public void run()
  {
    if (this.b.this$0.isDestroyed()) {
      return;
    }
    Object localObject = this.b.this$0.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_UserGuide_for_more, 开始显示, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.b.this$0.findViewById(2131441197);
    if (localObject == null) {
      return;
    }
    if (this.b.this$0.K == null) {
      return;
    }
    if (!this.b.this$0.K.ab()) {
      return;
    }
    this.b.this$0.K.I(this.a);
    ((View)localObject).setVisibility(0);
    ((View)localObject).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.4.1
 * JD-Core Version:    0.7.0.1
 */