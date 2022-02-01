package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.io.IOException;
import java.io.InputStream;

class LiteActivity$44
  implements DialogInterface.OnClickListener
{
  LiteActivity$44(LiteActivity paramLiteActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.44
 * JD-Core Version:    0.7.0.1
 */