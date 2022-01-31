package com.tencent.mobileqq.activity.contacts.topentry;

import afsa;
import bbjn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class CTEntryMng$1
  implements Runnable
{
  public CTEntryMng$1(afsa paramafsa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "read sp and init config");
    }
    String str = bbjn.a(afsa.a(this.this$0).getApp(), afsa.a(this.this$0).c(), "contact_top_entry_config");
    afsa.a(this.this$0, false, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1
 * JD-Core Version:    0.7.0.1
 */