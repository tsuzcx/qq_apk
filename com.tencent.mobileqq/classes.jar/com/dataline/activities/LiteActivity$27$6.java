package com.dataline.activities;

import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;

class LiteActivity$27$6
  implements Runnable
{
  LiteActivity$27$6(LiteActivity.27 param27, int paramInt) {}
  
  public void run()
  {
    this.b.a.m.notifyDataSetChanged();
    LiteActivity.a(this.b.a.g, this.b.a.f);
    LiteActivity.a(this.b.a.f);
    this.b.a.app.getMessageFacade().d(this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.6
 * JD-Core Version:    0.7.0.1
 */