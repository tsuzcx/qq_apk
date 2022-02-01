package com.tencent.luggage.scanner.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BaseScanUI$5
  implements DialogInterface.OnClickListener
{
  BaseScanUI$5(BaseScanUI paramBaseScanUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    BaseScanUI.e(this.a, true);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.5
 * JD-Core Version:    0.7.0.1
 */