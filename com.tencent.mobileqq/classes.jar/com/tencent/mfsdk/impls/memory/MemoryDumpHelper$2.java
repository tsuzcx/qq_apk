package com.tencent.mfsdk.impls.memory;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MemoryDumpHelper$2
  implements DialogInterface.OnClickListener
{
  MemoryDumpHelper$2(MemoryDumpHelper paramMemoryDumpHelper, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MemoryDumpHelper.c(this.b);
    MemoryDumpHelper.a(this.b, true, this.a, null, -1L, false);
    MemoryDumpHelper.d(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.2
 * JD-Core Version:    0.7.0.1
 */