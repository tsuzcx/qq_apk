package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class LiteActivity$45
  implements DialogInterface.OnClickListener
{
  LiteActivity$45(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w(LiteActivity.jdField_a_of_type_JavaLangString, 2, "copy file error", paramDialogInterface);
      }
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.45
 * JD-Core Version:    0.7.0.1
 */