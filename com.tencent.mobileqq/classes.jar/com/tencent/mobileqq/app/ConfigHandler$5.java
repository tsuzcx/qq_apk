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
      if (HttpDownloadUtil.download(this.this$0.a, new URL(this.jdField_a_of_type_JavaLangString), localFile))
      {
        this.this$0.notifyUI(1, true, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
        return;
      }
      this.this$0.notifyUI(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.this$0.notifyUI(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.5
 * JD-Core Version:    0.7.0.1
 */