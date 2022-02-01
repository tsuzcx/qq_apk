package com.tencent.mobileqq.apollo;

import amme;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public class ApolloManager$5
  implements Runnable
{
  public ApolloManager$5(amme paramamme) {}
  
  public void run()
  {
    Object localObject13 = null;
    Object localObject7 = null;
    Object localObject9 = null;
    if (this.this$0.jdField_a_of_type_OrgJsonJSONObject == null) {}
    label463:
    for (;;)
    {
      return;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
      Object localObject6;
      for (Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();; localObject6 = null) {
        for (;;)
        {
          if (localObject1 == null) {
            break label463;
          }
          localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
          ((File)localObject1).mkdirs();
          File localFile = new File((File)localObject1, "apollo_res_version_info.json");
          if (localFile.exists()) {
            localFile.delete();
          }
          localObject1 = localObject7;
          try
          {
            for (;;)
            {
              JSONObject localJSONObject = this.this$0.jdField_a_of_type_OrgJsonJSONObject;
              localObject1 = localObject7;
              try
              {
                String str = this.this$0.jdField_a_of_type_OrgJsonJSONObject.toString();
                localObject1 = localObject7;
                boolean bool = TextUtils.isEmpty(str);
                if (bool)
                {
                  if (0 == 0) {
                    break;
                  }
                  try
                  {
                    throw new NullPointerException();
                  }
                  catch (IOException localIOException1) {}
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ApolloManager", 2, localIOException1.getMessage());
                  return;
                }
              }
              finally
              {
                localObject2 = localObject7;
              }
            }
          }
          catch (FileNotFoundException localFileNotFoundException1)
          {
            for (;;)
            {
              localObject7 = null;
              Object localObject2 = localObject7;
              try
              {
                if (QLog.isColorLevel())
                {
                  localObject2 = localObject7;
                  QLog.d("ApolloManager", 2, localFileNotFoundException1.getMessage());
                }
                if (localObject7 == null) {
                  break;
                }
                try
                {
                  ((FileOutputStream)localObject7).flush();
                  ((FileOutputStream)localObject7).close();
                  return;
                }
                catch (IOException localIOException2) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloManager", 2, localIOException2.getMessage());
                return;
              }
              finally
              {
                for (;;)
                {
                  Object localObject3;
                  Object localObject10;
                  Object localObject4;
                  Object localObject5;
                  Object localObject8 = localObject6;
                  localObject6 = localObject12;
                }
              }
            }
            localObject3 = localObject7;
            localObject7 = new FileOutputStream(localFile);
            localObject3 = localObject7;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            localOutOfMemoryError1 = localOutOfMemoryError1;
            localObject7 = localFileNotFoundException1;
            localObject10 = localOutOfMemoryError1;
            localObject4 = localObject7;
            if (QLog.isColorLevel())
            {
              localObject4 = localObject7;
              QLog.d("ApolloManager", 2, localObject10.getMessage());
            }
            if (localObject7 == null) {
              break;
            }
            try
            {
              ((FileOutputStream)localObject7).flush();
              ((FileOutputStream)localObject7).close();
              return;
            }
            catch (IOException localIOException4) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloManager", 2, localIOException4.getMessage());
            return;
          }
          catch (Exception localException1)
          {
            localObject7 = localObject13;
            localObject5 = localObject7;
            if (QLog.isColorLevel())
            {
              localObject5 = localObject7;
              QLog.d("ApolloManager", 2, localException1.getMessage());
            }
            if (localObject7 == null) {
              break;
            }
            try
            {
              ((FileOutputStream)localObject7).flush();
              ((FileOutputStream)localObject7).close();
              return;
            }
            catch (IOException localIOException5) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloManager", 2, localIOException5.getMessage());
            return;
          }
          finally
          {
            for (;;)
            {
              localObject7 = localIOException5;
              localObject6 = localObject11;
              if (localObject7 != null) {}
              try
              {
                ((FileOutputStream)localObject7).flush();
                ((FileOutputStream)localObject7).close();
                throw localObject6;
              }
              catch (IOException localIOException6)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloManager", 2, localIOException6.getMessage());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.5
 * JD-Core Version:    0.7.0.1
 */