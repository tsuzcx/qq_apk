package com.tencent.luggage.wxa.mx;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.mn.e.a;
import com.tencent.luggage.wxa.mn.e.b;
import com.tencent.luggage.wxa.mn.e.c;
import com.tencent.luggage.wxa.mn.e.d;
import com.tencent.luggage.wxa.mn.e.e;
import com.tencent.luggage.wxa.mn.e.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class a$a
{
  static ah a = new e.c();
  static ah b = new e.e();
  static ah c = new e.d();
  static ah d = new e.b();
  static ah e = new e.a();
  static ah f = new a.b(null);
  static ah g = new a.c(null);
  public boolean h;
  public String i;
  private e j;
  private GestureDetector k;
  private long l = 0L;
  
  public a$a(e parame)
  {
    this.j = parame;
    this.k = new GestureDetector(this.j.getContext(), new a.a.1(this));
  }
  
  private void a(ah paramah, JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.i);
    localHashMap.put("touches", paramJSONArray);
    this.j.a(paramah.b(localHashMap), null);
  }
  
  private void a(ah paramah, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.i);
    localHashMap.put("touch", paramJSONObject);
    this.j.a(paramah.b(localHashMap), null);
  }
  
  private JSONObject b(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getActionIndex();
    int n = paramMotionEvent.getPointerId(m);
    float f1 = paramMotionEvent.getX(m);
    float f2 = paramMotionEvent.getY(m);
    paramMotionEvent = new e.f();
    paramMotionEvent.a(n, f1, f2);
    return paramMotionEvent.a();
  }
  
  private void b(ah paramah, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.i);
    localHashMap.put("touch", paramJSONObject);
    this.j.a(paramah.b(localHashMap));
  }
  
  private JSONArray c(MotionEvent paramMotionEvent)
  {
    JSONArray localJSONArray = new JSONArray();
    paramMotionEvent = i(paramMotionEvent);
    if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
    {
      int m = 0;
      while (m < paramMotionEvent.length)
      {
        localJSONArray.put(paramMotionEvent[m].a());
        m += 1;
      }
    }
    return localJSONArray;
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    a(a, b(paramMotionEvent));
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    a(b, b(paramMotionEvent));
    b(g, b(paramMotionEvent));
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    a(e, b(paramMotionEvent));
    b(f, b(paramMotionEvent));
  }
  
  private void g(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.l < 20L) {
      return;
    }
    this.l = System.currentTimeMillis();
    a(c, c(paramMotionEvent));
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    a(d, c(paramMotionEvent));
  }
  
  private e.f[] i(MotionEvent paramMotionEvent)
  {
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    int m = 0;
    while (m < paramMotionEvent.getPointerCount())
    {
      e.f localf = new e.f();
      localf.a = paramMotionEvent.getPointerId(m);
      localf.b = paramMotionEvent.getX(m);
      localf.c = paramMotionEvent.getY(m);
      localArrayList.add(localf);
      m += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    m = n;
    while (m < localArrayList.size())
    {
      paramMotionEvent[m] = ((e.f)localArrayList.get(m));
      m += 1;
    }
    return paramMotionEvent;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getActionMasked();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m == 5) {
              break label62;
            }
            if (m != 6) {
              break label67;
            }
          }
          else
          {
            h(paramMotionEvent);
            break label67;
          }
        }
        else
        {
          g(paramMotionEvent);
          break label67;
        }
      }
      e(paramMotionEvent);
      break label67;
    }
    label62:
    d(paramMotionEvent);
    label67:
    this.k.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.a.a
 * JD-Core Version:    0.7.0.1
 */