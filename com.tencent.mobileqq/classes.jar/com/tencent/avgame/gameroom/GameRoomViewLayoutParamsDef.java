package com.tencent.avgame.gameroom;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.avgame.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class GameRoomViewLayoutParamsDef
{
  public static int A = 0;
  public static int B = 0;
  public static int C = 0;
  public static int D = 0;
  public static int E = 0;
  public static int F = 0;
  public static int G = 0;
  public static int H = 0;
  public static int I = 0;
  public static int J = 0;
  public static int K = 0;
  public static int L = 0;
  public static int M = 0;
  public static int N = 60;
  public static int O = 0;
  public static int P = 0;
  public static int Q = 0;
  public static int R = 0;
  public static float S = 597.0F;
  public static float T = 249.0F;
  public static float U = 46.0F;
  public static float V = 750.0F;
  public static int W;
  public static int X;
  public static int Y;
  public static int Z;
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    int i4 = ViewUtils.getScreenWidth();
    int i1 = ViewUtils.getScreenHeight();
    int i2 = ImmersiveUtils.getStatusBarHeight(paramContext);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      a = i2 + ViewUtils.dpToPx(4.0F);
    }
    else
    {
      i1 -= i2;
      X = i2;
      a = ViewUtils.dpToPx(8.0F);
    }
    double d1 = i4;
    Double.isNaN(d1);
    int i5 = (int)(d1 * 0.2D);
    W = i5;
    int i3 = i4 + 0 + ViewUtils.dpToPx(22.0F) + ((i4 - ViewUtils.dpToPx(72.0F)) / 4 + ViewUtils.dpToPx(32.0F)) * 2;
    i2 = i3;
    if (paramBoolean) {
      i2 = i3 - ViewUtils.dpToPx(32.0F) / 2;
    }
    i2 = i1 - (i2 + ViewUtils.dpToPx(46.0F));
    paramBoolean = false;
    w = 0;
    y = i4;
    z = i4;
    d = i4;
    s = 0;
    if (i2 < -ViewUtils.dpToPx(6.0F))
    {
      w = 0;
      y += i2;
      W = i5;
    }
    else if (i2 >= a + ViewUtils.dpToPx(48.0F))
    {
      w = a + ViewUtils.dpToPx(48.0F);
      W = w + ViewUtils.dpToPx(20.0F);
      paramBoolean = true;
    }
    x = (int)(y * 0.2373333F);
    b = a + paramContext.getResources().getDimensionPixelSize(2131296920);
    c = y;
    if (!paramBoolean) {
      c -= b;
    }
    c += b + ViewUtils.dip2px(14.0F);
    r = ViewUtils.dip2px(16.0F);
    t = ViewUtils.dip2px(40.0F);
    p = (i4 - r * 2 - ViewUtils.dip2px(14.0F) * 2) / 3;
    q = (int)(p * 1.428572F);
    u = ViewUtils.dip2px(16.0F);
    v = c - b - ViewUtils.dip2px(70.0F);
    A = w + y + ViewUtils.dpToPx(16.0F);
    i2 = ViewUtils.dpToPx(10.0F);
    D = i2;
    C = i2;
    E = ViewUtils.dpToPx(0.0F);
    F = (i4 - D - C - E * 3) / 4;
    G = F + ViewUtils.dpToPx(18.0F);
    B = G * 2 + ViewUtils.dpToPx(20.0F);
    J = w + y + ViewUtils.dpToPx(10.0F);
    M = ViewUtils.dpToPx(2.0F);
    O = DisplayUtil.a(paramContext) - J - ViewUtils.dpToPx(65.0F) - X;
    i2 = M;
    K = (i4 - i2 * 11) / 12;
    L = K;
    N = (O + i2) / (L + i2) * 12;
    P = z;
    Y = ViewUtils.dpToPx(88.0F);
    Z = ViewUtils.dpToPx(29.0F);
    R = w + y;
    Q = i4;
    float f1 = i4;
    float f2 = 0.1066667F * f1;
    if (f2 < ViewUtils.dip2px(40.0F))
    {
      i2 = (int)f2;
      e = i2;
      i = i2;
      m = i2;
      f = (int)(0.04266667F * f1);
      g = (int)(0.05333334F * f1);
      h = (int)(0.36F * f1);
      j = (int)(0.016F * f1);
      k = (int)(0.2746667F * f1);
      l = (int)(0.01F * f1);
      n = (int)(0.002666667F * f1);
      o = (int)(f1 * 0.03733333F);
    }
    else
    {
      i2 = ViewUtils.dip2px(40.0F);
      e = i2;
      i = i2;
      m = i2;
      f = ViewUtils.dip2px(16.0F);
      g = ViewUtils.dip2px(20.0F);
      h = ViewUtils.dip2px(135.0F);
      j = ViewUtils.dip2px(6.0F);
      k = ViewUtils.dip2px(103.0F);
      l = 10;
      n = ViewUtils.dip2px(1.0F);
      o = ViewUtils.dip2px(14.0F);
    }
    paramContext = new StringBuilder();
    paramContext.append(" viewScreenWidth:");
    paramContext.append(i4);
    paramContext.append(" viewScreenHeight:");
    paramContext.append(i1);
    paramContext.append(" titleViewMarginTop:");
    paramContext.append(a);
    paramContext.append("\n gameListViewChoseTextMarginTop:");
    paramContext.append(b);
    paramContext.append("\n gameListGridHeight:");
    paramContext.append(q);
    paramContext.append("\n gameListGridWidth:");
    paramContext.append(p);
    paramContext.append("\n gameListGridRowMargin:");
    paramContext.append(u);
    paramContext.append("\n gameListRootPaddingLR:");
    paramContext.append(r);
    paramContext.append("\n gameListRootPaddingTop:");
    paramContext.append(s);
    paramContext.append("\n gameListRootPaddingBottom:");
    paramContext.append(t);
    paramContext.append("\n stageViewMarginTop:");
    paramContext.append(w);
    paramContext.append("\n stageViewHeight:");
    paramContext.append(y);
    paramContext.append("\n stageViewWidth:");
    paramContext.append(z);
    paramContext.append("\n seatViewMarginTop:");
    paramContext.append(A);
    paramContext.append("\n seatViewHeight:");
    paramContext.append(B);
    paramContext.append("\n seatViewPaddingLeft:");
    paramContext.append(C);
    paramContext.append("\n seatViewPaddingRight:");
    paramContext.append(D);
    paramContext.append("\n seatViewMemberItemGapH:");
    paramContext.append(E);
    paramContext.append("\n seatViewPaddingRight:");
    paramContext.append(D);
    paramContext.append("\n seatViewMemberItemWidth:");
    paramContext.append(F);
    paramContext.append("\n seatViewMemberItemHeight:");
    paramContext.append(G);
    paramContext.append("\n stageEnough:");
    paramContext.append(paramBoolean);
    paramContext.append("\n viewRootMarginTopOfScreen:");
    paramContext.append(X);
    paramContext.append("\n stageTopTipMarginTop:");
    paramContext.append(W);
    paramContext.append("\n pkSeatViewMarginTop:");
    paramContext.append(J);
    paramContext.append("\n seatBgItemWidth:");
    paramContext.append(K);
    paramContext.append("\n seatBgItemHeight:");
    paramContext.append(L);
    paramContext.append("\n seatBgItemGapH:");
    paramContext.append(M);
    paramContext.append("\n seatBgItemMaxNum:");
    paramContext.append(N);
    paramContext.append("\n seatBgViewHeight:");
    paramContext.append(O);
    paramContext.append("\n seatBgViewWidth:");
    paramContext.append(P);
    paramContext.append("\n gameMatchViewWidth:");
    paramContext.append(Y);
    paramContext.append("\n gameMatchViewHeight:");
    paramContext.append(Z);
    paramContext.append("\n pkCJTopHouseWidth:");
    paramContext.append(Q);
    paramContext.append("\n pkCJTopHouseHeight:");
    paramContext.append(R);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("calculateViewsLocSize : ");
    localStringBuilder.append(paramContext.toString());
    QLog.i("GameRoomViewLayoutParamsDef", 2, localStringBuilder.toString());
  }
  
  public static void a(View paramView)
  {
    O = paramView.getHeight();
    int i1 = O;
    int i2 = M;
    N = (i1 + i2) / (L + i2) * 12;
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    paramView.getLocationInWindow(paramArrayOfInt);
    int i1 = X;
    if (i1 > 0) {
      paramArrayOfInt[1] -= i1;
    }
  }
  
  public static void b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    X = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef
 * JD-Core Version:    0.7.0.1
 */