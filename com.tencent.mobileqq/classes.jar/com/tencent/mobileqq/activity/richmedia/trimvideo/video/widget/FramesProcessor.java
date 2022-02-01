package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class FramesProcessor
  implements FrameAdapter.DataSetChangeListener
{
  public static final boolean a;
  private Rect A;
  private Rect B = new Rect();
  private float[] C = { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private int g;
  private int h;
  private final int i;
  private int j;
  private FrameParent k;
  private FramesProcessor.OnMoveListener l;
  private float m;
  private float n;
  private float o;
  private float p;
  private FrameAdapter q;
  private OnFetchFrameListener r;
  private Scroller s;
  private GestureDetector t;
  private GestureDetector.OnGestureListener u = new FramesProcessor.1(this);
  private Canvas v;
  private Bitmap w;
  private Paint x = new Paint();
  private Paint y = new Paint();
  private Rect z;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 10) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  public FramesProcessor(FrameParent paramFrameParent, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4)
  {
    this.k = paramFrameParent;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.j = paramInt2;
    paramFloat2 = paramInt3;
    this.p = paramFloat2;
    float f1 = paramInt1 * 1.0F / paramInt4 * paramFloat1;
    this.m = f1;
    float f2 = this.m;
    float f3 = paramInt2 * paramFloat1;
    this.n = Math.max(f2 - f3, 0.0F);
    this.o = 0.0F;
    if (QLog.isColorLevel())
    {
      paramFrameParent = new StringBuilder();
      paramFrameParent.append("mTotalRange=");
      paramFrameParent.append(this.m);
      paramFrameParent.append(", mMaxMovedDistance=");
      paramFrameParent.append(this.n);
      QLog.d("FramesProcessor", 2, paramFrameParent.toString());
    }
    this.e = 0.0F;
    this.w = Bitmap.createBitmap(paramInt3, (int)this.d, Bitmap.Config.RGB_565);
    this.v = new Canvas(this.w);
    this.y.setColorFilter(new ColorMatrixColorFilter(this.C));
    this.b = paramFloat3;
    this.z = new Rect(0, 0, (int)paramFloat3, (int)this.d);
    this.A = new Rect((int)(paramFloat3 + Math.min(f1, f3)), 0, paramInt3, (int)this.d);
    this.s = new Scroller(this.k.getContext());
    this.t = new GestureDetector(this.k.getContext(), this.u);
    this.q = new FrameAdapter(this);
    this.h = ((int)Math.ceil(paramFloat2 * 1.0F / this.c));
    this.h = Math.min(this.h, paramInt2);
    this.i = this.h;
    this.g = 0;
    if (a) {
      this.r = new VideoFramesRetriever(paramString, paramFloat1);
    } else {
      this.r = new VideoFramesFetcher();
    }
    this.r.a(paramInt4, paramInt1, this.q);
    this.r.a(this.g, this.h);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void d()
  {
    FrameAdapter localFrameAdapter = this.q;
    if (localFrameAdapter != null)
    {
      if (localFrameAdapter.a()) {
        return;
      }
      int i1 = (int)(this.e / this.c);
      this.g = Math.max(i1, 0);
      int i2 = this.i;
      if (i2 >= 6) {
        this.h = Math.min(i2 + i1, this.j);
      }
    }
  }
  
  private void e()
  {
    this.v.drawColor(-16777216);
    if (this.s.computeScrollOffset())
    {
      this.e = this.s.getCurrX();
      f1 = this.e;
      f2 = this.o;
      if (f1 < f2)
      {
        this.e = f2;
        this.s.forceFinished(true);
      }
      f1 = this.e;
      f2 = this.n;
      if (f1 > f2)
      {
        this.e = f2;
        this.s.forceFinished(true);
      }
      d();
      localObject = this.k;
      if (localObject != null) {
        ((FrameParent)localObject).invalidate();
      }
    }
    else
    {
      this.r.a(this.g, this.h);
    }
    float f1 = this.e;
    float f2 = this.f;
    this.f = f1;
    if (a(f1 - f2, 0.0F)) {
      return;
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      f1 = this.e;
      ((FramesProcessor.OnMoveListener)localObject).a(f1, -f1, this.m - f1);
    }
  }
  
  public void a()
  {
    this.k.postInvalidate();
  }
  
  public void a(int paramInt)
  {
    int i1 = this.z.right;
    this.o += i1 - paramInt;
    this.z.right = paramInt;
    this.k.invalidate();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.q == null) {
      return;
    }
    e();
    int i1 = Math.max(this.g - 1, 0);
    float f1 = i1 * this.c;
    this.v.translate(f1 - this.e + this.b, 0.0F);
    int i3 = Math.min(this.h + 3, this.j);
    int i2 = (int)this.c;
    while (i1 < i3)
    {
      localObject2 = this.q.a(i1);
      if (localObject2 != null)
      {
        i2 = (int)Math.min(this.m - f1, this.c);
        this.B.set(0, 0, i2, (int)this.d);
        localObject1 = this.v;
        localObject2 = ((FramesProcessor.Frame)localObject2).a;
        Rect localRect = this.B;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, localRect, localRect, this.x);
      }
      localObject1 = this.v;
      float f2 = i2;
      ((Canvas)localObject1).translate(f2, 0.0F);
      f1 += f2;
      i1 += 1;
    }
    this.v.translate(-f1 + this.e - this.b, 0.0F);
    paramCanvas.drawBitmap(this.w, 0.0F, 0.0F, this.x);
    Object localObject1 = this.w;
    Object localObject2 = this.z;
    paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, (Rect)localObject2, this.y);
    localObject1 = this.w;
    localObject2 = this.A;
    paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, (Rect)localObject2, this.y);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.t;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void a(FramesProcessor.OnMoveListener paramOnMoveListener)
  {
    this.l = paramOnMoveListener;
    paramOnMoveListener = this.l;
    if (paramOnMoveListener != null)
    {
      float f1 = this.e;
      paramOnMoveListener.a(f1, -f1, this.m - f1);
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = this.A.left;
    this.n += i1 - paramInt;
    this.A.left = paramInt;
    this.k.invalidate();
  }
  
  public boolean b()
  {
    return a(this.e, 0.0F) ^ true;
  }
  
  public void c()
  {
    this.l = null;
    Object localObject = this.r;
    if (localObject != null) {
      ((OnFetchFrameListener)localObject).a();
    }
    localObject = this.q;
    if (localObject != null) {
      ((FrameAdapter)localObject).b();
    }
    this.q = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor
 * JD-Core Version:    0.7.0.1
 */