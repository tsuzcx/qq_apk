package com.tencent.biz.pubaccount.readinjoy.model;

import aldk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmqa;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pyn;
import twg;
import twi;
import tzo;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = twi.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      twg localtwg = (twg)((Iterator)localObject).next();
      if (localtwg.a != null)
      {
        localtwg.b = 0;
        int i = tzo.b((QQAppInterface)this.this$0.a, localtwg.a);
        aldk.b((QQAppInterface)this.this$0.a, localtwg.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localtwg.a, 1008);
      }
    }
    localObject = bmqa.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    pyn.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */