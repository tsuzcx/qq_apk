package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeishiUIUtil
{
  public static final int a;
  private static final Pattern a;
  public static final int b = ScreenUtil.dip2px(1.0F);
  public static final int c = ScreenUtil.dip2px(2.0F);
  public static final int d = ScreenUtil.dip2px(4.0F);
  public static final int e = ScreenUtil.dip2px(7.0F);
  public static final int f = ScreenUtil.dip2px(10.0F);
  public static final int g = ScreenUtil.dip2px(14.0F);
  public static final int h = ScreenUtil.dip2px(16.0F);
  public static final int i = ScreenUtil.dip2px(20.0F);
  public static final int j = ScreenUtil.dip2px(24.0F);
  public static final int k = ScreenUtil.dip2px(28.0F);
  public static final int l = ScreenUtil.dip2px(58.0F);
  public static final int m = ScreenUtil.dip2px(60.0F);
  public static final int n = ScreenUtil.dip2px(80.0F);
  public static final int o = ScreenUtil.dip2px(84.0F);
  private static final int p;
  private static final int q;
  private static int r;
  private static int s;
  private static int t;
  private static int u;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
    p = ScreenUtil.getRealWidth(BaseApplicationImpl.getApplication());
    q = ScreenUtil.getRealHeight(BaseApplicationImpl.getApplication());
    jdField_a_of_type_Int = ScreenUtil.dip2px(0.5F);
  }
  
  public static int a()
  {
    if (t == 0) {
      t = ScreenUtil.dip2px(16.0F);
    }
    return t;
  }
  
  public static int a(Activity paramActivity)
  {
    if ((r == 0) && (paramActivity != null)) {
      r = LiuHaiUtils.b(paramActivity);
    }
    return r;
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
    if (u == 0) {
      u = ScreenUtil.dip2px(41.0F);
    }
    return u;
  }
  
  public static int b(Activity paramActivity)
  {
    if (s == 0) {
      s = a(paramActivity) + ScreenUtil.dip2px(4.5F);
    }
    return s;
  }
  
  public static int c()
  {
    return p;
  }
  
  public static int c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return q;
    }
    int i1 = ScreenUtil.getNavigationBarHeight(paramActivity);
    if (ScreenUtil.checkDeviceHasNavigationBar(paramActivity)) {
      return q - i1;
    }
    return q;
  }
  
  public static int d()
  {
    return q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil
 * JD-Core Version:    0.7.0.1
 */