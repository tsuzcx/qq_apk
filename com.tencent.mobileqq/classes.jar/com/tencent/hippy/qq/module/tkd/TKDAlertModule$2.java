package com.tencent.hippy.qq.module.tkd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mtt.hippy.modules.Promise;

class TKDAlertModule$2
  implements DialogInterface.OnClickListener
{
  TKDAlertModule$2(TKDAlertModule paramTKDAlertModule, Promise paramPromise) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.val$promise.resolve(Integer.valueOf(1));
      return;
    }
    this.val$promise.resolve(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDAlertModule.2
 * JD-Core Version:    0.7.0.1
 */