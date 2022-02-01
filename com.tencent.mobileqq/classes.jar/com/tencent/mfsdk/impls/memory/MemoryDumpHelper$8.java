package com.tencent.mfsdk.impls.memory;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class MemoryDumpHelper$8
  implements Runnable
{
  MemoryDumpHelper$8(MemoryDumpHelper paramMemoryDumpHelper) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getContext().getApplicationContext(), 2, HardCodeUtil.a(2131904433), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.8
 * JD-Core Version:    0.7.0.1
 */