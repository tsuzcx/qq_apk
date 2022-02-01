package com.tencent.mobileqq.app;

import ansg;
import atpj;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$4
  implements Runnable
{
  public ConfigHandler$4(ansg paramansg, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    atpj.a(this.this$0.app, MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.4
 * JD-Core Version:    0.7.0.1
 */