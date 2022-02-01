package com.tencent.mobileqq.app;

import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import protocol.KQQConfig.GetResourceRespInfo;

class ConfigHandler$4
  implements Runnable
{
  ConfigHandler$4(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    ((IFMConfig)QRoute.api(IFMConfig.class)).updatePreviewList(this.this$0.c, MsfSdkUtils.insertMtype("ConfigCheck", this.a), this.b.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.4
 * JD-Core Version:    0.7.0.1
 */