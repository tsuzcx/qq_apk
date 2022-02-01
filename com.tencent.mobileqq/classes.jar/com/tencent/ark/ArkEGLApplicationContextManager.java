package com.tencent.ark;

import java.util.HashMap;

final class ArkEGLApplicationContextManager
  extends ArkEGLApplicationContextManagerBase
  implements IArkEGLContextManager
{
  private HashMap<String, ArkEGLApplicationContextManager.AppEGLContext> _appContextMap = new HashMap();
  
  public EGLContextHolder createContext(String paramString)
  {
    ENV.logI("ArkApp.ContextManager", String.format("ArkEGLApplicationContextManager.createContext.%s", new Object[] { paramString }));
    synchronized (this._appContextMap)
    {
      ArkEGLApplicationContextManager.AppEGLContext localAppEGLContext = (ArkEGLApplicationContextManager.AppEGLContext)this._appContextMap.get(paramString);
      if (localAppEGLContext != null)
      {
        localAppEGLContext.refCount += 1;
        paramString = localAppEGLContext;
        paramString = paramString.context;
        return paramString;
      }
      localAppEGLContext = new ArkEGLApplicationContextManager.AppEGLContext(null);
      localAppEGLContext.refCount = 1;
      localAppEGLContext.context = createOffscreenContext();
      this._appContextMap.put(paramString, localAppEGLContext);
      paramString = localAppEGLContext;
    }
  }
  
  public EGLContextHolder getContext(String paramString)
  {
    synchronized (this._appContextMap)
    {
      paramString = (ArkEGLApplicationContextManager.AppEGLContext)this._appContextMap.get(paramString);
      if ((paramString != null) && (paramString.refCount > 0))
      {
        paramString = paramString.context;
        return paramString;
      }
      return null;
    }
  }
  
  public boolean releaseContext(String paramString)
  {
    synchronized (this._appContextMap)
    {
      ArkEGLApplicationContextManager.AppEGLContext localAppEGLContext = (ArkEGLApplicationContextManager.AppEGLContext)this._appContextMap.get(paramString);
      if (localAppEGLContext == null)
      {
        ENV.logE("ArkApp.ContextManager", String.format("release context unexpectedly, appid is %s", new Object[] { paramString }));
        return false;
      }
      localAppEGLContext.refCount -= 1;
      if (localAppEGLContext.refCount == 0)
      {
        ENV.logI("ArkApp.ContextManager", String.format("release context, appid is %s", new Object[] { paramString }));
        this._appContextMap.remove(paramString);
        localAppEGLContext.context.release();
        localAppEGLContext.context = null;
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkEGLApplicationContextManager
 * JD-Core Version:    0.7.0.1
 */