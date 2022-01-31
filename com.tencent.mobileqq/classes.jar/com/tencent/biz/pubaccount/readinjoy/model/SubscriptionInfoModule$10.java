package com.tencent.biz.pubaccount.readinjoy.model;

import ahpf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pbu;
import sdd;
import sdf;
import sgj;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = sdf.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      sdd localsdd = (sdd)((Iterator)localObject).next();
      if (localsdd.a != null)
      {
        localsdd.b = 0;
        int i = sgj.b((QQAppInterface)this.this$0.a, localsdd.a);
        ahpf.b((QQAppInterface)this.this$0.a, localsdd.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localsdd.a, 1008);
      }
    }
    localObject = bhvh.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    pbu.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */