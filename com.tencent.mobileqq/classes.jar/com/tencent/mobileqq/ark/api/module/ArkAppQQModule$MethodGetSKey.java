package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;

class ArkAppQQModule$MethodGetSKey
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodGetSKey()
  {
    super(null);
  }
  
  public String a()
  {
    return "GetSkey";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    paramVariantWrapper.SetString(ArkQQAPIIPCModule.b());
  }
  
  public boolean b()
  {
    return true;
  }
  
  public String c()
  {
    return null;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodGetSKey
 * JD-Core Version:    0.7.0.1
 */