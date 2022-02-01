package com.tencent.luggage.scanner.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BaseScanUI$7
  implements DialogInterface.OnClickListener
{
  BaseScanUI$7(BaseScanUI paramBaseScanUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    BaseScanUI.e(this.a, true);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.7
 * JD-Core Version:    0.7.0.1
 */