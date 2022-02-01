package com.jeremyliao.liveeventbus;

import com.jeremyliao.liveeventbus.core.Config;
import com.jeremyliao.liveeventbus.core.LiveEventBusCore;
import com.jeremyliao.liveeventbus.core.Observable;

public final class LiveEventBus
{
  public static Config config()
  {
    return LiveEventBusCore.get().config();
  }
  
  public static Observable<Object> get(String paramString)
  {
    return get(paramString, Object.class);
  }
  
  public static <T> Observable<T> get(String paramString, Class<T> paramClass)
  {
    return LiveEventBusCore.get().with(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.LiveEventBus
 * JD-Core Version:    0.7.0.1
 */