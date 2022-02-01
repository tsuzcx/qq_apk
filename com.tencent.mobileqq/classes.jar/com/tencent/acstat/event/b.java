package com.tencent.acstat.event;

import android.content.Context;
import com.tencent.acstat.StatServiceImpl;
import com.tencent.acstat.StatSpecifyReportedInfo;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends d
{
  protected c a = new c();
  private long p = -1L;
  
  public b(Context paramContext, int paramInt, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a.a = paramString;
  }
  
  private void h()
  {
    if (this.a.a != null)
    {
      Object localObject = StatServiceImpl.getCommonKeyValueForKVEvent(this.a.a);
      if ((localObject != null) && (((Properties)localObject).size() > 0))
      {
        if ((this.a.c != null) && (this.a.c.length() != 0)) {
          localObject = ((Properties)localObject).entrySet().iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          try
          {
            this.a.c.put(localEntry.getKey().toString(), localEntry.getValue());
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          continue;
          this.a.c = new JSONObject((Map)localObject);
        }
      }
    }
  }
  
  public EventType a()
  {
    return EventType.CUSTOM;
  }
  
  public void a(long paramLong)
  {
    this.p = paramLong;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ei", this.a.a);
    long l = this.p;
    if (l > 0L) {
      paramJSONObject.put("du", l);
    }
    Object localObject;
    String str;
    if (this.a.b == null)
    {
      h();
      localObject = this.a.c;
      str = "kv";
    }
    else
    {
      localObject = this.a.b;
      str = "ar";
    }
    paramJSONObject.put(str, localObject);
    return true;
  }
  
  public c b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.event.b
 * JD-Core Version:    0.7.0.1
 */