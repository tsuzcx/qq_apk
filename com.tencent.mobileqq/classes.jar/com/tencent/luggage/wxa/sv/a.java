package com.tencent.luggage.wxa.sv;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  extends FrameLayout
{
  private static final int[] a = { 1, 2, 8, 11 };
  private int b;
  private float c = 0.3F;
  private boolean d = true;
  private View e;
  private c f = c.a(this, new a.c(this, null));
  private float g;
  private int h;
  private int i;
  private CopyOnWriteArrayList<a.a> j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private float n;
  private int o = -1728053248;
  private boolean p;
  private Rect q = new Rect();
  private int r;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034133);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwipeBackLayout, paramInt, 2131952378);
    paramInt = paramContext.getDimensionPixelSize(R.styleable.SwipeBackLayout_edge_size, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(a[paramContext.getInt(R.styleable.SwipeBackLayout_edge_flag, 0)]);
    paramInt = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_left, 2130851784);
    int i1 = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_right, 2130851785);
    int i2 = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_bottom, 2130851783);
    a(paramInt, 1);
    a(i1, 2);
    a(i2, 8);
    paramContext.recycle();
    float f1 = getResources().getDisplayMetrics().density * 400.0F;
    this.f.a(f1);
    this.f.b(f1 * 2.0F);
  }
  
  private void a(Canvas paramCanvas, View paramView)
  {
    int i1 = this.o;
    int i2 = (int)(((0xFF000000 & i1) >>> 24) * this.n);
    int i3 = this.r;
    if ((i3 & 0x1) != 0) {
      paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    } else if ((i3 & 0x2) != 0) {
      paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
    } else if ((i3 & 0x8) != 0) {
      paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
    }
    paramCanvas.drawColor(i1 & 0xFFFFFF | i2 << 24);
  }
  
  private void b(Canvas paramCanvas, View paramView)
  {
    Rect localRect = this.q;
    paramView.getHitRect(localRect);
    if ((this.b & 0x1) != 0)
    {
      this.k.setBounds(localRect.left - this.k.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
      this.k.setAlpha((int)(this.n * 255.0F));
      this.k.draw(paramCanvas);
    }
    if ((this.b & 0x2) != 0)
    {
      this.l.setBounds(localRect.right, localRect.top, localRect.right + this.l.getIntrinsicWidth(), localRect.bottom);
      this.l.setAlpha((int)(this.n * 255.0F));
      this.l.draw(paramCanvas);
    }
    if ((this.b & 0x8) != 0)
    {
      this.m.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.m.getIntrinsicHeight());
      this.m.setAlpha((int)(this.n * 255.0F));
      this.m.draw(paramCanvas);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(getResources().getDrawable(paramInt1), paramInt2);
  }
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      this.k = paramDrawable;
    } else if ((paramInt & 0x2) != 0) {
      this.l = paramDrawable;
    } else if ((paramInt & 0x8) != 0) {
      this.m = paramDrawable;
    }
    invalidate();
  }
  
  public void a(a.a parama)
  {
    if (this.j == null) {
      this.j = new CopyOnWriteArrayList();
    }
    this.j.add(parama);
  }
  
  public void computeScroll()
  {
    this.n = (1.0F - this.g);
    if (this.f.a(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    Object localObject = this.j;
    if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
    {
      localObject = this.j.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a.a)((Iterator)localObject).next()).a(paramMotionEvent);
      }
    }
    if (this.f.a() == 1)
    {
      this.f.b(paramMotionEvent);
      return true;
    }
    try
    {
      if (this.f.a(paramMotionEvent))
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    catch (NullPointerException|IllegalArgumentException|ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i1;
    if (paramView == this.e) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((this.n > 0.0F) && (i1 != 0) && (this.f.a() != 0))
    {
      b(paramCanvas, paramView);
      a(paramCanvas, paramView);
    }
    return bool;
  }
  
  public View getTargetView()
  {
    return this.e;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p = true;
    View localView = this.e;
    if (localView != null)
    {
      paramInt1 = this.h;
      localView.layout(paramInt1, this.i, localView.getMeasuredWidth() + paramInt1, this.i + this.e.getMeasuredHeight());
    }
    this.p = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return false;
    }
    this.f.b(paramMotionEvent);
    return true;
  }
  
  public void requestLayout()
  {
    if (!this.p) {
      super.requestLayout();
    }
  }
  
  public void setContentView(View paramView)
  {
    this.e = paramView;
  }
  
  public void setEdgeSize(int paramInt)
  {
    this.f.b(paramInt);
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.b = paramInt;
    this.f.a(this.b);
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.f.b(paramFloat);
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.f.a(paramFloat);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.o = paramInt;
    invalidate();
  }
  
  public void setScrollThresHold(float paramFloat)
  {
    if ((paramFloat < 1.0F) && (paramFloat > 0.0F))
    {
      this.c = paramFloat;
      return;
    }
    throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
  }
  
  @Deprecated
  public void setSwipeListener(a.a parama)
  {
    a(parama);
  }
  
  public void t()
  {
    this.g = 0.0F;
    this.f.b();
    this.f.d(0);
    if ((this.h != 0) || (this.i != 0))
    {
      this.i = 0;
      this.h = 0;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sv.a
 * JD-Core Version:    0.7.0.1
 */