package com.tencent.ad.tangram.analysis;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import java.util.UUID;

@Keep
public final class AdAnalysisEvent
{
  public static final int STRATEGY_BATCH = 102;
  public static final int STRATEGY_BATCH_WITHOUT_ABTEST = 103;
  public static final int STRATEGY_INSTANT = 101;
  private static final String TAG = "AdAnalysisEvent";
  private gdt_analysis_event event;
  private int strategy = -2147483648;
  private String uuid;
  
  public AdAnalysisEvent(gdt_analysis_event paramgdt_analysis_event, int paramInt)
  {
    this.event = paramgdt_analysis_event;
    this.uuid = UUID.randomUUID().toString();
    this.strategy = paramInt;
  }
  
  public String getId()
  {
    if (isValid()) {
      return this.event.eventId;
    }
    return null;
  }
  
  public int getStrategy()
  {
    if (isValid()) {
      return this.strategy;
    }
    return -2147483648;
  }
  
  public long getTime()
  {
    if (!isValid())
    {
      AdLog.e("AdAnalysisEvent", "getTime error");
      return -2147483648L;
    }
    try
    {
      long l = Long.valueOf(this.event.currentTime).longValue();
      return l;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdAnalysisEvent", "getTime", localThrowable);
    }
    return -2147483648L;
  }
  
  public String getUUID()
  {
    if (isValid()) {
      return this.uuid;
    }
    return null;
  }
  
  public boolean isValid()
  {
    return (this.event != null) && (!TextUtils.isEmpty(this.event.eventId)) && (this.event.currentTime != -2147483648L) && (!TextUtils.isEmpty(this.uuid)) && (this.strategy != -2147483648);
  }
  
  public String toString()
  {
    if (!isValid()) {
      AdLog.e("AdAnalysisEvent", "toString error");
    }
    for (;;)
    {
      return null;
      try
      {
        Object localObject1 = AdJSON.fromObject(this.event);
        if (localObject1 == null) {
          continue;
        }
        return localObject1.toString();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          AdLog.e("AdAnalysisEvent", "toString", localThrowable);
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysisEvent
 * JD-Core Version:    0.7.0.1
 */