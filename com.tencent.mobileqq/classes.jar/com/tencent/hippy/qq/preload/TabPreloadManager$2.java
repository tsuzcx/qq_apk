package com.tencent.hippy.qq.preload;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class TabPreloadManager$2
  implements ComponentCallbacks2
{
  TabPreloadManager$2(TabPreloadManager paramTabPreloadManager) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt != 10) && (paramInt != 15)) {
      return;
    }
    this.this$0.clearAllPreloads("lowMemory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */