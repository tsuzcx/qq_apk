package com.tencent.luggage.wxa.mn;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d$a$1
  implements Runnable
{
  d$a$1(d.a parama, c paramc) {}
  
  public void run()
  {
    if (!d.a.a(this.b))
    {
      o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
      return;
    }
    if (!ViewCompat.isAttachedToWindow(d.a.b(this.b)))
    {
      o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
      if ((d.a.a() != null) && (d.a.a().equals(d.a.b(this.b)))) {
        d.a.a(null);
      }
      return;
    }
    Object localObject = e.a(d.a.b(this.b));
    if ((Math.abs(d.a.c(this.b).b - ((e.f)localObject).b) <= 1.0F) && (Math.abs(d.a.c(this.b).c - ((e.f)localObject).c) <= 1.0F))
    {
      if (d.a.d(this.b).size() != 1)
      {
        o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
        return;
      }
      if ((Math.abs(d.a.e(this.b).b - d.a.f(this.b).b) <= d.a.g(this.b)) && (Math.abs(d.a.e(this.b).c - d.a.f(this.b).c) <= d.a.g(this.b)))
      {
        o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(this.b).b), Float.valueOf(d.a.f(this.b).b), Float.valueOf(d.a.e(this.b).c), Float.valueOf(d.a.f(this.b).c) });
        localObject = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject).put("data", d.a.h(this.b).b("data", ""));
      ((JSONObject)localObject).put("touch", d.a.e(this.b).a());
      label344:
      if (!d.a.h(this.b).b("disableScroll", false))
      {
        d.a locala = this.b;
        d.a.a(locala, MotionEvent.obtain(d.a.i(locala)));
        d.a.j(this.b).setAction(0);
        d.a.h(this.b).a("fakeDownEvent", true);
        d.a.b(this.b).getParent().requestDisallowInterceptTouchEvent(true);
        d.a.b(this.b).setDuplicateParentStateEnabled(false);
        locala = this.b;
        d.a.a(locala, d.a.b(locala), MotionEvent.obtain(d.a.j(this.b)));
      }
      d.a.a(this.b, this.a, new e.a(), ((JSONObject)localObject).toString());
      return;
      o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(this.b).b), Float.valueOf(d.a.f(this.b).b), Float.valueOf(d.a.e(this.b).c), Float.valueOf(d.a.f(this.b).c) });
      return;
      o.f("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label344;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.d.a.1
 * JD-Core Version:    0.7.0.1
 */