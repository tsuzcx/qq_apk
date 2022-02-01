package com.tencent.mobileqq.app;

import anxu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;

public class UniteSearchHandler$1
  implements Runnable
{
  public UniteSearchHandler$1(anxu paramanxu, String paramString, Object paramObject) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = BaseApplication.getContext().openFileOutput(this.jdField_a_of_type_JavaLangString, 0);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.write((byte[])this.jdField_a_of_type_JavaLangObject);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.flush();
      }
      catch (IOException localIOException4)
      {
        FileOutputStream localFileOutputStream;
        localObject3 = localIOException1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localIOException1;
        QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, QLog.getStackTraceString(localIOException4));
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return;
        }
        catch (IOException localIOException2) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, QLog.getStackTraceString(localIOException2));
        return;
      }
      finally
      {
        if (localObject3 == null) {
          break label126;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, QLog.getStackTraceString(localIOException1));
          return;
        }
      }
    }
    try
    {
      localObject3.close();
      label126:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, QLog.getStackTraceString(localIOException3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchHandler.1
 * JD-Core Version:    0.7.0.1
 */