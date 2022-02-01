package com.tencent.mfsdk.impls.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class MemoryDumpHelper$1
  implements Runnable
{
  MemoryDumpHelper$1(MemoryDumpHelper paramMemoryDumpHelper, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    try
    {
      if (!MemoryDumpHelper.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump init dialog error!");
        }
      }
      else if (!MemoryDumpHelper.a(this.this$0).isShowing())
      {
        MemoryDumpHelper.a(this.this$0).setMessage(this.jdField_a_of_type_JavaLangString);
        MemoryDumpHelper.a(this.this$0).setPositiveButton(2131691594, new MemoryDumpHelper.1.1(this));
        MemoryDumpHelper.a(this.this$0).show();
        int i = MemoryDumpHelper.a(this.this$0).getInt("DumpCount" + AppSetting.a(), 0);
        MemoryDumpHelper.a(this.this$0).edit().putInt("DumpCount" + AppSetting.a(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.1
 * JD-Core Version:    0.7.0.1
 */