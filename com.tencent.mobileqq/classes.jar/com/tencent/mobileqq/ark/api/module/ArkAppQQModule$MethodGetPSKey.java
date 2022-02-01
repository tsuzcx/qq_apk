package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;

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
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodGetPSKey
 * JD-Core Version:    0.7.0.1
 */