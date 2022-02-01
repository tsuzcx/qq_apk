package com.tencent.biz.qqcircle.richframework.widget.drag;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragFrameLayout
  extends FrameLayout
  implements IDragView.OnChangeModeListener
{
  private static final int[] u = { 2130842414, 2130842415, 2130842416, 2130842417, 2130842418 };
  private final int a;
  private final int b;
  private final int c;
  private int d = -1;
  private Bitmap e;
  private Bitmap f;
  private int g;
  private View h;
  private int i;
  private DragFrameLayout.IDragViewProvider j;
  private DragFrameLayout.OnDragListener k;
  private Paint l = new Paint();
  private DragFrameLayout.ShakeRunner m;
  private DragFrameLayout.BornRunner n;
  private DragFrameLayout.AllBornRunner o;
  private Rect p = new Rect();
  private int q;
  private PointF r = new PointF(-1.0F, -1.0F);
  private float s;
  private final List<DragFrameLayout.OnDragModeChangedListener> t = new ArrayList();
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
    this.b = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.a = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setWillNotDraw(false);
    this.b = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.a = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setWillNotDraw(false);
    this.b = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.a = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  private static Bitmap a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = paramView.getDrawingCache();
    if (localBitmap != null) {}
    try
    {
      localBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    localBitmap = null;
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if ((localView instanceof DragFrameLayout)) {
      return (DragFrameLayout)localView;
    }
    paramActivity = new DragFrameLayout(paramActivity.getApplication());
    localViewGroup.addView(paramActivity, 0);
    localViewGroup.removeView(localView);
    paramActivity.addView(localView);
    return paramActivity;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    DragFrameLayout.OnDragListener localOnDragListener = this.k;
    if (localOnDragListener != null) {
      localOnDragListener.a(paramFloat1, paramFloat2, paramInt, this.h);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.d == -1) {
      return;
    }
    this.l.setAntiAlias(true);
    int i1 = this.g;
    if (i1 != 0) {
      this.l.setColor(i1);
    } else if (this.i == 1) {
      this.l.setColor(-4797728);
    } else {
      this.l.setColor(-65536);
    }
    i1 = this.d;
    if (i1 == 0)
    {
      paramCanvas.drawBitmap(this.f, this.p.left, this.p.top, this.l);
      return;
    }
    float f3;
    float f2;
    float f1;
    Object localObject;
    if (i1 == 1)
    {
      paramCanvas.save();
      i1 = this.q;
      f3 = i1 / 1.5F;
      f2 = i1 * (0.8F - this.s * 0.45F / this.a);
      i1 = this.c;
      f1 = f2;
      if (f2 > i1) {
        f1 = i1;
      }
      i1 = this.b;
      f2 = f1;
      if (f1 < i1) {
        f2 = i1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MODE_DRAG:");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(this.s);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
      }
      paramCanvas.translate(this.p.centerX(), this.p.centerY());
      paramCanvas.rotate((float)(Math.atan2(this.r.y - this.p.centerY(), this.r.x - this.p.centerX()) * 57.295779513082323D) - 90.0F);
      paramCanvas.translate(-f3, -f2);
      a(paramCanvas, f2, f3);
      paramCanvas.restore();
      this.l.setColor(-16711936);
      paramCanvas.drawBitmap(this.f, this.r.x - this.p.width() / 2.0F, this.r.y - this.p.height() / 2.0F, this.l);
      return;
    }
    if ((i1 != 3) && (i1 != 6))
    {
      if (i1 == 2)
      {
        paramCanvas.drawBitmap(this.f, this.r.x - this.p.width() / 2.0F, this.r.y - this.p.height() / 2.0F, this.l);
        return;
      }
      if (i1 == 4)
      {
        localObject = this.n;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.BornRunner)localObject).a();
          if (localObject != null) {
            paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new RectF(this.r.x - ((Bitmap)localObject).getWidth() / 2.0F, this.r.y - ((Bitmap)localObject).getHeight() / 2.0F, this.r.x + ((Bitmap)localObject).getWidth() / 2.0F, this.r.y + ((Bitmap)localObject).getHeight() / 2.0F), this.l);
          }
          postDelayed(this.n, 50L);
        }
      }
      else if (i1 == 5)
      {
        localObject = this.o;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.AllBornRunner)localObject).a();
          Bitmap localBitmap = this.o.b();
          if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
            paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.l);
          }
          if (DragFrameLayout.AllBornRunner.a(this.o) == -1)
          {
            post(this.o);
            return;
          }
          postDelayed(this.o, 25L);
        }
      }
    }
    else
    {
      localObject = this.m;
      if ((localObject != null) && (this.f != null))
      {
        localObject = ((DragFrameLayout.ShakeRunner)localObject).a();
        this.r.set((PointF)localObject);
        this.s = ((float)Math.sqrt((this.r.x - this.p.centerX()) * (this.r.x - this.p.centerX()) + (this.r.y - this.p.centerY()) * (this.r.y - this.p.centerY())));
        paramCanvas.save();
        f3 = this.q / 1.5F;
        f2 = (1.0F - this.s / this.a) * f3;
        i1 = this.c;
        f1 = f2;
        if (f2 > i1 / 2) {
          f1 = i1 / 2;
        }
        i1 = this.b;
        f2 = f1;
        if (f1 < i1) {
          f2 = i1;
        }
        paramCanvas.translate(this.p.centerX(), this.p.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.r.y - this.p.centerY(), this.r.x - this.p.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.l.setColor(-16711936);
        paramCanvas.drawBitmap(this.f, this.r.x - this.p.width() / 2.0F, this.r.y - this.p.height() / 2.0F, this.l);
        postDelayed(this.m, 60L);
      }
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("drawAtOrigion:");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramFloat2);
      QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
    }
    float f1 = this.s;
    float f3 = paramFloat1 / 2.0F;
    float f2 = paramFloat2 - f3;
    f3 = paramFloat2 + f3;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.l);
    Object localObject = new Path();
    ((Path)localObject).moveTo(paramFloat2 + paramFloat1, paramFloat1);
    float f4 = 0.5F + (paramFloat1 + f1);
    ((Path)localObject).cubicTo(f3, paramFloat1 + 0.3F * f1, f3, paramFloat1 + f1 * 0.7F, paramFloat2 + paramFloat2, f4);
    ((Path)localObject).lineTo(paramFloat2 - paramFloat2, f4);
    ((Path)localObject).cubicTo(f2, f1 * 0.7F + paramFloat1, f2, f1 * 0.3F + paramFloat1, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath((Path)localObject, this.l);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == -1) {
      this.g = 0;
    }
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).onChange(paramBoolean, this.i, this);
    }
  }
  
  private void setMode(int paramInt)
  {
    this.d = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMode:");
      localStringBuilder.append(this.d);
      QLog.d("Drag", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (this.d != -1)
    {
      if (this.m != null)
      {
        getHandler().removeCallbacks(this.m);
        this.m = null;
      }
      if (this.n != null)
      {
        getHandler().removeCallbacks(this.n);
        this.n = null;
      }
      if (this.o != null)
      {
        getHandler().removeCallbacks(this.o);
        this.o = null;
      }
      boolean bool;
      if (this.d == 5) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause call, mMode=");
      localStringBuilder.append(this.d);
      QLog.d("DragFrameLayout", 2, new Object[] { localStringBuilder.toString(), " isDone=", Boolean.valueOf(bool) });
      setMode(-1);
      a(bool);
      this.f = null;
      this.h = null;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModeChanged:");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
    }
    this.g = 0;
    this.e = a(paramView);
    Object localObject = this.e;
    if (localObject != null)
    {
      this.g = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, 1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getOrginalCachePixel:");
        ((StringBuilder)localObject).append(this.g);
        QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Matrix();
      ((Matrix)localObject).postScale(1.1F, 1.1F);
      Bitmap localBitmap = this.e;
      this.f = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), this.e.getHeight(), (Matrix)localObject, true);
      getGlobalVisibleRect(this.p);
      int i1 = this.p.left;
      int i2 = this.p.top;
      paramView.getGlobalVisibleRect(this.p);
      localObject = this.p;
      ((Rect)localObject).left -= i1;
      localObject = this.p;
      ((Rect)localObject).top -= i2;
      localObject = this.p;
      ((Rect)localObject).right -= i1;
      localObject = this.p;
      ((Rect)localObject).bottom -= i2;
      i1 = this.p.width();
      i2 = this.p.height();
      localObject = this.p;
      float f1 = ((Rect)localObject).left;
      float f2 = i1;
      f2 = (f2 * 1.1F - f2) / 2.0F;
      ((Rect)localObject).left = ((int)(f1 - f2));
      localObject = this.p;
      ((Rect)localObject).right = ((int)(((Rect)localObject).right + f2));
      localObject = this.p;
      f1 = ((Rect)localObject).bottom;
      f2 = i2;
      f2 = (1.1F * f2 - f2) / 2.0F;
      ((Rect)localObject).bottom = ((int)(f1 + f2));
      localObject = this.p;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - f2));
      double d1 = Math.min(this.p.width(), this.p.height());
      Double.isNaN(d1);
      this.q = ((int)(d1 * 0.8D));
      i1 = this.q;
      i2 = this.c;
      if (i1 > i2) {
        this.q = i2;
      }
      this.h = paramView;
      setMode(0);
      this.i = paramInt;
      paramView.setVisibility(4);
      invalidate();
      a(false);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("init:");
        paramView.append(this.p);
        QLog.d("Drag", 2, paramView.toString());
      }
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((paramOnDragModeChangedListener != null) && (!this.t.contains(paramOnDragModeChangedListener)))
    {
      if (!paramBoolean)
      {
        this.t.add(paramOnDragModeChangedListener);
        return;
      }
      this.t.add(0, paramOnDragModeChangedListener);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      label5:
      a(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    StringBuilder localStringBuilder;
    if (this.d == -1)
    {
      if ((i1 == 0) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Host.dispatchTouchEvent: Down At<");
        localStringBuilder.append(paramMotionEvent.getX());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramMotionEvent.getY());
        localStringBuilder.append(">");
        QLog.d("Drag", 2, localStringBuilder.toString());
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Host.dispatchTouchEvent: ");
      localStringBuilder.append(paramMotionEvent.getAction());
      localStringBuilder.append(" At<");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMotionEvent.getY());
      localStringBuilder.append(">");
      QLog.d("Drag", 2, localStringBuilder.toString());
    }
    if ((this.d != 6) && (this.i == 4))
    {
      setMode(6);
      paramMotionEvent = new RectF(this.p.centerX(), this.p.centerY(), this.p.centerX() - 6, this.p.centerY());
      this.m = new DragFrameLayout.ShakeRunner(this, new PointF(this.p.centerX(), this.p.centerY()), paramMotionEvent);
      invalidate();
    }
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 == 2)
      {
        i1 = this.d;
        if ((i1 != 0) && (i1 != 1))
        {
          if (i1 == 3) {
            return true;
          }
          if (i1 == 2)
          {
            this.r.set(f1, f2);
            a(this.p.centerX() - f1, this.p.centerY() - f2, 2);
            invalidate();
            return true;
          }
        }
        else
        {
          float f3 = (float)Math.sqrt((f1 - this.p.centerX()) * (f1 - this.p.centerX()) + (f2 - this.p.centerY()) * (f2 - this.p.centerY()));
          if (f3 >= this.q + this.a)
          {
            this.s = f3;
            this.r.set(f1, f2);
            setMode(2);
            a(this.p.centerX() - f1, this.p.centerY() - f2, 2);
          }
          else if (f3 >= 0.0F)
          {
            this.s = f3;
            this.r.set(f1, f2);
            setMode(1);
            a(this.p.centerX() - f1, this.p.centerY() - f2, 1);
          }
          else
          {
            setMode(0);
            a(0.0F, 0.0F, 0);
          }
          invalidate();
          return true;
        }
      }
    }
    else
    {
      a(this.p.centerX() - f1, this.p.centerY() - f2, -1);
      i1 = this.d;
      if (i1 == 0)
      {
        this.f = null;
        this.h.setVisibility(0);
        this.h = null;
        setMode(-1);
        invalidate();
        a(false);
        return true;
      }
      if (i1 == 1)
      {
        setMode(3);
        this.r.set(f1, f2);
        paramMotionEvent = new RectF(this.p.centerX(), this.p.centerY(), this.r.x, this.r.y);
        this.m = new DragFrameLayout.ShakeRunner(this, new PointF(this.p.centerX(), this.p.centerY()), paramMotionEvent);
        invalidate();
        return true;
      }
      if (i1 == 3) {
        return true;
      }
      if (i1 == 2)
      {
        if ((float)Math.sqrt((f1 - this.p.centerX()) * (f1 - this.p.centerX()) + (f2 - this.p.centerY()) * (f2 - this.p.centerY())) < (this.q + this.a) / 2)
        {
          this.f = null;
          this.h.setVisibility(0);
          this.h = null;
          setMode(-1);
          a(false);
        }
        else
        {
          setMode(4);
          this.r.set(f1, f2);
          this.n = new DragFrameLayout.BornRunner(this, this.r);
        }
        invalidate();
      }
    }
    return true;
  }
  
  public View getDragView()
  {
    return this.h;
  }
  
  public int getMode()
  {
    return this.d;
  }
  
  public void setDragViewProvider(DragFrameLayout.IDragViewProvider paramIDragViewProvider)
  {
    this.j = paramIDragViewProvider;
  }
  
  public void setOnDragListener(DragFrameLayout.OnDragListener paramOnDragListener)
  {
    this.k = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.drag.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */