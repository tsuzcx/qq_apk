package com.tencent.biz.pubaccount.readinjoy.model;

import akms;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bkwm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pwr;
import ucy;
import uda;
import ugf;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = uda.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ucy localucy = (ucy)((Iterator)localObject).next();
      if (localucy.a != null)
      {
        localucy.b = 0;
        int i = ugf.b((QQAppInterface)this.this$0.a, localucy.a);
        akms.b((QQAppInterface)this.this$0.a, localucy.a, i);
        ((QQAppInterface)this.this$0.a).getMessageFacade().setReaded(localucy.a, 1008);
      }
    }
    localObject = bkwm.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    pwr.a(this.this$0, false);
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