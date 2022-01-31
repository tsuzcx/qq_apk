package com.tencent.mobileqq.app;

import alqf;
import arrr;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$4
  implements Runnable
{
  public ConfigHandler$4(alqf paramalqf, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    arrr.a(this.this$0.app, MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.4
 * JD-Core Version:    0.7.0.1
 */