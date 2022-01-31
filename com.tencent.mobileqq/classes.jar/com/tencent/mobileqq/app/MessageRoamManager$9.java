package com.tencent.mobileqq.app;

import alsk;
import alsl;
import android.content.SharedPreferences;
import android.os.Bundle;
import bdvv;
import bdvx;
import bdwa;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(alsl paramalsl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    bdwa localbdwa = ((bdvx)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if ((localbdwa != null) && (localbdwa.a(alsk.a) == null))
    {
      Object localObject = new File(alsk.b);
      bdvv localbdvv = new bdvv(alsk.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localbdvv.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localbdvv.i)
        {
          localbdvv.m = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localbdvv.i);
          }
        }
      }
      localbdvv.j = true;
      localbdvv.p = false;
      localObject = new Bundle();
      localbdwa.a(localbdvv, this.this$0.jdField_a_of_type_Bdvu, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */