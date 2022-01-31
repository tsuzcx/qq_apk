package com.tencent.mobileqq.activity.contacts.topentry;

import afry;
import android.util.SparseArray;
import bbcx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class CTEntryMng$2
  implements Runnable
{
  public CTEntryMng$2(afry paramafry, SparseArray paramSparseArray) {}
  
  public void run()
  {
    String str = afry.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveEntryRedDot value: %s", new Object[] { str }));
    }
    bbcx.a(afry.a(this.this$0).getApp(), afry.a(this.this$0).c(), "ct_entry_reddot_info", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2
 * JD-Core Version:    0.7.0.1
 */