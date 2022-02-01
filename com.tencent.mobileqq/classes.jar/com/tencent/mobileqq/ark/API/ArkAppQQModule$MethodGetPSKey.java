package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;

class ArkAppQQModule$MethodGetPSKey
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodGetPSKey()
  {
    super(null);
  }
  
  public String a()
  {
    return "GetPskey";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1)) {
      paramVariantWrapper.SetString(ArkQQAPIIPCModule.b(paramArrayOfVariantWrapper[0].GetString()));
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodGetPSKey
 * JD-Core Version:    0.7.0.1
 */