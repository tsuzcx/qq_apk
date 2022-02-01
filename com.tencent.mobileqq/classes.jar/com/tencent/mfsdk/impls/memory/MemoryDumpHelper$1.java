package com.tencent.mfsdk.impls.memory;

import acyw;
import acyx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class MemoryDumpHelper$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!acyw.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump init dialog error!");
        }
      }
      else if (!acyw.a(this.this$0).isShowing())
      {
        acyw.a(this.this$0).setMessage(this.a);
        acyw.a(this.this$0).setPositiveButton(2131691481, new acyx(this));
        acyw.a(this.this$0).show();
        int i = acyw.a(this.this$0).getInt("DumpCount" + AppSetting.a(), 0);
        acyw.a(this.this$0).edit().putInt("DumpCount" + AppSetting.a(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
        if (QLog.isColorLevel())
        {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump have show dump dialog");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump startDumpingMemory Exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.1
 * JD-Core Version:    0.7.0.1
 */