package com.tencent.mobileqq.app;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import protocol.KQQConfig.GetResourceRespInfo;

class ConfigHandler$5
  implements Runnable
{
  ConfigHandler$5(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    File localFile = new File(AppConstants.PATH_SYSTEM_BACKGROUND_CONFIG);
    try
    {
      if (HttpDownloadUtil.download(this.this$0.c, new URL(this.a), localFile))
      {
        this.this$0.notifyUI(1, true, this.b);
        return;
      }
      this.this$0.notifyUI(1, false, this.b);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label64:
      break label64;
    }
    this.this$0.notifyUI(1, false, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.5
 * JD-Core Version:    0.7.0.1
 */