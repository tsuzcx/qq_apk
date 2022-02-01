package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$3$1
  implements Runnable
{
  DoodleMsgLayout$3$1(DoodleMsgLayout.3 param3, Drawable paramDrawable) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDoodleContent start update drawable:");
    localStringBuilder.append(this.b.a);
    QLog.d("DoodleMsgLayout", 2, localStringBuilder.toString());
    if (this.b.a != DoodleMsgLayout.f(this.b.this$0)) {
      return;
    }
    if (DoodleMsgLayout.c(this.b.this$0) != null) {
      DoodleMsgLayout.c(this.b.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.d(this.b.this$0) != null) {
      DoodleMsgLayout.d(this.b.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.a(this.b.this$0) != null) {
      DoodleMsgLayout.a(this.b.this$0).setImageDrawable(this.a);
    }
    DoodleMsgLayout.a(this.b.this$0, 0);
    if (DoodleMsgLayout.g(this.b.this$0) != null) {
      this.b.this$0.a(DoodleMsgLayout.g(this.b.this$0).getDataState());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDoodleContent finish update drawable:");
    localStringBuilder.append(this.b.a);
    QLog.d("DoodleMsgLayout", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3.1
 * JD-Core Version:    0.7.0.1
 */