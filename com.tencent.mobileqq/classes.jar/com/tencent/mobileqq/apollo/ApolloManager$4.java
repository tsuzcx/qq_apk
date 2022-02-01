package com.tencent.mobileqq.apollo;

import amme;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ApolloManager$4
  implements Runnable
{
  public ApolloManager$4(amme paramamme) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label151;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, localException.getMessage());
          }
        }
      } while (localException != null);
    }
    localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
    ((File)localObject).mkdirs();
    localObject = new File((File)localObject, "apollo_res_version_info.json");
    if (((File)localObject).exists())
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
      }
    }
    if (this.this$0.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      this.this$0.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      return;
    }
    label151:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.4
 * JD-Core Version:    0.7.0.1
 */