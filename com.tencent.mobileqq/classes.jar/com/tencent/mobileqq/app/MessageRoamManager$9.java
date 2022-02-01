package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import aocl;
import aocm;
import bihu;
import bihw;
import bihz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(aocm paramaocm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bihz localbihz = ((bihw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbihz != null) && (localbihz.a(aocl.a) == null))
    {
      Object localObject = new File(aocl.b);
      bihu localbihu = new bihu(aocl.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbihu.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbihu.i)
        {
          localbihu.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbihu.i);
          }
        }
      }
      localbihu.j = true;
      localbihu.p = false;
      localObject = new Bundle();
      localbihz.a(localbihu, this.this$0.jdField_a_of_type_Biht, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */