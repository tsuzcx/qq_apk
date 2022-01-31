package com.tencent.mobileqq.activity;

import aceg;
import android.view.View;
import android.view.ViewGroup;

public class BaseChatPie$84$2$1
  implements Runnable
{
  public BaseChatPie$84$2$1(aceg paramaceg) {}
  
  public void run()
  {
    if ((BaseChatPie.b(this.a.a.this$0) != null) && (BaseChatPie.b(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)BaseChatPie.b(this.a.a.this$0).getParent()).removeView(BaseChatPie.b(this.a.a.this$0));
    }
    BaseChatPie.b(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.84.2.1
 * JD-Core Version:    0.7.0.1
 */