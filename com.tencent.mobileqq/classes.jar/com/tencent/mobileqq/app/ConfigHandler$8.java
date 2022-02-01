package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;

class ConfigHandler$8
  implements Runnable
{
  ConfigHandler$8(ConfigHandler paramConfigHandler, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (!ConfigHandler.a(this.this$0, this.a.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (AioAnimationConfigHelper.a().a() != null) {
      return;
    }
    AioAnimationConfigHelper.a().a(this.this$0.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.8
 * JD-Core Version:    0.7.0.1
 */