package com.tencent.mobileqq.activity.home;

import ajdm;
import com.tencent.mobileqq.app.QQAppInterface;
import vxw;
import vxx;

public class Conversation$UICallBack$4
  implements Runnable
{
  public Conversation$UICallBack$4(ajdm paramajdm) {}
  
  public void run()
  {
    if (((vxx)this.a.a.a.getManager(252)).a)
    {
      ((vxw)this.a.a.a.getManager(251)).a();
      this.a.a.b(new Conversation.UICallBack.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.4
 * JD-Core Version:    0.7.0.1
 */