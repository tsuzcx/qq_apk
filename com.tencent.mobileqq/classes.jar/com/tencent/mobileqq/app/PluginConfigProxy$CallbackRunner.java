package com.tencent.mobileqq.app;

import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespV2;

class PluginConfigProxy$CallbackRunner
  implements Runnable
{
  private ServerConfigObserver a;
  private boolean b;
  private int c;
  private GetResourceRespV2 d;
  
  public PluginConfigProxy$CallbackRunner(PluginConfigProxy paramPluginConfigProxy, ServerConfigObserver paramServerConfigObserver, boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    this.a = paramServerConfigObserver;
    this.b = paramBoolean;
    this.c = paramInt;
    this.d = paramGetResourceRespV2;
  }
  
  public void run()
  {
    this.a.onGetPluginConfig(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PluginConfigProxy.CallbackRunner
 * JD-Core Version:    0.7.0.1
 */