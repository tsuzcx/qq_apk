package com.qflutter.vistaplayer;

import com.qflutter.superchannel.SuperChannelPlugin;
import java.util.HashMap;
import java.util.Map;

public class VistaPlayerEvent
{
  private static String eventsNameFor(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.qflutter.vista_player/videoEvents/");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static void sendCompletionEvent(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", "completed");
    SuperChannelPlugin.sendEvent(eventsNameFor(paramLong), localHashMap);
  }
  
  public static void sendFirstFrameRenderedEvent(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", "first_frame_rendered");
    SuperChannelPlugin.sendEvent(eventsNameFor(paramLong), localHashMap);
  }
  
  public static void sendPreparedEvent(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", "prepared");
    localHashMap.put("duration", Long.valueOf(paramLong2));
    localHashMap.put("width", Long.valueOf(paramInt1));
    localHashMap.put("height", Long.valueOf(paramInt2));
    SuperChannelPlugin.sendEvent(eventsNameFor(paramLong1), localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.VistaPlayerEvent
 * JD-Core Version:    0.7.0.1
 */