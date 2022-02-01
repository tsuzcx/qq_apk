package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

public class PttAudioWaveView
  extends View
{
  private float[] A = new float[0];
  private Paint B;
  private int C;
  private int D = -1;
  private float E = 0.0F;
  private int F = -1;
  private int G = 1;
  private int H;
  private volatile boolean I = true;
  private int[] J;
  private float K = 0.0F;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private Xfermode S;
  private PorterDuff.Mode T = PorterDuff.Mode.SRC_IN;
  private PttAudioWaveView.SeekProgressListener U;
  private int V = 0;
  private int W = 0;
  private int Z;
  int a = a(this.F, 0.33F);
  private int aa;
  private float ab = 0.0F;
  private float ac = 1.5F;
  View.OnLongClickListener b;
  View.OnClickListener c;
  Bitmap d;
  Bitmap e;
  Canvas f;
  Canvas g;
  int h;
  int i;
  int j;
  int k;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  boolean p = true;
  int q = 15;
  PorterDuffXfermode r = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  RectF s = new RectF();
  boolean t = false;
  boolean u = false;
  boolean v = false;
  PttAudioWaveView.OnPressListener w;
  float x = 0.0F;
  float y = 0.0F;
  Runnable z = new PttAudioWaveView.1(this);
  
  public PttAudioWaveView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public static double a(int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    int i2 = 0;
    double d2 = 0.0D;
    double d1 = 0.0D;
    int i1 = 0;
    while (i1 < i3)
    {
      d3 = paramArrayOfInt[i1];
      Double.isNaN(d3);
      d1 += d3;
      i1 += 1;
    }
    double d3 = i3;
    Double.isNaN(d3);
    double d4 = d1 / d3;
    d1 = d2;
    i1 = i2;
    while (i1 < i3)
    {
      d2 = paramArrayOfInt[i1];
      Double.isNaN(d2);
      double d5 = paramArrayOfInt[i1];
      Double.isNaN(d5);
      d1 += (d2 - d4) * (d5 - d4);
      i1 += 1;
    }
    Double.isNaN(d3);
    return d1 / d3;
  }
  
  public static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramInt1 / paramInt2, paramFloat * 2.0F));
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    float f1 = (paramInt >> 16 & 0xFF) / 255.0F;
    float f2 = (paramInt >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt & 0xFF) / 255.0F;
    return (int)((paramInt >> 24 & 0xFF) / 255.0F * paramFloat * 255.0F + 0.5F) << 24 | (int)(f1 * 255.0F + 0.5F) << 16 | (int)(f2 * 255.0F + 0.5F) << 8 | (int)(f3 * 255.0F + 0.5F);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    if ((i1 == paramInt1) && (i2 == paramInt2)) {
      return paramBitmap;
    }
    paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initBitmap change width =");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" oldBitmapWidth =");
      localStringBuilder.append(i1);
      localStringBuilder.append(" oldBitmpHeight=");
      localStringBuilder.append(i2);
      QLog.d("PttAudioWaveView", 2, localStringBuilder.toString());
    }
    return paramBitmap;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.E = ((paramFloat - paramInt1) / (paramInt2 - paramInt1));
  }
  
  private void a(Canvas paramCanvas)
  {
    this.B.setStrokeWidth(this.R);
    float f1 = this.K;
    int i1 = this.V;
    if (f1 > i1) {
      this.K = i1;
    }
    f1 = this.K;
    i1 = this.W;
    if (f1 < i1) {
      this.K = i1;
    }
    if (this.p)
    {
      f1 = this.K;
      float f2 = getMeasuredHeight();
      i1 = this.a;
      int i2 = this.F;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(f1, 0.0F, f1, f2, new int[] { i1, i2, i1 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
      this.B.setShader((Shader)localObject);
      f1 = this.K;
      paramCanvas.drawLine(f1, 0.0F, f1, getMeasuredHeight(), this.B);
      this.B.setShader(null);
    }
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = 0;
    if (paramInt < 100)
    {
      arrayOfInt = new int[paramInt];
      while (i1 < paramInt)
      {
        arrayOfInt[i1] = ((int)(paramArrayOfInt[i1] * 0.02480583F));
        if (arrayOfInt[i1] > 255) {
          arrayOfInt[i1] = 255;
        }
        i1 += 1;
      }
      return arrayOfInt;
    }
    int[] arrayOfInt = new int[100];
    float f3 = paramInt / 100.0F;
    float f1 = f3;
    long l1 = 0L;
    int i2 = 0;
    i1 = 0;
    int i4;
    for (int i3 = 0; i2 < paramInt; i3 = i4)
    {
      long l2 = l1 + paramArrayOfInt[i2];
      int i5 = i1 + 1;
      l1 = l2;
      i1 = i5;
      float f2 = f1;
      i4 = i3;
      if (i2 > f1)
      {
        arrayOfInt[i3] = ((int)((float)l2 / i5 * 0.02480583F));
        if (arrayOfInt[i3] > 255) {
          arrayOfInt[i3] = 255;
        }
        i4 = i3 + 1;
        f2 = (i4 + 1) * f3;
        i1 = 0;
        l1 = 0L;
      }
      i2 += 1;
      f1 = f2;
    }
    return arrayOfInt;
  }
  
  private void c()
  {
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setColor(this.F);
    this.B.setStrokeWidth(this.G);
    this.H = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    this.S = new PorterDuffXfermode(this.T);
    this.L = ViewUtils.dip2px(3.0F);
    this.O = this.L;
    this.Q = (ViewUtils.dip2px(3.0F) - 1);
    this.R = ViewUtils.dip2px(1.0F);
    this.Z = ViewUtils.dip2px(174.0F);
    this.aa = ViewUtils.dip2px(5.0F);
  }
  
  private void d()
  {
    if ((this.g != null) && (this.B != null) && (this.A.length > 0))
    {
      if (!this.u) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawBitMapDesWave mSelectColor=");
        ((StringBuilder)localObject).append(Integer.toHexString(this.F));
        ((StringBuilder)localObject).append("bitmpt");
        ((StringBuilder)localObject).append(this.e.getHeight());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.e.getWidth());
        ((StringBuilder)localObject).append(" len");
        ((StringBuilder)localObject).append(this.A.length);
        ((StringBuilder)localObject).append(" this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("PttAudioWaveView", 2, ((StringBuilder)localObject).toString());
      }
      int i1 = 0;
      this.u = false;
      this.B.setStrokeWidth(1.0F);
      this.B.setColor(this.F);
      this.B.setXfermode(this.r);
      this.g.drawPaint(this.B);
      this.B.setXfermode(null);
      for (;;)
      {
        localObject = this.A;
        if (i1 >= localObject.length) {
          break;
        }
        int i2 = this.D;
        a(i1, i2 - localObject[i1] / 2.0F, i2 + localObject[i1] / 2.0F);
        i1 += 1;
      }
    }
  }
  
  private void e()
  {
    this.B.setStrokeWidth(1.0F);
    this.B.setXfermode(this.r);
    this.f.drawPaint(this.B);
    this.B.setXfermode(null);
    this.s.set(0.0F, 0.0F, this.K, getMeasuredHeight());
    this.f.drawRect(this.s, this.B);
    this.B.setAlpha(75);
    this.s.set(this.K, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.f.drawRect(this.s, this.B);
    this.B.setAlpha(255);
  }
  
  private void setPress(boolean paramBoolean)
  {
    PttAudioWaveView.OnPressListener localOnPressListener = this.w;
    if (localOnPressListener != null) {
      localOnPressListener.a(paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public float a(float paramFloat)
  {
    float f1 = this.ab;
    float f2 = this.A.length * f1;
    return paramFloat / f2 * (f2 - (f1 - this.Q));
  }
  
  public void a()
  {
    this.I = true;
    Object localObject = this.J;
    int i2 = localObject.length;
    this.A = new float[localObject.length];
    int i3 = this.M;
    int i4 = this.N;
    int i1 = 0;
    float f1;
    double d1;
    float f2;
    while (i1 < this.A.length)
    {
      f1 = a(this.J[i1], 255, this.ac);
      int i5;
      float f3;
      if (f1 > 0.9D)
      {
        i5 = this.L;
        f3 = i5 + f1 * (this.N - i5);
        d1 = i2 % 4 + 3;
        Double.isNaN(d1);
        d1 = 6.28D / d1;
        double d2 = i1;
        Double.isNaN(d2);
        f1 = (float)Math.sin(d1 * d2);
        f2 = i3 - i4;
      }
      else
      {
        i5 = this.L;
        f3 = i5;
        f2 = this.M - i5;
      }
      f1 = f3 + f1 * f2;
      if (f1 > this.O) {
        this.O = ((int)f1);
      }
      this.A[i1] = f1;
      i1 += 1;
    }
    for (i1 = 1;; i1 = i2)
    {
      localObject = this.A;
      if (i1 >= localObject.length - 1) {
        break;
      }
      f1 = localObject[(i1 - 1)];
      i2 = i1 + 1;
      f2 = localObject[i2];
      d1 = f1;
      Double.isNaN(d1);
      if (d1 * 0.5D > localObject[i1]) {
        localObject[i1] = ((f1 + localObject[i1]) / 2.0F);
      }
      d1 = f2;
      Double.isNaN(d1);
      localObject = this.A;
      if (d1 * 0.5D > localObject[i1]) {
        localObject[i1] = ((localObject[i1] + f2) / 2.0F);
      }
    }
  }
  
  protected void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i1 = this.A.length;
    float f2 = (getMeasuredWidth() - this.G - this.h - this.j) / i1;
    i1 = this.aa;
    float f1 = f2;
    if (f2 > i1) {
      f1 = i1;
    }
    this.ab = f1;
    i1 = (int)(paramInt * f1) + this.G + this.h;
    int i2 = this.Q + i1;
    RectF localRectF = this.s;
    f1 = i1;
    f2 = i2;
    localRectF.set(f1, paramFloat1, f2, paramFloat2);
    this.g.drawRect(this.s, this.B);
    if (paramInt == this.A.length - 1) {
      this.V = i2;
    }
    if (paramInt == 0) {
      this.W = i1;
    }
    paramInt = (int)(this.Q / 2.0F);
    localRectF = this.s;
    float f3 = paramInt;
    localRectF.set(f1, paramFloat1 - f3 + 1.0F, f2, paramFloat1 + f3 + 1.0F);
    this.g.drawArc(this.s, 180.0F, 180.0F, true, this.B);
    this.s.set(f1, paramFloat2 - f3 - 1.0F, f2, paramFloat2 + f3 - 1.0F);
    this.g.drawArc(this.s, 180.0F, -180.0F, true, this.B);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "destory");
    }
    Bitmap localBitmap = this.d;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.d.recycle();
    }
    localBitmap = this.e;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.e.recycle();
    }
    this.d = null;
    this.e = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.d;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localBitmap = this.e;
      if (localBitmap != null)
      {
        if (localBitmap.isRecycled()) {
          return;
        }
        d();
        int i1;
        if ((this.K <= 0.0F) && (!this.o))
        {
          paramCanvas.save();
          i1 = 0;
        }
        else
        {
          i1 = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
          this.v = true;
        }
        this.B.setXfermode(null);
        this.B.setColor(this.F);
        paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, this.B);
        if (this.K > 0.0F)
        {
          e();
          this.B.setXfermode(this.S);
          paramCanvas.drawBitmap(this.d, 0.0F, 0.0F, this.B);
          this.B.setXfermode(null);
        }
        if ((this.K > 0.0F) || (this.o)) {
          a(paramCanvas);
        }
        if (this.v)
        {
          paramCanvas.restoreToCount(i1);
          this.v = false;
          return;
        }
        paramCanvas.restore();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout changed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" hasDataConvert=");
      localStringBuilder.append(this.I);
      QLog.d("PttAudioWaveView", 2, localStringBuilder.toString());
    }
    if (getMeasuredWidth() > 0)
    {
      if (getMeasuredHeight() <= 0) {
        return;
      }
      if (paramBoolean)
      {
        this.h = getPaddingLeft();
        this.i = getPaddingTop();
        this.j = getPaddingRight();
        this.k = getPaddingBottom();
        this.C = ((this.C + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
        if (this.C < 0) {
          this.C = 0;
        }
        this.D = (getMeasuredHeight() / 2);
        this.M = (getMeasuredHeight() - ViewUtils.dpToPx(this.q) * 2);
        if (this.M < ViewUtils.dpToPx(12.0F)) {
          this.M = ViewUtils.dpToPx(12.0F);
        }
        this.d = a(this.d, this.Z + this.h + this.j, getMeasuredHeight() + this.i + this.k);
        this.e = a(this.e, this.Z + this.h + this.j, getMeasuredHeight() + this.i + this.k);
        this.f = new Canvas(this.d);
        this.g = new Canvas(this.e);
        this.u = true;
        paramInt1 = this.D;
        paramInt2 = this.M;
        this.P = (paramInt1 + paramInt2 / 2);
        double d1 = paramInt2;
        Double.isNaN(d1);
        this.N = ((int)(d1 * 0.8D));
        if (!this.I) {
          a();
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.x = paramMotionEvent.getX();
      this.y = paramMotionEvent.getY();
      if (this.t) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.l = false;
      this.m = false;
      this.o = false;
      setPress(true);
      getHandler().postDelayed(this.z, 500L);
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      float f1 = Math.abs(paramMotionEvent.getX() - this.x);
      float f2 = Math.abs(paramMotionEvent.getY() - this.y);
      int i1 = this.H;
      if ((f1 > i1) || (f2 > i1))
      {
        if (this.n)
        {
          this.K = paramMotionEvent.getX();
          invalidate();
          a(paramMotionEvent.getX(), this.W, this.V);
          paramMotionEvent = this.U;
          if ((paramMotionEvent != null) && (!this.o))
          {
            this.o = true;
            paramMotionEvent.a(this);
          }
        }
        getHandler().removeCallbacks(this.z);
        this.m = true;
      }
      return true;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      getHandler().removeCallbacks(this.z);
      this.o = false;
      setPress(false);
      if ((!this.l) && (!this.m))
      {
        paramMotionEvent = this.c;
        if (paramMotionEvent != null) {
          paramMotionEvent.onClick(this);
        }
        return true;
      }
      if ((!this.l) && (this.n))
      {
        paramMotionEvent = this.U;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(this, this.E);
          ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
        }
        return true;
      }
    }
    else if (paramMotionEvent.getAction() == 3)
    {
      getHandler().removeCallbacks(this.z);
      this.o = false;
    }
    return false;
  }
  
  public void setAudioData(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i3 = 0;
    this.I = false;
    boolean bool = QLog.isColorLevel();
    String str = "PttAudioWaveView";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioData mCenterHeight=");
      ((StringBuilder)localObject).append(this.D);
      ((StringBuilder)localObject).append(" data.length");
      ((StringBuilder)localObject).append(this.A.length);
      QLog.d("PttAudioWaveView", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramInt1 / ViewUtils.dpToPx(5.0F);
    int i2 = i1;
    if (i1 > 34) {
      i2 = 34;
    }
    i1 = i2;
    if (i2 < 3) {
      i1 = 3;
    }
    if (paramArrayOfInt == null)
    {
      this.J = new int[i1];
      paramArrayOfInt = new Random(System.currentTimeMillis());
      paramInt1 = i3;
      while (paramInt1 < i1)
      {
        this.J[paramInt1] = paramArrayOfInt.nextInt(255);
        paramInt1 += 1;
      }
      return;
    }
    Object localObject = new int[i1];
    float f1 = paramArrayOfInt.length;
    float f3 = i1;
    float f2 = f1 / f3;
    f1 = f2;
    int i6 = 255;
    i3 = 0;
    int i8 = 0;
    int i4 = 0;
    long l1 = 0L;
    int i9 = 0;
    int i5 = 0;
    i2 = i1;
    while (i3 < paramArrayOfInt.length)
    {
      long l2 = l1 + paramArrayOfInt[i3];
      int i12 = i9 + 1;
      int i11;
      int i10;
      int i7;
      if (i3 < f1)
      {
        i11 = i6;
        i10 = i8;
        i9 = i4;
        l1 = l2;
        i1 = i12;
        i7 = i5;
        if (i3 != paramArrayOfInt.length - 1) {}
      }
      else
      {
        i7 = i5 + 1;
        localObject[i5] = ((int)(l2 / i12));
        i1 = i7 - 1;
        i10 = i8 + localObject[i1];
        i9 = Math.max(i4, localObject[i1]);
        i11 = Math.min(i6, localObject[i1]);
        f1 = i7 + 1;
        f1 *= f2;
        l1 = 0L;
        i1 = 0;
      }
      i3 += 1;
      i6 = i11;
      i8 = i10;
      i4 = i9;
      i9 = i1;
      i5 = i7;
    }
    this.J = ((int[])localObject);
    if ((this.A.length <= 0) && (this.D > 0))
    {
      a();
      this.u = true;
    }
    if (new Random().nextInt(1000) == 520)
    {
      paramArrayOfInt = new HashMap();
      paramArrayOfInt.put("voiceLength", String.valueOf(paramInt2));
      paramArrayOfInt.put("waveWidth", String.valueOf(paramInt1));
      paramArrayOfInt.put("waveNum", String.valueOf(i2));
      paramArrayOfInt.put("waveMax", String.valueOf(i4));
      paramArrayOfInt.put("waveMin", String.valueOf(i6));
      paramArrayOfInt.put("waveAvg", String.valueOf(i8 / f3));
      paramArrayOfInt.put("waveVar", String.valueOf(Math.sqrt(a((int[])localObject))));
      if (QLog.isColorLevel()) {
        QLog.d(str, 2, "real do report");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "PttWaveInfo", true, 0L, 0L, paramArrayOfInt, "");
    }
  }
  
  public void setCanSupportSlide(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setMaxTopBottomPadding(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.b = paramOnLongClickListener;
  }
  
  public void setOnPressListener(PttAudioWaveView.OnPressListener paramOnPressListener)
  {
    this.w = paramOnPressListener;
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    this.E = a(f1);
    this.K = (this.V * this.E);
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    if (paramInt != this.F)
    {
      this.F = paramInt;
      this.a = a(this.F, 0.33F);
      this.u = true;
      invalidate();
    }
  }
  
  public void setSeekListener(PttAudioWaveView.SeekProgressListener paramSeekProgressListener)
  {
    this.U = paramSeekProgressListener;
  }
  
  public void setShouldDisallowInterceptTouch(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setShowProgressLine(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView
 * JD-Core Version:    0.7.0.1
 */