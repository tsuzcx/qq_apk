package com.huawei.multimedia.liteav.audioengine;

import android.os.IInterface;

public abstract interface IHwAudioKaraokeFeature
  extends IInterface
{
  public abstract int enableKaraokeFeature(boolean paramBoolean);
  
  public abstract int getKaraokeLatency();
  
  public abstract void init(String paramString);
  
  public abstract boolean isKaraokeFeatureSupport();
  
  public abstract int setParameter(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audioengine.IHwAudioKaraokeFeature
 * JD-Core Version:    0.7.0.1
 */