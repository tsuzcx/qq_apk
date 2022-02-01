package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class IndividualRedPacketManager$2
  implements Runnable
{
  IndividualRedPacketManager$2(IndividualRedPacketManager paramIndividualRedPacketManager) {}
  
  public void run()
  {
    String str1 = "font";
    Object localObject1 = str1;
    try
    {
      String[] arrayOfString = new String[4];
      localObject1 = str1;
      Object localObject3 = IndividualRedPacketManager.a(5);
      int i = 0;
      arrayOfString[0] = localObject3;
      localObject1 = str1;
      arrayOfString[1] = IndividualRedPacketManager.a(6);
      localObject1 = str1;
      arrayOfString[2] = IndividualRedPacketManager.a(7);
      localObject1 = str1;
      arrayOfString[3] = IndividualRedPacketManager.a(8);
      for (;;)
      {
        localObject1 = str1;
        if (i >= arrayOfString.length) {
          break;
        }
        localObject1 = str1;
        str1 = new String[] { "font", "aio", "tp", "send" }[i];
        localObject1 = str1;
        localObject3 = new File(arrayOfString[i]);
        localObject1 = str1;
        if (((File)localObject3).exists())
        {
          localObject1 = str1;
          if (((File)localObject3).isDirectory())
          {
            localObject1 = str1;
            File[] arrayOfFile = ((File)localObject3).listFiles();
            if (arrayOfFile != null)
            {
              localObject1 = str1;
              if (arrayOfFile.length > 150)
              {
                localObject1 = str1;
                Arrays.sort(arrayOfFile, this.this$0.v);
                int j = 100;
                for (;;)
                {
                  localObject1 = str1;
                  if (j < arrayOfFile.length)
                  {
                    localObject1 = str1;
                    localObject3 = this.this$0.r;
                    localObject1 = str1;
                    try
                    {
                      this.this$0.r.add(arrayOfFile[j].getAbsolutePath());
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(arrayOfFile[j].getParent());
                      ((StringBuilder)localObject1).append(File.separator);
                      ((StringBuilder)localObject1).append(System.currentTimeMillis());
                      localObject1 = new File(((StringBuilder)localObject1).toString());
                      arrayOfFile[j].renameTo((File)localObject1);
                      ((File)localObject1).delete();
                      this.this$0.r.remove(arrayOfFile[j].getAbsolutePath());
                      j += 1;
                    }
                    finally
                    {
                      localObject1 = str1;
                    }
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      String str2;
      HashMap localHashMap;
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        str2 = IndividualRedPacketManager.i();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("eliminateImageCache error: ");
        ((StringBuilder)localObject3).append(localException2.getMessage());
        ((StringBuilder)localObject3).append(", in step=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.e(str2, 2, ((StringBuilder)localObject3).toString());
      }
      try
      {
        localHashMap = new HashMap();
        localHashMap.put("param_FailCode", localObject1);
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketClearCacheError", false, 1L, 0L, localHashMap, "", false);
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.2
 * JD-Core Version:    0.7.0.1
 */