package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import anzb;
import anzc;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(anzc paramanzc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bhyt localbhyt = ((bhyq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if ((localbhyt != null) && (localbhyt.a(anzb.a) == null))
    {
      Object localObject = new File(anzb.b);
      bhyo localbhyo = new bhyo(anzb.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbhyo.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbhyo.i)
        {
          localbhyo.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbhyo.i);
          }
        }
      }
      localbhyo.j = true;
      localbhyo.p = false;
      localObject = new Bundle();
      localbhyt.a(localbhyo, this.this$0.jdField_a_of_type_Bhyn, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */