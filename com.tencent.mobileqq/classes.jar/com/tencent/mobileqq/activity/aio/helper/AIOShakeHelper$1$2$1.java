package com.tencent.mobileqq.activity.aio.helper;

import agkt;
import agkv;
import android.view.View;
import android.view.ViewGroup;

public class AIOShakeHelper$1$2$1
  implements Runnable
{
  public AIOShakeHelper$1$2$1(agkv paramagkv) {}
  
  public void run()
  {
    if ((agkt.a(this.a.a.this$0) != null) && (agkt.a(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)agkt.a(this.a.a.this$0).getParent()).removeView(agkt.a(this.a.a.this$0));
    }
    agkt.a(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */