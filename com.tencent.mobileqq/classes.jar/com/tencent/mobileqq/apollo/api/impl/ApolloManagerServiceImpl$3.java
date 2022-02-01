package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class ApolloManagerServiceImpl$3
  implements Runnable
{
  ApolloManagerServiceImpl$3(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    Object localObject = null;
    label110:
    do
    {
      try
      {
        AppInterface localAppInterface = ApolloManagerServiceImpl.access$200(this.this$0);
        if (localAppInterface == null) {
          continue;
        }
        localObject = localAppInterface.getApp();
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloManager", 1, localException.getMessage());
        break label110;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]ApolloManager", 1, localOutOfMemoryError.getMessage());
      }
      localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
      ((File)localObject).mkdirs();
      localObject = new File((File)localObject, "apollo_res_version_info.json");
      if (((File)localObject).exists())
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$0.mApolloResVersionInfo = new JSONObject((String)localObject);
        }
      }
      if (this.this$0.mApolloResVersionInfo == null) {
        this.this$0.mApolloResVersionInfo = new JSONObject();
      }
      return;
    } while (localOutOfMemoryError != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */