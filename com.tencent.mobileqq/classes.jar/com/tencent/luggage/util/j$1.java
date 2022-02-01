package com.tencent.luggage.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.core.app.ActivityCompat;

final class j$1
  implements DialogInterface.OnClickListener
{
  j$1(Activity paramActivity, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a;
    String str = this.b;
    paramInt = this.c;
    ActivityCompat.requestPermissions(paramDialogInterface, new String[] { str }, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.j.1
 * JD-Core Version:    0.7.0.1
 */