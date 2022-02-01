package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.ColorInt;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class WeishiUIUtil
{
  private static int A;
  private static int B;
  public static final int a = ScreenUtil.dip2px(0.5F);
  public static final int b = ScreenUtil.dip2px(1.0F);
  public static final int c = ScreenUtil.dip2px(2.0F);
  public static final int d = ScreenUtil.dip2px(4.0F);
  public static final int e = ScreenUtil.dip2px(5.0F);
  public static final int f = ScreenUtil.dip2px(6.0F);
  public static final int g = ScreenUtil.dip2px(7.0F);
  public static final int h = ScreenUtil.dip2px(10.0F);
  public static final int i = ScreenUtil.dip2px(12.0F);
  public static final int j = ScreenUtil.dip2px(14.0F);
  public static final int k = ScreenUtil.dip2px(15.0F);
  public static final int l = ScreenUtil.dip2px(18.0F);
  public static final int m = ScreenUtil.dip2px(20.0F);
  public static final int n = ScreenUtil.dip2px(24.0F);
  public static final int o = ScreenUtil.dip2px(28.0F);
  public static final int p = ScreenUtil.dip2px(55.0F);
  public static final int q = ScreenUtil.dip2px(58.0F);
  public static final int r = ScreenUtil.dip2px(60.0F);
  public static final int s = ScreenUtil.dip2px(80.0F);
  public static final int t = ScreenUtil.dip2px(84.0F);
  public static final int u = WSFeedUtils.a(5.0F);
  private static final Pattern v = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
  private static final int w = ScreenUtil.getRealWidth(BaseApplicationImpl.getApplication());
  private static final int x = ScreenUtil.getRealHeight(BaseApplicationImpl.getApplication());
  private static int y;
  private static int z;
  
  public static int a()
  {
    if (A == 0) {
      A = ScreenUtil.dip2px(16.0F);
    }
    return A;
  }
  
  public static int a(Activity paramActivity)
  {
    if ((y == 0) && (paramActivity != null)) {
      y = LiuHaiUtils.e(paramActivity);
    }
    return y;
  }
  
  public static int a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
      {
        paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView;
        int[] arrayOfInt = new int[paramRecyclerView.getSpanCount()];
        paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
        return b(arrayOfInt);
      }
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramRecyclerView).findFirstVisibleItemPosition();
      }
    }
    return -1;
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramArrayOfInt[0];
    int i5 = paramArrayOfInt.length;
    while (i1 < i5)
    {
      int i4 = paramArrayOfInt[i1];
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  @NotNull
  public static GradientDrawable a(float paramFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(-16777216);
    localGradientDrawable.setCornerRadii(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, 0.0F, 0.0F, 0.0F, 0.0F });
    return localGradientDrawable;
  }
  
  @NotNull
  public static GradientDrawable a(@ColorInt int paramInt, float paramFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setCornerRadii(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat });
    return localGradientDrawable;
  }
  
  public static Pair<Integer, Integer> a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.waterFallCardStyle;
    int i1;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.isFullSpan)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    float f1;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.ratioW != 0)) {
      f1 = paramstSimpleMetaFeed.ratioH * 1.0F / paramstSimpleMetaFeed.ratioW;
    } else {
      f1 = 1.333333F;
    }
    float f2 = f1;
    if (f1 > 2.0F) {
      f2 = 1.333333F;
    }
    if (i1 != 0) {
      f2 = 0.5625F;
    }
    int i2 = c();
    if (i1 != 0) {
      i1 = i2 - WSItemDecoration.a * 2;
    } else {
      i1 = (i2 - WSItemDecoration.a * 3) / 2;
    }
    return new Pair(Integer.valueOf(i1), Integer.valueOf((int)(i1 * f2)));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return v.matcher(paramString).matches();
  }
  
  public static int b()
  {
    if (B == 0) {
      B = ScreenUtil.dip2px(41.0F);
    }
    return B;
  }
  
  public static int b(Activity paramActivity)
  {
    if (z == 0) {
      z = a(paramActivity) + ScreenUtil.dip2px(4.5F);
    }
    return z;
  }
  
  public static int b(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
      {
        paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView;
        int[] arrayOfInt = new int[paramRecyclerView.getSpanCount()];
        paramRecyclerView.findLastVisibleItemPositions(arrayOfInt);
        return a(arrayOfInt);
      }
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    return -1;
  }
  
  private static int b(int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramArrayOfInt[0];
    int i5 = paramArrayOfInt.length;
    while (i1 < i5)
    {
      int i4 = paramArrayOfInt[i1];
      int i3 = i2;
      if (i4 < i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  public static int c()
  {
    return w;
  }
  
  public static int c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return x;
    }
    int i1 = ScreenUtil.getNavigationBarHeight(paramActivity);
    if (ScreenUtil.checkDeviceHasNavigationBar(paramActivity)) {
      return x - i1;
    }
    return x;
  }
  
  public static int d()
  {
    return x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil
 * JD-Core Version:    0.7.0.1
 */