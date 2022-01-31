package com.tencent.mobileqq.app;

import alwz;
import alxa;
import android.content.SharedPreferences;
import android.os.Bundle;
import beae;
import beag;
import beaj;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(alxa paramalxa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    beaj localbeaj = ((beag)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbeaj != null) && (localbeaj.a(alwz.a) == null))
    {
      Object localObject = new File(alwz.b);
      beae localbeae = new beae(alwz.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbeae.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbeae.i)
        {
          localbeae.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbeae.i);
          }
        }
      }
      localbeae.j = true;
      localbeae.p = false;
      localObject = new Bundle();
      localbeaj.a(localbeae, this.this$0.jdField_a_of_type_Bead, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */