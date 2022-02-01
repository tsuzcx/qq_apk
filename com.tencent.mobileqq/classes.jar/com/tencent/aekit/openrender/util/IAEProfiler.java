package com.tencent.aekit.openrender.util;

public abstract interface IAEProfiler
{
  public static final String TAG = "IAEProfiler";
  public static final String TAG_CAL_FPS = "IAEProfiler-calFps";
  public static final String TAG_CHAIN_FILTERS = "IAEProfiler-chainFilters";
  public static final String TAG_CONFIG_FILTERS = "IAEProfiler-configFilters";
  public static final String TAG_DETECT_FRAME = "IAEProfiler-detectFrame";
  public static final String TAG_DRAW_FRAME = "IAEProfiler-drawFrame";
  public static final String TAG_GL_WAIT_FACE_Time = "IAEProfiler-waitFaceTime";
  public static final String TAG_GL_WAIT_SEG_Time = "IAEProfiler-waitSegTime";
  public static final String TAG_INIT_FILTERS = "IAEProfiler-initFilters";
  
  public abstract long endByTag(String paramString);
  
  public abstract String print();
  
  public abstract void reset();
  
  public abstract void startByTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.IAEProfiler
 * JD-Core Version:    0.7.0.1
 */