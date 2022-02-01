package com.tencent.biz.qrcode;

import java.util.concurrent.atomic.AtomicBoolean;

class CodeMaskManager$2
  implements Runnable
{
  CodeMaskManager$2(CodeMaskManager paramCodeMaskManager, CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, CodeMaskManager.Callback paramCallback) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.a.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback.a(CodeMaskManager.a(this.this$0));
      CodeMaskManager.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.2
 * JD-Core Version:    0.7.0.1
 */