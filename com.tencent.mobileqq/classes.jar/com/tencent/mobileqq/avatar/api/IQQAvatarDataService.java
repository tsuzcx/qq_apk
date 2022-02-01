package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IQQAvatarDataService
  extends IRuntimeService
{
  public abstract Bitmap getBitmapFromCache(String paramString);
  
  public abstract String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2);
  
  public abstract String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract String getCustomFaceFilePath(Setting paramSetting, int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract String getCustomFaceFilePath(boolean paramBoolean, String paramString);
  
  public abstract String getCustomFaceFilePathBySetting(Setting paramSetting, int paramInt1, int paramInt2);
  
  public abstract String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2);
  
  public abstract String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract Setting getFaceSetting(String paramString);
  
  public abstract String getOldCustomFaceFilePath(int paramInt, String paramString);
  
  public abstract Pair<Boolean, Setting> getQQHeadSetting(int paramInt1, String paramString, int paramInt2);
  
  public abstract Setting getQQHeadSettingFromDB(String paramString);
  
  public abstract Drawable getRoundFaceDrawable(Bitmap paramBitmap);
  
  public abstract Setting getSettingFromDb(String paramString);
  
  public abstract void initFaceSettingCache();
  
  public abstract boolean isFaceFileExist(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void putBitmapToCache(String paramString, Bitmap paramBitmap, byte paramByte);
  
  public abstract void removeBitmapFromCache(String paramString);
  
  public abstract void removeFaceIconCache(int paramInt1, String paramString, int paramInt2);
  
  public abstract void removeFaceIconCacheApollo(int paramInt1, String paramString, int paramInt2);
  
  public abstract void updateSettingTableCache(Setting paramSetting);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarDataService
 * JD-Core Version:    0.7.0.1
 */