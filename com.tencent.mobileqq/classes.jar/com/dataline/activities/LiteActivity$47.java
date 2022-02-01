package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class LiteActivity$47
  implements DialogInterface.OnClickListener
{
  LiteActivity$47(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      LiteActivity.a(this.d, this.a, this.b, this.c);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w(LiteActivity.a, 2, "copy file error", paramDialogInterface);
      }
      paramDialogInterface = this.d;
      LiteActivity.b(paramDialogInterface, paramDialogInterface.z());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.47
 * JD-Core Version:    0.7.0.1
 */