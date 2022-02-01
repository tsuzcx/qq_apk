package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;
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
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsString())) {}
    for (;;)
    {
      return;
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
        QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodStopSilkAudio exception" + paramArkAppModuleBase);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodStopSilkAudio
 * JD-Core Version:    0.7.0.1
 */