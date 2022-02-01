package com.tencent.mfsdk.impls.memory;

import acin;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class MemoryDumpHelper$3
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!acin.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "init dialog error!");
        }
      }
      else if (!acin.a(this.this$0).isShowing())
      {
        acin.a(this.this$0).setMessage(this.jdField_a_of_type_JavaLangString);
        acin.a(this.this$0).setPositiveButton(this.b, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        acin.a(this.this$0).show();
        int i = acin.a(this.this$0).getInt("DumpCount" + AppSetting.a(), 0);
        acin.a(this.this$0).edit().putInt("DumpCount" + AppSetting.a(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
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