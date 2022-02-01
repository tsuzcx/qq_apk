package com.tencent.hippy.qq.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mtt.hippy.modules.Promise;

class QQUiModule$4$1
  implements DialogInterface.OnClickListener
{
  QQUiModule$4$1(QQUiModule.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      this.this$1.val$promise.resolve("{\"button\":1}");
    }
    while (paramInt != 1) {
      return;
    }
    this.this$1.val$promise.resolve("{\"button\":0}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.4.1
 * JD-Core Version:    0.7.0.1
 */