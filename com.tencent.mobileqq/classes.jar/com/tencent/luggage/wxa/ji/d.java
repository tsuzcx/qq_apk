package com.tencent.luggage.wxa.ji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ja.f;
import com.tencent.luggage.wxa.jh.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class d
  extends View
  implements b
{
  private final com.tencent.luggage.wxa.ja.b a = new com.tencent.luggage.wxa.ja.b(this);
  private final Set<View.OnAttachStateChangeListener> b = new LinkedHashSet();
  private Bitmap c;
  
  public d(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private void d()
  {
    o.f("MicroMsg.MCanvasView", "init %s", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  private void e()
  {
    Bitmap localBitmap = this.c;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      o.d("MicroMsg.MCanvasView", "bitmap recycle %s %s", new Object[] { Integer.valueOf(hashCode()), this.c });
      this.c.recycle();
    }
  }
  
  public void a()
  {
    o.f("MicroMsg.MCanvasView", "onPause :%s", new Object[] { Integer.valueOf(hashCode()) });
    this.a.c();
    e();
  }
  
  public void a(Runnable paramRunnable)
  {
    post(paramRunnable);
  }
  
  public void a(JSONArray paramJSONArray, b.a parama)
  {
    this.a.a(paramJSONArray, parama);
  }
  
  public boolean a(Canvas paramCanvas)
  {
    return this.a.a(paramCanvas);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    if (this.b.contains(paramOnAttachStateChangeListener)) {
      return;
    }
    this.b.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public void b()
  {
    if (!ViewCompat.isLaidOut(this))
    {
      post(new d.1(this));
      return;
    }
    postInvalidate();
  }
  
  public void b(JSONArray paramJSONArray, b.a parama)
  {
    this.a.b(paramJSONArray, parama);
  }
  
  public void c()
  {
    o.f("MicroMsg.MCanvasView", "onResume :%s", new Object[] { Integer.valueOf(hashCode()) });
    this.a.d();
  }
  
  public com.tencent.luggage.wxa.ja.d getDrawContext()
  {
    return this.a.f();
  }
  
  public String getSessionId()
  {
    return this.a.e();
  }
  
  public String getTraceId()
  {
    return this.a.g();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (i > 0)
    {
      if (j <= 0) {
        return;
      }
      localObject = this.c;
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()) || (this.c.getWidth() != i) || (this.c.getHeight() != j)) {
        e();
      }
    }
    try
    {
      this.c = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      o.f("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label114:
      break label114;
    }
    o.b("MicroMsg.MCanvasView", "onDraw oom w:%d h:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    this.c = null;
    Object localObject = this.c;
    if (localObject == null)
    {
      o.e("MicroMsg.MCanvasView", "bitmap is null.");
      return;
    }
    ((Bitmap)localObject).eraseColor(0);
    localObject = new f(this.c);
    a((Canvas)localObject);
    try
    {
      paramCanvas.drawBitmap(((f)localObject).a(), 0.0F, 0.0F, null);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MCanvasView", localException, "", new Object[0]);
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    e();
    paramInt3 = getMeasuredWidth();
    paramInt4 = getMeasuredHeight();
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    try
    {
      this.c = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      o.f("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label83:
      break label83;
    }
    o.b("MicroMsg.MCanvasView", "onSizeChanged oom w:%d h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.c = null;
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.b.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public void setDrawActionReportable(a parama)
  {
    this.a.a(parama);
  }
  
  public void setSessionId(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void setStartTime(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void setTraceId(String paramString)
  {
    this.a.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ji.d
 * JD-Core Version:    0.7.0.1
 */