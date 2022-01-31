package com.tencent.mobileqq.app;

import ajmo;
import ajmp;
import android.content.SharedPreferences;
import android.os.Bundle;
import batm;
import bato;
import batr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(ajmp paramajmp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    batr localbatr = ((bato)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbatr != null) && (localbatr.a(ajmo.a) == null))
    {
      Object localObject = new File(ajmo.b);
      batm localbatm = new batm(ajmo.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbatm.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbatm.i)
        {
          localbatm.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbatm.i);
          }
        }
      }
      localbatm.j = true;
      localbatm.p = false;
      localObject = new Bundle();
      localbatr.a(localbatm, this.this$0.jdField_a_of_type_Batl, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */