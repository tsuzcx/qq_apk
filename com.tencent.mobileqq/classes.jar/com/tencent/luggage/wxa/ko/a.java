package com.tencent.luggage.wxa.ko;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<c>
{
  public static final int CTRL_INDEX = 912;
  public static final String NAME = "addPhoneCalendar";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Context localContext = paramc.getContext();
    String str1 = paramJSONObject.optString("title", "");
    long l1 = paramJSONObject.optLong("startTime", 0L);
    boolean bool = paramJSONObject.optBoolean("allDay", false);
    Boolean localBoolean = Boolean.valueOf(paramJSONObject.optBoolean("repeat", false));
    if ((!"".equals(str1)) && (l1 != 0L))
    {
      long l2 = paramJSONObject.optLong("endTime", l1);
      String str2 = paramJSONObject.optString("description", "");
      String str3 = paramJSONObject.optString("location", "");
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("FREQ=");
      if (localBoolean.booleanValue())
      {
        String str4 = paramJSONObject.optString("repeatInterval", "");
        int i = str4.hashCode();
        if (i != 0)
        {
          if (i != 99228)
          {
            if (i != 3645428)
            {
              if (i != 3704893)
              {
                if ((i == 104080000) && (str4.equals("month")))
                {
                  i = 3;
                  break label261;
                }
              }
              else if (str4.equals("year"))
              {
                i = 4;
                break label261;
              }
            }
            else if (str4.equals("week"))
            {
              i = 2;
              break label261;
            }
          }
          else if (str4.equals("day"))
          {
            i = 1;
            break label261;
          }
        }
        else if (str4.equals(""))
        {
          i = 0;
          break label261;
        }
        i = -1;
        label261:
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  o.b("MicroMsg.JsApiAddPhoneCalendar", "wrong format, repeat is true,but the repeatInterval is not day,week,month,year");
                  paramc.a(paramInt, b("fail:wrong format:repeat"));
                  return;
                }
                localStringBuilder.append("YEARLY");
              }
              else
              {
                localStringBuilder.append("MONTHLY;BYMONTHDAY=");
                localStringBuilder.append(new SimpleDateFormat("d").format(new Date(l1 * 1000L)));
              }
            }
            else {
              localStringBuilder.append("WEEKLY");
            }
          }
          else {
            localStringBuilder.append("DAILY");
          }
          long l3 = paramJSONObject.optLong("repeatEndTime", 0L);
          if (l3 != 0L)
          {
            paramJSONObject = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(new Date(l3 * 1000L));
            localStringBuilder.append(";UNTIL=");
            localStringBuilder.append(paramJSONObject);
          }
        }
        else
        {
          o.b("MicroMsg.JsApiAddPhoneCalendar", "wrong format, repeat is true,but the repeatInterval is null");
          paramc.a(paramInt, b("fail:wrong format:repeat"));
          return;
        }
      }
      o.d("MicroMsg.JsApiAddPhoneCalendar", "title:%s, description:%s, startTime:%d, endTime:%d, repeatValue:%s", new Object[] { str1, str2, Long.valueOf(l1), Long.valueOf(l2), localStringBuilder });
      paramJSONObject = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("beginTime", l1 * 1000L).putExtra("endTime", l2 * 1000L).putExtra("title", str1).putExtra("description", str2).putExtra("eventLocation", str3).putExtra("availability", 0).putExtra("allDay", Boolean.valueOf(bool));
      if (localBoolean.booleanValue()) {
        paramJSONObject.putExtra("rrule", localStringBuilder.toString());
      }
      if (localContext != null)
      {
        if (paramJSONObject.resolveActivity(localContext.getPackageManager()) != null) {
          try
          {
            localContext.startActivity(paramJSONObject);
            paramc.a(paramInt, b("ok"));
            return;
          }
          catch (Exception paramJSONObject)
          {
            o.b("MicroMsg.JsApiAddPhoneCalendar", "startActivity exp:%s", new Object[] { paramJSONObject });
            paramc.a(paramInt, b("fail:startActivity exception"));
            return;
          }
        }
        paramc.a(paramInt, b("fail:no supporting apps"));
        return;
      }
      paramc.a(paramInt, b("fail:context nil"));
      return;
    }
    o.b("MicroMsg.JsApiAddPhoneCalendar", "wrong format, title is blank, or startTime is 0");
    paramc.a(paramInt, b("fail:wrong format:title or startTime"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ko.a
 * JD-Core Version:    0.7.0.1
 */