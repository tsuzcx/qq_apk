package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bakz;
import bgmq;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import obz;

public final class ReadInJoyUtils$10
  implements Runnable
{
  public ReadInJoyUtils$10(Object paramObject, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new ByteArrayOutputStream();
      Object localObject2 = new ObjectOutputStream((OutputStream)localObject1);
      ((ObjectOutputStream)localObject2).writeObject(this.jdField_a_of_type_JavaLangObject);
      ((ObjectOutputStream)localObject2).flush();
      ((ObjectOutputStream)localObject2).close();
      localObject1 = bakz.a(((ByteArrayOutputStream)localObject1).toByteArray());
      localObject2 = bgmq.a(obz.a(), true, this.jdField_a_of_type_Boolean);
      if (localObject2 != null)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putString(this.jdField_a_of_type_JavaLangString, (String)localObject1);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      QLog.d("ReadInJoyUtils", 2, "writeDataToSP successful !  key : " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReadInJoyUtils", 2, "write hb info to storage , error : " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.10
 * JD-Core Version:    0.7.0.1
 */