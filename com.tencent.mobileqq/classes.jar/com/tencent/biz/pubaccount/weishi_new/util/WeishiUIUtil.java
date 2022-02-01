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
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class WeishiUIUtil
{
  public static final int a;
  private static final Pattern a;
  public static final int b = ScreenUtil.dip2px(1.0F);
  public static final int c = ScreenUtil.dip2px(2.0F);
  public static final int d = ScreenUtil.dip2px(4.0F);
  public static final int e = ScreenUtil.dip2px(5.0F);
  public static final int f = ScreenUtil.dip2px(7.0F);
  public static final int g = ScreenUtil.dip2px(10.0F);
  public static final int h = ScreenUtil.dip2px(12.0F);
  public static final int i = ScreenUtil.dip2px(14.0F);
  public static final int j = ScreenUtil.dip2px(18.0F);
  public static final int k = ScreenUtil.dip2px(20.0F);
  public static final int l = ScreenUtil.dip2px(24.0F);
  public static final int m = ScreenUtil.dip2px(28.0F);
  public static final int n = ScreenUtil.dip2px(55.0F);
  public static final int o = ScreenUtil.dip2px(58.0F);
  public static final int p = ScreenUtil.dip2px(60.0F);
  public static final int q = ScreenUtil.dip2px(80.0F);
  public static final int r = ScreenUtil.dip2px(84.0F);
  public static final int s = WSFeedUtils.a(5.0F);
  private static final int t;
  private static final int u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
    t = ScreenUtil.getRealWidth(BaseApplicationImpl.getApplication());
    u = ScreenUtil.getRealHeight(BaseApplicationImpl.getApplication());
    jdField_a_of_type_Int = ScreenUtil.dip2px(0.5F);
  }
  
  public static int a()
  {
    if (x == 0) {
      x = ScreenUtil.dip2px(16.0F);
    }
    return x;
  }
  
  public static int a(Activity paramActivity)
  {
    if ((v == 0) && (paramActivity != null)) {
      v = LiuHaiUtils.b(paramActivity);
    }
    return v;
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
      i1 = i2 - WSItemDecoration.jdField_a_of_type_Int * 2;
    } else {
      i1 = (i2 - WSItemDecoration.jdField_a_of_type_Int * 3) / 2;
    }
    return new Pair(Integer.valueOf(i1), Integer.valueOf((int)(i1 * f2)));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
  }
  
  public static int b()
  {
    if (y == 0) {
      y = ScreenUtil.dip2px(41.0F);
    }
    return y;
  }
  
  public static int b(Activity paramActivity)
  {
    if (w == 0) {
      w = a(paramActivity) + ScreenUtil.dip2px(4.5F);
    }
    return w;
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
    return t;
  }
  
  public static int c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return u;
    }
    int i1 = ScreenUtil.getNavigationBarHeight(paramActivity);
    if (ScreenUtil.checkDeviceHasNavigationBar(paramActivity)) {
      return u - i1;
    }
    return u;
  }
  
  public static int d()
  {
    return u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil
 * JD-Core Version:    0.7.0.1
 */