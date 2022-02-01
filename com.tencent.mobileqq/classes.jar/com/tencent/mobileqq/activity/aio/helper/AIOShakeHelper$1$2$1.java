package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.ViewGroup;

class AIOShakeHelper$1$2$1
  implements Runnable
{
  AIOShakeHelper$1$2$1(AIOShakeHelper.1.2 param2) {}
  
  public void run()
  {
    if ((AIOShakeHelper.a(this.a.a.this$0) != null) && (AIOShakeHelper.a(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)AIOShakeHelper.a(this.a.a.this$0).getParent()).removeView(AIOShakeHelper.a(this.a.a.this$0));
    }
    AIOShakeHelper.a(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */