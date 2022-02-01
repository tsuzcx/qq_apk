package com.tencent.mfsdk.impls.memory;

import adcw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgpa;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

public class MemoryDumpHelper$3
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!adcw.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "init dialog error!");
        }
      }
      else if (!adcw.a(this.this$0).isShowing())
      {
        adcw.a(this.this$0).setMessage(this.jdField_a_of_type_JavaLangString);
        adcw.a(this.this$0).setPositiveButton(this.b, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        adcw.a(this.this$0).show();
        int i = adcw.a(this.this$0).getInt("DumpCount" + AppSetting.a(), 0);
        adcw.a(this.this$0).edit().putInt("DumpCount" + AppSetting.a(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
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
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump startDumpingMemoryLeak Exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.3
 * JD-Core Version:    0.7.0.1
 */