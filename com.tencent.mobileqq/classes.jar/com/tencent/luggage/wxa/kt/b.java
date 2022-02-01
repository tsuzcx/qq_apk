package com.tencent.luggage.wxa.kt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ks.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
  implements com.tencent.luggage.wxa.mn.g
{
  private static HashMap<Integer, b> j = new HashMap();
  GradientDrawable a = new GradientDrawable();
  float[] b = new float[8];
  private float c;
  private float[] d;
  private float e;
  private int f;
  private int g;
  private Paint h = new Paint();
  private View i;
  private boolean k = false;
  private String l = "";
  private int m;
  private int n;
  private boolean o = false;
  private String p;
  private float q;
  private float r;
  private long s;
  private View.OnClickListener t;
  private int u = 0;
  private int v = 0;
  private b.a w;
  
  public b(@NonNull Context paramContext, View paramView)
  {
    super(paramContext);
    setTargetView(paramView);
    b();
  }
  
  public static RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private JSONObject a(MotionEvent paramMotionEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.m);
      localJSONObject.put("x", com.tencent.luggage.wxa.pc.g.a(paramMotionEvent.getRawX()));
      localJSONObject.put("y", com.tencent.luggage.wxa.pc.g.a(paramMotionEvent.getRawY()));
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      label51:
      break label51;
    }
    return null;
  }
  
  private JSONObject a(View paramView, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", com.tencent.luggage.wxa.pc.g.a(paramView.getX()));
      localJSONObject.put("top", com.tencent.luggage.wxa.pc.g.a(paramView.getY()));
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      label48:
      break label48;
    }
    return null;
  }
  
  private void a(String paramString, b paramb, MotionEvent paramMotionEvent)
  {
    b.a locala = this.w;
    if (locala != null) {
      locala.a(paramString, paramb.l, a(paramb, paramb.m), a(paramMotionEvent));
    }
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    if (paramViewGroup1 == paramViewGroup2) {
      return false;
    }
    int i2 = paramViewGroup1.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup1.getChildAt(i1);
      if (localView == paramViewGroup2) {
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private Drawable getShadowDrawable()
  {
    int i1 = this.g;
    if (i1 != 0) {
      this.a.setColor(i1);
    }
    float[] arrayOfFloat1 = this.b;
    float[] arrayOfFloat2 = this.d;
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[1] = arrayOfFloat2[0];
    arrayOfFloat1[2] = arrayOfFloat2[1];
    arrayOfFloat1[3] = arrayOfFloat2[1];
    arrayOfFloat1[4] = arrayOfFloat2[3];
    arrayOfFloat1[5] = arrayOfFloat2[3];
    arrayOfFloat1[6] = arrayOfFloat2[2];
    arrayOfFloat1[7] = arrayOfFloat2[2];
    this.a.setCornerRadii(arrayOfFloat1);
    float f1 = this.e;
    if (f1 > 0.0F)
    {
      i1 = this.f;
      if (i1 != 0) {
        this.a.setStroke((int)f1, i1);
      }
    }
    return this.a;
  }
  
  public <T> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      if (paramClass.isAssignableFrom(this.i.getClass()))
      {
        paramClass = this.i;
        return paramClass;
      }
    }
    catch (Exception paramClass)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    j.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(paramBoolean, paramInt, this.l);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.k = paramBoolean;
    this.m = paramInt;
    if (paramBoolean)
    {
      this.l = paramString;
      j.put(Integer.valueOf(paramInt), this);
      return;
    }
    j.remove(Integer.valueOf(paramInt));
  }
  
  protected boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.c;
    if (f1 <= 0.0F) {
      return true;
    }
    double d1 = Math.pow(f1, 2.0D);
    f1 = getWidth();
    float f2 = getHeight();
    float f3 = this.c;
    if (paramFloat1 < f3)
    {
      if (paramFloat2 < f3)
      {
        if (Math.pow(f3 - paramFloat1, 2.0D) + Math.pow(this.c - paramFloat2, 2.0D) > d1) {
          return false;
        }
      }
      else if ((paramFloat2 > f2 - f3) && (Math.pow(f3 - paramFloat1, 2.0D) + Math.pow(paramFloat2 + this.c - f2, 2.0D) > d1)) {
        return false;
      }
    }
    else if (paramFloat1 > f1 - f3) {
      if (paramFloat2 < f3)
      {
        if (Math.pow(paramFloat1 + f3 - f1, 2.0D) + Math.pow(this.c - paramFloat2, 2.0D) > d1) {
          return false;
        }
      }
      else if ((paramFloat2 > f2 - f3) && (Math.pow(paramFloat1 + f3 - f1, 2.0D) + Math.pow(paramFloat2 + this.c - f2, 2.0D) > d1)) {
        return false;
      }
    }
    return true;
  }
  
  public void addView(View paramView, int paramInt)
  {
    int i1;
    if (paramInt < 0)
    {
      i1 = 0;
    }
    else
    {
      i1 = paramInt;
      if (paramInt > getChildCount() - 1) {
        i1 = getChildCount() - 1;
      }
    }
    super.addView(paramView, i1 + 1);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    int i1;
    if (paramInt < 0)
    {
      i1 = 0;
    }
    else
    {
      i1 = paramInt;
      if (paramInt > getChildCount() - 1) {
        i1 = getChildCount() - 1;
      }
    }
    super.addView(paramView, i1 + 1, paramLayoutParams);
  }
  
  protected void b()
  {
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.u == 0)
    {
      this.u = localWindowManager.getDefaultDisplay().getWidth();
      this.v = localWindowManager.getDefaultDisplay().getHeight();
    }
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = a(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!a(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool)) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      super.draw(paramCanvas);
      return;
    }
    float f1 = this.c;
    float f2 = 0.0F;
    int i1;
    if (f1 > 0.0F) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramCanvas.save();
      localObject = new Path();
      RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      f1 = this.c;
      ((Path)localObject).addRoundRect(localRectF, f1, f1, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject);
    }
    int i2 = this.g;
    if (i2 != 0) {
      paramCanvas.drawColor(i2);
    }
    f1 = this.e;
    i2 = i1;
    if (f1 > 0.0F)
    {
      f1 /= 2.0F;
      localObject = new RectF(f1, f1, getWidth() - f1, getHeight() - f1);
      f1 = this.c;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.h);
      if (i1 != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      localObject = new Path();
      float f3 = this.c;
      f1 = f2;
      if (f3 > 0.0F)
      {
        float f4 = this.e;
        f1 = f2;
        if (f3 - f4 > 0.0F) {
          f1 = f3 - f4;
        }
      }
      f2 = this.e;
      ((Path)localObject).addRoundRect(new RectF(f2, f2, getWidth() - this.e, getHeight() - this.e), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject);
      i2 = 1;
    }
    super.draw(paramCanvas);
    if (i2 != 0) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("event: ");
    ((StringBuilder)localObject).append(paramMotionEvent.getAction());
    o.e("MicroMsg.CoverViewContainer", ((StringBuilder)localObject).toString());
    if (this.k)
    {
      localObject = this;
    }
    else
    {
      i1 = this.n;
      if (i1 > 0) {
        localObject = (b)j.get(Integer.valueOf(i1));
      } else {
        localObject = null;
      }
    }
    if ((!this.k) && ((!this.o) || (!a((ViewGroup)localObject, this)))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        float f1 = paramMotionEvent.getRawX() - this.q;
        float f2 = paramMotionEvent.getRawY() - this.r;
        if ((localObject != null) && ((Math.abs(f1) > 1.0F) || (Math.abs(f2) > 1.0F)))
        {
          int i3 = (int)(((b)localObject).getX() + f1);
          int i2 = (int)(((b)localObject).getY() + f2);
          int i4;
          if (i3 < 0)
          {
            i1 = 0;
          }
          else
          {
            i4 = ((b)localObject).getWidth();
            int i5 = this.u;
            i1 = i3;
            if (i4 + i3 > i5) {
              i1 = i5 - ((b)localObject).getWidth();
            }
          }
          ((b)localObject).setX(i1);
          if (i2 < 0)
          {
            i1 = 0;
          }
          else
          {
            i3 = ((b)localObject).getHeight();
            i4 = this.v;
            i1 = i2;
            if (i3 + i2 > i4) {
              i1 = i4 - ((b)localObject).getHeight();
            }
          }
          ((b)localObject).setY(i1);
          this.q = paramMotionEvent.getRawX();
          this.r = paramMotionEvent.getRawY();
          a("dragging", (b)localObject, paramMotionEvent);
          return true;
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        long l1 = this.s;
        l2 -= l1;
        if ((l1 != 0L) && (l2 < 300L) && (l2 >= 0L))
        {
          View.OnClickListener localOnClickListener = this.t;
          if (localOnClickListener != null) {
            localOnClickListener.onClick(this);
          }
        }
        if (localObject != null)
        {
          a("end", (b)localObject, paramMotionEvent);
          return true;
        }
      }
    }
    else
    {
      this.q = paramMotionEvent.getRawX();
      this.r = paramMotionEvent.getRawY();
      this.s = System.currentTimeMillis();
      if (localObject != null) {
        a("start", (b)localObject, paramMotionEvent);
      }
    }
    return true;
  }
  
  public void setBgColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.f = paramInt;
    this.h.setColor(paramInt);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    this.d = paramArrayOfFloat;
    paramArrayOfFloat = this.d;
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length > 0)) {
      setBackground(getShadowDrawable());
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.e = paramFloat;
    this.h.setStrokeWidth(paramFloat);
  }
  
  public void setDragConfig(String paramString)
  {
    this.p = paramString;
  }
  
  public void setDragEventCallback(b.a parama)
  {
    this.w = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.t = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    this.i = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.b
 * JD-Core Version:    0.7.0.1
 */