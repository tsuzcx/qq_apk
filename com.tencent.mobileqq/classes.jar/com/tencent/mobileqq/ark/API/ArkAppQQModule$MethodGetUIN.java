package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;

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
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodGetUIN
 * JD-Core Version:    0.7.0.1
 */