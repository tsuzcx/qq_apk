package com.tencent.mobileqq.activity;

import aejr;
import com.tencent.mobileqq.app.QQAppInterface;
import wwg;
import wwh;

public class Conversation$UICallBack$4
  implements Runnable
{
  public Conversation$UICallBack$4(aejr paramaejr) {}
  
  public void run()
  {
    if (((wwh)this.a.a.a.getManager(252)).a)
    {
      ((wwg)this.a.a.a.getManager(251)).a();
      this.a.a.a(new Conversation.UICallBack.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.UICallBack.4
 * JD-Core Version:    0.7.0.1
 */