package com.tencent.hippy.qq.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mtt.hippy.modules.Promise;

class QQUiModule$4$2
  implements DialogInterface.OnCancelListener
{
  QQUiModule$4$2(QQUiModule.4 param4) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$1.val$promise.resolve("{\"button\": -1}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.4.2
 * JD-Core Version:    0.7.0.1
 */