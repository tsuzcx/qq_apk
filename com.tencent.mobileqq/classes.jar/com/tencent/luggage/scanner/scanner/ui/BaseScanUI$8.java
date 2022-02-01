package com.tencent.luggage.scanner.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseScanUI$8
  implements DialogInterface.OnClickListener
{
  BaseScanUI$8(BaseScanUI paramBaseScanUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseScanUI.e(this.a, true);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.8
 * JD-Core Version:    0.7.0.1
 */