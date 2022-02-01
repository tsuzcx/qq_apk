package com.tencent.mfsdk.impls.memory;

import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class MemoryDumpHelper$4
  implements Runnable
{
  MemoryDumpHelper$4(MemoryDumpHelper paramMemoryDumpHelper, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    try
    {
      if (!MemoryDumpHelper.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "init dialog error!");
        }
      }
      else if (!MemoryDumpHelper.a(this.this$0).isShowing())
      {
        MemoryDumpHelper.a(this.this$0).setMessage(this.jdField_a_of_type_JavaLangString);
        MemoryDumpHelper.a(this.this$0).setPositiveButton(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        MemoryDumpHelper.a(this.this$0).setNegativeButton(2131690800, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
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
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump startDumpingMemoryLeak Exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.4
 * JD-Core Version:    0.7.0.1
 */