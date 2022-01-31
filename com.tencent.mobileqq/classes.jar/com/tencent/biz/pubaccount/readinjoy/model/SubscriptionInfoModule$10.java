package com.tencent.biz.pubaccount.readinjoy.model;

import ajlb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bkbq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import phd;
import sut;
import suv;
import syb;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = suv.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      sut localsut = (sut)((Iterator)localObject).next();
      if (localsut.a != null)
      {
        localsut.b = 0;
        int i = syb.b((QQAppInterface)this.this$0.a, localsut.a);
        ajlb.b((QQAppInterface)this.this$0.a, localsut.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localsut.a, 1008);
      }
    }
    localObject = bkbq.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    phd.a(this.this$0, false);
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