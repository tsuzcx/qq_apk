package com.tencent.crossengine;

import android.content.Context;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.offscreen.OffscreenWorldCallback;

public class CEApplicationBuilder
{
  private String assetsPath;
  private CEJSEventListener ceJSEventListener;
  private Context context;
  private int defaultFPS = 30;
  private boolean enableDebugJS = false;
  private boolean enableGPUSkinning = false;
  private FontPixelsFactory fontPixelsFactory;
  private FrameCallback frameCallback;
  private boolean isOffscreenMode = false;
  private CELifeCycle lifeCycle;
  private LogDelegate logDelegate;
  private OffscreenWorldCallback offscreenWorldCallback;
  private String startUpWorld;
  
  public static CEApplicationBuilder createBuilder()
  {
    return new CEApplicationBuilder();
  }
  
  public CEApplication build()
  {
    CEApplication localCEApplication = new CEApplication(this.context, this.isOffscreenMode);
    localCEApplication.setLogger(this.logDelegate);
    localCEApplication.setAssetsPath(this.assetsPath);
    localCEApplication.setStartUpWorld(this.startUpWorld);
    localCEApplication.setCELifeCycle(this.lifeCycle);
    localCEApplication.setFrameCallback(this.frameCallback);
    localCEApplication.setCEJSEventListener(this.ceJSEventListener);
    localCEApplication.setOffscreenWorldCallback(this.offscreenWorldCallback);
    localCEApplication.setEnableDebugJS(this.enableDebugJS);
    localCEApplication.setDefaultFPS(this.defaultFPS);
    localCEApplication.setFontPixelsFactory(this.fontPixelsFactory);
    localCEApplication.setEnableGPUSkinning(this.enableGPUSkinning);
    return localCEApplication;
  }
  
  public CEApplicationBuilder setAssetsPath(String paramString)
  {
    this.assetsPath = paramString;
    return this;
  }
  
  public CEApplicationBuilder setCEJSEventListener(CEJSEventListener paramCEJSEventListener)
  {
    this.ceJSEventListener = paramCEJSEventListener;
    return this;
  }
  
  public CEApplicationBuilder setDefaultFPS(int paramInt)
  {
    this.defaultFPS = paramInt;
    return this;
  }
  
  public CEApplicationBuilder setEnableDebugJS(boolean paramBoolean)
  {
    this.enableDebugJS = paramBoolean;
    return this;
  }
  
  public CEApplicationBuilder setEnableGPUSkinning(boolean paramBoolean)
  {
    this.enableGPUSkinning = paramBoolean;
    return this;
  }
  
  public CEApplicationBuilder setFontPixelsFactory(FontPixelsFactory paramFontPixelsFactory)
  {
    this.fontPixelsFactory = paramFontPixelsFactory;
    return this;
  }
  
  public CEApplicationBuilder setFrameCallback(FrameCallback paramFrameCallback)
  {
    this.frameCallback = paramFrameCallback;
    return this;
  }
  
  public CEApplicationBuilder setLifeCycle(CELifeCycle paramCELifeCycle)
  {
    this.lifeCycle = paramCELifeCycle;
    return this;
  }
  
  public CEApplicationBuilder setLogger(LogDelegate paramLogDelegate)
  {
    this.logDelegate = paramLogDelegate;
    return this;
  }
  
  public CEApplicationBuilder setOffscreenMode(boolean paramBoolean)
  {
    this.isOffscreenMode = paramBoolean;
    return this;
  }
  
  public CEApplicationBuilder setOffscreenWorldCallback(OffscreenWorldCallback paramOffscreenWorldCallback)
  {
    this.offscreenWorldCallback = paramOffscreenWorldCallback;
    return this;
  }
  
  public CEApplicationBuilder setStartUpWorld(String paramString)
  {
    this.startUpWorld = paramString;
    return this;
  }
  
  public CEApplicationBuilder withContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.CEApplicationBuilder
 * JD-Core Version:    0.7.0.1
 */