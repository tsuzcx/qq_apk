package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

class QCircleLbsPart$11
  implements DialogInterface.OnClickListener
{
  QCircleLbsPart$11(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    paramDialogInterface.setData(Uri.fromParts("package", this.a.c().getPackageName(), null));
    this.a.c().startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.11
 * JD-Core Version:    0.7.0.1
 */