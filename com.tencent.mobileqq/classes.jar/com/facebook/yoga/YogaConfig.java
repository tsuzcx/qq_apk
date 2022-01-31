package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class YogaConfig
{
  private YogaLogger mLogger;
  long mNativePointer = jni_YGConfigNew();
  
  static
  {
    SoLoader.loadLibrary("yoga");
  }
  
  public YogaConfig()
  {
    if (this.mNativePointer == 0L) {
      throw new IllegalStateException("Failed to allocate native memory");
    }
  }
  
  private native void jni_YGConfigFree(long paramLong);
  
  private native long jni_YGConfigNew();
  
  private native void jni_YGConfigSetExperimentalFeatureEnabled(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void jni_YGConfigSetLogger(long paramLong, Object paramObject);
  
  private native void jni_YGConfigSetPointScaleFactor(long paramLong, float paramFloat);
  
  private native void jni_YGConfigSetUseLegacyStretchBehaviour(long paramLong, boolean paramBoolean);
  
  private native void jni_YGConfigSetUseWebDefaults(long paramLong, boolean paramBoolean);
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      jni_YGConfigFree(this.mNativePointer);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public YogaLogger getLogger()
  {
    return this.mLogger;
  }
  
  public void setExperimentalFeatureEnabled(YogaExperimentalFeature paramYogaExperimentalFeature, boolean paramBoolean)
  {
    jni_YGConfigSetExperimentalFeatureEnabled(this.mNativePointer, paramYogaExperimentalFeature.intValue(), paramBoolean);
  }
  
  public void setLogger(YogaLogger paramYogaLogger)
  {
    this.mLogger = paramYogaLogger;
    jni_YGConfigSetLogger(this.mNativePointer, paramYogaLogger);
  }
  
  public void setPointScaleFactor(float paramFloat)
  {
    jni_YGConfigSetPointScaleFactor(this.mNativePointer, paramFloat);
  }
  
  public void setUseLegacyStretchBehaviour(boolean paramBoolean)
  {
    jni_YGConfigSetUseLegacyStretchBehaviour(this.mNativePointer, paramBoolean);
  }
  
  public void setUseWebDefaults(boolean paramBoolean)
  {
    jni_YGConfigSetUseWebDefaults(this.mNativePointer, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaConfig
 * JD-Core Version:    0.7.0.1
 */