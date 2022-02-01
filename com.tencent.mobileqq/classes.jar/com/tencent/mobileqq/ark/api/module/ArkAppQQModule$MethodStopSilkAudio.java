package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$MethodStopSilkAudio
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodStopSilkAudio(ArkAppQQModule paramArkAppQQModule)
  {
    super(null);
  }
  
  public String a()
  {
    return "StopSilkAudio";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      if (!paramArrayOfVariantWrapper[0].IsString()) {
        return;
      }
      try
      {
        if (this.a.a != null)
        {
          this.a.a.a();
          return;
        }
      }
      catch (Exception paramArkAppModuleBase)
      {
        paramArrayOfVariantWrapper = new StringBuilder();
        paramArrayOfVariantWrapper.append("invoke method MethodStopSilkAudio exception");
        paramArrayOfVariantWrapper.append(paramArkAppModuleBase);
        QLog.w("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodStopSilkAudio
 * JD-Core Version:    0.7.0.1
 */