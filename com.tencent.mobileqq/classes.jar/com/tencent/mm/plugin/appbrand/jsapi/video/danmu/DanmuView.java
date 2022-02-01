package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private final Context a;
  private int b = 5;
  private int c = 500;
  private int d = 10;
  private float e = 0.0F;
  private float f = 0.6F;
  private boolean g = false;
  private boolean h = false;
  private c i;
  private HashMap<Integer, ArrayList<d>> j;
  private final Deque<d> k = new LinkedList();
  private List<d> l = new LinkedList();
  private int[] m;
  private volatile int n = 3;
  private volatile boolean o;
  private LinkedList<Long> p;
  private Paint q;
  private long r = 0L;
  private LinkedList<Float> s;
  
  public DanmuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private int b(d paramd)
  {
    int i1 = 0;
    try
    {
      Object localObject;
      while (i1 < this.b)
      {
        int i2 = (i1 + 0) % this.b;
        localObject = (ArrayList)this.j.get(Integer.valueOf(i2));
        if (((ArrayList)localObject).size() == 0) {
          return i2;
        }
        if (((ArrayList)localObject).size() <= this.d)
        {
          boolean bool = paramd.a((d)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1));
          if (!bool) {
            return i2;
          }
        }
        i1 += 1;
      }
      return -1;
    }
    catch (Exception paramd)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findVacant,Exception:");
      ((StringBuilder)localObject).append(paramd.getMessage());
      o.c("MicroMsg.DanmuView", ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2)
    {
      if ((paramFloat1 >= 0.0F) && (paramFloat1 < 1.0F) && (paramFloat2 >= 0.0F) && (paramFloat2 <= 1.0F)) {
        return;
      }
      throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
    }
    throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
  }
  
  private void f()
  {
    g();
    h();
  }
  
  private void g()
  {
    this.j = new HashMap(this.b);
    int i1 = 0;
    while (i1 < this.b)
    {
      ArrayList localArrayList = new ArrayList(this.d);
      this.j.put(Integer.valueOf(i1), localArrayList);
      i1 += 1;
    }
  }
  
  private void h()
  {
    this.m = new int[this.b];
    float f1 = b.a(this.a);
    float f2 = getHeight() * this.e;
    int i2 = 0;
    Object localObject;
    int i3;
    for (int i1 = 0; i1 < this.b; i1 = i3)
    {
      localObject = this.m;
      i3 = i1 + 1;
      localObject[i1] = ((int)(i3 * f1 + f2 - 3.0F * f1 / 4.0F));
    }
    if (this.h)
    {
      this.s.clear();
      this.s.add(Float.valueOf(f2));
      i1 = i2;
      while (i1 < this.b)
      {
        localObject = this.s;
        i1 += 1;
        ((LinkedList)localObject).add(Float.valueOf(i1 * f1 + f2));
      }
    }
  }
  
  private void i()
  {
    HashMap localHashMap = this.j;
    int i1;
    if (localHashMap != null) {
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.j.size())
        {
          ArrayList localArrayList = (ArrayList)this.j.get(Integer.valueOf(i1));
          if (localArrayList == null) {
            break label59;
          }
          localArrayList.clear();
          break label59;
        }
        return;
      }
      finally {}
      return;
      label59:
      i1 += 1;
    }
  }
  
  private void j()
  {
    if (p())
    {
      this.o = true;
      return;
    }
    post(new DanmuView.1(this));
  }
  
  private void k()
  {
    if (p())
    {
      this.o = false;
      invalidate();
      return;
    }
    post(new DanmuView.2(this));
  }
  
  private void l()
  {
    m();
    n();
  }
  
  private void m()
  {
    HashMap localHashMap = this.j;
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      this.j.clear();
    }
  }
  
  private void n()
  {
    synchronized (this.k)
    {
      if (!this.k.isEmpty()) {
        this.k.clear();
      }
      return;
    }
  }
  
  private double o()
  {
    long l1 = System.nanoTime();
    this.p.addLast(Long.valueOf(l1));
    double d1 = l1 - ((Long)this.p.getFirst()).longValue();
    Double.isNaN(d1);
    double d2 = d1 / 1000000000.0D;
    if (this.p.size() > 100) {
      this.p.removeFirst();
    }
    d1 = 0.0D;
    if (d2 > 0.0D)
    {
      d1 = this.p.size();
      Double.isNaN(d1);
      d1 /= d2;
    }
    return d1;
  }
  
  private boolean p()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void a()
  {
    b(this.e, this.f);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    f();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(paramInt) });
    j();
    l();
    a();
    f.a.c(new DanmuView.5(this, paramInt));
  }
  
  public void a(d paramd)
  {
    synchronized (this.k)
    {
      this.k.offerFirst(paramd);
      f.a.a(new DanmuView.3(this, paramd), "DanmuView-addItemToWaitingHead");
      return;
    }
  }
  
  public void a(List<d> paramList, boolean paramBoolean)
  {
    j();
    l();
    this.l.clear();
    a();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b(paramList, paramBoolean);
      k();
      return;
    }
    k();
  }
  
  public void b()
  {
    this.n = 1;
    invalidate();
  }
  
  public void b(List<d> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f.a.f(new DanmuView.4(this, paramList));
      return;
    }
    synchronized (this.k)
    {
      this.k.addAll(paramList);
      synchronized (this.l)
      {
        this.l.addAll(paramList);
        return;
      }
    }
  }
  
  public void c()
  {
    this.n = 2;
    invalidate();
  }
  
  public void d()
  {
    this.n = 4;
    invalidate();
  }
  
  public void e()
  {
    this.n = 3;
    l();
    this.l.clear();
    invalidate();
  }
  
  public float getYOffset()
  {
    return this.f - this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.o)
    {
      o.d("MicroMsg.DanmuView", "inTransition");
      return;
    }
    int i1;
    Object localObject1;
    float f1;
    if (this.n == 1) {
      try
      {
        paramCanvas.drawColor(0);
        i1 = 0;
        if (i1 < this.j.size())
        {
          localObject1 = ((ArrayList)this.j.get(Integer.valueOf(i1))).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (d)((Iterator)localObject1).next();
            if (((d)???).b()) {
              ((Iterator)localObject1).remove();
            } else {
              ((d)???).a(paramCanvas, false);
            }
          }
        }
        if (System.currentTimeMillis() - this.r > this.c)
        {
          this.r = System.currentTimeMillis();
          synchronized (this.k)
          {
            if (this.k.size() > 0)
            {
              localObject1 = (d)this.k.getFirst();
              i1 = this.i.a();
              while ((localObject1 != null) && (((d)localObject1).b(i1)))
              {
                this.k.pollFirst();
                localObject1 = (d)this.k.getFirst();
              }
              if ((localObject1 != null) && (((d)localObject1).a(i1)))
              {
                i1 = b((d)localObject1);
                if (i1 >= 0)
                {
                  ((d)localObject1).a(paramCanvas.getWidth() - 2, this.m[i1]);
                  ((d)localObject1).a(paramCanvas, false);
                  ((ArrayList)this.j.get(Integer.valueOf(i1))).add(localObject1);
                  this.k.pollFirst();
                }
              }
            }
          }
        }
        if ((this.g) && (this.p != null))
        {
          i1 = (int)o();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("FPS:");
          ((StringBuilder)localObject1).append(i1);
          paramCanvas.drawText(((StringBuilder)localObject1).toString(), 5.0F, 20.0F, this.q);
        }
        if ((this.h) && (this.s != null))
        {
          localObject1 = this.s.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f1 = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f1, getWidth(), f1, this.q);
          }
        }
        if (this.n != 2) {}
      }
      catch (Exception paramCanvas)
      {
        o.c("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramCanvas.drawColor(0);
        i1 = 0;
        if (i1 < this.j.size())
        {
          localObject1 = ((ArrayList)this.j.get(Integer.valueOf(i1))).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label715;
          }
          ((d)((Iterator)localObject1).next()).a(paramCanvas, true);
          continue;
        }
        if ((this.g) && (this.p != null))
        {
          i1 = (int)o();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("FPS:");
          ((StringBuilder)localObject1).append(i1);
          paramCanvas.drawText(((StringBuilder)localObject1).toString(), 5.0F, 20.0F, this.q);
        }
        if ((this.h) && (this.s != null))
        {
          localObject1 = this.s.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            f1 = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f1, getWidth(), f1, this.q);
            continue;
          }
        }
        return;
      }
      catch (Exception paramCanvas)
      {
        o.c("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
      }
      i1 += 1;
      break;
      label715:
      i1 += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    h();
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.i = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    this.b = paramInt;
    i();
    f();
  }
  
  public void setMaxRunningPerRow(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if ((paramBoolean) && ((this.q == null) || (this.p == null)))
    {
      this.q = new TextPaint(1);
      this.q.setColor(-256);
      this.q.setTextSize(20.0F);
      this.p = new LinkedList();
    }
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if ((paramBoolean) && (this.s == null)) {
      this.s = new LinkedList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */