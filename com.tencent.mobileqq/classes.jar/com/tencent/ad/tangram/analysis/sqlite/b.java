package com.tencent.ad.tangram.analysis.sqlite;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;

public class b
{
  public String eventString;
  public int strategy = -2147483648;
  public long timeMillis = -2147483648L;
  public String uuid;
  
  public b() {}
  
  public b(AdAnalysisEvent paramAdAnalysisEvent)
  {
    this.uuid = paramAdAnalysisEvent.getUUID();
    this.timeMillis = paramAdAnalysisEvent.getTime();
    this.strategy = paramAdAnalysisEvent.getStrategy();
    this.eventString = paramAdAnalysisEvent.toString();
  }
  
  public ContentValues getContentValues()
  {
    if (!isValid()) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uuid", this.uuid);
    localContentValues.put("time_millis", Long.valueOf(this.timeMillis));
    localContentValues.put("strategy", Integer.valueOf(this.strategy));
    localContentValues.put("event", this.eventString);
    return localContentValues;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.uuid)) && (this.timeMillis != -2147483648L) && (this.strategy != -2147483648) && (!TextUtils.isEmpty(this.eventString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.sqlite.b
 * JD-Core Version:    0.7.0.1
 */