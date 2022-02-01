package com.tencent.biz.eqq.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.InputStream;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class CrmApiImpl
  implements ICrmApi
{
  private QQAppInterface app;
  
  public InputStream bitmap2InputStream(Bitmap paramBitmap)
  {
    return CrmUtils.a(paramBitmap);
  }
  
  public int convertSubVersionToInt(String paramString)
  {
    return CrmUtils.a(paramString);
  }
  
  public void deleteQdCustomerTransferSp(Context paramContext, String paramString)
  {
    deleteQdCustomerTransferSp(paramContext, paramString);
  }
  
  public void enterLightTalk(Context paramContext, String paramString1, String paramString2)
  {
    CrmUtils.b(this.app, paramContext, paramString1, paramString2);
  }
  
  public String getCrmNameFromCache(String paramString)
  {
    return CrmUtils.c(this.app, paramString);
  }
  
  public void getCustomerTransferInfo(Context paramContext, String paramString1, String paramString2)
  {
    CrmUtils.c(this.app, paramContext, paramString1, paramString2);
  }
  
  public String getNickName(String paramString)
  {
    return CrmUtils.e(this.app, paramString);
  }
  
  public int getQidianUinType(String paramString)
  {
    return CrmUtils.f(this.app, paramString);
  }
  
  public Intent gotoCrmMainProfile(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    return CrmUtils.a(paramContext, paramIntent, paramString, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
  }
  
  public boolean hasIvrAbility(String paramString, int paramInt)
  {
    return CrmUtils.a(this.app, paramString, paramInt);
  }
  
  public int isCertified(String paramString)
  {
    return CrmUtils.d(this.app, paramString);
  }
  
  public boolean isCrmMainUinAndGetSimpleInfoIfNeed(String paramString)
  {
    return CrmUtils.a(this.app, paramString);
  }
  
  public boolean isCrmMaster(int paramInt)
  {
    return CrmUtils.a(paramInt);
  }
  
  public boolean isCrmQQ(String paramString)
  {
    return CrmUtils.b(this.app, paramString);
  }
  
  public boolean isQiye(String paramString, int paramInt)
  {
    return CrmUtils.a(this.app, paramString, paramInt);
  }
  
  public void ivrAudio(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    CrmUtils.a(this.app, paramContext, paramString1, paramString2, paramString3);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((QQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void showCrmIvrVideoActionSheet(Context paramContext, String paramString1, String paramString2)
  {
    CrmUtils.a(this.app, paramContext, paramString1, paramString2);
  }
  
  public void updateDetailBackground(Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    CrmUtils.a(this.app, paramContext, paramString, paramInt, paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.api.impl.CrmApiImpl
 * JD-Core Version:    0.7.0.1
 */