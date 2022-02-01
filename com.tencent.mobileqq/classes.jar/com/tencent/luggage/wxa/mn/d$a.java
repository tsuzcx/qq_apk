package com.tencent.luggage.wxa.mn;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d$a
  implements View.OnTouchListener
{
  private static volatile View a;
  private Map<Integer, e.f> b = new HashMap();
  private boolean c;
  private boolean d;
  private e.f e;
  private Runnable f;
  private a.b g;
  private int h;
  private float i;
  private MotionEvent j;
  private MotionEvent k;
  private e.f l;
  private e.f m;
  private View n;
  private c o;
  
  public d$a(c paramc, @NonNull a.b paramb)
  {
    a.a(paramc);
    a.a(paramb);
    this.g = paramb;
    this.h = paramc.getComponentId();
    this.o = paramc;
    this.i = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.l = new e.f();
    this.m = new e.f();
    this.f = new d.a.1(this, paramc);
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      float f1 = localViewGroup.getScrollX();
      float f2 = paramView.getX();
      float f3 = localViewGroup.getScrollY();
      float f4 = paramView.getY();
      paramMotionEvent.offsetLocation(-(f1 - f2), -(f3 - f4));
      a((View)localViewParent, paramMotionEvent);
      return;
    }
    paramView.dispatchTouchEvent(paramMotionEvent);
  }
  
  private void a(View paramView, boolean paramBoolean, e.f paramf)
  {
    this.n = paramView;
    this.c = paramBoolean;
    if (!paramBoolean)
    {
      this.g.a("fakeDownEvent", false);
      this.g.a("onLongClick", false);
      this.n.removeCallbacks(this.f);
      this.l.a(-1, 0.0F, 0.0F);
      this.j = null;
    }
  }
  
  private void a(c paramc, ah paramah, String paramString)
  {
    paramc.a(paramah.d(), paramString, null);
  }
  
  private void a(c paramc, e.f paramf, ah paramah, String paramString)
  {
    JSONObject localJSONObject;
    if (paramf != null)
    {
      if (paramah == null) {
        return;
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("touch", paramf.a());
      label40:
      a(paramc, paramah, localJSONObject.toString());
      return;
    }
    catch (JSONException paramf)
    {
      break label40;
    }
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    while (i1 < paramMotionEvent.getPointerCount())
    {
      float f1 = paramMotionEvent.getX(i1);
      float f2 = paramMotionEvent.getY(i1);
      int i2 = paramMotionEvent.getPointerId(i1);
      e.f localf = (e.f)this.b.get(Integer.valueOf(i2));
      if ((localf == null) || ((f1 == localf.b) && (f2 == localf.c))) {
        i1 += 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  e.f[] b(MotionEvent paramMotionEvent)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = 0;
    int i1 = 0;
    while (i1 < paramMotionEvent.getPointerCount())
    {
      int i3 = paramMotionEvent.getPointerId(i1);
      e.f localf = (e.f)this.b.get(Integer.valueOf(i3));
      if (localf != null)
      {
        localf.b = paramMotionEvent.getX(i1);
        localf.c = paramMotionEvent.getY(i1);
        localArrayList.add(localf);
      }
      i1 += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    i1 = i2;
    while (i1 < localArrayList.size())
    {
      paramMotionEvent[i1] = ((e.f)localArrayList.get(i1));
      i1 += 1;
    }
    return paramMotionEvent;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((a != null) && (!a.equals(paramView)))
    {
      o.f("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      return false;
    }
    this.k = paramMotionEvent;
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int i3 = paramMotionEvent.getPointerId(i2);
    float f1 = paramMotionEvent.getX(i2);
    float f2 = paramMotionEvent.getY(i2);
    if ((i1 != 0) && (!this.g.b("isTouching")) && (!ViewCompat.isAttachedToWindow(paramView)) && (i1 != 3)) {
      return false;
    }
    String str = this.g.b("data", "");
    boolean bool4 = this.g.b("disableScroll", false);
    boolean bool1 = this.g.b("fakeDownEvent", false);
    boolean bool3 = this.g.b("onLongClick", false);
    this.d = this.g.b("enableLongClick", false);
    this.m.a(i3, f1, f2);
    boolean bool2 = bool4 | bool3;
    boolean bool6;
    boolean bool5;
    Object localObject;
    if (i1 != 0) {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 == 6) {
                break label735;
              }
              break label785;
            }
            bool4 = bool2;
            bool6 = bool3;
            bool5 = bool1;
            break label1041;
          }
          a = null;
          a(paramView, false, null);
          if ((!bool4) && (!bool3)) {
            paramView.setDuplicateParentStateEnabled(false);
          } else {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          this.g.a("isTouching", false);
          if (this.g.a("disableScroll-nextState"))
          {
            localObject = this.g;
            ((a.b)localObject).a("disableScroll", ((a.b)localObject).b("disableScroll-nextState", bool4));
          }
          if (ViewCompat.isAttachedToWindow(paramView))
          {
            paramView = new JSONObject();
            localObject = new JSONArray();
          }
        }
      }
    }
    try
    {
      paramView.put("data", str);
      paramView.put("touches", localObject);
      paramMotionEvent = b(paramMotionEvent);
      i1 = 0;
      while (i1 < paramMotionEvent.length)
      {
        ((JSONArray)localObject).put(paramMotionEvent[i1].a());
        i1 += 1;
      }
      a(this.o, new e.b(), paramView.toString());
      this.b.clear();
      break label785;
      if (a(paramMotionEvent))
      {
        if ((this.b.size() == 1) && (this.c) && ((Math.abs(this.l.b - this.m.b) > this.i) || (Math.abs(this.l.c - this.m.c) > this.i))) {
          a(paramView, false, null);
        }
        paramView = new JSONObject();
        localObject = new JSONArray();
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramView.put("data", str);
        paramView.put("touches", localObject);
        label572:
        paramMotionEvent = b(paramMotionEvent);
        if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
        {
          i1 = 0;
          while (i1 < paramMotionEvent.length)
          {
            ((JSONArray)localObject).put(paramMotionEvent[i1].a());
            i1 += 1;
          }
        }
        if (this.b.size() != 0)
        {
          a(this.o, new e.d(), paramView.toString());
          break label785;
          if ((!bool4) && (!bool3)) {
            paramView.setDuplicateParentStateEnabled(false);
          } else {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          a = null;
          this.g.a("isTouching", false);
          if (this.g.a("disableScroll-nextState"))
          {
            paramMotionEvent = this.g;
            paramMotionEvent.a("disableScroll", paramMotionEvent.b("disableScroll-nextState", bool4));
          }
          label735:
          paramMotionEvent = (e.f)this.b.remove(Integer.valueOf(i3));
          if (paramMotionEvent != null)
          {
            a(paramView, false, null);
            a(this.o, paramMotionEvent, new e.e(), str);
          }
        }
        label785:
        return bool2;
        if ((this.j != null) && (paramMotionEvent.getDownTime() != this.j.getDownTime()))
        {
          this.g.a("fakeDownEvent", false);
          o.f("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool1 = false;
        }
        if ((!bool4) && (!bool1))
        {
          paramView.setDuplicateParentStateEnabled(true);
        }
        else
        {
          paramView.getParent().requestDisallowInterceptTouchEvent(true);
          paramView.setDuplicateParentStateEnabled(false);
          o.d("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
        }
        if (bool1)
        {
          this.g.a("fakeDownEvent", false);
          this.g.a("onLongClick", true);
          bool2 = true;
          bool3 = true;
        }
        else
        {
          a = paramView;
          this.e = e.a(paramView);
          this.l.a(i3, f1, f2);
        }
        this.g.a("isTouching", true);
        bool4 = bool2;
        bool6 = bool3;
        bool5 = bool1;
        if (this.d)
        {
          bool4 = bool2;
          bool6 = bool3;
          bool5 = bool1;
          if (!bool3)
          {
            bool4 = bool2;
            bool6 = bool3;
            bool5 = bool1;
            if (!this.b.containsKey(Integer.valueOf(i3)))
            {
              paramView.postDelayed(this.f, ViewConfiguration.getLongPressTimeout());
              bool5 = bool1;
              bool6 = bool3;
              bool4 = bool2;
            }
          }
        }
        label1041:
        bool1 = true;
        if (!e.a(paramView, f1, f2)) {
          return bool4;
        }
        paramMotionEvent = new e.f(i3, f1, f2);
        if ((i1 != 0) || (bool6)) {
          bool1 = false;
        }
        a(paramView, bool1, paramMotionEvent);
        bool1 = this.b.containsKey(Integer.valueOf(i3));
        this.b.put(Integer.valueOf(i3), paramMotionEvent);
        if ((!bool5) && (!bool1)) {
          a(this.o, paramMotionEvent, new e.c(), str);
        }
        return bool4;
        localJSONException1 = localJSONException1;
      }
      catch (JSONException localJSONException2)
      {
        break label572;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.d.a
 * JD-Core Version:    0.7.0.1
 */