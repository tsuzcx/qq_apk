package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bkbq;
import com.tencent.qphone.base.util.QLog;
import ors;

public final class ReadInJoyUtils$9
  implements Runnable
{
  public ReadInJoyUtils$9(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject = bkbq.a(ors.a(), this.jdField_a_of_type_Boolean, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("ReadInJoyUtils", 2, "delete data in sp successful ! key : " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.9
 * JD-Core Version:    0.7.0.1
 */