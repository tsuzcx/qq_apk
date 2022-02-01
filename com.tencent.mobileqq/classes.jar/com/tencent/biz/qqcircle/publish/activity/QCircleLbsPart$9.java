package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class QCircleLbsPart$9
  implements DialogInterface.OnClickListener
{
  QCircleLbsPart$9(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    this.a.c().startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.9
 * JD-Core Version:    0.7.0.1
 */