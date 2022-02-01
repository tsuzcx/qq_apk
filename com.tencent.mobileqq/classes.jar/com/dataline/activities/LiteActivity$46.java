package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.io.IOException;
import java.io.InputStream;

class LiteActivity$46
  implements DialogInterface.OnClickListener
{
  LiteActivity$46(LiteActivity paramLiteActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.a.close();
    }
    catch (IOException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.46
 * JD-Core Version:    0.7.0.1
 */