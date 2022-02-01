package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloUtilImpl$9
  implements Runnable
{
  ApolloUtilImpl$9(ApolloUtilImpl paramApolloUtilImpl, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
      if (!localFile.exists()) {
        return;
      }
      if (!localFile.isDirectory())
      {
        QLog.e("[cmshow]ApolloUtil", 1, "deleteApolloResource .apollo is not directory");
        FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
        return;
      }
      if (this.a)
      {
        FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
        return;
      }
      FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", false);
      FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/", false);
      FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/", false);
      FileUtils.delete(ApolloConstant.N, false);
      com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.sBasicScript = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloUtil", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.9
 * JD-Core Version:    0.7.0.1
 */