package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloUtilImpl$10
  implements Runnable
{
  ApolloUtilImpl$10(ApolloUtilImpl paramApolloUtilImpl, boolean paramBoolean) {}
  
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
        QLog.e("ApolloUtil", 1, "deleteApolloResource .apollo is not directory");
        FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloUtil", 1, localException, new Object[0]);
      return;
    }
    if (this.a)
    {
      FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
      return;
    }
    FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", false);
    FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/", false);
    FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/", false);
    FileUtils.a(ApolloConstant.I, false);
    com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.sBasicScript = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.10
 * JD-Core Version:    0.7.0.1
 */