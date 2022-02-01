package com.tencent.mobileqq.activity.specialcare.api;

import com.tencent.mobileqq.activity.specialcare.CallBack;
import com.tencent.mobileqq.vas.api.IVasManager;
import java.io.File;

public abstract interface IQvipSpecialSoundManager
  extends IVasManager
{
  public abstract String getSoundName(int paramInt);
  
  public abstract boolean isCacheData();
  
  public abstract void loadSpecialSoundConfig(CallBack paramCallBack);
  
  public abstract void onSpecialSoundConfigDownloaded(int paramInt, File paramFile, String paramString);
  
  public abstract void parseSpecialSoundConfigFile();
  
  public abstract void updateSpecialSoundConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
 * JD-Core Version:    0.7.0.1
 */