package com.tencent.biz.qrcode;

import android.os.Bundle;

class CodeMaskManager$PrepareBundleTask$1
  implements Runnable
{
  CodeMaskManager$PrepareBundleTask$1(CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.this$0.a) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.a.a(CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.this$0));
    } else {
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.a.a((Bundle)this.jdField_a_of_type_AndroidOsBundle.clone());
    }
    CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask.1
 * JD-Core Version:    0.7.0.1
 */