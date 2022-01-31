package com.tencent.mobileqq.app;

import akav;
import akaw;
import android.content.SharedPreferences;
import android.os.Bundle;
import bbwu;
import bbww;
import bbwz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(akaw paramakaw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bbwz localbbwz = ((bbww)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbbwz != null) && (localbbwz.a(akav.a) == null))
    {
      Object localObject = new File(akav.b);
      bbwu localbbwu = new bbwu(akav.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbbwu.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbbwu.i)
        {
          localbbwu.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbbwu.i);
          }
        }
      }
      localbbwu.j = true;
      localbbwu.p = false;
      localObject = new Bundle();
      localbbwz.a(localbbwu, this.this$0.jdField_a_of_type_Bbwt, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */