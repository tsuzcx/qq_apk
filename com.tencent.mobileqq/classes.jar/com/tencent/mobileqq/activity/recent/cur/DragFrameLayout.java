package com.tencent.mobileqq.activity.recent.cur;

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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DragFrameLayout
  extends FrameLayout
  implements IDragView.OnChangeModeListener
{
  private static final int[] x = { 2130843433, 2130843434, 2130843435, 2130843436, 2130843437 };
  private final int a;
  private final int b;
  private final int c;
  private int d = -1;
  private Bitmap e;
  private Bitmap f;
  private int g;
  private View h;
  private int i;
  private String j;
  private DragFrameLayout.IDragViewProvider k;
  private HashMap<String, DragFrameLayout.IDragViewProvider> l = new HashMap();
  private DragFrameLayout.OnDragListener m;
  private Paint n = new Paint();
  private DragFrameLayout.ShakeRunner o;
  private DragFrameLayout.BornRunner p;
  private DragFrameLayout.AllBornRunner q;
  private Rect r = new Rect();
  private int s;
  private PointF t = new PointF(-1.0F, -1.0F);
  private float u;
  private final List<DragFrameLayout.OnDragModeChangedListener> v = new ArrayList();
  private final HashMap<String, List<DragFrameLayout.OnDragModeChangedListener>> w = new HashMap();
  
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
    if ((localView != null) && ((localView instanceof DragFrameLayout))) {
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
    DragFrameLayout.OnDragListener localOnDragListener = this.m;
    if (localOnDragListener != null) {
      localOnDragListener.a(paramFloat1, paramFloat2, paramInt, this.h);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.d == -1) {
      return;
    }
    this.n.setAntiAlias(true);
    int i1 = this.g;
    if (i1 != 0) {
      this.n.setColor(i1);
    } else if (this.i == 1) {
      this.n.setColor(-4797728);
    } else {
      this.n.setColor(-65536);
    }
    i1 = this.d;
    if (i1 == 0)
    {
      paramCanvas.drawBitmap(this.f, this.r.left, this.r.top, this.n);
      return;
    }
    float f3;
    float f2;
    float f1;
    Object localObject;
    if (i1 == 1)
    {
      paramCanvas.save();
      i1 = this.s;
      f3 = i1 / 1.5F;
      f2 = i1 * (0.8F - this.u * 0.45F / this.a);
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
        ((StringBuilder)localObject).append(this.u);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
      }
      paramCanvas.translate(this.r.centerX(), this.r.centerY());
      paramCanvas.rotate((float)(Math.atan2(this.t.y - this.r.centerY(), this.t.x - this.r.centerX()) * 57.295779513082323D) - 90.0F);
      paramCanvas.translate(-f3, -f2);
      a(paramCanvas, f2, f3);
      paramCanvas.restore();
      this.n.setColor(-16711936);
      paramCanvas.drawBitmap(this.f, this.t.x - this.r.width() / 2.0F, this.t.y - this.r.height() / 2.0F, this.n);
      return;
    }
    if ((i1 != 3) && (i1 != 6))
    {
      if (i1 == 2)
      {
        paramCanvas.drawBitmap(this.f, this.t.x - this.r.width() / 2.0F, this.t.y - this.r.height() / 2.0F, this.n);
        return;
      }
      if (i1 == 4)
      {
        localObject = this.p;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.BornRunner)localObject).a();
          if (localObject != null) {
            paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new RectF(this.t.x - ((Bitmap)localObject).getWidth() / 2.0F, this.t.y - ((Bitmap)localObject).getHeight() / 2.0F, this.t.x + ((Bitmap)localObject).getWidth() / 2.0F, this.t.y + ((Bitmap)localObject).getHeight() / 2.0F), this.n);
          }
          postDelayed(this.p, 50L);
        }
      }
      else if (i1 == 5)
      {
        localObject = this.q;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.AllBornRunner)localObject).a();
          Bitmap localBitmap = this.q.b();
          if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
            paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.n);
          }
          if (DragFrameLayout.AllBornRunner.a(this.q) == -1)
          {
            post(this.q);
            return;
          }
          postDelayed(this.q, 25L);
        }
      }
    }
    else
    {
      localObject = this.o;
      if ((localObject != null) && (this.f != null))
      {
        localObject = ((DragFrameLayout.ShakeRunner)localObject).a();
        this.t.set((PointF)localObject);
        this.u = ((float)Math.sqrt((this.t.x - this.r.centerX()) * (this.t.x - this.r.centerX()) + (this.t.y - this.r.centerY()) * (this.t.y - this.r.centerY())));
        paramCanvas.save();
        f3 = this.s / 1.5F;
        f2 = (1.0F - this.u / this.a) * f3;
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
        paramCanvas.translate(this.r.centerX(), this.r.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.t.y - this.r.centerY(), this.t.x - this.r.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.n.setColor(-16711936);
        paramCanvas.drawBitmap(this.f, this.t.x - this.r.width() / 2.0F, this.t.y - this.r.height() / 2.0F, this.n);
        postDelayed(this.o, 60L);
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
    float f1 = this.u;
    float f3 = paramFloat1 / 2.0F;
    float f2 = paramFloat2 - f3;
    f3 = paramFloat2 + f3;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.n);
    Object localObject = new Path();
    ((Path)localObject).moveTo(paramFloat2 + paramFloat1, paramFloat1);
    float f4 = 0.5F + (paramFloat1 + f1);
    ((Path)localObject).cubicTo(f3, paramFloat1 + 0.3F * f1, f3, paramFloat1 + f1 * 0.7F, paramFloat2 + paramFloat2, f4);
    ((Path)localObject).lineTo(paramFloat2 - paramFloat2, f4);
    ((Path)localObject).cubicTo(f2, f1 * 0.7F + paramFloat1, f2, f1 * 0.3F + paramFloat1, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath((Path)localObject, this.n);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == -1) {
      this.g = 0;
    }
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).onChange(paramBoolean, this.i, this);
    }
    if (!TextUtils.isEmpty(this.j))
    {
      if (!this.w.containsKey(this.j)) {
        return;
      }
      localIterator = ((List)this.w.get(this.j)).iterator();
      while (localIterator.hasNext()) {
        ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).onChange(paramBoolean, this.i, this);
      }
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
      if (this.o != null)
      {
        getHandler().removeCallbacks(this.o);
        this.o = null;
      }
      if (this.p != null)
      {
        getHandler().removeCallbacks(this.p);
        this.p = null;
      }
      if (this.q != null)
      {
        getHandler().removeCallbacks(this.q);
        this.q = null;
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
  
  public void a(View paramView, int paramInt, String paramString)
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
      getGlobalVisibleRect(this.r);
      int i1 = this.r.left;
      int i2 = this.r.top;
      paramView.getGlobalVisibleRect(this.r);
      localObject = this.r;
      ((Rect)localObject).left -= i1;
      localObject = this.r;
      ((Rect)localObject).top -= i2;
      localObject = this.r;
      ((Rect)localObject).right -= i1;
      localObject = this.r;
      ((Rect)localObject).bottom -= i2;
      i1 = this.r.width();
      i2 = this.r.height();
      localObject = this.r;
      float f1 = ((Rect)localObject).left;
      float f2 = i1;
      f2 = (f2 * 1.1F - f2) / 2.0F;
      ((Rect)localObject).left = ((int)(f1 - f2));
      localObject = this.r;
      ((Rect)localObject).right = ((int)(((Rect)localObject).right + f2));
      localObject = this.r;
      f1 = ((Rect)localObject).bottom;
      f2 = i2;
      f2 = (1.1F * f2 - f2) / 2.0F;
      ((Rect)localObject).bottom = ((int)(f1 + f2));
      localObject = this.r;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - f2));
      double d1 = Math.min(this.r.width(), this.r.height());
      Double.isNaN(d1);
      this.s = ((int)(d1 * 0.8D));
      i1 = this.s;
      i2 = this.c;
      if (i1 > i2) {
        this.s = i2;
      }
      this.h = paramView;
      setMode(0);
      this.i = paramInt;
      this.j = paramString;
      paramView.setVisibility(4);
      invalidate();
      a(false);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("init:");
        paramView.append(this.r);
        QLog.d("Drag", 2, paramView.toString());
      }
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramOnDragModeChangedListener != null) && (this.v.contains(paramOnDragModeChangedListener))) {
      this.v.remove(paramOnDragModeChangedListener);
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((paramOnDragModeChangedListener != null) && (!this.v.contains(paramOnDragModeChangedListener)))
    {
      if (!paramBoolean)
      {
        this.v.add(paramOnDragModeChangedListener);
        return;
      }
      this.v.add(0, paramOnDragModeChangedListener);
    }
  }
  
  public void a(String paramString, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramOnDragModeChangedListener != null))
    {
      if (!this.w.containsKey(paramString)) {
        return;
      }
      paramString = (List)this.w.get(paramString);
      if (paramString.contains(paramOnDragModeChangedListener)) {
        paramString.remove(paramOnDragModeChangedListener);
      }
    }
  }
  
  public void a(String paramString, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramOnDragModeChangedListener != null))
    {
      if (!this.w.containsKey(paramString)) {
        this.w.put(paramString, new ArrayList());
      }
      paramString = (List)this.w.get(paramString);
      if (!paramBoolean)
      {
        paramString.add(paramOnDragModeChangedListener);
        return;
      }
      paramString.add(0, paramOnDragModeChangedListener);
    }
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    super.addChildrenForAccessibility(paramArrayList);
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localView = (View)paramArrayList.get(i1);
      if (localView.getId() == 2131436932) {
        break label46;
      }
      i1 += 1;
    }
    View localView = null;
    label46:
    if (localView != null)
    {
      paramArrayList.remove(localView);
      paramArrayList.add(0, localView);
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
      paramMotionEvent = new RectF(this.r.centerX(), this.r.centerY(), this.r.centerX() - 6, this.r.centerY());
      this.o = new DragFrameLayout.ShakeRunner(this, new PointF(this.r.centerX(), this.r.centerY()), paramMotionEvent);
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
            this.t.set(f1, f2);
            a(this.r.centerX() - f1, this.r.centerY() - f2, 2);
            invalidate();
            return true;
          }
        }
        else
        {
          float f3 = (float)Math.sqrt((f1 - this.r.centerX()) * (f1 - this.r.centerX()) + (f2 - this.r.centerY()) * (f2 - this.r.centerY()));
          if (f3 >= this.s + this.a)
          {
            this.u = f3;
            this.t.set(f1, f2);
            setMode(2);
            a(this.r.centerX() - f1, this.r.centerY() - f2, 2);
          }
          else if (f3 >= 0.0F)
          {
            this.u = f3;
            this.t.set(f1, f2);
            setMode(1);
            a(this.r.centerX() - f1, this.r.centerY() - f2, 1);
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
      a(this.r.centerX() - f1, this.r.centerY() - f2, -1);
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
        this.t.set(f1, f2);
        paramMotionEvent = new RectF(this.r.centerX(), this.r.centerY(), this.t.x, this.t.y);
        this.o = new DragFrameLayout.ShakeRunner(this, new PointF(this.r.centerX(), this.r.centerY()), paramMotionEvent);
        invalidate();
        return true;
      }
      if (i1 == 3) {
        return true;
      }
      if (i1 == 2)
      {
        if ((float)Math.sqrt((f1 - this.r.centerX()) * (f1 - this.r.centerX()) + (f2 - this.r.centerY()) * (f2 - this.r.centerY())) < (this.s + this.a) / 2)
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
          this.t.set(f1, f2);
          this.p = new DragFrameLayout.BornRunner(this, this.t);
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
    this.k = paramIDragViewProvider;
  }
  
  public void setDragViewProviderByGroup(String paramString, DragFrameLayout.IDragViewProvider paramIDragViewProvider)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.l.put(paramString, paramIDragViewProvider);
    }
  }
  
  public void setOnDragListener(DragFrameLayout.OnDragListener paramOnDragListener)
  {
    this.m = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */