package com.tencent.mobileqq.app;

import aeur;
import alqf;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$8
  implements Runnable
{
  public ConfigHandler$8(alqf paramalqf, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (!alqf.a(this.this$0, this.a.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (aeur.a().a() != null) {
      return;
    }
    aeur.a().a(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.8
 * JD-Core Version:    0.7.0.1
 */