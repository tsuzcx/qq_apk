package com.tencent.mobileqq.app;

import aeqc;
import allq;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$8
  implements Runnable
{
  public ConfigHandler$8(allq paramallq, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (!allq.a(this.this$0, this.a.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (aeqc.a().a() != null) {
      return;
    }
    aeqc.a().a(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.8
 * JD-Core Version:    0.7.0.1
 */