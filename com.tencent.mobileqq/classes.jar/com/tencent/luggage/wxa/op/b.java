package com.tencent.luggage.wxa.op;

import android.content.res.Configuration;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.f;
import com.tencent.luggage.wxa.lp.g;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.pd.r;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.e.a;

class b
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private final String a;
  @NonNull
  private final u b;
  @NonNull
  private final e c;
  @NonNull
  private final View d;
  @NonNull
  private final h e;
  @NonNull
  private final j f;
  @Nullable
  private final r g;
  private volatile boolean h;
  private volatile boolean i;
  private int j;
  private int k;
  @Nullable
  private b.a l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  b(@NonNull u paramu, @NonNull e parame, @NonNull View paramView, @NonNull h paramh, @NonNull j paramj, @Nullable r paramr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
    this.h = false;
    this.i = false;
    this.l = null;
    this.E = e.j;
    this.F = e.i;
    this.G = e.k;
    this.H = e.l;
    this.I = e.m;
    this.J = e.n;
    this.b = paramu;
    this.c = parame;
    this.d = paramView;
    this.e = paramh;
    this.f = paramj;
    this.g = paramr;
  }
  
  @NonNull
  private e.a a(int paramInt1, int paramInt2, @Nullable Point paramPoint)
  {
    if (this.l == null) {
      this.l = new b.a(this, null);
    }
    b.a.a(this.l, paramInt1);
    b.a.b(this.l, paramInt2);
    b.a.a(this.l, paramPoint);
    return this.l;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    paramFloat /= 100.0F;
    paramInt7 = (int)(paramInt7 * paramFloat);
    paramInt8 = (int)(paramInt8 * paramFloat);
    paramInt9 = (int)(paramInt9 * paramFloat);
    int i1 = paramInt7 * 2 + paramInt5;
    int i2 = paramInt6 + paramInt8 + paramInt9;
    paramInt1 = (paramInt1 - i1) / 2;
    paramInt2 = (paramInt2 - i2) / 2;
    paramInt10 = (int)(paramInt10 * paramFloat);
    paramInt11 = (int)(paramInt11 * paramFloat);
    paramInt12 = (int)(paramFloat * paramInt12);
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    localLayoutParams.width = i1;
    localLayoutParams.height = i2;
    this.c.setLayoutParams(localLayoutParams);
    this.c.setX(paramInt3 + paramInt1);
    this.c.setY(paramInt4 + paramInt2);
    localLayoutParams = this.d.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.d.setLayoutParams(localLayoutParams);
    this.c.a(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = 1;
    int i1;
    if ((-1 != paramInt1) && (-1 != paramInt2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (paramInt1 >= paramInt2)
      {
        paramInt1 = i2;
        break label52;
      }
    }
    else if (paramInt3 >= paramInt4)
    {
      paramInt1 = i2;
      break label52;
    }
    paramInt1 = 0;
    label52:
    if (paramInt1 != 0)
    {
      this.y = e.a;
      this.z = e.b;
    }
    else
    {
      this.y = e.e;
      this.z = e.f;
    }
    Object localObject = this.d;
    if ((localObject instanceof g))
    {
      g localg = (g)localObject;
      if (paramInt1 != 0) {
        localObject = f.a;
      } else {
        localObject = f.b;
      }
      localg.a((f)localObject);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i1 = paramInt1;
    if ((-1 != i1) && (-1 != paramInt2)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i2;
    if (paramInt1 != 0 ? i1 >= paramInt2 : paramInt3 >= paramInt4) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if (i2 != 0)
    {
      this.y = e.a;
      this.z = e.b;
      i2 = e.c;
      i3 = e.d;
    }
    else
    {
      this.y = e.e;
      this.z = e.f;
      i2 = e.g;
      i3 = e.h;
    }
    int i4 = this.c.getStablePosX();
    int i5 = this.c.getStablePosY();
    o.d(this.a, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) });
    this.A = Math.min(Math.max(0, i4), this.j - this.y);
    this.B = Math.min(Math.max(0, i5), this.k - this.z);
    o.d(this.a, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(this.A), Integer.valueOf(this.B) });
    i4 = paramInt2;
    if (paramInt1 == 0)
    {
      paramInt2 = paramInt3;
      i4 = paramInt4;
      i1 = paramInt2;
    }
    float f2 = i2;
    float f1 = i1;
    f2 = (f2 + 0.0F) / f1;
    float f4 = i3;
    float f3 = i4;
    f4 = (f4 + 0.0F) / f3;
    if (f2 >= f4)
    {
      this.C = i2;
      this.D = ((int)Math.ceil(f2 * f3));
    }
    else
    {
      this.C = ((int)Math.ceil(f4 * f1));
      this.D = i3;
    }
    this.q = paramInt3;
    this.r = paramInt4;
    o.e(this.a, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(this.q), Integer.valueOf(this.r) });
    this.n = ((int)((this.z + 0.0F) / this.D * this.r));
    this.m = ((int)((this.y + 0.0F) / this.C * this.q));
    o.e(this.a, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) });
    this.C = i2;
    this.D = i3;
    f1 = (this.m + 0.0F) / this.y;
    f2 = (this.n + 0.0F) / this.z;
    o.e(this.a, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    paramInt2 = Math.min(Math.max(paramInt5, -this.m), this.j);
    paramInt5 = Math.min(Math.max(paramInt6, -this.n), this.k);
    o.e(this.a, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    if (paramInt1 != 0)
    {
      this.o = (paramInt2 - (int)(f1 * (this.y - i2) / 2.0F));
      this.p = (paramInt5 - (int)((this.z - i3) * f2 / 2.0F));
    }
    else
    {
      paramInt1 = this.q;
      this.o = (paramInt2 + (paramInt3 - paramInt1) / 2 - (this.m - paramInt1) / 2);
      paramInt1 = this.r;
      this.p = (paramInt5 + (paramInt4 - paramInt1) / 2 - (this.n - paramInt1) / 2);
    }
    this.s = ((int)Math.ceil((this.m - this.q) * 0.5F));
    this.t = ((int)Math.ceil((this.n - this.r) * 0.4F));
    this.u = ((int)Math.ceil((this.n - this.r) * 0.6F));
    this.v = ((int)(this.H * f2));
    this.w = ((int)(this.I * f2));
    this.x = ((int)(f2 * this.J));
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i1 = this.f.c();
    int i2 = this.f.d();
    if ((i1 != 0) && (i2 != 0))
    {
      Object localObject = d();
      if (localObject == null)
      {
        o.c(this.a, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
        return false;
      }
      Point localPoint1 = new Point();
      localObject = new b.2(this, localPoint1, (Point)localObject, i1, i2);
      if (paramBoolean)
      {
        this.e.a(this.b, new b.3(this, localPoint1, (Runnable)localObject));
      }
      else
      {
        Point localPoint2 = this.e.c();
        localPoint1.x = localPoint2.x;
        localPoint1.y = localPoint2.y;
        ((Runnable)localObject).run();
      }
      return true;
    }
    o.c(this.a, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
    return false;
  }
  
  private void b(float paramFloat)
  {
    int i1 = this.m;
    paramFloat /= 100.0F;
    this.K = (i1 + (int)((this.y - i1) * paramFloat));
    i1 = this.n;
    this.L = (i1 + (int)((this.z - i1) * paramFloat));
    i1 = this.o;
    this.M = (i1 + (int)((this.A - i1) * paramFloat));
    i1 = this.p;
    this.N = (i1 + (int)((this.B - i1) * paramFloat));
    i1 = this.q;
    this.O = (i1 + (int)((this.C - i1) * paramFloat));
    i1 = this.r;
    this.P = (i1 + (int)((this.D - i1) * paramFloat));
    this.Q = ((int)Math.ceil((this.K - this.O) * 0.5F));
    this.R = ((int)Math.ceil((this.L - this.P) * 0.4F));
    this.S = ((int)Math.ceil((this.L - this.P) * 0.6F));
    i1 = this.v;
    this.T = (i1 + (int)((this.H - i1) * paramFloat));
    i1 = this.w;
    this.U = (i1 + (int)((this.I - i1) * paramFloat));
    i1 = this.x;
    this.V = (i1 + (int)(paramFloat * (this.J - i1)));
  }
  
  private Point d()
  {
    Object localObject = this.b.aj();
    if (localObject == null)
    {
      o.c(this.a, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      return null;
    }
    View localView = ((am)localObject).getContentView();
    if (localView == null)
    {
      o.c(this.a, "calculateWebView2PipContainerParentOffset, null == webView");
      return null;
    }
    localObject = this.c.getParent();
    if (!(localObject instanceof ViewGroup))
    {
      o.c(this.a, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localObject;
    this.j = localViewGroup.getWidth();
    this.k = localViewGroup.getHeight();
    o.e(this.a, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.k) });
    localObject = localView.getParent();
    int i2 = 0;
    int i1 = 0;
    while (localObject != null)
    {
      if (!(localObject instanceof ViewGroup))
      {
        o.c(this.a, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        return null;
      }
      i2 = (int)(i2 + localView.getX());
      i1 = (int)(i1 + localView.getY());
      if (localObject == localViewGroup)
      {
        o.e(this.a, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
        return new Point(i2, i1);
      }
      localView = (View)localObject;
      localObject = localView.getParent();
    }
    return null;
  }
  
  void a(float paramFloat)
  {
    if (!this.h)
    {
      o.c(this.a, "handleVideoTransferProgress, false == mHandleStarted");
      return;
    }
    b(paramFloat);
    a(paramFloat, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V);
  }
  
  void a(@NonNull Configuration paramConfiguration)
  {
    o.d(this.a, "onConfigurationChanged");
    if (!this.h)
    {
      o.e(this.a, "onConfigurationChanged, false == mHandleStarted");
      return;
    }
    this.e.a(this.b, new b.1(this));
  }
  
  boolean a()
  {
    return a(true);
  }
  
  void b()
  {
    o.d(this.a, "handleVideoPage2PipEnd");
    if (!this.h) {
      a(false);
    }
    a(100.0F, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J);
  }
  
  void c()
  {
    o.d(this.a, "release");
    b.a locala = this.l;
    if (locala != null) {
      this.c.b(locala);
    }
    this.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.b
 * JD-Core Version:    0.7.0.1
 */