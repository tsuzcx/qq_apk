package com.tencent.biz.qrcode;

import android.os.Bundle;

class CodeMaskManager$PrepareBundleTask$1
  implements Runnable
{
  CodeMaskManager$PrepareBundleTask$1(CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.b.this$0.h) {
      return;
    }
    if (this.a == null) {
      this.b.b.a(CodeMaskManager.a(this.b.this$0));
    } else {
      this.b.b.a((Bundle)this.a.clone());
    }
    CodeMaskManager.b(this.b.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask.1
 * JD-Core Version:    0.7.0.1
 */