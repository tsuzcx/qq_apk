package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anqf;
import anqg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import osq;
import oss;
import osw;

public final class ReadInJoyWebRenderEngine$3
  implements Runnable
{
  public ReadInJoyWebRenderEngine$3(oss paramoss, String paramString) {}
  
  public void run()
  {
    int j = 0;
    if (!osw.a(this.jdField_a_of_type_Oss))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, " checkReinstallSoDel is false, return and wait for next load");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("native_render loadLibrary from: ").append(this.jdField_a_of_type_JavaLangString);
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (anqg.i()) {
          continue;
        }
        localStringBuilder.append("viola jsc lib not exist");
        if (this.jdField_a_of_type_Oss != null) {
          this.jdField_a_of_type_Oss.onError(osq.c);
        }
        localSharedPreferences1 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        l2 = localSharedPreferences1.getLong("js_lib", 0L);
        if (l2 <= 0L) {
          continue;
        }
        if (System.currentTimeMillis() - l2 > 120000L)
        {
          anqg.a();
          localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
        }
        osq.a(1);
      }
      catch (Throwable localThrowable)
      {
        SharedPreferences localSharedPreferences1;
        osq.a(false);
        localStringBuilder.append(localThrowable.getMessage());
        if (this.jdField_a_of_type_Oss == null) {
          continue;
        }
        this.jdField_a_of_type_Oss.onError(osq.b);
        return;
        if (anqf.i()) {
          break label470;
        }
        if (this.jdField_a_of_type_Oss == null) {
          continue;
        }
        this.jdField_a_of_type_Oss.onError(osq.d);
        SharedPreferences localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        long l2 = localSharedPreferences2.getLong("js_lib_biz", 0L);
        if (l2 <= 0L) {
          break label444;
        }
        if (System.currentTimeMillis() - l2 <= 120000L) {
          continue;
        }
        anqf.a();
        localSharedPreferences2.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
        osq.a(2);
        continue;
      }
      finally
      {
        localStringBuilder.append(", isLoaded: ").append(osq.c()).append(", cost: ").append(System.currentTimeMillis() - l1);
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      }
      localStringBuilder.append(", isLoaded: ").append(osq.c()).append(", cost: ").append(System.currentTimeMillis() - l1);
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      return;
      localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
      continue;
      label444:
      localObject.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
      continue;
      label470:
      String str1 = osw.a();
      String[] arrayOfString = anqg.a;
      int k = arrayOfString.length;
      int i = 0;
      String str2;
      File localFile;
      while (i < k)
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
          if (this.jdField_a_of_type_Oss != null) {
            this.jdField_a_of_type_Oss.onError(osq.c);
          }
          localStringBuilder.append(str2).append(" not exist");
          osq.a(1);
        }
      }
      arrayOfString = anqf.a;
      k = arrayOfString.length;
      i = j;
      while (i < k)
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
          if (this.jdField_a_of_type_Oss != null) {
            this.jdField_a_of_type_Oss.onError(osq.d);
          }
          localStringBuilder.append(str2).append(" not exist");
          osq.a(2);
        }
      }
      osq.a(true);
      if (this.jdField_a_of_type_Oss != null) {
        this.jdField_a_of_type_Oss.onFinish(osq.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.3
 * JD-Core Version:    0.7.0.1
 */