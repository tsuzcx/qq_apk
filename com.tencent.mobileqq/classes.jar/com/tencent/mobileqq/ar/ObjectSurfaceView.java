package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public FaceUIController a;
  int[] b = { Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255) };
  float[] c = { 0.0F, 0.5F };
  SweepGradient d;
  BlurMaskFilter e;
  Matrix f = new Matrix();
  private SurfaceHolder g;
  private float h = 1.0F;
  private boolean i;
  private long j = 50L;
  private CopyOnWriteArrayList<ObjectBaseData> k = new CopyOnWriteArrayList();
  private ConcurrentHashMap<String, ObjectBaseData> l = new ConcurrentHashMap();
  private CopyOnWriteArrayList<String> m = new CopyOnWriteArrayList();
  private List<DrawView2.FaceData> n;
  private boolean o;
  private HandlerThread p;
  private Handler q;
  private HandlerThread r;
  private Handler s;
  private Runnable t = new ObjectSurfaceView.1(this);
  
  public ObjectSurfaceView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= paramFloat1) {
      return paramFloat2 - paramFloat1;
    }
    return paramFloat2 + 360.0F - paramFloat1;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Canvas paramCanvas)
  {
    Canvas localCanvas = paramCanvas;
    if (localCanvas != null)
    {
      ObjectBaseData localObjectBaseData1 = getMainFaceData();
      int i3 = 0;
      int i4 = 1;
      while (i3 < this.k.size())
      {
        ObjectBaseData localObjectBaseData2 = (ObjectBaseData)this.k.get(i3);
        if (localObjectBaseData2 == null) {
          return;
        }
        Object localObject2;
        if (!localObjectBaseData2.T)
        {
          this.q.post(new ObjectSurfaceView.2(this, localObjectBaseData2, localObjectBaseData1));
          if ((localObjectBaseData2.c) && (!localObjectBaseData2.d) && (localObjectBaseData2.Q) && (!localObjectBaseData2.h)) {
            if (!TextUtils.isEmpty(localObjectBaseData2.R))
            {
              if (!this.m.contains(localObjectBaseData2.R))
              {
                localObject1 = localObjectBaseData2.R;
                localObject2 = localObjectBaseData2.N;
                this.q.postDelayed(new ObjectSurfaceView.3(this, (String)localObject1, (String)localObject2), 4000L);
              }
            }
            else if (localObjectBaseData2.Q) {
              this.q.postDelayed(new ObjectSurfaceView.4(this, localObjectBaseData2), 4000L);
            }
          }
        }
        localObjectBaseData2.cH.setColor(localObjectBaseData2.G);
        localObjectBaseData2.cH.setStrokeWidth(localObjectBaseData2.o);
        if (((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cH.setAlpha((int)(localObjectBaseData2.F * 255.0F));
        }
        else
        {
          localObject1 = localObjectBaseData2.cH;
          d1 = localObjectBaseData2.F * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.5D));
        }
        float f1 = localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o;
        Object localObject1 = new RectF(localObjectBaseData2.a - f1, localObjectBaseData2.b - f1, localObjectBaseData2.a + f1, localObjectBaseData2.b + f1);
        if ((localObjectBaseData2.G != -1) && (localObjectBaseData2.c) && (!localObjectBaseData2.h))
        {
          this.d = new SweepGradient(localObjectBaseData2.a, localObjectBaseData2.b, this.b, this.c);
          this.f.setRotate(localObjectBaseData2.p + localObjectBaseData2.n - 5.0F, localObjectBaseData2.a, localObjectBaseData2.b);
          this.d.setLocalMatrix(this.f);
          localObjectBaseData2.cH.setShader(this.d);
        }
        else
        {
          localObjectBaseData2.cH.setShader(null);
        }
        if (localObjectBaseData2.ba != 0.0F) {
          this.e = new BlurMaskFilter(localObjectBaseData2.bb * localObjectBaseData2.ba, BlurMaskFilter.Blur.SOLID);
        } else {
          this.e = null;
        }
        if (this.e != null)
        {
          localObjectBaseData2.cH.setMaskFilter(this.e);
          localObjectBaseData2.cH.setShader(null);
        }
        else
        {
          localObjectBaseData2.cH.setMaskFilter(null);
        }
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.p + localObjectBaseData2.n, a(localObjectBaseData2.p + localObjectBaseData2.n, localObjectBaseData2.q + localObjectBaseData2.n), false, localObjectBaseData2.cH);
        if ((localObjectBaseData2.G != -1) && (localObjectBaseData2.c) && (!localObjectBaseData2.h))
        {
          this.b = new int[] { localObjectBaseData2.u, localObjectBaseData2.t };
          this.d = new SweepGradient(localObjectBaseData2.a, localObjectBaseData2.b, this.b, this.c);
          this.f.setRotate(localObjectBaseData2.r + localObjectBaseData2.n - 5.0F, localObjectBaseData2.a, localObjectBaseData2.b);
          this.d.setLocalMatrix(this.f);
          localObjectBaseData2.cH.setShader(this.d);
        }
        else
        {
          localObjectBaseData2.cH.setShader(null);
        }
        if (this.e != null)
        {
          localObjectBaseData2.cH.setMaskFilter(this.e);
          localObjectBaseData2.cH.setShader(null);
        }
        else
        {
          localObjectBaseData2.cH.setMaskFilter(null);
        }
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.r + localObjectBaseData2.n, a(localObjectBaseData2.r + localObjectBaseData2.n, localObjectBaseData2.s + localObjectBaseData2.n), false, localObjectBaseData2.cH);
        float f5;
        double d2;
        float f2;
        float f3;
        float f4;
        float f6;
        float f7;
        if ((localObjectBaseData2.E > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          f5 = localObjectBaseData2.o;
          d1 = localObjectBaseData2.l * localObjectBaseData2.m + f5;
          d2 = localObjectBaseData2.w + localObjectBaseData2.n;
          Double.isNaN(d2);
          d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          double d3 = localObjectBaseData2.a;
          Double.isNaN(d3);
          localObjectBaseData2.y = ((float)(d1 * d2 + d3));
          d1 = localObjectBaseData2.l * localObjectBaseData2.m + f5;
          d2 = localObjectBaseData2.w + localObjectBaseData2.n;
          Double.isNaN(d2);
          d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.b;
          Double.isNaN(d3);
          localObjectBaseData2.z = ((float)(d1 * d2 + d3));
          f2 = localObjectBaseData2.x + localObjectBaseData2.n;
          f3 = f2 + 120.0F;
          f4 = f3 + 120.0F;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f1;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          double d4 = localObjectBaseData2.y;
          Double.isNaN(d4);
          f1 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.z;
          Double.isNaN(d3);
          f4 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f2;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.y;
          Double.isNaN(d4);
          f2 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.z;
          Double.isNaN(d3);
          f6 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f3;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.y;
          Double.isNaN(d4);
          f3 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.z;
          Double.isNaN(d3);
          f7 = (float)(d1 * d2 + d3);
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f4);
          ((Path)localObject1).lineTo(f2, f6);
          ((Path)localObject1).lineTo(f3, f7);
          ((Path)localObject1).close();
          localObjectBaseData2.cI.setColor(localObjectBaseData2.C);
          localObjectBaseData2.cI.setAlpha((int)(localObjectBaseData2.E * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.cI);
          d1 = localObjectBaseData2.l * localObjectBaseData2.m + f5;
          d2 = localObjectBaseData2.x + localObjectBaseData2.n;
          Double.isNaN(d2);
          d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.a;
          Double.isNaN(d3);
          localObjectBaseData2.A = ((float)(d1 * d2 + d3));
          d1 = localObjectBaseData2.l * localObjectBaseData2.m + f5;
          d2 = localObjectBaseData2.x + localObjectBaseData2.n;
          Double.isNaN(d2);
          d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.b;
          Double.isNaN(d3);
          localObjectBaseData2.B = ((float)(d1 * d2 + d3));
          f2 = localObjectBaseData2.w + localObjectBaseData2.n;
          f3 = f2 + 120.0F;
          f4 = 120.0F + f3;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f1;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.A;
          Double.isNaN(d4);
          f1 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.B;
          Double.isNaN(d3);
          f4 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f2;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.A;
          Double.isNaN(d4);
          f2 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.B;
          Double.isNaN(d3);
          f5 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = f3;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.A;
          Double.isNaN(d4);
          f3 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.v * localObjectBaseData2.m;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.B;
          Double.isNaN(d3);
          f6 = (float)(d1 * d2 + d3);
          ((Path)localObject1).reset();
          ((Path)localObject1).moveTo(f1, f4);
          ((Path)localObject1).lineTo(f2, f5);
          ((Path)localObject1).lineTo(f3, f6);
          ((Path)localObject1).close();
          localObjectBaseData2.cI.setColor(localObjectBaseData2.D);
          localObjectBaseData2.cI.setAlpha((int)(localObjectBaseData2.E * 255.0F));
          localObject2 = localObjectBaseData2.cI;
          localCanvas = paramCanvas;
          localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
        }
        if ((localObjectBaseData2.ae > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cJ.setColor(localObjectBaseData2.ad);
          localObjectBaseData2.cJ.setStrokeWidth(localObjectBaseData2.Y);
          localObject1 = localObjectBaseData2.cJ;
          d1 = localObjectBaseData2.ae * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.4D));
          f1 = localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y;
          localObject1 = new RectF(localObjectBaseData2.a - f1, localObjectBaseData2.b - f1, localObjectBaseData2.a + f1, localObjectBaseData2.b + f1);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.Z + localObjectBaseData2.X, a(localObjectBaseData2.Z + localObjectBaseData2.X, localObjectBaseData2.aa + localObjectBaseData2.X), false, localObjectBaseData2.cJ);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ab + localObjectBaseData2.X, a(localObjectBaseData2.ab + localObjectBaseData2.X, localObjectBaseData2.ac + localObjectBaseData2.X), false, localObjectBaseData2.cJ);
        }
        localObjectBaseData2.cK.setColor(localObjectBaseData2.ar);
        localObjectBaseData2.cK.setStrokeWidth(localObjectBaseData2.ak);
        localObject1 = localObjectBaseData2.cK;
        double d1 = localObjectBaseData2.as * 255.0F;
        Double.isNaN(d1);
        ((Paint)localObject1).setAlpha((int)(d1 * 0.3D));
        f1 = localObjectBaseData2.ag * localObjectBaseData2.ah + localObjectBaseData2.ak;
        localObject1 = new RectF(localObjectBaseData2.a - f1, localObjectBaseData2.b - f1, localObjectBaseData2.a + f1, localObjectBaseData2.b + f1);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.al + localObjectBaseData2.ai, a(localObjectBaseData2.al + localObjectBaseData2.ai, localObjectBaseData2.am + localObjectBaseData2.ai), false, localObjectBaseData2.cK);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ap + localObjectBaseData2.ai, a(localObjectBaseData2.ap + localObjectBaseData2.ai, localObjectBaseData2.aq + localObjectBaseData2.ai), false, localObjectBaseData2.cK);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.an + localObjectBaseData2.ai, a(localObjectBaseData2.an + localObjectBaseData2.ai, localObjectBaseData2.ao + localObjectBaseData2.ai), false, localObjectBaseData2.cK);
        if ((localObjectBaseData2.aC > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cL.setColor(localObjectBaseData2.aB);
          localObjectBaseData2.cL.setStrokeWidth(localObjectBaseData2.au);
          localObjectBaseData2.cL.setAlpha((int)(localObjectBaseData2.aC * 255.0F));
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.av + localObjectBaseData2.ai, a(localObjectBaseData2.av + localObjectBaseData2.ai, localObjectBaseData2.aw + localObjectBaseData2.ai), false, localObjectBaseData2.cL);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.az + localObjectBaseData2.ai, a(localObjectBaseData2.az + localObjectBaseData2.ai, localObjectBaseData2.aA + localObjectBaseData2.ai), false, localObjectBaseData2.cL);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ax + localObjectBaseData2.ai, a(localObjectBaseData2.ax + localObjectBaseData2.ai, localObjectBaseData2.ay + localObjectBaseData2.ai), false, localObjectBaseData2.cL);
        }
        if ((localObjectBaseData2.aH > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cM.setColor(localObjectBaseData2.aG);
          localObjectBaseData2.cM.setStrokeWidth(localObjectBaseData2.aF);
          localObject1 = localObjectBaseData2.cM;
          d1 = localObjectBaseData2.aH * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.1D));
          f1 = localObjectBaseData2.aF / 2.0F;
          localCanvas.drawCircle(localObjectBaseData2.a, localObjectBaseData2.b, localObjectBaseData2.aD * localObjectBaseData2.aE + f1, localObjectBaseData2.cM);
        }
        if ((localObjectBaseData2.aV > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cN.setColor(localObjectBaseData2.aU);
          localObjectBaseData2.cN.setStrokeWidth(localObjectBaseData2.aL);
          localObject1 = localObjectBaseData2.cN;
          d1 = localObjectBaseData2.aV * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.3D));
          f1 = localObjectBaseData2.aK * localObjectBaseData2.aI + localObjectBaseData2.aL;
          localObject1 = new RectF(localObjectBaseData2.a - f1, localObjectBaseData2.b - f1, localObjectBaseData2.a + f1, localObjectBaseData2.b + f1);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.aO + localObjectBaseData2.aJ, a(localObjectBaseData2.aO + localObjectBaseData2.aJ, localObjectBaseData2.aP + localObjectBaseData2.aJ), false, localObjectBaseData2.cN);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.aM + localObjectBaseData2.aJ, a(localObjectBaseData2.aM + localObjectBaseData2.aJ, localObjectBaseData2.aN + localObjectBaseData2.aJ), false, localObjectBaseData2.cN);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.aS + localObjectBaseData2.aJ, a(localObjectBaseData2.aS + localObjectBaseData2.aJ, localObjectBaseData2.aT + localObjectBaseData2.aJ), false, localObjectBaseData2.cN);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.aQ + localObjectBaseData2.aJ, a(localObjectBaseData2.aQ + localObjectBaseData2.aJ, localObjectBaseData2.aR + localObjectBaseData2.aJ), false, localObjectBaseData2.cN);
        }
        if ((localObjectBaseData2.aZ > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (localObjectBaseData2.P) && (!localObjectBaseData2.h))
        {
          localObjectBaseData2.cO.setColor(localObjectBaseData2.aY);
          localObjectBaseData2.cO.setAlpha((int)(localObjectBaseData2.aZ * 255.0F));
          localCanvas.drawCircle(localObjectBaseData2.a, localObjectBaseData2.b, localObjectBaseData2.aX * localObjectBaseData2.aW + 0.0F, localObjectBaseData2.cO);
        }
        int i1;
        if (localObjectBaseData2.b < localObjectBaseData2.l + (float)c(localObjectBaseData2) + 80.0F) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        float f8;
        float f9;
        float f10;
        String str;
        if ((localObjectBaseData2.P) && (localObjectBaseData2.by > 0.0F) && (!localObjectBaseData2.h) && (i1 == 1))
        {
          localObjectBaseData2.cR.setAlpha((int)(localObjectBaseData2.by * 255.0F));
          localObjectBaseData2.cR.setStrokeWidth(localObjectBaseData2.bk);
          localObjectBaseData2.cP.setStrokeWidth(localObjectBaseData2.bj);
          localObjectBaseData2.cP.setAlpha((int)(localObjectBaseData2.by * 255.0F));
          if ((localObjectBaseData2.c) && (localObjectBaseData2.W != 0.0F)) {
            localObjectBaseData2.be = ((localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y) * 2.0F / 3.6F);
          } else {
            localObjectBaseData2.be = ((localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o) * 2.0F / 3.6F);
          }
          if (localObjectBaseData2.be > localObjectBaseData2.bf) {
            localObjectBaseData2.be = localObjectBaseData2.bf;
          }
          if (localObjectBaseData2.be < localObjectBaseData2.bg) {
            localObjectBaseData2.be = localObjectBaseData2.bg;
          }
          localObjectBaseData2.bh = (localObjectBaseData2.a - localObjectBaseData2.l * localObjectBaseData2.m - localObjectBaseData2.o - localObjectBaseData2.bv);
          localObjectBaseData2.bi = (localObjectBaseData2.b - localObjectBaseData2.l * localObjectBaseData2.m - localObjectBaseData2.o - localObjectBaseData2.bw * localObjectBaseData2.bL);
          if ((localObjectBaseData2.c) && (localObjectBaseData2.P) && (localObjectBaseData2.W != 0.0F))
          {
            localObjectBaseData2.bh = (localObjectBaseData2.a - localObjectBaseData2.l * localObjectBaseData2.m - localObjectBaseData2.o - localObjectBaseData2.bv - ObjectBaseData.Dip2PxCache.e);
            localObjectBaseData2.I = (localObjectBaseData2.bi - localObjectBaseData2.be);
            localObjectBaseData2.K = (localObjectBaseData2.b + localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y);
            localObjectBaseData2.L = (localObjectBaseData2.a + localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y);
            localObjectBaseData2.J = localObjectBaseData2.bh;
          }
          else
          {
            localObjectBaseData2.I = (localObjectBaseData2.bi - localObjectBaseData2.be);
            localObjectBaseData2.K = (localObjectBaseData2.b + localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o);
            localObjectBaseData2.L = (localObjectBaseData2.a + localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o);
            localObjectBaseData2.J = localObjectBaseData2.bh;
          }
          f4 = localObjectBaseData2.a;
          f5 = localObjectBaseData2.ag;
          f6 = localObjectBaseData2.aF;
          f7 = localObjectBaseData2.cF;
          f8 = localObjectBaseData2.cu;
          f9 = localObjectBaseData2.cv;
          if ((!TextUtils.isEmpty(localObjectBaseData2.bc)) && (!TextUtils.isEmpty(localObjectBaseData2.bd)))
          {
            localObjectBaseData2.bd = localObjectBaseData2.bd.toUpperCase();
            localObjectBaseData2.cR.setTextSize(localObjectBaseData2.br * localObjectBaseData2.bL);
            localObjectBaseData2.cR.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.by != 0.0F) {
              localObjectBaseData2.cR.setShadowLayer(localObjectBaseData2.bA, 0.0F, localObjectBaseData2.bB, localObjectBaseData2.bC);
            } else {
              localObjectBaseData2.cR.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localObject1 = localObjectBaseData2.cR.getFontMetrics();
            f2 = localObjectBaseData2.bi + ((Paint.FontMetrics)localObject1).top;
            f3 = localObjectBaseData2.bi + ((Paint.FontMetrics)localObject1).bottom;
            if (localObjectBaseData2.bn == 0.0F)
            {
              f10 = localObjectBaseData2.J;
              f1 = localObjectBaseData2.bm;
              localObjectBaseData2.cQ.setTextSize(localObjectBaseData2.bL * f1);
              while (localObjectBaseData2.cQ.measureText(localObjectBaseData2.bc) > f4 + f5 + f6 + f7 - f8 - f9 * 4.0F - f10)
              {
                f1 -= 1.0F;
                localObjectBaseData2.cQ.setTextSize(localObjectBaseData2.bL * f1);
              }
              localObjectBaseData2.bn = (f1 / localObjectBaseData2.e);
            }
            localObjectBaseData2.bm = (localObjectBaseData2.bn * localObjectBaseData2.e);
            localObjectBaseData2.bm = localObjectBaseData2.bp;
            localObjectBaseData2.br = localObjectBaseData2.bt;
            localObjectBaseData2.cP.setTextSize(localObjectBaseData2.bm * localObjectBaseData2.bL);
            localObjectBaseData2.cP.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.c) {
              localObjectBaseData2.cP.setFakeBoldText(true);
            } else {
              localObjectBaseData2.cP.setFakeBoldText(false);
            }
            if (localObjectBaseData2.by != 0.0F) {
              localObjectBaseData2.cP.setShadowLayer(localObjectBaseData2.bA, 0.0F, localObjectBaseData2.bB, localObjectBaseData2.bC);
            } else {
              localObjectBaseData2.cP.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localCanvas.drawText(localObjectBaseData2.bd, localObjectBaseData2.bh, localObjectBaseData2.bi, localObjectBaseData2.cR);
            i1 = localObjectBaseData2.bc.length();
            if (i1 < 9)
            {
              localCanvas.drawText(localObjectBaseData2.bc, localObjectBaseData2.bh, localObjectBaseData2.bi - localObjectBaseData2.bx - (f3 - f2), localObjectBaseData2.cP);
            }
            else
            {
              str = localObjectBaseData2.bc.substring(0, 7);
              localObject2 = localObjectBaseData2.bc.substring(7, i1);
              localObject1 = localObject2;
              if (((String)localObject2).length() > 7)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 6));
                ((StringBuilder)localObject1).append("...");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject2 = new Rect();
              localObjectBaseData2.cP.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
              i1 = (int)(localObjectBaseData2.bx + (((Rect)localObject2).bottom - ((Rect)localObject2).top));
              f1 = localObjectBaseData2.bh;
              f4 = localObjectBaseData2.bi;
              f2 = f3 - f2;
              localCanvas.drawText((String)localObject1, f1, f4 - f2, localObjectBaseData2.cP);
              i1 = (int)(i1 + (f2 + 20.0F));
              localCanvas.drawText(str, localObjectBaseData2.bh, localObjectBaseData2.bi - i1, localObjectBaseData2.cP);
            }
            localObjectBaseData2.cS.setAlpha((int)(localObjectBaseData2.bG * 255.0F));
            f1 = localObjectBaseData2.bi + localObjectBaseData2.bw * localObjectBaseData2.bL;
            f2 = localObjectBaseData2.bh + localObjectBaseData2.bK;
            f3 = f1 + localObjectBaseData2.bH * localObjectBaseData2.bL;
            d1 = localObjectBaseData2.bI * localObjectBaseData2.bL;
            d2 = localObjectBaseData2.bE;
            Double.isNaN(d2);
            d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f4 = f2 + (float)(d1 * d2);
            d1 = localObjectBaseData2.bI * localObjectBaseData2.bL;
            d2 = localObjectBaseData2.bE;
            Double.isNaN(d2);
            d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f5 = f3 + (float)(d1 * d2);
            if (localObjectBaseData2.bG >= 0.2D) {
              paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.cS);
            }
            if (localObjectBaseData2.bG >= 0.5D) {
              paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.cS);
            }
            localObjectBaseData2.cT.setAlpha((int)(localObjectBaseData2.bG * 255.0F));
            localCanvas.drawCircle(f4, f5, localObjectBaseData2.bM, localObjectBaseData2.cT);
          }
        }
        else if ((localObjectBaseData2.P) && (localObjectBaseData2.by > 0.0F) && (!localObjectBaseData2.h) && (i1 == 2))
        {
          localObjectBaseData2.cR.setAlpha((int)(localObjectBaseData2.by * 255.0F));
          localObjectBaseData2.cR.setStrokeWidth(localObjectBaseData2.bk);
          localObjectBaseData2.cP.setStrokeWidth(localObjectBaseData2.bj);
          localObjectBaseData2.cP.setAlpha((int)(localObjectBaseData2.by * 255.0F));
          if ((localObjectBaseData2.c) && (localObjectBaseData2.W != 0.0F)) {
            localObjectBaseData2.be = ((localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y) * 2.0F / 3.6F);
          } else {
            localObjectBaseData2.be = ((localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o) * 2.0F / 3.6F);
          }
          if (localObjectBaseData2.be > localObjectBaseData2.bf) {
            localObjectBaseData2.be = localObjectBaseData2.bf;
          }
          if (localObjectBaseData2.be < localObjectBaseData2.bg) {
            localObjectBaseData2.be = localObjectBaseData2.bg;
          }
          localObjectBaseData2.bh = (localObjectBaseData2.a - localObjectBaseData2.l * localObjectBaseData2.m - localObjectBaseData2.o - localObjectBaseData2.bv);
          localObjectBaseData2.bi = (localObjectBaseData2.b + localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o + localObjectBaseData2.bw * localObjectBaseData2.bL);
          if ((localObjectBaseData2.c) && (localObjectBaseData2.P) && (localObjectBaseData2.W != 0.0F))
          {
            localObjectBaseData2.bh = (localObjectBaseData2.a - localObjectBaseData2.l * localObjectBaseData2.m - localObjectBaseData2.o - localObjectBaseData2.bv - ObjectBaseData.Dip2PxCache.e);
            localObjectBaseData2.I = (localObjectBaseData2.b + localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y);
            localObjectBaseData2.K = (localObjectBaseData2.bi + localObjectBaseData2.be);
            localObjectBaseData2.L = (localObjectBaseData2.a + localObjectBaseData2.V * localObjectBaseData2.W + localObjectBaseData2.Y);
            localObjectBaseData2.J = localObjectBaseData2.bh;
          }
          else
          {
            localObjectBaseData2.I = (localObjectBaseData2.bi - localObjectBaseData2.be);
            localObjectBaseData2.K = (localObjectBaseData2.b + localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o);
            localObjectBaseData2.L = (localObjectBaseData2.a + localObjectBaseData2.l * localObjectBaseData2.m + localObjectBaseData2.o);
            localObjectBaseData2.J = localObjectBaseData2.bh;
          }
          f2 = localObjectBaseData2.a;
          f3 = localObjectBaseData2.ag;
          f4 = localObjectBaseData2.aF;
          f5 = localObjectBaseData2.cF;
          f6 = localObjectBaseData2.cu;
          f7 = localObjectBaseData2.cv;
          if ((!TextUtils.isEmpty(localObjectBaseData2.bc)) && (!TextUtils.isEmpty(localObjectBaseData2.bd)))
          {
            localObjectBaseData2.bd = localObjectBaseData2.bd.toUpperCase();
            localObjectBaseData2.cR.setTextSize(localObjectBaseData2.br * localObjectBaseData2.bL);
            localObjectBaseData2.cR.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.by != 0.0F) {
              localObjectBaseData2.cR.setShadowLayer(localObjectBaseData2.bA, 0.0F, localObjectBaseData2.bB, localObjectBaseData2.bC);
            } else {
              localObjectBaseData2.cR.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localObject1 = localObjectBaseData2.cR.getFontMetrics();
            f8 = localObjectBaseData2.bi;
            f9 = ((Paint.FontMetrics)localObject1).top;
            f10 = localObjectBaseData2.bi;
            float f11 = ((Paint.FontMetrics)localObject1).bottom;
            if (localObjectBaseData2.bn == 0.0F)
            {
              float f12 = localObjectBaseData2.J;
              f1 = localObjectBaseData2.bm;
              localObjectBaseData2.cQ.setTextSize(localObjectBaseData2.bL * f1);
              while (localObjectBaseData2.cQ.measureText(localObjectBaseData2.bc) > f2 + f3 + f4 + f5 - f6 - f7 * 4.0F - f12)
              {
                f1 -= 1.0F;
                localObjectBaseData2.cQ.setTextSize(localObjectBaseData2.bL * f1);
              }
              localObjectBaseData2.bn = (f1 / localObjectBaseData2.e);
            }
            localObjectBaseData2.bm = (localObjectBaseData2.bn * localObjectBaseData2.e);
            localObjectBaseData2.bm = localObjectBaseData2.bp;
            localObjectBaseData2.br = localObjectBaseData2.bt;
            localObjectBaseData2.cP.setTextSize(localObjectBaseData2.bm * localObjectBaseData2.bL);
            localObjectBaseData2.cP.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.c) {
              localObjectBaseData2.cP.setFakeBoldText(true);
            } else {
              localObjectBaseData2.cP.setFakeBoldText(false);
            }
            if (localObjectBaseData2.by != 0.0F) {
              localObjectBaseData2.cP.setShadowLayer(localObjectBaseData2.bA, 0.0F, localObjectBaseData2.bB, localObjectBaseData2.bC);
            } else {
              localObjectBaseData2.cP.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            i1 = localObjectBaseData2.bc.length();
            f1 = f10 + f11 - (f8 + f9);
            int i5 = (int)f1;
            if (i1 >= 9)
            {
              str = localObjectBaseData2.bc.substring(0, 7);
              localObject2 = localObjectBaseData2.bc.substring(7, i1);
              localObject1 = localObject2;
              if (((String)localObject2).length() > 7)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 6));
                ((StringBuilder)localObject1).append("...");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject2 = new Rect();
              localObjectBaseData2.cP.getTextBounds(str, 0, str.length(), (Rect)localObject2);
              long l1 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
              f1 = localObjectBaseData2.bh;
              f2 = localObjectBaseData2.bi;
              f3 = (float)l1;
              localCanvas.drawText(str, f1, f2 + f3, localObjectBaseData2.cP);
              localObjectBaseData2.cP.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
              long l2 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
              localCanvas.drawText((String)localObject1, localObjectBaseData2.bh, localObjectBaseData2.bi + (float)l2 + f3 + 20.0F, localObjectBaseData2.cP);
              f1 = (float)(l1 + l2 + 20L);
            }
            else
            {
              localCanvas.drawText(localObjectBaseData2.bc, localObjectBaseData2.bh, localObjectBaseData2.bi + i5, localObjectBaseData2.cP);
              f1 = localObjectBaseData2.bx + f1;
            }
            localObject1 = new Rect();
            localObjectBaseData2.cR.getTextBounds(localObjectBaseData2.bd, 0, localObjectBaseData2.bd.length(), (Rect)localObject1);
            localCanvas.drawText(localObjectBaseData2.bd, localObjectBaseData2.bh, localObjectBaseData2.bi + f1 + (((Rect)localObject1).bottom - ((Rect)localObject1).top) + 20.0F, localObjectBaseData2.cR);
            localObjectBaseData2.cS.setAlpha((int)(localObjectBaseData2.bG * 255.0F));
            f1 = localObjectBaseData2.bi - localObjectBaseData2.bw * localObjectBaseData2.bL;
            f2 = localObjectBaseData2.bh + localObjectBaseData2.bK;
            f3 = f1 - localObjectBaseData2.bH * localObjectBaseData2.bL;
            d1 = localObjectBaseData2.bI * localObjectBaseData2.bL;
            d2 = localObjectBaseData2.bE;
            Double.isNaN(d2);
            d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f4 = f2 + (float)(d1 * d2);
            d1 = localObjectBaseData2.bI * localObjectBaseData2.bL;
            d2 = localObjectBaseData2.bE;
            Double.isNaN(d2);
            d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f5 = f3 - (float)(d1 * d2);
            if (localObjectBaseData2.bG >= 0.2D) {
              paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.cS);
            }
            if (localObjectBaseData2.bG >= 0.5D) {
              paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.cS);
            }
            localObjectBaseData2.cT.setAlpha((int)(localObjectBaseData2.bG * 255.0F));
            localCanvas.drawCircle(f4, f5, localObjectBaseData2.bM, localObjectBaseData2.cT);
          }
        }
        if ((localObjectBaseData2.bP > 0.0F) && ((localObjectBaseData2.c) || (localObjectBaseData2.f)) && (!localObjectBaseData2.h))
        {
          boolean bool;
          if (localObjectBaseData2.P)
          {
            if ((!TextUtils.isEmpty(localObjectBaseData2.cb)) && (!TextUtils.isEmpty(localObjectBaseData2.cc))) {
              i1 = 1;
            } else {
              i1 = 0;
            }
          }
          else {
            bool = TextUtils.isEmpty(localObjectBaseData2.cb) ^ true;
          }
          if (bool)
          {
            int i2 = this.a.a.b();
            if (localObjectBaseData2.P)
            {
              if (i2 != 3) {
                this.a.a.a(localObjectBaseData2.cb, localObjectBaseData2.cc, new ObjectSurfaceView.5(this, localObjectBaseData2), TextUtils.isEmpty(localObjectBaseData2.O) ^ true);
              }
            }
            else if (i2 != 2) {
              this.a.a.a(2, localObjectBaseData2.cb, false);
            }
            i4 = 0;
          }
        }
        i3 += 1;
      }
      if (i4 != 0)
      {
        this.a.a.b();
        this.a.a.a();
      }
    }
  }
  
  private void a(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData != null) && (!paramObjectBaseData.h))
    {
      if (this.l.contains(paramObjectBaseData.U)) {
        return;
      }
      this.l.put(paramObjectBaseData.U, paramObjectBaseData);
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {
      try
      {
        Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("finish_animation_up_down", true);
        getContext().startActivity(localIntent);
        if ((getContext() instanceof Activity)) {
          ((Activity)getContext()).overridePendingTransition(2130772014, 0);
        }
        ReportController.b(null, "dc00898", "", "", "0X800899A", "0X800899A", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
      }
    }
  }
  
  private void a(List<ObjectBaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ObjectBaseData)paramList.next());
      }
    }
  }
  
  private void b(ObjectBaseData paramObjectBaseData)
  {
    int i1;
    if (paramObjectBaseData != null) {
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.k.size())
        {
          ObjectBaseData localObjectBaseData = (ObjectBaseData)this.k.get(i1);
          if (localObjectBaseData != null)
          {
            if ((!localObjectBaseData.U.equals(paramObjectBaseData.U)) || (localObjectBaseData.h != paramObjectBaseData.h)) {
              break label94;
            }
            return;
          }
          this.k.remove(i1);
          break label94;
        }
        this.k.add(paramObjectBaseData);
        return;
      }
      catch (Exception paramObjectBaseData)
      {
        QLog.e("ObjectSurfaceView", 1, "addObjectData", paramObjectBaseData);
      }
      return;
      label94:
      i1 += 1;
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {
      try
      {
        Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        getContext().startActivity(localIntent);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
      }
    }
  }
  
  private long c(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData.P) && (paramObjectBaseData.by > 0.0F) && (!paramObjectBaseData.h) && (!TextUtils.isEmpty(paramObjectBaseData.bc)) && (!TextUtils.isEmpty(paramObjectBaseData.bd)))
    {
      long l2 = a(getContext(), 10.0F) + 0L + 32L;
      long l1;
      if (paramObjectBaseData.bc.length() < 8) {
        l1 = 60L;
      }
      for (;;)
      {
        return l2 + l1;
        if (paramObjectBaseData.bc.length() == 8)
        {
          l1 = 52L;
        }
        else
        {
          if (paramObjectBaseData.bc.length() <= 8) {
            break;
          }
          l1 = 160L;
        }
      }
      return l2;
    }
    return 0L;
  }
  
  private void c()
  {
    setZOrderOnTop(true);
    this.g = getHolder();
    this.g.setFormat(-2);
    this.g.addCallback(this);
    this.p = new HandlerThread("ObjectSurfaceViewAnimationThread");
    this.p.start();
    this.q = new Handler(this.p.getLooper());
    this.r = new HandlerThread("ObjectSurfaceViewDrawThread");
    this.r.start();
    this.s = new Handler(this.r.getLooper());
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 952	com/tencent/mobileqq/ar/ObjectSurfaceView:g	Landroid/view/SurfaceHolder;
    //   8: invokeinterface 989 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +66 -> 81
    //   18: aload_3
    //   19: astore_1
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: iconst_0
    //   24: getstatic 995	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   27: invokevirtual 999	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   30: aload_3
    //   31: astore_1
    //   32: aload_3
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 1001	com/tencent/mobileqq/ar/ObjectSurfaceView:i	Z
    //   38: ifeq +20 -> 58
    //   41: aload_3
    //   42: astore_1
    //   43: aload_3
    //   44: astore_2
    //   45: ldc_w 884
    //   48: iconst_1
    //   49: ldc_w 1003
    //   52: invokestatic 1006	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: goto +26 -> 81
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial 1008	com/tencent/mobileqq/ar/ObjectSurfaceView:a	(Landroid/graphics/Canvas;)V
    //   67: aload_3
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: ldc_w 884
    //   74: iconst_1
    //   75: ldc_w 1010
    //   78: invokestatic 1006	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_3
    //   82: ifnull +59 -> 141
    //   85: aload_0
    //   86: getfield 952	com/tencent/mobileqq/ar/ObjectSurfaceView:g	Landroid/view/SurfaceHolder;
    //   89: aload_3
    //   90: invokeinterface 1013 2 0
    //   95: return
    //   96: astore_1
    //   97: ldc_w 884
    //   100: iconst_1
    //   101: ldc_w 1015
    //   104: aload_1
    //   105: invokestatic 891	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: return
    //   109: astore_2
    //   110: goto +32 -> 142
    //   113: astore_3
    //   114: aload_2
    //   115: astore_1
    //   116: ldc_w 884
    //   119: iconst_1
    //   120: ldc_w 1017
    //   123: aload_3
    //   124: invokestatic 891	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: ifnull +13 -> 141
    //   131: aload_0
    //   132: getfield 952	com/tencent/mobileqq/ar/ObjectSurfaceView:g	Landroid/view/SurfaceHolder;
    //   135: aload_2
    //   136: invokeinterface 1013 2 0
    //   141: return
    //   142: aload_1
    //   143: ifnull +28 -> 171
    //   146: aload_0
    //   147: getfield 952	com/tencent/mobileqq/ar/ObjectSurfaceView:g	Landroid/view/SurfaceHolder;
    //   150: aload_1
    //   151: invokeinterface 1013 2 0
    //   156: goto +15 -> 171
    //   159: astore_1
    //   160: ldc_w 884
    //   163: iconst_1
    //   164: ldc_w 1015
    //   167: aload_1
    //   168: invokestatic 891	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ObjectSurfaceView
    //   3	66	1	localObject1	Object
    //   96	9	1	localException1	Exception
    //   115	36	1	localCanvas1	Canvas
    //   159	9	1	localException2	Exception
    //   1	70	2	localObject2	Object
    //   109	63	2	localCanvas2	Canvas
    //   13	77	3	localCanvas3	Canvas
    //   113	11	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   85	95	96	java/lang/Exception
    //   131	141	96	java/lang/Exception
    //   4	14	109	finally
    //   22	30	109	finally
    //   34	41	109	finally
    //   45	55	109	finally
    //   62	67	109	finally
    //   71	81	109	finally
    //   116	127	109	finally
    //   4	14	113	java/lang/Exception
    //   22	30	113	java/lang/Exception
    //   34	41	113	java/lang/Exception
    //   45	55	113	java/lang/Exception
    //   62	67	113	java/lang/Exception
    //   71	81	113	java/lang/Exception
    //   146	156	159	java/lang/Exception
  }
  
  private ObjectBaseData getMainFaceData()
  {
    int i1 = 0;
    while (i1 < this.k.size())
    {
      localObjectBaseData1 = (ObjectBaseData)this.k.get(i1);
      if ((localObjectBaseData1 != null) && (localObjectBaseData1.c) && (localObjectBaseData1.P) && (!localObjectBaseData1.h)) {
        break label62;
      }
      i1 += 1;
    }
    ObjectBaseData localObjectBaseData1 = null;
    label62:
    ObjectBaseData localObjectBaseData2 = localObjectBaseData1;
    if (localObjectBaseData1 == null)
    {
      localObjectBaseData2 = localObjectBaseData1;
      if (this.l.size() > 0)
      {
        Iterator localIterator = this.l.entrySet().iterator();
        do
        {
          localObjectBaseData2 = localObjectBaseData1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObjectBaseData2 = (ObjectBaseData)((Map.Entry)localIterator.next()).getValue();
        } while ((localObjectBaseData2 == null) || (!localObjectBaseData2.c) || (!localObjectBaseData2.P) || (localObjectBaseData2.h));
      }
    }
    return localObjectBaseData2;
  }
  
  public void a()
  {
    Object localObject1 = this.n;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      float f1;
      Object localObject2;
      int i3;
      Object localObject3;
      if (getMainFaceData() == null)
      {
        if (this.n.get(0) != null) {
          f1 = ((DrawView2.FaceData)this.n.get(0)).o;
        } else {
          f1 = 0.0F;
        }
        i1 = 1;
        for (i2 = 0; i1 < this.n.size(); i2 = i3)
        {
          localObject2 = (DrawView2.FaceData)this.n.get(i1);
          i3 = i2;
          if (localObject2 != null)
          {
            i3 = i2;
            if (((DrawView2.FaceData)localObject2).o > f1) {
              i3 = i1;
            }
          }
          if ((localObject2 != null) && (QLog.isColorLevel()))
          {
            localObject1 = HardCodeUtil.a(2131905507);
            if (!TextUtils.isEmpty(((DrawView2.FaceData)localObject2).d)) {
              localObject1 = ((DrawView2.FaceData)localObject2).d;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("name = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(",confidence = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).o);
            ((StringBuilder)localObject3).append(",faceId = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).f);
            ((StringBuilder)localObject3).append(",isTmpFace = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).r);
            QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject3).toString());
          }
          i1 += 1;
        }
        localObject1 = (DrawView2.FaceData)this.n.get(i2);
        if (localObject1 != null) {
          ((DrawView2.FaceData)localObject1).h = true;
        }
      }
      int i2 = 0;
      while (i2 < this.n.size())
      {
        DrawView2.FaceData localFaceData = (DrawView2.FaceData)this.n.get(i2);
        if (localFaceData != null)
        {
          localObject3 = localFaceData.a();
          i1 = 0;
          while (i1 < this.k.size())
          {
            localObject2 = (ObjectBaseData)this.k.get(i1);
            if ((localObject2 != null) && (((ObjectBaseData)localObject2).U.equals(localFaceData.d)) && (((ObjectBaseData)localObject2).h == localFaceData.r))
            {
              i1 = 1;
              break label417;
            }
            i1 += 1;
          }
          localObject2 = null;
          i1 = 0;
          label417:
          i3 = i1;
          localObject1 = localObject2;
          if (!localFaceData.r)
          {
            i3 = i1;
            localObject1 = localObject2;
            if (i1 == 0)
            {
              i3 = i1;
              localObject1 = localObject2;
              if (this.l.containsKey(Integer.valueOf(localFaceData.f)))
              {
                localObject2 = (ObjectBaseData)this.l.get(Integer.valueOf(localFaceData.f));
                i3 = i1;
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  b((ObjectBaseData)localObject2);
                  this.l.remove(Integer.valueOf(localFaceData.f));
                  i3 = 1;
                  localObject1 = localObject2;
                }
              }
            }
          }
          if (i3 == 0)
          {
            localObject1 = new MainObjectScanningData(getContext());
            ((ObjectBaseData)localObject1).h = localFaceData.r;
            ((ObjectBaseData)localObject1).U = localFaceData.d;
            if (!localFaceData.r)
            {
              ((ObjectBaseData)localObject1).c = localFaceData.h;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("1=");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).c);
                QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject2).toString());
              }
              ((ObjectBaseData)localObject1).R = localFaceData.e;
              ((ObjectBaseData)localObject1).bc = localFaceData.d;
              ((ObjectBaseData)localObject1).N = localFaceData.k;
              ((ObjectBaseData)localObject1).P = localFaceData.m;
              ((ObjectBaseData)localObject1).Q = localFaceData.n;
              ((ObjectBaseData)localObject1).S = ((RectF)localObject3);
              ((ObjectBaseData)localObject1).M = localFaceData.p;
              ((ObjectBaseData)localObject1).O = localFaceData.l;
              ((ObjectBaseData)localObject1).cb = localFaceData.i;
              ((ObjectBaseData)localObject1).cc = localFaceData.j;
              if ((!((ObjectBaseData)localObject1).g) && (QLog.isColorLevel()))
              {
                ((ObjectBaseData)localObject1).g = true;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("isMainFace = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).c);
                ((StringBuilder)localObject2).append(", fNCH = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).bc);
                ((StringBuilder)localObject2).append(", faceID = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).U);
                ((StringBuilder)localObject2).append(", isStar = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).P);
                ((StringBuilder)localObject2).append(", isActivate = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).Q);
                ((StringBuilder)localObject2).append(", fCTitleText = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).cb);
                ((StringBuilder)localObject2).append(", fCContentText = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).cc);
                ((StringBuilder)localObject2).append(", url = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).N);
                ((StringBuilder)localObject2).append(", imgUrl = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).M);
                ((StringBuilder)localObject2).append(", wikiUrl = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).O);
                QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject2).toString());
              }
            }
            b((ObjectBaseData)localObject1);
          }
          ((ObjectBaseData)localObject1).S = ((RectF)localObject3);
          ((ObjectBaseData)localObject1).bd = localFaceData.g;
          if (((ObjectBaseData)localObject1).c)
          {
            i1 = 0;
            while (i1 < this.k.size())
            {
              localObject2 = (ObjectBaseData)this.k.get(i1);
              if ((localObject2 != null) && (!((ObjectBaseData)localObject2).U.equals(((ObjectBaseData)localObject1).U)) && (!((ObjectBaseData)localObject2).P) && (((ObjectBaseData)localObject2).c)) {
                ((ObjectBaseData)localObject2).c = false;
              }
              i1 += 1;
            }
          }
          if (localObject3 != null)
          {
            f1 = ((RectF)localObject3).centerX();
            float f2 = ((RectF)localObject3).centerY();
            if ((Math.abs(f1 - ((ObjectBaseData)localObject1).a) > ObjectBaseData.Dip2PxCache.j) || (Math.abs(f2 - ((ObjectBaseData)localObject1).b) > ObjectBaseData.Dip2PxCache.j))
            {
              ((ObjectBaseData)localObject1).a = f1;
              ((ObjectBaseData)localObject1).b = f2;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("centerX = ");
            ((StringBuilder)localObject2).append(f1);
            ((StringBuilder)localObject2).append(", centerY = ");
            ((StringBuilder)localObject2).append(f2);
            QLog.d("ObjectSurfaceView", 1, ((StringBuilder)localObject2).toString());
            f1 = (float)Math.sqrt(((RectF)localObject3).width() * ((RectF)localObject3).width() + ((RectF)localObject3).height() * ((RectF)localObject3).height());
            f1 = Math.min(((ObjectBaseData)localObject1).af, f1 / 2.0F);
            this.h = 1.0F;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("scale = ");
            ((StringBuilder)localObject2).append(this.h);
            ((StringBuilder)localObject2).append(",scanningData.scale = ");
            ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).e);
            ((StringBuilder)localObject2).append(", trueRadius = ");
            ((StringBuilder)localObject2).append(f1);
            ((StringBuilder)localObject2).append(", iBCRadiusFix = ");
            ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).aj);
            QLog.d("ObjectSurfaceView", 1, ((StringBuilder)localObject2).toString());
          }
          if (this.o)
          {
            if (Math.abs(((ObjectBaseData)localObject1).e - this.h) >= 0.03D)
            {
              ((ObjectBaseData)localObject1).b();
              ((ObjectBaseData)localObject1).a(this.h);
            }
          }
          else
          {
            ((ObjectBaseData)localObject1).b();
            ((ObjectBaseData)localObject1).a(this.h);
          }
        }
        i2 += 1;
      }
      int i1 = 0;
      while (i1 < this.k.size())
      {
        localObject1 = (ObjectBaseData)this.k.get(i1);
        i2 = 0;
        while (i2 < this.n.size())
        {
          localObject2 = (DrawView2.FaceData)this.n.get(i2);
          if ((localObject2 != null) && (localObject1 != null) && (((ObjectBaseData)localObject1).U.equals(((DrawView2.FaceData)localObject2).d)) && (((ObjectBaseData)localObject1).h == ((DrawView2.FaceData)localObject2).r))
          {
            i2 = 1;
            break label1521;
          }
          i2 += 1;
        }
        i2 = 0;
        label1521:
        if (i2 == 0)
        {
          a((ObjectBaseData)localObject1);
          this.k.remove(i1);
          QLog.d("ckwkenvencai", 1, "remove2");
        }
        i1 += 1;
      }
      this.i = false;
      if ((!this.o) && (this.k.size() > 0))
      {
        this.o = true;
        this.s.post(this.t);
      }
      if (this.k.size() == 0) {
        this.o = false;
      }
    }
    else
    {
      b();
      QLog.e("ObjectSurfaceView", 1, "lost the face data.");
      this.a.a.b();
      this.a.a.a();
    }
  }
  
  public void b()
  {
    this.i = true;
    this.o = false;
    a(this.k);
    this.k.clear();
    this.a.a.b();
    this.a.a.a();
    QLog.d("ObjectSurfaceView", 1, "clear the animation and face data.");
  }
  
  public void setFaceData(List<DrawView2.FaceData> paramList)
  {
    try
    {
      this.n = paramList;
      a();
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ObjectSurfaceView", 1, "setFaceData catch an exception.", paramList);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceChanged");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceCreated");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView
 * JD-Core Version:    0.7.0.1
 */