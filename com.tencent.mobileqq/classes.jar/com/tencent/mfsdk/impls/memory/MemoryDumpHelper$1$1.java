package com.tencent.mfsdk.impls.memory;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MemoryDumpHelper$1$1
  implements DialogInterface.OnClickListener
{
  MemoryDumpHelper$1$1(MemoryDumpHelper.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MemoryDumpHelper.c(this.a.this$0);
    MemoryDumpHelper.a(this.a.this$0, false, null, this.a.b, this.a.c, false);
    MemoryDumpHelper.d(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.1.1
 * JD-Core Version:    0.7.0.1
 */