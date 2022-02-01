package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
public abstract interface IAEBaseReportParam
  extends QRouteApi
{
  public abstract void clearLatestPostMd5();
  
  public abstract boolean getGifMode();
  
  public abstract String getIntentUidKey();
  
  public abstract void resetEditInfo();
  
  public abstract void setContentType(long paramLong);
  
  public abstract void setEditHasCut(boolean paramBoolean);
  
  public abstract void setEditHasGraffiti(boolean paramBoolean);
  
  public abstract void setEditMusicId(String paramString);
  
  public abstract void setEditSpeedChanged(boolean paramBoolean);
  
  public abstract void setEditStickerIds(String paramString);
  
  public abstract void setEditTextIds(String paramString);
  
  public abstract void setEntry(int paramInt, String paramString);
  
  public abstract void setExperimentID(String paramString);
  
  public abstract void setFilterId(String paramString);
  
  public abstract void setNetWork();
  
  public abstract void setOprationTime();
  
  public abstract void setShootTime();
  
  public abstract void setUin(@Nullable String paramString);
  
  public abstract void setVideoDuration(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.IAEBaseReportParam
 * JD-Core Version:    0.7.0.1
 */