package com.tencent.ilivesdk.floatwindowconfigservice;

import android.content.Context;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;

public class FloatWindowConfigService
  implements FloatWindowConfigServiceInterface
{
  private boolean isFloatWindowEnabledAllTime = false;
  private boolean isFloatWindowEnabledOnce = false;
  
  public void clearEventOutput() {}
  
  public boolean getFloatWindowEnabledAllTime()
  {
    return this.isFloatWindowEnabledAllTime;
  }
  
  public boolean getFloatWindowEnabledOnce()
  {
    return this.isFloatWindowEnabledOnce;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void setFloatWindowEnabledAllTime(boolean paramBoolean)
  {
    this.isFloatWindowEnabledAllTime = paramBoolean;
  }
  
  public void setFloatWindowEnabledOnce(boolean paramBoolean)
  {
    this.isFloatWindowEnabledOnce = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.floatwindowconfigservice.FloatWindowConfigService
 * JD-Core Version:    0.7.0.1
 */