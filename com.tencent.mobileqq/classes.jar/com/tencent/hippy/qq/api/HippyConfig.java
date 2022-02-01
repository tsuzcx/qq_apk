package com.tencent.hippy.qq.api;

public class HippyConfig
{
  public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120L;
  public long checkUpdateGap = 120L;
  public int isGameCenterLoadHippyInToolProcess = 0;
  public int isGameCenterPredrawHippy = 0;
  public int isGameCenterPreloadHippy = 0;
  
  public boolean isGameCenterLoadHippyInToolProcess()
  {
    return this.isGameCenterLoadHippyInToolProcess == 1;
  }
  
  public boolean isGameCenterPredrawHippy()
  {
    return this.isGameCenterPredrawHippy == 1;
  }
  
  public boolean isGameCenterPreloadHippy()
  {
    return this.isGameCenterPreloadHippy == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.HippyConfig
 * JD-Core Version:    0.7.0.1
 */