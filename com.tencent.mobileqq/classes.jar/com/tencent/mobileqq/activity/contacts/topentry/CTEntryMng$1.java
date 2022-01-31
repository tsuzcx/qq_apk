package com.tencent.mobileqq.activity.contacts.topentry;

import afry;
import bbkb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class CTEntryMng$1
  implements Runnable
{
  public CTEntryMng$1(afry paramafry) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "read sp and init config");
    }
    String str = bbkb.a(afry.a(this.this$0).getApp(), afry.a(this.this$0).c(), "contact_top_entry_config");
    afry.a(this.this$0, false, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1
 * JD-Core Version:    0.7.0.1
 */