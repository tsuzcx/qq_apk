package com.tencent.biz.eqq.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.io.InputStream;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;

@Service(process={""})
public abstract interface ICrmApi
  extends IRuntimeService
{
  public abstract InputStream bitmap2InputStream(Bitmap paramBitmap);
  
  public abstract int convertSubVersionToInt(String paramString);
  
  public abstract void deleteQdCustomerTransferSp(Context paramContext, String paramString);
  
  public abstract void enterLightTalk(Context paramContext, String paramString1, String paramString2);
  
  public abstract String getCrmNameFromCache(String paramString);
  
  public abstract void getCustomerTransferInfo(Context paramContext, String paramString1, String paramString2);
  
  public abstract String getNickName(String paramString);
  
  public abstract int getQidianUinType(String paramString);
  
  public abstract Intent gotoCrmMainProfile(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2);
  
  public abstract boolean hasIvrAbility(String paramString, int paramInt);
  
  public abstract int isCertified(String paramString);
  
  public abstract boolean isCrmMainUinAndGetSimpleInfoIfNeed(String paramString);
  
  public abstract boolean isCrmMaster(int paramInt);
  
  public abstract boolean isCrmQQ(String paramString);
  
  public abstract boolean isQiye(String paramString, int paramInt);
  
  public abstract void ivrAudio(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void showCrmIvrVideoActionSheet(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateDetailBackground(Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.eqq.api.ICrmApi
 * JD-Core Version:    0.7.0.1
 */