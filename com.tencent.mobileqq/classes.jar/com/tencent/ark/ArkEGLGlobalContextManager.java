package com.tencent.ark;

final class ArkEGLGlobalContextManager
  extends ArkEGLApplicationContextManagerBase
  implements IArkEGLContextManager
{
  EGLContextHolder _globalContext;
  
  public EGLContextHolder createContext(String paramString)
  {
    Logger.logI("ArkApp.ContextManager", String.format("ArkEGLGlobalContextManager.createContext.%s", new Object[] { paramString }));
    try
    {
      if (this._globalContext == null)
      {
        this._globalContext = createOffscreenContext();
        if (this._globalContext == null)
        {
          Logger.logE("ArkApp.ContextManager", "failed to create global offscreen context");
        }
        else
        {
          EGLContextHolder.setOffscreenContext(this._globalContext);
          Logger.logI("ArkApp.ContextManager", "create global offscreen context");
        }
      }
      paramString = this._globalContext;
      return paramString;
    }
    finally {}
  }
  
  public EGLContextHolder getContext(String paramString)
  {
    try
    {
      paramString = this._globalContext;
      return paramString;
    }
    finally {}
  }
  
  public boolean releaseContext(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkEGLGlobalContextManager
 * JD-Core Version:    0.7.0.1
 */