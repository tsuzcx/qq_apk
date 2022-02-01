package com.tencent.luggage.wxa.kt;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.mn.e.b;
import com.tencent.luggage.wxa.mn.e.c;
import com.tencent.luggage.wxa.mn.e.d;
import com.tencent.luggage.wxa.mn.e.e;
import com.tencent.luggage.wxa.mn.e.f;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static int a;
  private static int b;
  private static long c;
  private static long d;
  
  public static void a(e parame, View paramView, int paramInt, MotionEvent paramMotionEvent, String paramString, boolean paramBoolean)
  {
    int i = paramMotionEvent.getActionIndex();
    int k = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    int m = a;
    int n = paramMotionEvent.getAction();
    int j = 0;
    i = 0;
    if ((m == n) && (b == k) && (c == paramMotionEvent.getEventTime()) && (d == paramMotionEvent.getDownTime()))
    {
      o.d("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d, don't send Duplicate event", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(k), Long.valueOf(paramMotionEvent.getEventTime()), Long.valueOf(paramMotionEvent.getDownTime()) });
      return;
    }
    a = paramMotionEvent.getAction();
    b = k;
    c = paramMotionEvent.getEventTime();
    d = paramMotionEvent.getDownTime();
    paramView = new e.f();
    paramView.a(k, f1, f2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("viewId", paramInt);
      o.d("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(k), Long.valueOf(c), Long.valueOf(d) });
      paramInt = paramMotionEvent.getAction();
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              paramView = null;
              break label463;
            }
            paramView = new JSONArray();
          }
        }
      }
    }
    catch (JSONException paramView)
    {
      try
      {
        localJSONObject.put("touches", paramView);
        paramMotionEvent = a(paramMotionEvent);
        if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
        {
          paramInt = i;
          while (paramInt < paramMotionEvent.length)
          {
            paramView.put(paramMotionEvent[paramInt].a());
            paramInt += 1;
          }
        }
        paramView = new e.b();
        break label463;
        paramView = new JSONArray();
      }
      catch (JSONException paramView)
      {
        try
        {
          localJSONObject.put("touches", paramView);
          paramMotionEvent = a(paramMotionEvent);
          if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
          {
            paramInt = j;
            while (paramInt < paramMotionEvent.length)
            {
              paramView.put(paramMotionEvent[paramInt].a());
              paramInt += 1;
            }
          }
          paramView = new e.d();
        }
        catch (JSONException paramView)
        {
          try
          {
            localJSONObject.put("touch", paramView.a());
            paramView = new e.e();
          }
          catch (JSONException paramView)
          {
            try
            {
              for (;;)
              {
                localJSONObject.put("touch", paramView.a());
                label455:
                paramView = new e.c();
                label463:
                if ((paramView != null) && (paramBoolean))
                {
                  paramView.b(localJSONObject.toString());
                  parame.a(paramView);
                  return;
                }
                if (paramView != null)
                {
                  paramView.b(localJSONObject.toString());
                  parame.a(paramView, null);
                }
                return;
                paramString = paramString;
                continue;
                paramString = paramString;
                continue;
                paramString = paramString;
              }
              paramView = paramView;
            }
            catch (JSONException paramView)
            {
              break label455;
            }
          }
        }
      }
    }
  }
  
  private static e.f[] a(MotionEvent paramMotionEvent)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      e.f localf = new e.f();
      localf.a = paramMotionEvent.getPointerId(i);
      localf.b = paramMotionEvent.getX(i);
      localf.c = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((e.f)localArrayList.get(i));
      i += 1;
    }
    return paramMotionEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.d
 * JD-Core Version:    0.7.0.1
 */