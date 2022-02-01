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
    int i = paramMessage.what;
    boolean bool2 = false;
    if (i == 9)
    {
      paramMessage = Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131690724), 1);
      paramMessage.setGravity(17, 0, 0);
      paramMessage.show();
      return;
    }
    Object localObject = ScannerView.a(this.a);
    if (localObject != null)
    {
      i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 7)
          {
            if (i == 8) {
              ((ScannerView.ScannerListener)localObject).b();
            }
          }
          else {
            ((ScannerView.ScannerListener)localObject).a();
          }
        }
        else {
          ((ScannerView.ScannerListener)localObject).c();
        }
      }
      else
      {
        ((ScannerView.ScannerListener)localObject).a(String.valueOf(paramMessage.obj));
        return;
      }
    }
    localObject = ScannerView.a(this.a);
    if (localObject != null)
    {
      i = paramMessage.what;
      if (i != 3)
      {
        if (i == 4) {
          ((ScannerView.FileDecodeListener)localObject).b(1);
        }
      }
      else
      {
        ((ScannerView.FileDecodeListener)localObject).a(String.valueOf(paramMessage.obj), 1, 1);
        return;
      }
    }
    localObject = ScannerView.a(this.a);
    if (localObject != null)
    {
      if (paramMessage.what != 10) {
        return;
      }
      boolean bool1 = bool2;
      if ((paramMessage.obj instanceof Boolean))
      {
        bool1 = bool2;
        if (((Boolean)paramMessage.obj).booleanValue()) {
          bool1 = true;
        }
      }
      ((ScannerView.FlashLightListener)localObject).a(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.1
 * JD-Core Version:    0.7.0.1
 */