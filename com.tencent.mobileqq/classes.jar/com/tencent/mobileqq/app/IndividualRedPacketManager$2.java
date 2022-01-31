package com.tencent.mobileqq.app;

import alvg;
import azri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class IndividualRedPacketManager$2
  implements Runnable
{
  public IndividualRedPacketManager$2(alvg paramalvg) {}
  
  public void run()
  {
    int i = 0;
    String str = "font";
    Object localObject1 = str;
    try
    {
      arrayOfString = new String[4];
      localObject1 = str;
      arrayOfString[0] = alvg.a(5);
      localObject1 = str;
      arrayOfString[1] = alvg.a(6);
      localObject1 = str;
      arrayOfString[2] = alvg.a(7);
      localObject1 = str;
      arrayOfString[3] = alvg.a(8);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String[] arrayOfString;
        Object localObject3;
        File[] arrayOfFile;
        int j;
        if (QLog.isColorLevel()) {
          QLog.e(alvg.b(), 2, "eliminateImageCache error: " + localException2.getMessage() + ", in step=" + (String)localObject1);
        }
        label425:
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_FailCode", localObject1);
          azri.a(BaseApplicationImpl.sApplication.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketClearCacheError", false, 1L, 0L, localHashMap, "", false);
          return;
        }
        catch (Exception localException1) {}
        i += 1;
      }
    }
    localObject1 = str;
    if (i < arrayOfString.length)
    {
      localObject1 = str;
      str = new String[] { "font", "aio", "tp", "send" }[i];
      localObject1 = str;
      localObject3 = new File(arrayOfString[i]);
      localObject1 = str;
      if (!((File)localObject3).exists()) {
        break label425;
      }
      localObject1 = str;
      if (!((File)localObject3).isDirectory()) {
        break label425;
      }
      localObject1 = str;
      arrayOfFile = ((File)localObject3).listFiles();
      if (arrayOfFile == null) {
        break label425;
      }
      localObject1 = str;
      if (arrayOfFile.length <= 150) {
        break label425;
      }
      localObject1 = str;
      Arrays.sort(arrayOfFile, this.this$0.jdField_a_of_type_JavaUtilComparator);
      j = 100;
      for (;;)
      {
        localObject1 = str;
        if (j < arrayOfFile.length)
        {
          localObject1 = str;
          localObject3 = this.this$0.jdField_a_of_type_JavaUtilLinkedList;
          localObject1 = str;
          try
          {
            this.this$0.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile[j].getAbsolutePath());
            localObject1 = new File(arrayOfFile[j].getParent() + File.separator + System.currentTimeMillis());
            arrayOfFile[j].renameTo((File)localObject1);
            ((File)localObject1).delete();
            this.this$0.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile[j].getAbsolutePath());
            j += 1;
          }
          finally
          {
            localObject1 = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.2
 * JD-Core Version:    0.7.0.1
 */