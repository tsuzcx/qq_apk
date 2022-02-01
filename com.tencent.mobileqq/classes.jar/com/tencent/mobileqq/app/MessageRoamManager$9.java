package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import anqf;
import anqg;
import bhhf;
import bhhh;
import bhhk;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(anqg paramanqg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bhhk localbhhk = ((bhhh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbhhk != null) && (localbhhk.a(anqf.a) == null))
    {
      Object localObject = new File(anqf.b);
      bhhf localbhhf = new bhhf(anqf.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbhhf.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbhhf.i)
        {
          localbhhf.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbhhf.i);
          }
        }
      }
      localbhhf.j = true;
      localbhhf.p = false;
      localObject = new Bundle();
      localbhhk.a(localbhhf, this.this$0.jdField_a_of_type_Bhhe, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */