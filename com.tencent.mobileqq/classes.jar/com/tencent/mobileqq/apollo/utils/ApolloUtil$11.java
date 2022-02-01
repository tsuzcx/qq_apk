package com.tencent.mobileqq.apollo.utils;

import anka;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ApolloUtil$11
  implements Runnable
{
  ApolloUtil$11(boolean paramBoolean) {}
  
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
        FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
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
      FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", false);
      return;
    }
    FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", false);
    FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/", false);
    FileUtils.delete("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/", false);
    FileUtils.delete(anka.I, false);
    amme.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.11
 * JD-Core Version:    0.7.0.1
 */