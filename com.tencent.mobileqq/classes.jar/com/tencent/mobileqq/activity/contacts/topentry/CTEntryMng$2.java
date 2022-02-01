package com.tencent.mobileqq.activity.contacts.topentry;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class CTEntryMng$2
  implements Runnable
{
  CTEntryMng$2(CTEntryMng paramCTEntryMng, SparseArray paramSparseArray) {}
  
  public void run()
  {
    String str = CTEntryMng.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveEntryRedDot value: %s", new Object[] { str }));
    }
    ConfigUtil.a(CTEntryMng.a(this.this$0).getApp(), CTEntryMng.a(this.this$0).getCurrentUin(), "ct_entry_reddot_info", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2
 * JD-Core Version:    0.7.0.1
 */