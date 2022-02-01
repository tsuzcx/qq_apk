package com.tencent.luggage.wxa.bm;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.MBRuntime;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private Context a;
  private d b;
  private volatile b c;
  private volatile int d = 0;
  private final Queue<String> e = new LinkedList();
  private com.tencent.magicbrush.e f;
  private e.e g = new e.e(null);
  
  private void a(FrameLayout paramFrameLayout)
  {
    paramFrameLayout.setClipChildren(false);
    float f1 = this.a.getResources().getDisplayMetrics().density;
    FrameLayout.LayoutParams localLayoutParams;
    if (this.c != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      paramFrameLayout.addView(this.c.c(), localLayoutParams);
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 8388693;
      localLayoutParams.bottomMargin = ((int)(55.0F * f1));
      int i = (int)(f1 * 15.0F);
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      paramFrameLayout.addView(this.c.a(), localLayoutParams);
    }
    if (this.b != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = k.a.a(this.a);
      paramFrameLayout.addView(this.b, localLayoutParams);
    }
  }
  
  private void a(MBRuntime paramMBRuntime, e.c paramc)
  {
    this.b = new d(this.a);
    this.b.a(paramc);
    this.b.setBackground(this.a.getResources().getDrawable(2130838667));
  }
  
  private void b()
  {
    this.d = 2;
    this.g.c();
    this.f = null;
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
    d locald = this.b;
    if (locald != null)
    {
      locald.a();
      this.b = null;
    }
  }
  
  private void c()
  {
    if (this.c != null) {
      this.c.a(new e.1(this));
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wxClient: ");
      localStringBuilder.append(paramString);
      localJSONArray.put(localStringBuilder.toString());
      localJSONObject.put("logs", localJSONArray);
      a(localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      o.a("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
    }
  }
  
  public void a(e.a parama, String paramString)
  {
    if ((parama != null) && (!af.c(paramString)))
    {
      int k = e.3.a[parama.ordinal()];
      int j = 0;
      int i = j;
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4) {
              i = j;
            } else {
              i = 3;
            }
          }
          else {
            i = 2;
          }
        }
        else {
          i = 1;
        }
      }
      a(i, paramString);
      return;
    }
    o.b("MicroMsg.GameInspector", "hy: not valid console!");
  }
  
  public void a(e.b paramb)
  {
    this.f = e.b.a(paramb);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.d != 0) {
        return;
      }
      this.a = e.b.b(paramb).getContext();
      if (e.b.c(paramb)) {
        a(this.f, e.b.d(paramb));
      }
      if (e.b.e(paramb)) {
        a(e.b.f(paramb), this.f);
      }
      a(e.b.b(paramb));
      synchronized (this.e)
      {
        if (this.d != 0) {
          return;
        }
        this.d = 1;
        if (e.b.e(paramb)) {
          c();
        }
        return;
      }
    }
    throw new IllegalStateException("You can only init GameInspector in main thread.");
  }
  
  protected void a(h paramh, com.tencent.magicbrush.e parame)
  {
    this.c = b.a(parame, this.a, paramh);
  }
  
  public void a(String paramString)
  {
    o.d("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.e)
    {
      if (this.d != 1)
      {
        this.e.add(paramString);
        return;
      }
      if (this.c == null) {
        return;
      }
      this.c.a(new e.2(this, paramString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.e
 * JD-Core Version:    0.7.0.1
 */