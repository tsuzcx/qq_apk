package com.tencent.biz.pubaccount.readinjoy.model;

import alik;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmhv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qhx;
import uqv;
import uqx;
import uuc;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = uqx.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uqv localuqv = (uqv)((Iterator)localObject).next();
      if (localuqv.a != null)
      {
        localuqv.b = 0;
        int i = uuc.b((QQAppInterface)this.this$0.a, localuqv.a);
        alik.b((QQAppInterface)this.this$0.a, localuqv.a, i);
        ((QQAppInterface)this.this$0.a).getMessageFacade().setReaded(localuqv.a, 1008);
      }
    }
    localObject = bmhv.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    qhx.a(this.this$0, false);
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