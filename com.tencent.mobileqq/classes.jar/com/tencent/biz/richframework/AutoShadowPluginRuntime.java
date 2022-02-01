package com.tencent.biz.richframework;

import android.app.Application;
import com.tencent.biz.richframework.delegate.impl.RFApplication;

public class AutoShadowPluginRuntime
{
  private static volatile AutoShadowPluginRuntime a;
  private Application b;
  
  public AutoShadowPluginRuntime()
  {
    if ((RFApplication.getApplication() instanceof Application)) {
      this.b = ((Application)RFApplication.getApplication());
    }
  }
  
  public static AutoShadowPluginRuntime a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AutoShadowPluginRuntime();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Application paramApplication)
  {
    this.b = paramApplication;
  }
  
  public Application b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.AutoShadowPluginRuntime
 * JD-Core Version:    0.7.0.1
 */