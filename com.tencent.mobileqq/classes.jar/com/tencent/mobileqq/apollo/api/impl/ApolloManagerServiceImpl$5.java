package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class ApolloManagerServiceImpl$5
  implements Runnable
{
  ApolloManagerServiceImpl$5(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      QQAppInterface localQQAppInterface = ApolloManagerServiceImpl.access$300(this.this$0);
      if (localQQAppInterface == null) {
        break label147;
      }
      localObject = localQQAppInterface.getApp();
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
      localObject = FileUtils.b((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.mApolloResVersionInfo = new JSONObject((String)localObject);
      }
    }
    if (this.this$0.mApolloResVersionInfo == null)
    {
      this.this$0.mApolloResVersionInfo = new JSONObject();
      return;
    }
    label147:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */