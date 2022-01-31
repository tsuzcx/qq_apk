package com.tencent.biz.qrcode;

import java.util.concurrent.atomic.AtomicBoolean;
import wfc;

class CodeMaskManager$2
  implements Runnable
{
  CodeMaskManager$2(CodeMaskManager paramCodeMaskManager, CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, wfc paramwfc) {}
  
  public void run()
  {
    if (this.this$0.a) {}
    while (!this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.a.compareAndSet(false, true)) {
      return;
    }
    this.jdField_a_of_type_Wfc.a(CodeMaskManager.a(this.this$0));
    CodeMaskManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.2
 * JD-Core Version:    0.7.0.1
 */