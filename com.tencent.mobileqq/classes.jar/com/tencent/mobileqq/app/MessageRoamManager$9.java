package com.tencent.mobileqq.app;

import akax;
import akay;
import android.content.SharedPreferences;
import android.os.Bundle;
import bbwg;
import bbwi;
import bbwl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(akay paramakay) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bbwl localbbwl = ((bbwi)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbbwl != null) && (localbbwl.a(akax.a) == null))
    {
      Object localObject = new File(akax.b);
      bbwg localbbwg = new bbwg(akax.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbbwg.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbbwg.i)
        {
          localbbwg.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbbwg.i);
          }
        }
      }
      localbbwg.j = true;
      localbbwg.p = false;
      localObject = new Bundle();
      localbbwl.a(localbbwg, this.this$0.jdField_a_of_type_Bbwf, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */