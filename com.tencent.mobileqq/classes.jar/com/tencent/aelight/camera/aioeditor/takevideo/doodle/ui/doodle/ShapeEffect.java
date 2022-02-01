package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ShapeEffect
{
  private static final int a = UIUtils.a(BaseApplicationImpl.getContext(), 160.5F);
  private static final int b = UIUtils.a(BaseApplicationImpl.getContext(), 53.5F);
  private static final int c = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  private static final int d = ViewConfiguration.get(BaseApplicationImpl.getContext()).getScaledTouchSlop();
  private static final int e = ViewConfiguration.getLongPressTimeout();
  private float A = 1.0F;
  private float B;
  private float C;
  private float D;
  private float E;
  private float F = 0.0F;
  private RectF G = new RectF();
  private RectF H = new RectF();
  private Path I;
  private Path J;
  private ShapeEffect.ControlPoint K;
  private ShapeEffect.NonPoint L;
  private ShapeEffect.StartPoint M;
  private ShapeEffect.EndPoint N;
  private ShapeEffect.RotatePoint O;
  private ShapeEffect.ResizePoint P;
  private ShapeEffect.TipsControl Q;
  private final RectF R = new RectF();
  private int S;
  private int T;
  private int U;
  private float V;
  private Paint W = new Paint();
  private ShapeEffect.InteractionListener X;
  private long Y;
  private boolean Z = true;
  private Context f;
  private ShapeOperator.Shape g;
  private float h;
  private boolean i = false;
  private boolean j = false;
  private Boolean k = null;
  private boolean l = false;
  private boolean m = false;
  private boolean n;
  private float o;
  private float p;
  private float q;
  private Bitmap r;
  private Bitmap s;
  private Paint t = new Paint();
  private Paint u = new Paint();
  private TextPaint v = new TextPaint();
  private Paint w = new Paint();
  private Paint x;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public ShapeEffect(Context paramContext, ShapeOperator.Shape paramShape, float paramFloat, int paramInt)
  {
    this.f = paramContext;
    this.g = paramShape;
    this.h = paramFloat;
    this.S = UIUtils.a(paramContext, 5.0F);
    this.T = UIUtils.a(paramContext, 7.0F);
    this.U = UIUtils.a(paramContext, 20.0F);
    this.V = UIUtils.a(paramContext, 6.0F);
    this.o = UIUtils.a(this.f, 15.0F);
    this.p = UIUtils.a(this.f, 10.0F);
    this.q = Math.max(this.p, c);
    this.s = BitmapFactory.decodeResource(paramContext.getResources(), 2130837904);
    this.r = BitmapFactory.decodeResource(paramContext.getResources(), 2130837903);
    h();
    this.t.setStrokeWidth(c(paramFloat));
    this.t.setColor(paramInt);
    if ((this.g == ShapeOperator.Shape.OVAL) || (this.g == ShapeOperator.Shape.RECT)) {
      this.t.setStyle(Paint.Style.FILL);
    }
    if ((this.g == ShapeOperator.Shape.ARROW) || (this.g == ShapeOperator.Shape.LINE))
    {
      this.t.setStrokeCap(Paint.Cap.ROUND);
      this.t.setStrokeJoin(Paint.Join.ROUND);
      this.u.setColor(-789517);
    }
    this.x = new Paint(this.t);
  }
  
  private double a(double paramDouble)
  {
    if (paramDouble > a) {
      paramDouble = b;
    } else {
      paramDouble /= 3.0D;
    }
    double d1 = this.t.getStrokeWidth();
    Double.isNaN(d1);
    paramDouble = Math.min(d1 * 1.4D + 8.800000000000001D, paramDouble);
    return Math.sqrt(paramDouble * paramDouble * 2.0D);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i2 = (int)this.v.measureText("点击输入文字");
    int i1 = (int)Math.ceil(this.v.descent() - this.v.ascent());
    if (paramBoolean) {
      paramFloat2 = paramFloat2 + i1 / 2.0F + this.U;
    } else {
      paramFloat2 = paramFloat2 - i1 / 2.0F - this.U;
    }
    RectF localRectF = this.R;
    int i3 = this.T;
    localRectF.left = (paramFloat1 - (i3 * 2 + i2) / 2.0F);
    localRectF.right = ((i2 + i3 * 2) / 2.0F + paramFloat1);
    i2 = this.S;
    localRectF.top = (paramFloat2 - (i2 * 2 + i1) / 2.0F);
    localRectF.bottom = ((i1 + i2 * 2) / 2.0F + paramFloat2);
    float f1 = this.V;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.W);
    paramCanvas.drawText("点击输入文字", paramFloat1, paramFloat2 - (this.v.descent() + this.v.ascent()) / 2.0F, this.v);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.D;
    float f1 = this.B;
    f2 -= f1;
    float f4 = this.E;
    float f3 = this.C;
    f4 -= f3;
    double d1 = Math.sqrt(f2 * f2 + f4 * f4);
    double d2 = Math.abs(f2 * (paramFloat2 - f3) - f4 * (paramFloat1 - f1));
    Double.isNaN(d2);
    d2 /= d1;
    f1 = this.B;
    f2 = this.C;
    double d3 = Math.sqrt((paramFloat1 - f1) * (paramFloat1 - f1) + (paramFloat2 - f2) * (paramFloat2 - f2));
    f1 = this.D;
    f2 = this.E;
    double d4 = Math.sqrt((paramFloat1 - f1) * (paramFloat1 - f1) + (paramFloat2 - f2) * (paramFloat2 - f2));
    double d5 = paramFloat3;
    return (d3 < d5) || (d4 < d5) || ((d2 < d5) && (d3 < d1) && (d4 < d1));
  }
  
  private double[] a(float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2)
  {
    double d1 = paramFloat1;
    double d3 = Math.cos(paramDouble1);
    Double.isNaN(d1);
    double d2 = paramFloat2;
    double d4 = Math.sin(paramDouble1);
    Double.isNaN(d2);
    d3 = d3 * d1 - d4 * d2;
    d4 = Math.sin(paramDouble1);
    Double.isNaN(d1);
    paramDouble1 = Math.cos(paramDouble1);
    Double.isNaN(d2);
    paramDouble1 = d1 * d4 + d2 * paramDouble1;
    d1 = Math.sqrt(d3 * d3 + paramDouble1 * paramDouble1);
    return new double[] { d3 / d1 * paramDouble2, paramDouble1 / d1 * paramDouble2 };
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    Object localObject;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
        }
        else
        {
          localObject = this.K;
          if (localObject != null) {
            return ((ShapeEffect.ControlPoint)localObject).a(paramMotionEvent);
          }
          return false;
        }
      }
      this.l = false;
      localObject = this.K;
      if (localObject != null)
      {
        boolean bool = ((ShapeEffect.ControlPoint)localObject).a(paramMotionEvent);
        this.K = null;
        return bool;
      }
      return false;
    }
    this.l = true;
    this.K = g((paramMotionEvent.getX() - this.y) / this.A, (paramMotionEvent.getY() - this.z) / this.A);
    if (this.K != null)
    {
      localObject = this.X;
      if (localObject != null) {
        ((ShapeEffect.InteractionListener)localObject).a(this);
      }
      return this.K.a(paramMotionEvent);
    }
    return false;
  }
  
  private float c(float paramFloat)
  {
    return DoodleLayout.b(paramFloat);
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    this.J = o();
    RectF localRectF = new RectF();
    this.J.computeBounds(localRectF, true);
    Region localRegion = new Region();
    localRegion.setPath(this.J, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
    return localRegion.contains(paramInt1, paramInt2);
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.y) / this.A;
    float f2 = (paramMotionEvent.getY() - this.z) / this.A;
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      boolean bool2 = false;
      if (i1 != 1)
      {
        if (i1 != 2) {
          return i1 == 3;
        }
        if (System.currentTimeMillis() - this.Y > 150L) {
          this.Z = false;
        }
        this.D = f1;
        this.E = f2;
        if (!this.Z)
        {
          if (this.g == ShapeOperator.Shape.ARROW)
          {
            this.I = n();
            return true;
          }
          l();
          m();
        }
        return true;
      }
      this.D = f1;
      this.E = f2;
      f1 = this.D - this.B;
      f2 = this.E - this.C;
      long l1 = paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime();
      boolean bool1;
      if (l1 <= e) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      double d1 = f1 * f1 + f2 * f2;
      if (Math.sqrt(d1) <= d) {
        bool2 = true;
      }
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleTouchWhenDrawing--UP--elapse=");
      paramMotionEvent.append(l1);
      paramMotionEvent.append(", inTapTime=");
      paramMotionEvent.append(bool1);
      paramMotionEvent.append(", inTapDis=");
      paramMotionEvent.append(bool2);
      AEQLog.a("ShapeEffect", paramMotionEvent.toString());
      if ((bool1) && (bool2))
      {
        paramMotionEvent = this.X;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      if ((!this.Z) && (Math.sqrt(d1) > UIUtils.a(this.f, 10.0F)))
      {
        if (this.g == ShapeOperator.Shape.ARROW)
        {
          this.I = n();
          this.J = o();
        }
        else
        {
          l();
          m();
        }
        this.i = true;
      }
      return true;
    }
    this.Y = System.currentTimeMillis();
    this.B = f1;
    this.C = f2;
    this.D = this.B;
    this.E = this.C;
    return true;
  }
  
  private ShapeEffect.ControlPoint g(float paramFloat1, float paramFloat2)
  {
    if (d(paramFloat1, paramFloat2))
    {
      if (this.Q == null) {
        this.Q = new ShapeEffect.TipsControl(this, this.f, null);
      }
      return this.Q;
    }
    if ((this.g != ShapeOperator.Shape.LINE) && (this.g != ShapeOperator.Shape.ARROW))
    {
      if (f(paramFloat1, paramFloat2))
      {
        if (this.O == null) {
          this.O = new ShapeEffect.RotatePoint(this, null);
        }
        return this.O;
      }
      if (e(paramFloat1, paramFloat2))
      {
        if (this.P == null) {
          this.P = new ShapeEffect.ResizePoint(this, null);
        }
        return this.P;
      }
    }
    else
    {
      if (j(paramFloat1, paramFloat2))
      {
        if (this.M == null) {
          this.M = new ShapeEffect.StartPoint(this, null);
        }
        return this.M;
      }
      if (k(paramFloat1, paramFloat2))
      {
        if (this.N == null) {
          this.N = new ShapeEffect.EndPoint(this, null);
        }
        return this.N;
      }
    }
    if (this.L == null) {
      this.L = new ShapeEffect.NonPoint(this, null);
    }
    return this.L;
  }
  
  private void h()
  {
    this.t.setShader(null);
    this.t.setStyle(Paint.Style.STROKE);
    this.t.setAntiAlias(true);
    this.t.setDither(true);
    this.u.setColor(-1);
    this.u.setStrokeWidth(UIUtils.a(this.f, 1.0F));
    this.u.setStyle(Paint.Style.STROKE);
    this.w.setColor(-1);
    this.w.setStyle(Paint.Style.FILL);
    this.v.setTypeface(Typeface.DEFAULT);
    this.v.setTextAlign(Paint.Align.CENTER);
    this.v.setAntiAlias(true);
    this.v.setStyle(Paint.Style.FILL_AND_STROKE);
    this.v.setTextSize(UIUtils.a(this.f, 12.0F));
    this.v.setShadowLayer(UIUtils.a(this.f, 2.0F), 0.0F, UIUtils.a(this.f, 1.0F), 687865856);
    this.v.setColor(-1);
    this.W.setStyle(Paint.Style.FILL);
    this.W.setColor(687865856);
    this.W.setAntiAlias(true);
  }
  
  private void h(float paramFloat1, float paramFloat2)
  {
    this.B += paramFloat1;
    this.C += paramFloat2;
    if (this.g == ShapeOperator.Shape.ARROW)
    {
      this.I = n();
      this.J = o();
    }
  }
  
  private void i()
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = this.G.centerX();
    arrayOfFloat1[1] = this.G.centerY();
    float[] arrayOfFloat2 = new float[2];
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F, this.B, this.C);
    localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
    float f1 = arrayOfFloat2[0];
    float f2 = arrayOfFloat1[0];
    float f3 = arrayOfFloat2[1];
    float f4 = arrayOfFloat1[1];
    arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (f1 - f2);
    arrayOfFloat1[1] = (f3 - f4);
    localMatrix.setRotate(this.F);
    localMatrix.mapPoints(arrayOfFloat1);
    a(arrayOfFloat1[0], arrayOfFloat1[1]);
  }
  
  private void i(float paramFloat1, float paramFloat2)
  {
    this.D += paramFloat1;
    this.E += paramFloat2;
    if (this.g == ShapeOperator.Shape.ARROW)
    {
      this.I = n();
      this.J = o();
    }
  }
  
  private void j()
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = this.G.centerX();
    arrayOfFloat1[1] = this.G.centerY();
    float[] arrayOfFloat2 = new float[2];
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(1.0F, 1.0F);
    localMatrix.postRotate(this.F, this.B, this.C);
    localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
    a(arrayOfFloat2[0] - arrayOfFloat1[0], arrayOfFloat2[1] - arrayOfFloat1[1]);
  }
  
  private boolean j(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.B;
    paramFloat2 -= this.C;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.q;
  }
  
  private boolean k()
  {
    return (this.n) && (!this.l);
  }
  
  private boolean k(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.D;
    paramFloat2 -= this.E;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.q;
  }
  
  private void l()
  {
    float f1 = this.B;
    float f2 = this.D;
    if (f1 < f2)
    {
      localRectF = this.G;
      localRectF.left = f1;
      localRectF.right = f2;
    }
    else
    {
      localRectF = this.G;
      localRectF.left = f2;
      localRectF.right = f1;
    }
    f1 = this.C;
    f2 = this.E;
    if (f1 < f2)
    {
      localRectF = this.G;
      localRectF.top = f1;
      localRectF.bottom = f2;
      return;
    }
    RectF localRectF = this.G;
    localRectF.top = f2;
    localRectF.bottom = f1;
  }
  
  private void m()
  {
    float f1 = this.x.getStrokeWidth() / 2.0F;
    int i1 = ShapeEffect.1.a[this.g.ordinal()];
    if ((i1 != 1) && (i1 != 2) && (i1 != 3) && (i1 != 4)) {
      return;
    }
    this.H.left = (this.G.left - f1);
    this.H.top = (this.G.top - f1);
    this.H.right = (this.G.right + f1);
    this.H.bottom = (this.G.bottom + f1);
  }
  
  private Path n()
  {
    float f1 = this.B - this.D;
    float f2 = this.C - this.E;
    double d1 = a(Math.sqrt(f1 * f1 + f2 * f2));
    Path localPath = new Path();
    localPath.moveTo(this.B, this.C);
    localPath.lineTo(this.D, this.E);
    double[] arrayOfDouble = a(f1, f2, -0.7853981633974483D, d1);
    localPath.lineTo(this.D + (float)arrayOfDouble[0], this.E + (float)arrayOfDouble[1]);
    localPath.lineTo(this.D, this.E);
    arrayOfDouble = a(f1, f2, 0.7853981633974483D, d1);
    localPath.lineTo(this.D + (float)arrayOfDouble[0], this.E + (float)arrayOfDouble[1]);
    localPath.lineTo(this.D, this.E);
    localPath.close();
    return localPath;
  }
  
  private Path o()
  {
    float f2 = this.t.getStrokeWidth() / 2.0F;
    int i1 = c;
    float f1 = f2;
    if (f2 < i1) {
      f1 = i1;
    }
    Path localPath = new Path();
    float f4 = this.D - this.B;
    f2 = this.E - this.C;
    double d1 = a(Math.sqrt(f4 * f4 + f2 * f2));
    double d2 = f1;
    double[] arrayOfDouble = a(f4, f2, 0.0D, d2);
    float f5 = this.B - (float)arrayOfDouble[0];
    float f6 = this.C - (float)arrayOfDouble[1];
    f1 = this.D + (float)arrayOfDouble[0];
    float f3 = this.E + (float)arrayOfDouble[1];
    arrayOfDouble = a(f4, f2, 1.570796326794897D, d2);
    localPath.moveTo(f5 + (float)arrayOfDouble[0], f6 + (float)arrayOfDouble[1]);
    localPath.lineTo(f5 - (float)arrayOfDouble[0], f6 - (float)arrayOfDouble[1]);
    f4 = -f4;
    f2 = -f2;
    Double.isNaN(d2);
    d1 += d2;
    arrayOfDouble = a(f4, f2, 0.7853981633974483D, d1);
    localPath.lineTo(f1 + (float)arrayOfDouble[0], f3 + (float)arrayOfDouble[1]);
    localPath.lineTo(f1, f3);
    arrayOfDouble = a(f4, f2, -0.7853981633974483D, d1);
    localPath.lineTo(f1 + (float)arrayOfDouble[0], f3 + (float)arrayOfDouble[1]);
    localPath.close();
    return localPath;
  }
  
  private void p()
  {
    ShapeEffect.InteractionListener localInteractionListener = this.X;
    if (localInteractionListener != null) {
      localInteractionListener.a(this, new RectF(this.R));
    }
  }
  
  public ShapeOperator.Shape a()
  {
    return this.g;
  }
  
  public void a(float paramFloat)
  {
    this.F += paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.B += paramFloat1;
    this.C += paramFloat2;
    this.D += paramFloat1;
    this.E += paramFloat2;
    if (this.g == ShapeOperator.Shape.ARROW)
    {
      this.I = n();
      this.J = o();
      return;
    }
    l();
    m();
  }
  
  public void a(int paramInt)
  {
    this.t.setColor(paramInt);
    this.x.setColor(paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    Object localObject1 = this.g;
    Object localObject2 = ShapeOperator.Shape.LINE;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1;
    float f2;
    float f3;
    if (localObject1 == localObject2)
    {
      paramCanvas.drawLine(this.B, this.C, this.D, this.E, this.x);
      if (this.j)
      {
        paramCanvas.drawLine(this.B, this.C, this.D, this.E, this.u);
        localObject1 = this.r;
        f1 = this.B;
        f2 = this.p;
        f3 = this.C;
        paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
        localObject1 = this.r;
        f1 = this.D;
        f2 = this.p;
        f3 = this.E;
        paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
      }
      if (k())
      {
        f1 = this.B;
        f2 = this.C;
        if (f2 >= this.E) {
          bool1 = true;
        }
        a(paramCanvas, f1, f2, bool1);
      }
    }
    else if (this.g == ShapeOperator.Shape.ARROW)
    {
      localObject1 = this.I;
      if (localObject1 != null)
      {
        paramCanvas.drawPath((Path)localObject1, this.t);
        if (this.j)
        {
          paramCanvas.drawLine(this.B, this.C, this.D, this.E, this.u);
          localObject1 = this.r;
          f1 = this.B;
          f2 = this.p;
          f3 = this.C;
          paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
          localObject1 = this.r;
          f1 = this.D;
          f2 = this.p;
          f3 = this.E;
          paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
        }
        if (k())
        {
          f1 = this.B;
          f2 = this.C;
          bool1 = bool2;
          if (f2 >= this.E) {
            bool1 = true;
          }
          a(paramCanvas, f1, f2, bool1);
        }
      }
    }
    else
    {
      paramCanvas.save();
      if (this.m) {
        paramCanvas.rotate(this.F, this.B, this.C);
      } else {
        paramCanvas.rotate(this.F, this.G.centerX(), this.G.centerY());
      }
      int i1 = ShapeEffect.1.a[this.g.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if ((i1 == 3) || (i1 == 4))
          {
            paramCanvas.drawOval(this.G, this.x);
            if (this.j)
            {
              paramCanvas.drawRect(this.H, this.u);
              paramCanvas.drawBitmap(this.r, null, new RectF(this.H.right - this.p, this.H.bottom - this.p, this.H.right + this.p, this.H.bottom + this.p), null);
              paramCanvas.drawBitmap(this.s, null, new RectF(this.H.left - this.o, this.H.top - this.o, this.H.left + this.o, this.H.top + this.o), null);
            }
          }
        }
        else
        {
          paramCanvas.drawRect(this.G, this.x);
          if (this.j)
          {
            paramCanvas.drawRect(this.G, this.u);
            paramCanvas.drawBitmap(this.r, null, new RectF(this.G.right - this.p, this.G.bottom - this.p, this.G.right + this.p, this.G.bottom + this.p), null);
            paramCanvas.drawBitmap(this.s, null, new RectF(this.G.left - this.o, this.G.top - this.o, this.G.left + this.o, this.G.top + this.o), null);
          }
        }
      }
      else
      {
        paramCanvas.drawRect(this.G, this.x);
        if (this.j)
        {
          paramCanvas.drawRect(this.H, this.u);
          paramCanvas.drawBitmap(this.r, null, new RectF(this.H.right - this.p, this.H.bottom - this.p, this.H.right + this.p, this.H.bottom + this.p), null);
          paramCanvas.drawBitmap(this.s, null, new RectF(this.H.left - this.o, this.H.top - this.o, this.H.left + this.o, this.H.top + this.o), null);
        }
      }
      paramCanvas.restore();
      localObject1 = new RectF();
      if (!this.m)
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).setRotate(this.F, this.G.centerX(), this.G.centerY());
        ((Matrix)localObject2).mapRect((RectF)localObject1, this.H);
      }
      else
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).postRotate(this.F, this.B, this.C);
        ((Matrix)localObject2).mapRect((RectF)localObject1, this.H);
      }
      f1 = ((RectF)localObject1).centerX();
      f2 = ((RectF)localObject1).bottom;
      if (k()) {
        a(paramCanvas, f1, f2, true);
      }
    }
  }
  
  public void a(ShapeEffect.InteractionListener paramInteractionListener)
  {
    this.X = paramInteractionListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.k == null) {
        this.k = Boolean.valueOf(true);
      }
    }
    else if (Boolean.TRUE.equals(this.k)) {
      this.k = Boolean.valueOf(false);
    }
    this.j = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.g == ShapeOperator.Shape.ARROW) {
      return c(paramInt1, paramInt2);
    }
    float f2 = this.x.getStrokeWidth() / 2.0F;
    int i1 = c;
    float f1 = f2;
    if (f2 < i1) {
      f1 = i1;
    }
    if (this.g == ShapeOperator.Shape.LINE) {
      return a(paramInt1, paramInt2, f1);
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F, this.G.centerX(), this.G.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    localMatrix.mapPoints(arrayOfFloat);
    float f6 = this.G.width() / 2.0F;
    float f7 = this.G.height() / 2.0F;
    float f4 = arrayOfFloat[0] - this.G.centerX();
    f2 = arrayOfFloat[1] - this.G.centerY();
    paramInt1 = ShapeEffect.1.a[this.g.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        float f3;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return false;
          }
          f3 = f6 + f1;
          f1 = f7 + f1;
          f3 *= f3;
          if (f4 * f4 + f2 * f2 * f3 / (f1 * f1) < f3) {
            return true;
          }
        }
        else
        {
          float f5 = f6 - f1;
          f3 = f7 - f1;
          f6 += f1;
          f1 = f7 + f1;
          f4 *= f4;
          f2 *= f2;
          f6 *= f6;
          if (f2 * f6 / (f1 * f1) + f4 < f6)
          {
            f1 = f5 * f5;
            if (f4 + f2 * f1 / (f3 * f3) > f1) {
              return true;
            }
          }
        }
      }
      else if ((arrayOfFloat[0] > this.H.left - f1) && (arrayOfFloat[0] < this.H.right + f1) && (arrayOfFloat[1] > this.H.top - f1) && (arrayOfFloat[1] < this.H.bottom + f1))
      {
        return true;
      }
    }
    else if ((arrayOfFloat[0] > this.G.left - f1) && (arrayOfFloat[0] < this.G.right + f1) && (arrayOfFloat[1] > this.G.top - f1) && (arrayOfFloat[1] < this.G.bottom + f1) && ((arrayOfFloat[0] <= this.G.left + f1) || (arrayOfFloat[0] >= this.G.right - f1) || (arrayOfFloat[1] <= this.G.top + f1) || (arrayOfFloat[1] >= this.G.bottom - f1))) {
      return true;
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.i) {
      return c(paramMotionEvent);
    }
    return b(paramMotionEvent);
  }
  
  public void b(float paramFloat)
  {
    this.h = paramFloat;
    paramFloat = c(paramFloat);
    this.t.setStrokeWidth(paramFloat);
    this.x.setStrokeWidth(paramFloat);
    if (this.g == ShapeOperator.Shape.ARROW)
    {
      this.I = n();
      this.J = o();
      return;
    }
    m();
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    this.D += arrayOfFloat[0];
    this.E += arrayOfFloat[1];
    l();
    m();
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean b()
  {
    float f1 = this.D - this.B;
    float f2 = this.E - this.C;
    return Math.sqrt(f1 * f1 + f2 * f2) > UIUtils.a(this.f, 10.0F);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    switch (ShapeEffect.1.a[this.g.ordinal()])
    {
    default: 
      return false;
    case 5: 
    case 6: 
      return a(paramInt1, paramInt2);
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F, this.G.centerX(), this.G.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    localMatrix.mapPoints(arrayOfFloat);
    return (arrayOfFloat[0] > this.H.left) && (arrayOfFloat[0] < this.H.right) && (arrayOfFloat[1] > this.H.top) && (arrayOfFloat[1] < this.H.bottom);
  }
  
  public float c()
  {
    return this.h;
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    if ((this.g != ShapeOperator.Shape.LINE) && (this.g != ShapeOperator.Shape.ARROW))
    {
      if ((f(paramFloat1, paramFloat2)) || (e(paramFloat1, paramFloat2))) {
        return true;
      }
    }
    else
    {
      if (j(paramFloat1, paramFloat2)) {
        break label65;
      }
      if (k(paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
    label65:
    return true;
  }
  
  public int d()
  {
    return this.t.getColor();
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    return (this.n) && (this.R.contains(paramFloat1, paramFloat2));
  }
  
  public PointF e()
  {
    return new PointF(this.G.centerX(), this.G.centerY());
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F, this.G.centerX(), this.G.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0] - this.H.right;
    paramFloat2 = arrayOfFloat[1] - this.H.bottom;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.q;
  }
  
  public boolean f(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.F, this.G.centerX(), this.G.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0] - this.H.left;
    paramFloat2 = arrayOfFloat[1] - this.H.top;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect
 * JD-Core Version:    0.7.0.1
 */