package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.module.AuthDialogEventHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IArkModuleAPIAuthority
  extends QRouteApi
{
  public static final String ARK_AUTHORITY_API_LOCATION = "ark_authority_api_location";
  public static final String ARK_AUTHORITY_API_LOGIN = "ark_authority_api_login";
  public static final String ARK_AUTHORITY_API_PHONENUMBER = "ark_authority_api_phone_number";
  public static final String ARK_AUTHORITY_API_RELATIONSHIP = "ark_authority_api_relationship";
  public static final String ARK_AUTHORITY_API_USER_INFO = "ark_authority_api_user_info";
  public static final int ARK_AUTHORITY_STATE_DISABLE = 2;
  public static final int ARK_AUTHORITY_STATE_ENABLE = 1;
  public static final int ARK_AUTHORITY_STATE_NONE = 0;
  public static final String SP_ARK_AUTHORITY = "sp_ark_authority";
  
  public abstract ArrayList<String> getArkAuthorityAppList(String paramString);
  
  public abstract int getArkAuthorityInfo(String paramString1, String paramString2, String paramString3);
  
  public abstract void showAuthDialog(String paramString1, String paramString2, String paramString3, String paramString4, AuthDialogEventHandler paramAuthDialogEventHandler);
  
  public abstract void updateArkAuthorityAppList(String paramString1, String paramString2);
  
  public abstract void updateArkAuthorityInfo(String paramString1, String paramString2, String paramString3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
 * JD-Core Version:    0.7.0.1
 */