package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all", "nearby"})
public abstract interface IQQAvatarManagerService
  extends IRuntimeService
{
  public abstract void addObserver(Object paramObject);
  
  public abstract void downloadFace(FaceInfo paramFaceInfo);
  
  public abstract String getChooseStrangerGroupIP();
  
  public abstract String getChoosedIP();
  
  public abstract Bitmap getFaceFromCache(String paramString);
  
  public abstract String getFacePath(FaceInfo paramFaceInfo);
  
  public abstract Setting getFaceSetting(String paramString);
  
  public abstract boolean isFaceFileExist(FaceInfo paramFaceInfo);
  
  public abstract void putFaceToCache(String paramString, Bitmap paramBitmap, byte paramByte);
  
  public abstract void removeFaceFromCache(String paramString);
  
  public abstract void removeObserver(Object paramObject);
  
  public abstract void updateFaceSetting(Setting paramSetting);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
 * JD-Core Version:    0.7.0.1
 */