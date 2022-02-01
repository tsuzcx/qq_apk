package com.tencent.mobileqq.activity;

import ajvr;
import ansb;
import com.tencent.mobileqq.app.QQAppInterface;

public class MainFragment$1
  implements Runnable
{
  MainFragment$1(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.a();
    }
    if (MainFragment.a(this.this$0) != null)
    {
      ((ansb)MainFragment.a(this.this$0).getManager(257)).a(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
    }
    MainFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.1
 * JD-Core Version:    0.7.0.1
 */