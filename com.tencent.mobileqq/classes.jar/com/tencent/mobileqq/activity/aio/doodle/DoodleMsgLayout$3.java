package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$3
  implements Runnable
{
  DoodleMsgLayout$3(DoodleMsgLayout paramDoodleMsgLayout, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDoodleContent start create drawable:");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    if (!DoodleResHelper.a().b(1, this.a))
    {
      localObject = DoodleResHelper.a();
      int i = this.a;
      DoodleMsgLayout localDoodleMsgLayout = this.this$0;
      ((DoodleResHelper)localObject).b(1, i, localDoodleMsgLayout, localDoodleMsgLayout);
      return;
    }
    localObject = DoodleResHelper.a().a(2, this.a, true);
    if (localObject != null) {
      ((URLDrawable)localObject).startDownload();
    }
    if (this.a != DoodleMsgLayout.a(this.this$0)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new DoodleMsgLayout.3.1(this, (Drawable)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDoodleContent finish create drawable:");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3
 * JD-Core Version:    0.7.0.1
 */