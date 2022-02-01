package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;

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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodGetSKey
 * JD-Core Version:    0.7.0.1
 */