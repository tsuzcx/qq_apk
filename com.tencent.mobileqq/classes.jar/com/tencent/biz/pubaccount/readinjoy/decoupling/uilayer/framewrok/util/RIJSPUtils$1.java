package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmhv;
import com.tencent.qphone.base.util.QLog;
import pnn;

public final class RIJSPUtils$1
  implements Runnable
{
  public RIJSPUtils$1(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject = bmhv.a(pnn.a(), this.jdField_a_of_type_Boolean, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("RIJSPUtils", 2, "delete data in sp successful ! key : " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils.1
 * JD-Core Version:    0.7.0.1
 */