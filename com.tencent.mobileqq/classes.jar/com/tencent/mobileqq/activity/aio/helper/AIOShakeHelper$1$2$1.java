package com.tencent.mobileqq.activity.aio.helper;

import afpo;
import afpq;
import android.view.View;
import android.view.ViewGroup;

public class AIOShakeHelper$1$2$1
  implements Runnable
{
  public AIOShakeHelper$1$2$1(afpq paramafpq) {}
  
  public void run()
  {
    if ((afpo.a(this.a.a.this$0) != null) && (afpo.a(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)afpo.a(this.a.a.this$0).getParent()).removeView(afpo.a(this.a.a.this$0));
    }
    afpo.a(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */