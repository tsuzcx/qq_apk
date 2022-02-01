package com.tencent.crossengine;

import android.content.Context;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.offscreen.OffscreenWorldCallback;

public class CEApplication$Builder
{
  private String assets_path;
  private CEJSEventListener ceJSEventListener;
  private Context context;
  private int defaultFPS = 30;
  private boolean enableDebugJS = false;
  private FontPixelsFactory fontPixelsFactory;
  private FrameCallback frameCallback;
  private boolean isOffscreenMode = false;
  private CELifeCycle lifeCycle;
  private LogDelegate logDelegate;
  private OffscreenWorldCallback offscreenWorldCallback;
  private String startUpWorld;
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public CEApplication build()
  {
    CEApplication localCEApplication = new CEApplication(this.context, this.isOffscreenMode);
    localCEApplication.setLogger(this.logDelegate);
    localCEApplication.setAssetsPath(this.assets_path);
    localCEApplication.setStartUpWorld(this.startUpWorld);
    localCEApplication.setCELifeCycle(this.lifeCycle);
    localCEApplication.setFrameCallback(this.frameCallback);
    localCEApplication.setCEJSEventListener(this.ceJSEventListener);
    localCEApplication.setOffscreenWorldCallback(this.offscreenWorldCallback);
    localCEApplication.setEnableDebugJS(this.enableDebugJS);
    localCEApplication.setDefaultFPS(this.defaultFPS);
    localCEApplication.setFontPixelsFactory(this.fontPixelsFactory);
    return localCEApplication;
  }
  
  public Builder setAssetsPath(String paramString)
  {
    this.assets_path = paramString;
    return this;
  }
  
  public Builder setCEJSEventListener(CEJSEventListener paramCEJSEventListener)
  {
    this.ceJSEventListener = paramCEJSEventListener;
    return this;
  }
  
  public Builder setDefaultFPS(int paramInt)
  {
    this.defaultFPS = paramInt;
    return this;
  }
  
  public Builder setEnableDebugJS(boolean paramBoolean)
  {
    this.enableDebugJS = paramBoolean;
    return this;
  }
  
  public Builder setFontPixelsFactory(FontPixelsFactory paramFontPixelsFactory)
  {
    this.fontPixelsFactory = paramFontPixelsFactory;
    return this;
  }
  
  public Builder setFrameCallback(FrameCallback paramFrameCallback)
  {
    this.frameCallback = paramFrameCallback;
    return this;
  }
  
  public Builder setLifeCycle(CELifeCycle paramCELifeCycle)
  {
    this.lifeCycle = paramCELifeCycle;
    return this;
  }
  
  public Builder setLogger(LogDelegate paramLogDelegate)
  {
    this.logDelegate = paramLogDelegate;
    return this;
  }
  
  public Builder setOffscreenMode(boolean paramBoolean)
  {
    this.isOffscreenMode = paramBoolean;
    return this;
  }
  
  public Builder setOffscreenWorldCallback(OffscreenWorldCallback paramOffscreenWorldCallback)
  {
    this.offscreenWorldCallback = paramOffscreenWorldCallback;
    return this;
  }
  
  public Builder setStartUpWorld(String paramString)
  {
    this.startUpWorld = paramString;
    return this;
  }
  
  public Builder withContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.CEApplication.Builder
 * JD-Core Version:    0.7.0.1
 */