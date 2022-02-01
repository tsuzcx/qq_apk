package com.huawei.multimedia.liteav.audioengine;

import android.os.IInterface;
import java.util.List;

public abstract interface IHwAudioEngine
  extends IInterface
{
  public abstract List getSupportedFeatures();
  
  public abstract void init(String paramString1, String paramString2);
  
  public abstract boolean isFeatureSupported(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audioengine.IHwAudioEngine
 * JD-Core Version:    0.7.0.1
 */