package com.tencent.mobileqq.app;

import ajud;
import apug;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$4
  implements Runnable
{
  public ConfigHandler$4(ajud paramajud, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    apug.a(this.this$0.app, MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.4
 * JD-Core Version:    0.7.0.1
 */