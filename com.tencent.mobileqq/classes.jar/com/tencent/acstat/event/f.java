package com.tencent.acstat.event;

import android.content.Context;
import com.tencent.acstat.StatSpecifyReportedInfo;
import com.tencent.acstat.common.Util;
import org.json.JSONObject;

public class f
  extends d
{
  Long a = null;
  String p;
  String q;
  
  public f(Context paramContext, String paramString1, String paramString2, int paramInt, Long paramLong, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.q = paramString1;
    this.p = paramString2;
    this.a = paramLong;
  }
  
  public EventType a()
  {
    return EventType.PAGE_VIEW;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    Util.jsonPut(paramJSONObject, "pi", this.p);
    Util.jsonPut(paramJSONObject, "rf", this.q);
    if (this.a != null) {
      paramJSONObject.put("du", this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.event.f
 * JD-Core Version:    0.7.0.1
 */