package com.jeremyliao.liveeventbus.core;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import com.jeremyliao.liveeventbus.logger.Logger;

public class Config
{
  public Config autoClear(boolean paramBoolean)
  {
    LiveEventBusCore.get().setAutoClear(paramBoolean);
    return this;
  }
  
  public Config enableLogger(boolean paramBoolean)
  {
    LiveEventBusCore.get().enableLogger(paramBoolean);
    return this;
  }
  
  public Config lifecycleObserverAlwaysActive(boolean paramBoolean)
  {
    LiveEventBusCore.get().setLifecycleObserverAlwaysActive(paramBoolean);
    return this;
  }
  
  public Config setJsonConverter(@NonNull JsonConverter paramJsonConverter)
  {
    LiveEventBusCore.get().setJsonConverter(paramJsonConverter);
    return this;
  }
  
  public Config setLogger(@NonNull Logger paramLogger)
  {
    LiveEventBusCore.get().setLogger(paramLogger);
    return this;
  }
  
  public Config supportBroadcast(Context paramContext)
  {
    LiveEventBusCore.get().registerReceiver(paramContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.Config
 * JD-Core Version:    0.7.0.1
 */