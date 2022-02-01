package com.tencent.mobileqq.activity.aio.helper;

import agtu;
import agtw;
import android.view.View;
import android.view.ViewGroup;

public class AIOShakeHelper$1$2$1
  implements Runnable
{
  public AIOShakeHelper$1$2$1(agtw paramagtw) {}
  
  public void run()
  {
    if ((agtu.a(this.a.a.this$0) != null) && (agtu.a(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)agtu.a(this.a.a.this$0).getParent()).removeView(agtu.a(this.a.a.this$0));
    }
    agtu.a(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */