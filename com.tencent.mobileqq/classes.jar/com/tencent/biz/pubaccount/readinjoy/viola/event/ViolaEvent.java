package com.tencent.biz.pubaccount.readinjoy.viola.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.json.JSONObject;

public class ViolaEvent
  extends SimpleBaseEvent
{
  public JSONObject data;
  public String eventName;
  
  public ViolaEvent(String paramString, JSONObject paramJSONObject)
  {
    this.eventName = paramString;
    this.data = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.event.ViolaEvent
 * JD-Core Version:    0.7.0.1
 */