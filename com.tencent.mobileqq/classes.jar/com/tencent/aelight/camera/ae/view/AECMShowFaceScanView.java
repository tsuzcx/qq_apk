package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AECMShowFaceScanView
  extends FrameLayout
{
  protected Matrix a = new Matrix();
  protected Matrix b = new Matrix();
  AECMShowFaceScanView.FaceRectData c;
  AECMShowFaceScanView.ScanViewListener d;
  Paint e = new Paint();
  Paint f = new Paint();
  Paint g = new Paint();
  Paint h = new Paint();
  private boolean i = false;
  private boolean j = false;
  private float k = 0.0F;
  private float l = 1.0F;
  private float m = 0.0F;
  private Bitmap n;
  private Path o;
  private Xfermode p;
  private int q = 1003;
  
  public AECMShowFaceScanView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AECMShowFaceScanView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AECMShowFaceScanView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private ValueAnimator a(ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
    localValueAnimator.setDuration(600L);
    localValueAnimator.addUpdateListener(new AECMShowFaceScanView.3(this));
    localValueAnimator.addListener(new AECMShowFaceScanView.4(this, paramValueAnimator));
    return localValueAnimator;
  }
  
  private void a()
  {
    this.o = new Path();
    this.o.addCircle(0.0F, 0.0F, 5.0F, Path.Direction.CW);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(-1);
    this.e.setStrokeWidth(12.0F);
    this.e.setPathEffect(new PathDashPathEffect(this.o, 30.0F, 0.0F, PathDashPathEffect.Style.TRANSLATE));
    this.e.setAntiAlias(true);
    this.g.setStyle(Paint.Style.FILL_AND_STROKE);
    this.g.setColor(-1);
    this.g.setAntiAlias(true);
    this.n = BitmapFactory.decodeResource(getResources(), 2063925305);
    this.f = new Paint();
    this.f.setColor(-1);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setAntiAlias(true);
    this.p = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.i)
    {
      RectF localRectF = new RectF();
      localRectF.left = (this.c.b.left + 3.0F);
      localRectF.top = (this.c.b.top + 3.0F);
      localRectF.right = (this.c.b.right - 3.0F);
      localRectF.bottom = (this.c.b.bottom - 3.0F);
      this.f.setAlpha((int)(this.k * 76.5F));
      localRectF = new RectF();
      localRectF.left = this.c.b.left;
      localRectF.top = (this.c.b.top + this.k * this.c.b.height() - 5.0F);
      localRectF.right = this.c.b.right;
      localRectF.bottom = (this.c.b.bottom + this.n.getHeight() / 2.0F);
      int i1 = paramCanvas.saveLayer(null, null, 31);
      if (this.c.c != 0.0F)
      {
        this.b.reset();
        this.b.postRotate(this.c.c, this.c.b.centerX(), this.c.b.centerY());
        paramCanvas.concat(this.b);
      }
      paramCanvas.drawOval(this.c.b, this.f);
      this.f.setXfermode(this.p);
      paramCanvas.drawRect(localRectF, this.f);
      this.f.setXfermode(null);
      paramCanvas.restoreToCount(i1);
    }
  }
  
  private void b()
  {
    int i1 = this.q;
    if (i1 != 1000)
    {
      if (i1 != 1001)
      {
        if (i1 != 1003) {
          return;
        }
        setVisibility(8);
        return;
      }
      setVisibility(0);
      c();
      return;
    }
    setVisibility(0);
    postInvalidate();
  }
  
  private void b(Canvas paramCanvas)
  {
    if ((this.j) || (this.i))
    {
      RadialGradient localRadialGradient = new RadialGradient(this.c.b.centerX(), this.c.b.centerY(), Math.min(getHeight(), getWidth()), 0, -16777216, Shader.TileMode.CLAMP);
      this.h.setAlpha((int)(this.m * 255.0F));
      this.h.setShader(localRadialGradient);
      paramCanvas.drawCircle(this.c.b.centerX(), this.c.b.centerY(), Math.max(getHeight(), getWidth()), this.h);
    }
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = a(e());
    d().start();
    localValueAnimator.start();
  }
  
  private void c(Canvas paramCanvas)
  {
    if ((this.i) && (this.n != null))
    {
      float f1 = this.c.b.top + this.k * this.c.b.height() - this.n.getHeight() / 2.0F;
      float f2 = this.n.getWidth() / this.n.getHeight();
      f2 = this.c.b.width() / f2;
      RectF localRectF = new RectF();
      localRectF.left = this.c.b.left;
      localRectF.right = this.c.b.right;
      localRectF.top = f1;
      localRectF.bottom = (f1 + f2);
      paramCanvas.save();
      if (this.c.c != 0.0F)
      {
        this.b.reset();
        this.b.postRotate(this.c.c, this.c.b.centerX(), this.c.b.centerY());
        paramCanvas.concat(this.b);
      }
      paramCanvas.drawBitmap(this.n, null, localRectF, this.g);
      paramCanvas.restore();
    }
  }
  
  private ValueAnimator d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.8F });
    localValueAnimator.setDuration(800L);
    localValueAnimator.addUpdateListener(new AECMShowFaceScanView.2(this));
    return localValueAnimator;
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.a.reset();
    if (this.j)
    {
      Matrix localMatrix = this.a;
      float f1 = this.l;
      localMatrix.postScale(f1, f1, this.c.b.centerX(), this.c.b.centerY());
      this.e.setAlpha((int)(this.l * 255.0F));
    }
    if (this.c.c != 0.0F) {
      this.a.postRotate(this.c.c, this.c.b.centerX(), this.c.b.centerY());
    }
    paramCanvas.concat(this.a);
    paramCanvas.drawOval(this.c.b, this.e);
    paramCanvas.restore();
  }
  
  @NotNull
  private ValueAnimator e()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(800L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new AECMShowFaceScanView.5(this));
    localValueAnimator.addListener(new AECMShowFaceScanView.6(this));
    return localValueAnimator;
  }
  
  public void a(int paramInt, AECMShowFaceScanView.FaceRectData paramFaceRectData)
  {
    if (this.q == paramInt) {
      return;
    }
    this.q = paramInt;
    this.c = paramFaceRectData;
    ThreadManager.getUIHandler().post(new AECMShowFaceScanView.1(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c != null)
    {
      b(paramCanvas);
      d(paramCanvas);
      c(paramCanvas);
      a(paramCanvas);
    }
  }
  
  public void setListener(AECMShowFaceScanView.ScanViewListener paramScanViewListener)
  {
    this.d = paramScanViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECMShowFaceScanView
 * JD-Core Version:    0.7.0.1
 */