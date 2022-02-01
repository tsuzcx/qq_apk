package com.tencent.mobileqq.activity;

import adyo;
import com.tencent.mobileqq.app.QQAppInterface;
import wsl;
import wsm;

public class Conversation$1$4
  implements Runnable
{
  public Conversation$1$4(adyo paramadyo) {}
  
  public void run()
  {
    if (((wsm)this.a.a.a.getManager(252)).a)
    {
      ((wsl)this.a.a.a.getManager(251)).a();
      this.a.a.a(new Conversation.1.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.4
 * JD-Core Version:    0.7.0.1
 */