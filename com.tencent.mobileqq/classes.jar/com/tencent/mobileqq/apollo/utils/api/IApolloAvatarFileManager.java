package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IApolloAvatarFileManager
  extends QRouteApi
{
  public abstract void delAllFrameFiles(int paramInt1, int paramInt2, String paramString);
  
  public abstract void delAllGifCache();
  
  public abstract void getAllFrameFiles(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener);
  
  public abstract String getGifFilePath(int paramInt1, int paramInt2, String paramString);
  
  public abstract void getSingleFrameFile(int paramInt1, int paramInt2, String paramString, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener);
  
  public abstract String getVideoFilePath(int paramInt);
  
  public abstract boolean isHasGif(int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean isHasVideo(int paramInt);
  
  public abstract void putAction2FrameFilePath(int paramInt, List<String> paramList);
  
  public abstract void putAction2GifFilePath(int paramInt, String paramString1, String paramString2);
  
  public abstract void putAction2VideoFilePath(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager
 * JD-Core Version:    0.7.0.1
 */