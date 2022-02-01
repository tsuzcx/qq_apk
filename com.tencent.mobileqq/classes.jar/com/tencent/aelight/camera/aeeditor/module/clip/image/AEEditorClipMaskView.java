package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.aelight.camera.impl.R.styleable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qav.thread.ThreadManager;

public class AEEditorClipMaskView
  extends View
{
  private static final String d = "AEEditorClipMaskView";
  private static final int e = Color.parseColor("#59C4C4C4");
  private static final int f = ViewUtils.dpToPx(4.0F);
  private static final int g = ViewUtils.dpToPx(16.0F);
  private Rect A = new Rect(0, 0, 0, 0);
  private Rect B = new Rect(0, 0, 0, 0);
  private Rect C = new Rect(0, 0, 0, 0);
  private Rect D = null;
  private int E = 0;
  private Rect F = null;
  private Rect G = null;
  private int H;
  private int I;
  public int a = 0;
  protected GestureDetector b;
  protected ScaleGestureDetector c;
  private Paint h;
  private int i = 268435455;
  private int j = 200;
  private float k = 0.8F;
  private int l = 3;
  private int m = 5;
  private Handler n;
  private Path o;
  private boolean p = false;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private AEEditorClipContainer u;
  private Rect v = new Rect(0, 0, 0, 0);
  private Rect w = new Rect(0, 0, 0, 0);
  private Rect x = new Rect(0, 0, 0, 0);
  private Rect y = new Rect(0, 0, 0, 0);
  private Rect z = new Rect(0, 0, 0, 0);
  
  public AEEditorClipMaskView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEEditorClipMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  public AEEditorClipMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
      this.i = paramAttributeSet.getColor(0, this.i);
      this.k = paramAttributeSet.getFloat(1, 1.0F);
      float f2 = this.k * 255.0F;
      float f1;
      if (f2 < 0.0F)
      {
        f1 = 0.0F;
      }
      else
      {
        f1 = f2;
        if (f2 > 255.0F) {
          f1 = 255.0F;
        }
      }
      this.j = ((int)f1);
      this.l = paramAttributeSet.getDimensionPixelOffset(2, this.l);
      paramAttributeSet.recycle();
    }
    this.h = new Paint();
    this.h.setColor(this.i);
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeCap(Paint.Cap.ROUND);
    this.h.setStrokeWidth(ViewUtils.dpToPx(2.0F));
    this.h.setAlpha(this.j);
    this.o = new Path();
    this.n = new Handler();
    this.b = new GestureDetector(paramContext, new AEEditorClipMaskView.GestureListener(this, null), null, true);
    this.c = new ScaleGestureDetector(paramContext, new AEEditorClipMaskView.ScaleListener(this, null));
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEEditorClipMaskView.1(this, paramRect1, paramRect2));
    localValueAnimator.addListener(new AEEditorClipMaskView.2(this));
    localValueAnimator.start();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = this.F.right;
    int i3 = this.F.left;
    int i1 = this.F.bottom - this.F.top;
    float f2 = paramMotionEvent.getX();
    float f3 = this.F.left;
    float f1 = (i2 - i3) * 1.0F;
    if ((f2 - f3 < f1 / this.m) && (paramMotionEvent.getY() - this.F.top < i1 * 1.0F / this.m))
    {
      this.E = 0;
      return true;
    }
    f2 = paramMotionEvent.getX();
    f3 = this.F.left;
    i2 = this.m;
    if ((f2 - f3 > (i2 - 1) * f1 / i2) && (paramMotionEvent.getY() - this.F.top < i1 * 1.0F / this.m))
    {
      this.E = 1;
      return true;
    }
    if (paramMotionEvent.getX() - this.F.left < f1 / this.m)
    {
      f2 = paramMotionEvent.getY();
      f3 = this.F.top;
      float f4 = i1;
      i2 = this.m;
      if (f2 - f3 > f4 * 1.0F * (i2 - 1) / i2)
      {
        this.E = 2;
        return true;
      }
    }
    f2 = paramMotionEvent.getX();
    f3 = this.F.left;
    i2 = this.m;
    if (f2 - f3 > f1 * (i2 - 1) / i2)
    {
      f1 = paramMotionEvent.getY();
      f2 = this.F.top;
      f3 = i1;
      i1 = this.m;
      if (f1 - f2 > f3 * 1.0F * (i1 - 1) / i1)
      {
        this.E = 3;
        return true;
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F))
    {
      int i1 = this.F.right;
      int i2 = this.F.left;
      int i3 = this.F.bottom;
      int i4 = this.F.top;
      float f2 = i1 - i2;
      float f3 = i3 - i4;
      float f1 = f2 * 1.0F / f3;
      if (Math.abs(paramFloat2 / f3) > Math.abs(paramFloat1 / f2)) {
        paramFloat1 = paramFloat1 / Math.abs(paramFloat1) * Math.abs(f2 * paramFloat2 / f3);
      } else {
        paramFloat2 = paramFloat2 / Math.abs(paramFloat2) * Math.abs(f3 * paramFloat1 / f2);
      }
      paramMotionEvent1 = new Rect(this.F.left, this.F.top, this.F.right, this.F.bottom);
      paramMotionEvent2 = a();
      if ((this.E == 0) && (paramFloat1 * paramFloat2 > 0.0F))
      {
        paramMotionEvent1.left -= (int)paramFloat1;
        paramMotionEvent1.top -= (int)paramFloat2;
        if ((paramMotionEvent1.left < paramMotionEvent2.left) && (paramMotionEvent1.top < paramMotionEvent2.top))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.left = paramMotionEvent2.left;
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.top = paramMotionEvent2.top;
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.left < paramMotionEvent2.left)
        {
          paramMotionEvent1.left = paramMotionEvent2.left;
          paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.top < paramMotionEvent2.top)
        {
          paramMotionEvent1.top = paramMotionEvent2.top;
          paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.D;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.D.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.D.right - this.D.left) * 1.0F / 5.0F));
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.D.bottom - this.D.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.E == 1) && (paramFloat1 * paramFloat2 < 0.0F))
      {
        paramMotionEvent1.top -= (int)paramFloat2;
        paramMotionEvent1.right -= (int)paramFloat1;
        if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.top < paramMotionEvent2.top))
        {
          if ((paramMotionEvent1.right - paramMotionEvent2.right) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.top = paramMotionEvent2.top;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.right > paramMotionEvent2.right)
        {
          paramMotionEvent1.right = paramMotionEvent2.right;
          paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.top < paramMotionEvent2.top)
        {
          paramMotionEvent1.top = paramMotionEvent2.top;
          paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.D;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.D.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.D.right - this.D.left) * 1.0F / 5.0F));
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.D.bottom - this.D.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.E == 2) && (paramFloat1 * paramFloat2 < 0.0F))
      {
        paramMotionEvent1.left -= (int)paramFloat1;
        paramMotionEvent1.bottom -= (int)paramFloat2;
        if ((paramMotionEvent1.left < paramMotionEvent2.left) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent1.bottom - paramMotionEvent2.bottom) > f1)
          {
            paramMotionEvent1.left = paramMotionEvent2.left;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.left < paramMotionEvent2.left)
        {
          paramMotionEvent1.left = paramMotionEvent2.left;
          paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
        {
          paramMotionEvent1.bottom = paramMotionEvent2.bottom;
          paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.D;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.D.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.D.right - this.D.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.D.bottom - this.D.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.E == 3) && (paramFloat1 * paramFloat2 > 0.0F))
      {
        paramMotionEvent1.right -= (int)paramFloat1;
        paramMotionEvent1.bottom -= (int)paramFloat2;
        if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.right > paramMotionEvent2.right)
        {
          paramMotionEvent1.right = paramMotionEvent2.right;
          paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
        {
          paramMotionEvent1.bottom = paramMotionEvent2.bottom;
          paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.D;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.D.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.D.right - this.D.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.D.bottom - this.D.top) * 1.0F / 5.0F));
          }
        }
      }
      this.F = paramMotionEvent1;
      this.G = this.F;
      invalidate();
      return true;
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return (this.F != null) && (paramMotionEvent.getX() >= this.F.left - AEEditorClipContainer.a) && (paramMotionEvent.getX() <= this.F.right + AEEditorClipContainer.a) && (paramMotionEvent.getY() >= this.F.top - AEEditorClipContainer.a) && (paramMotionEvent.getY() <= this.F.bottom + AEEditorClipContainer.a);
  }
  
  public Rect a()
  {
    int i1 = this.H;
    int i2 = this.I;
    int i3 = i1 - AEEditorClipContainer.a * 2;
    int i4 = i2 - AEEditorClipContainer.a * 2;
    int i5 = this.a;
    if (i5 != 0)
    {
      Rect localRect;
      if (i5 != 1)
      {
        int i6;
        if (i5 != 2)
        {
          if (i5 != 3)
          {
            if (i5 != 4) {
              break label430;
            }
            i6 = i4 * 16;
            i5 = i3 * 9;
            if (i6 >= i5)
            {
              i4 = (i1 - i3) / 2;
              i5 /= 16;
              return new Rect(i4, (i2 - i5) / 2, (i1 + i3) / 2, (i2 + i5) / 2);
            }
            i3 = i6 / 9;
            localRect = new Rect((i1 - i3) / 2, (i2 - i4) / 2, (i1 + i3) / 2, (i2 + i4) / 2);
          }
          else
          {
            i6 = i4 * 4;
            i5 = i3 * 3;
            if (i6 >= i5)
            {
              i4 = (i1 - i3) / 2;
              i5 /= 4;
              return new Rect(i4, (i2 - i5) / 2, (i1 + i3) / 2, (i2 + i5) / 2);
            }
            i3 = i6 / 3;
            localRect = new Rect((i1 - i3) / 2, (i2 - i4) / 2, (i1 + i3) / 2, (i2 + i4) / 2);
          }
        }
        else
        {
          i6 = i4 * 3;
          i5 = i3 * 4;
          if (i6 >= i5)
          {
            i4 = (i1 - i3) / 2;
            i5 /= 3;
            return new Rect(i4, (i2 - i5) / 2, (i1 + i3) / 2, (i2 + i5) / 2);
          }
          i3 = i6 / 4;
          localRect = new Rect((i1 - i3) / 2, (i2 - i4) / 2, (i1 + i3) / 2, (i2 + i4) / 2);
        }
      }
      else
      {
        if (i4 > i3) {
          return new Rect((i1 - i3) / 2, (i2 - i3) / 2, (i1 + i3) / 2, (i2 + i3) / 2);
        }
        localRect = new Rect((i1 - i4) / 2, (i2 - i4) / 2, (i1 + i4) / 2, (i2 + i4) / 2);
      }
      return localRect;
    }
    label430:
    return null;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    Rect localRect1 = a();
    if (localRect1 == null)
    {
      this.q = false;
      this.F = null;
      this.G = null;
      invalidate();
      return;
    }
    this.q = true;
    Rect localRect2 = this.G;
    if (localRect2 == null)
    {
      this.F = localRect1;
      invalidate();
      this.G = this.F;
      return;
    }
    a(localRect2, localRect1);
  }
  
  public void a(AEEditorClipContainer paramAEEditorClipContainer, int paramInt1, int paramInt2, int paramInt3)
  {
    this.u = paramAEEditorClipContainer;
    this.a = paramInt1;
    this.H = paramInt2;
    this.I = paramInt3;
    this.F = a();
    invalidate();
  }
  
  public void b()
  {
    Rect localRect1 = a();
    Rect localRect2 = this.F;
    if (localRect2 == null)
    {
      AEQLog.d(d, "onUp mCurrentCropRect == null");
      return;
    }
    if (localRect1 == null)
    {
      AEQLog.d(d, "onUp rect == null");
      return;
    }
    if (localRect1.equals(localRect2)) {
      return;
    }
    this.p = true;
    float f1 = (localRect1.right - localRect1.left) / (this.F.right - this.F.left);
    ThreadManager.a().postDelayed(new AEEditorClipMaskView.3(this, localRect1, f1), 1000L);
  }
  
  public Rect getCropRect()
  {
    Rect localRect = this.F;
    if (localRect != null) {
      return localRect;
    }
    return null;
  }
  
  public int getRatioType()
  {
    return this.a;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    Object localObject = this.F;
    if (localObject == null) {
      return;
    }
    int i1 = ((Rect)localObject).right - this.F.left;
    int i2 = this.F.bottom - this.F.top;
    paramCanvas.clipRect(this.F, Region.Op.XOR);
    paramCanvas.drawColor(e);
    paramCanvas.restore();
    this.o.reset();
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeWidth(ViewUtils.dpToPx(1.0F));
    this.o.moveTo(this.F.left, this.F.top);
    this.o.lineTo(this.F.right, this.F.top);
    this.o.lineTo(this.F.right, this.F.bottom);
    this.o.lineTo(this.F.left, this.F.bottom);
    this.o.lineTo(this.F.left, this.F.top);
    paramCanvas.drawPath(this.o, this.h);
    this.o.reset();
    this.h.setStrokeWidth(ViewUtils.dpToPx(0.5F));
    localObject = this.o;
    int i3 = this.F.left;
    int i4 = i1 / 3;
    ((Path)localObject).moveTo(i3 + i4, this.F.top);
    this.o.lineTo(this.F.left + i4, this.F.top + i2);
    localObject = this.o;
    i3 = this.F.left;
    i4 = i1 * 2 / 3;
    ((Path)localObject).moveTo(i3 + i4, this.F.top);
    this.o.lineTo(this.F.left + i4, this.F.top + i2);
    localObject = this.o;
    float f1 = this.F.left;
    i3 = this.F.top;
    i4 = i2 / 3;
    ((Path)localObject).moveTo(f1, i3 + i4);
    this.o.lineTo(this.F.left + i1, this.F.top + i4);
    localObject = this.o;
    f1 = this.F.left;
    i3 = this.F.top;
    i2 = i2 * 2 / 3;
    ((Path)localObject).moveTo(f1, i3 + i2);
    this.o.lineTo(this.F.left + i1, this.F.top + i2);
    paramCanvas.drawPath(this.o, this.h);
    this.v.set(this.F.left - f, this.F.top - f, this.F.left + g, this.F.top);
    this.w.set(this.F.left - f, this.F.top, this.F.left, this.F.top + g);
    this.x.set(this.F.right - g, this.F.top - f, this.F.right + f, this.F.top);
    this.y.set(this.F.right, this.F.top, this.F.right + f, this.F.top + g);
    this.z.set(this.F.left - f, this.F.bottom, this.F.left + g, this.F.bottom + f);
    this.A.set(this.F.left - f, this.F.bottom - g, this.F.left, this.F.bottom);
    this.B.set(this.F.right - g, this.F.bottom, this.F.right + f, this.F.bottom + f);
    this.C.set(this.F.right, this.F.bottom - g, this.F.right + f, this.F.bottom);
    this.h.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.v, this.h);
    paramCanvas.drawRect(this.w, this.h);
    paramCanvas.drawRect(this.x, this.h);
    paramCanvas.drawRect(this.y, this.h);
    paramCanvas.drawRect(this.z, this.h);
    paramCanvas.drawRect(this.A, this.h);
    paramCanvas.drawRect(this.B, this.h);
    paramCanvas.drawRect(this.C, this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent(");
    localStringBuilder.append(paramMotionEvent.getActionMasked());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramMotionEvent.getPointerCount());
    localStringBuilder.append(")");
    AEQLog.a((String)localObject, localStringBuilder.toString());
    if (this.p)
    {
      AEQLog.a(d, "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.r)
    {
      AEQLog.a(d, "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    this.c.onTouchEvent(paramMotionEvent);
    if (this.c.isInProgress())
    {
      this.s = false;
      AEQLog.a(d, "onTouchEvent(double finger scaling)");
      this.u.b.onTouchEvent(paramMotionEvent);
      return true;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((!this.t) && (((b(paramMotionEvent)) && (a(paramMotionEvent))) || (this.s)))
    {
      if (i1 == 0)
      {
        this.D = a();
        this.s = true;
      }
      else if (i1 == 1)
      {
        b();
        this.s = false;
      }
      boolean bool = this.b.onTouchEvent(paramMotionEvent);
      paramMotionEvent = d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTouchEvent mGestureDetector.onTouchEvent result :");
      ((StringBuilder)localObject).append(bool);
      AEQLog.a(paramMotionEvent, ((StringBuilder)localObject).toString());
      return true;
    }
    this.u.b.onTouchEvent(paramMotionEvent);
    if (i1 == 0) {
      this.t = true;
    } else if (i1 == 1) {
      this.t = false;
    }
    AEQLog.a(d, "onTouchEvent mContainer.mImageView.onTouchEvent :");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView
 * JD-Core Version:    0.7.0.1
 */