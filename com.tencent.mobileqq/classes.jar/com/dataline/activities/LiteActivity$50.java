package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LiteActivity$50
  implements DialogInterface.OnDismissListener
{
  LiteActivity$50(LiteActivity paramLiteActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LiteActivity.j(this.a))
    {
      LiteActivity.b(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.50
 * JD-Core Version:    0.7.0.1
 */