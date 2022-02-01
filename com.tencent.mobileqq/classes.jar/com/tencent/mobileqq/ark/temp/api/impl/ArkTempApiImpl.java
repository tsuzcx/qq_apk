package com.tencent.mobileqq.ark.temp.api.impl;

import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.ark.temp.api.IArkTempApi;

public class ArkTempApiImpl
  implements IArkTempApi
{
  public String getCurrentAppConfig()
  {
    return ArkAppCenterUtil.c();
  }
  
  public void initArkEnv() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.temp.api.impl.ArkTempApiImpl
 * JD-Core Version:    0.7.0.1
 */