package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ARScanEntryView$32
  implements DialogInterface.OnClickListener
{
  ARScanEntryView$32(ARScanEntryView paramARScanEntryView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Activity localActivity = (Activity)this.a.a;
    Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
    localActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.32
 * JD-Core Version:    0.7.0.1
 */