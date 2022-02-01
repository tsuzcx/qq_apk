package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class GetPollInfoHandlerWithFreqController
{
  public static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    Long localLong;
    do
    {
      return;
      l = System.currentTimeMillis();
      localLong = (Long)a.get(paramString);
    } while ((localLong != null) && (Math.abs(l - localLong.longValue()) <= 120000L));
    a.put(paramString, Long.valueOf(l));
    GetVidPollInfoHandler.a(Collections.singletonList(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.GetPollInfoHandlerWithFreqController
 * JD-Core Version:    0.7.0.1
 */