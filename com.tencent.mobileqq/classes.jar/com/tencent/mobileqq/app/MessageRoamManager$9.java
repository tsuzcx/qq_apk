package com.tencent.mobileqq.app;

import amwn;
import amwo;
import android.content.SharedPreferences;
import android.os.Bundle;
import bgoe;
import bgog;
import bgoj;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(amwo paramamwo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bgoj localbgoj = ((bgog)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbgoj != null) && (localbgoj.a(amwn.a) == null))
    {
      Object localObject = new File(amwn.b);
      bgoe localbgoe = new bgoe(amwn.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbgoe.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbgoe.i)
        {
          localbgoe.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbgoe.i);
          }
        }
      }
      localbgoe.j = true;
      localbgoe.p = false;
      localObject = new Bundle();
      localbgoj.a(localbgoe, this.this$0.jdField_a_of_type_Bgod, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */