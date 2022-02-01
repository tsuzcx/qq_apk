package com.tencent.hippy.qq.update;

public class HippyUpdateManager$HippyConfig
{
  protected long checkUpdateGap = 120L;
  protected int isLoadHippyInToolProcess = 0;
  protected int isPredrawHippy = 0;
  protected int isPreloadHippy = 0;
  
  public long checkUpdateGap()
  {
    return this.checkUpdateGap;
  }
  
  public boolean isLoadHippyInToolProcess()
  {
    return this.isLoadHippyInToolProcess == 1;
  }
  
  public boolean isPredrawHippy()
  {
    return this.isPredrawHippy == 1;
  }
  
  public boolean isPreloadHippy()
  {
    return this.isPreloadHippy == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager.HippyConfig
 * JD-Core Version:    0.7.0.1
 */