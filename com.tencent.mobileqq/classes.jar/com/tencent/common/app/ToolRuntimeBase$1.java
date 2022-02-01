package com.tencent.common.app;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class ToolRuntimeBase$1
  implements ComponentCallbacks2
{
  ToolRuntimeBase$1(ToolRuntimeBase paramToolRuntimeBase) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    this.a.onTrimMemory(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimeBase.1
 * JD-Core Version:    0.7.0.1
 */