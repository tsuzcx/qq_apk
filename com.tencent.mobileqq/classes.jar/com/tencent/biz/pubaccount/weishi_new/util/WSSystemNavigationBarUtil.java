package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/util/WSSystemNavigationBarUtil;", "", "()V", "changeNavigationBarColor", "", "activity", "Landroid/app/Activity;", "offset", "", "setNavigationBarColor", "color", "", "setNavigationBarStyle", "barStyle", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSSystemNavigationBarUtil
{
  public static final WSSystemNavigationBarUtil a = new WSSystemNavigationBarUtil();
  
  @JvmStatic
  public static final void a(@Nullable Activity paramActivity, float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    int j = (int)(paramFloat * 'ÿ');
    int i = j;
    if (j == 0) {
      i = 1;
    }
    b(paramActivity, Color.rgb(i, i, i));
  }
  
  @JvmStatic
  public static final void a(@Nullable Activity paramActivity, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b(paramActivity, -16777216);
      return;
    }
    b(paramActivity, -1);
  }
  
  @JvmStatic
  public static final void b(@Nullable Activity paramActivity, @ColorInt int paramInt)
  {
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null)
      {
        int i = paramInt;
        if (paramInt == -16777216) {
          i = Color.rgb(1, 1, 1);
        }
        ThemeNavigationBarUtil.a(paramActivity, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSSystemNavigationBarUtil
 * JD-Core Version:    0.7.0.1
 */