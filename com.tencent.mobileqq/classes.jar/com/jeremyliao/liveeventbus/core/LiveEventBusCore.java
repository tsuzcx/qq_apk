package com.jeremyliao.liveeventbus.core;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.jeremyliao.liveeventbus.ipc.encode.IEncoder;
import com.jeremyliao.liveeventbus.ipc.encode.ValueEncoder;
import com.jeremyliao.liveeventbus.ipc.json.GsonConverter;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import java.util.HashMap;
import java.util.Map;

public final class LiveEventBusCore
{
  private Context appContext;
  private boolean autoClear = false;
  private final Map<String, LiveEventBusCore.LiveEvent<Object>> bus = new HashMap();
  private final Config config = new Config();
  private IEncoder encoder;
  private boolean lifecycleObserverAlwaysActive = true;
  private LoggerManager logger = new LoggerManager(new DefaultLogger());
  private LebIpcReceiver receiver;
  
  private LiveEventBusCore()
  {
    GsonConverter localGsonConverter = new GsonConverter();
    this.encoder = new ValueEncoder(localGsonConverter);
    this.receiver = new LebIpcReceiver(localGsonConverter);
  }
  
  public static LiveEventBusCore get()
  {
    return LiveEventBusCore.SingletonHolder.access$100();
  }
  
  public Config config()
  {
    return this.config;
  }
  
  void enableLogger(boolean paramBoolean)
  {
    this.logger.setEnable(paramBoolean);
  }
  
  void registerReceiver(Context paramContext)
  {
    if (paramContext != null) {
      this.appContext = paramContext.getApplicationContext();
    }
    if (this.appContext != null)
    {
      paramContext = new IntentFilter();
      paramContext.addAction("intent.action.ACTION_LEB_IPC");
      this.appContext.registerReceiver(this.receiver, paramContext);
    }
  }
  
  void setAutoClear(boolean paramBoolean)
  {
    this.autoClear = paramBoolean;
  }
  
  void setJsonConverter(JsonConverter paramJsonConverter)
  {
    if (paramJsonConverter == null) {
      return;
    }
    this.encoder = new ValueEncoder(paramJsonConverter);
    this.receiver.setJsonConverter(paramJsonConverter);
  }
  
  void setLifecycleObserverAlwaysActive(boolean paramBoolean)
  {
    this.lifecycleObserverAlwaysActive = paramBoolean;
  }
  
  void setLogger(@NonNull Logger paramLogger)
  {
    this.logger.setLogger(paramLogger);
  }
  
  public <T> Observable<T> with(String paramString, Class<T> paramClass)
  {
    try
    {
      if (!this.bus.containsKey(paramString)) {
        this.bus.put(paramString, new LiveEventBusCore.LiveEvent(this, paramString));
      }
      paramString = (Observable)this.bus.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore
 * JD-Core Version:    0.7.0.1
 */