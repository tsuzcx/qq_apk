package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.module.AuthDialogEventHandler;
import java.util.ArrayList;

public class ArkModuleAPIAuthorityImpl
  implements IArkModuleAPIAuthority
{
  public ArrayList<String> getArkAuthorityAppList(String paramString)
  {
    return ArkModuleAPIAuthority.a(paramString);
  }
  
  public int getArkAuthorityInfo(String paramString1, String paramString2, String paramString3)
  {
    return ArkModuleAPIAuthority.a(paramString1, paramString2, paramString3);
  }
  
  public void showAuthDialog(String paramString1, String paramString2, String paramString3, String paramString4, AuthDialogEventHandler paramAuthDialogEventHandler)
  {
    ArkModuleAPIAuthority.a(paramString1, paramString2, paramString3, paramString4, paramAuthDialogEventHandler);
  }
  
  public void updateArkAuthorityAppList(String paramString1, String paramString2)
  {
    ArkModuleAPIAuthority.a(paramString1, paramString2);
  }
  
  public void updateArkAuthorityInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ArkModuleAPIAuthority.a(paramString1, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkModuleAPIAuthorityImpl
 * JD-Core Version:    0.7.0.1
 */