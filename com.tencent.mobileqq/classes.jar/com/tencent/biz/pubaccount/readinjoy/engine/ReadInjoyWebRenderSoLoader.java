package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.debug.io.tools.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReadInjoyWebRenderSoLoader
{
  private static int jdField_a_of_type_Int;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "";
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = ((File)localObject).getParent() + "/txlib/" + "readinjoy_viola/";
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      label65:
      QLog.w("viola.ReadInjoyWebRenderSoLoader", 2, "getSoLibPath but context is null");
    }
  }
  
  public static void a()
  {
    QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "[delAllSo]");
    try
    {
      FileUtil.deleteAllFilesOfDir(new File(a()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  public static boolean a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a();
      boolean bool = TextUtils.isEmpty(jdField_a_of_type_JavaLangString);
      if (!bool) {}
      try
      {
        a();
        jdField_a_of_type_Int = 1;
        FileUtils.a(paramString, jdField_a_of_type_JavaLangString, false);
        jdField_a_of_type_Int = 0;
        QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "succeed to unzip so.");
        if (jdField_a_of_type_Int == 0) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          jdField_a_of_type_Int = 2;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, paramString, new Object[0]);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader
 * JD-Core Version:    0.7.0.1
 */