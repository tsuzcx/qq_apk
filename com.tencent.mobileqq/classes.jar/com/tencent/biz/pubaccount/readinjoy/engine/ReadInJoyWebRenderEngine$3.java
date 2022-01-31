package com.tencent.biz.pubaccount.readinjoy.engine;

import amzs;
import amzt;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import ohi;
import ohk;
import oho;

public final class ReadInJoyWebRenderEngine$3
  implements Runnable
{
  public ReadInJoyWebRenderEngine$3(ohk paramohk, String paramString) {}
  
  public void run()
  {
    if (!oho.a(this.jdField_a_of_type_Ohk))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, " checkReinstallSoDel is false, return and wait for next load");
      }
      ohi.a().set(false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("native_render loadLibrary from: ").append(this.jdField_a_of_type_JavaLangString);
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (amzt.i()) {
          continue;
        }
        localStringBuilder.append("viola jsc lib not exist");
        if (this.jdField_a_of_type_Ohk != null) {
          this.jdField_a_of_type_Ohk.onError(ohi.c);
        }
        localSharedPreferences1 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        l2 = localSharedPreferences1.getLong("js_lib", 0L);
        if (l2 <= 0L) {
          continue;
        }
        if (System.currentTimeMillis() - l2 > 120000L)
        {
          amzt.a();
          localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
        }
        ohi.a(1);
      }
      catch (Throwable localThrowable)
      {
        SharedPreferences localSharedPreferences1;
        ohi.a(false);
        localStringBuilder.append(localThrowable.getMessage());
        if (this.jdField_a_of_type_Ohk == null) {
          continue;
        }
        this.jdField_a_of_type_Ohk.onError(ohi.b);
        return;
        if (amzs.i()) {
          break label492;
        }
        if (this.jdField_a_of_type_Ohk == null) {
          continue;
        }
        this.jdField_a_of_type_Ohk.onError(ohi.d);
        SharedPreferences localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        long l2 = localSharedPreferences2.getLong("js_lib_biz", 0L);
        if (l2 <= 0L) {
          break label466;
        }
        if (System.currentTimeMillis() - l2 <= 120000L) {
          continue;
        }
        amzs.a();
        localSharedPreferences2.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
        ohi.a(2);
        continue;
      }
      finally
      {
        ohi.a().set(false);
        localStringBuilder.append(", isLoaded: ").append(ohi.c()).append(", cost: ").append(System.currentTimeMillis() - l1);
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      }
      ohi.a().set(false);
      localStringBuilder.append(", isLoaded: ").append(ohi.c()).append(", cost: ").append(System.currentTimeMillis() - l1);
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      return;
      localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
      continue;
      label466:
      localObject.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
      continue;
      label492:
      String str1 = oho.a();
      String[] arrayOfString = amzt.a;
      int j = arrayOfString.length;
      int i = 0;
      String str2;
      File localFile;
      while (i < j)
      {
        str2 = arrayOfString[i];
        localFile = new File(str1, str2);
        if (localFile.exists())
        {
          System.load(localFile.getAbsolutePath());
          i += 1;
        }
        else
        {
          if (this.jdField_a_of_type_Ohk != null) {
            this.jdField_a_of_type_Ohk.onError(ohi.c);
          }
          localStringBuilder.append(str2).append(" not exist");
          ohi.a(1);
        }
      }
      arrayOfString = amzs.a;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str2 = arrayOfString[i];
        localFile = new File(str1, str2);
        if (localFile.exists())
        {
          System.load(localFile.getAbsolutePath());
          i += 1;
        }
        else
        {
          if (this.jdField_a_of_type_Ohk != null) {
            this.jdField_a_of_type_Ohk.onError(ohi.d);
          }
          localStringBuilder.append(str2).append(" not exist");
          ohi.a(2);
        }
      }
      ohi.a(true);
      if (this.jdField_a_of_type_Ohk != null) {
        this.jdField_a_of_type_Ohk.onFinish(ohi.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.3
 * JD-Core Version:    0.7.0.1
 */