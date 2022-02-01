package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;

class ArkAppQQModule$MethodGetUIN
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodGetUIN()
  {
    super(null);
  }
  
  public String a()
  {
    return "GetUIN";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    paramVariantWrapper.SetString(ArkQQAPIIPCModule.a());
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodGetUIN
 * JD-Core Version:    0.7.0.1
 */