package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class ScannerView$1
  extends Handler
{
  ScannerView$1(ScannerView paramScannerView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      paramMessage = Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131690796), 1);
      paramMessage.setGravity(17, 0, 0);
      paramMessage.show();
    }
    Object localObject;
    do
    {
      return;
      localObject = ScannerView.a(this.a);
      if (localObject != null) {}
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        localObject = ScannerView.a(this.a);
        if (localObject != null) {}
        switch (paramMessage.what)
        {
        default: 
          localObject = ScannerView.a(this.a);
        }
        break;
      }
    } while (localObject == null);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((ScannerView.FlashLightListener)localObject).a(bool);
      return;
      ((ScannerView.ScannerListener)localObject).a(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.ScannerListener)localObject).c();
      return;
      ((ScannerView.ScannerListener)localObject).b();
      return;
      ((ScannerView.ScannerListener)localObject).a();
      return;
      ((ScannerView.FileDecodeListener)localObject).a(String.valueOf(paramMessage.obj), 1, 1);
      return;
      ((ScannerView.FileDecodeListener)localObject).b(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.1
 * JD-Core Version:    0.7.0.1
 */