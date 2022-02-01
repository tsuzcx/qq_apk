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
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("QAPM_MemoryDumpHelper", 2, "init dialog error!");
        return;
      }
      if (!MemoryDumpHelper.a(this.this$0).isShowing())
      {
        MemoryDumpHelper.a(this.this$0).setMessage(this.jdField_a_of_type_JavaLangString);
        MemoryDumpHelper.a(this.this$0).setPositiveButton(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        MemoryDumpHelper.a(this.this$0).setNegativeButton(2131690728, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
        MemoryDumpHelper.a(this.this$0).show();
        Object localObject = MemoryDumpHelper.a(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DumpCount");
        localStringBuilder.append(AppSetting.a());
        int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
        localObject = MemoryDumpHelper.a(this.this$0).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DumpCount");
        localStringBuilder.append(AppSetting.a());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
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
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.4
 * JD-Core Version:    0.7.0.1
 */