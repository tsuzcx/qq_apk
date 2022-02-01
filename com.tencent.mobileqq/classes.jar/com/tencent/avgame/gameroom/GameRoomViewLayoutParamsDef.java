package com.tencent.avgame.gameroom;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class GameRoomViewLayoutParamsDef
{
  public static int A;
  public static int B;
  public static int C = 60;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I = 0;
  public static int J;
  public static int K;
  public static float a;
  public static int a;
  public static float b;
  public static int b;
  public static float c;
  public static int c;
  public static float d;
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
  
  static
  {
    jdField_a_of_type_Float = 597.0F;
    jdField_b_of_type_Float = 249.0F;
    jdField_c_of_type_Float = 46.0F;
    jdField_d_of_type_Float = 750.0F;
  }
  
  public static void a(Context paramContext)
  {
    int i4 = ViewUtils.a();
    int i1 = ViewUtils.b();
    int i2 = ImmersiveUtils.getStatusBarHeight(paramContext);
    boolean bool;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      jdField_a_of_type_Int = i2 + ViewUtils.b(4.0F);
      H = (int)(i4 * 0.2D);
      int i3 = 0 + i4 + ViewUtils.b(22.0F) + ((i4 - ViewUtils.b(72.0F)) / 4 + ViewUtils.b(32.0F)) * 2;
      i2 = i3;
      if (GameEngine.a().f()) {
        i2 = i3 - ViewUtils.b(32.0F) / 2;
      }
      i2 = i1 - (i2 + ViewUtils.b(46.0F));
      l = 0;
      n = i4;
      o = i4;
      jdField_d_of_type_Int = i4;
      h = 0;
      if (i2 >= -ViewUtils.b(6.0F)) {
        break label1026;
      }
      l = 0;
      n = i2 + n;
      H = (int)(i4 * 0.2D);
      bool = false;
    }
    for (;;)
    {
      m = (int)(n * 0.2373333F);
      jdField_b_of_type_Int = jdField_a_of_type_Int + paramContext.getResources().getDimensionPixelSize(2131296639);
      jdField_c_of_type_Int = n;
      if (!bool) {
        jdField_c_of_type_Int -= jdField_b_of_type_Int;
      }
      jdField_c_of_type_Int += jdField_b_of_type_Int + ViewUtils.a(14.0F);
      g = ViewUtils.a(16.0F);
      i = ViewUtils.a(40.0F);
      e = (i4 - g * 2 - ViewUtils.a(14.0F) * 2) / 3;
      f = (int)(e * 1.428572F);
      j = ViewUtils.a(16.0F);
      k = jdField_c_of_type_Int - jdField_b_of_type_Int - ViewUtils.a(70.0F);
      p = l + n + ViewUtils.b(16.0F);
      i2 = ViewUtils.b(10.0F);
      s = i2;
      r = i2;
      t = ViewUtils.b(0.0F);
      u = (i4 - s - r - t * 3) / 4;
      v = u + ViewUtils.b(18.0F);
      q = v * 2 + ViewUtils.b(20.0F);
      y = l + n + ViewUtils.b(10.0F);
      B = ViewUtils.b(2.0F);
      D = DisplayUtil.a(paramContext) - y - ViewUtils.b(65.0F) - I;
      z = (i4 - B * 11) / 12;
      A = z;
      C = (D + B) / (A + B) * 12;
      E = o;
      J = ViewUtils.b(88.0F);
      K = ViewUtils.b(29.0F);
      G = l + n;
      F = i4;
      paramContext = new StringBuilder();
      paramContext.append(" viewScreenWidth:").append(i4);
      paramContext.append(" viewScreenHeight:").append(i1);
      paramContext.append(" titleViewMarginTop:").append(jdField_a_of_type_Int);
      paramContext.append("\n gameListViewChoseTextMarginTop:").append(jdField_b_of_type_Int);
      paramContext.append("\n gameListGridHeight:").append(f);
      paramContext.append("\n gameListGridWidth:").append(e);
      paramContext.append("\n gameListGridRowMargin:").append(j);
      paramContext.append("\n gameListRootPaddingLR:").append(g);
      paramContext.append("\n gameListRootPaddingTop:").append(h);
      paramContext.append("\n gameListRootPaddingBottom:").append(i);
      paramContext.append("\n stageViewMarginTop:").append(l);
      paramContext.append("\n stageViewHeight:").append(n);
      paramContext.append("\n stageViewWidth:").append(o);
      paramContext.append("\n seatViewMarginTop:").append(p);
      paramContext.append("\n seatViewHeight:").append(q);
      paramContext.append("\n seatViewPaddingLeft:").append(r);
      paramContext.append("\n seatViewPaddingRight:").append(s);
      paramContext.append("\n seatViewMemberItemGapH:").append(t);
      paramContext.append("\n seatViewPaddingRight:").append(s);
      paramContext.append("\n seatViewMemberItemWidth:").append(u);
      paramContext.append("\n seatViewMemberItemHeight:").append(v);
      paramContext.append("\n stageEnough:").append(bool);
      paramContext.append("\n viewRootMarginTopOfScreen:").append(I);
      paramContext.append("\n stageTopTipMarginTop:").append(H);
      paramContext.append("\n pkSeatViewMarginTop:").append(y);
      paramContext.append("\n seatBgItemWidth:").append(z);
      paramContext.append("\n seatBgItemHeight:").append(A);
      paramContext.append("\n seatBgItemGapH:").append(B);
      paramContext.append("\n seatBgItemMaxNum:").append(C);
      paramContext.append("\n seatBgViewHeight:").append(D);
      paramContext.append("\n seatBgViewWidth:").append(E);
      paramContext.append("\n gameMatchViewWidth:").append(J);
      paramContext.append("\n gameMatchViewHeight:").append(K);
      paramContext.append("\n pkCJTopHouseWidth:").append(F);
      paramContext.append("\n pkCJTopHouseHeight:").append(G);
      QLog.i("GameRoomViewLayoutParamsDef", 2, "calculateViewsLocSize : " + paramContext.toString());
      return;
      i1 -= i2;
      I = i2;
      jdField_a_of_type_Int = ViewUtils.b(8.0F);
      break;
      label1026:
      if (i2 >= jdField_a_of_type_Int + ViewUtils.b(48.0F))
      {
        bool = true;
        l = jdField_a_of_type_Int + ViewUtils.b(48.0F);
        H = l + ViewUtils.b(20.0F);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static void a(View paramView)
  {
    D = paramView.getHeight();
    C = (D + B) / (A + B) * 12;
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    paramView.getLocationInWindow(paramArrayOfInt);
    if (I > 0) {
      paramArrayOfInt[1] -= I;
    }
  }
  
  public static void b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    I = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef
 * JD-Core Version:    0.7.0.1
 */