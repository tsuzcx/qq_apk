package com.tencent.mm.ui.widget.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.g;
import java.util.Iterator;
import java.util.List;

public class SubMenuLogic
{
  private static DisplayMetrics a;
  
  public static SubMenuLogic.SubmnuLocation calculateIndicatorLocation(Context paramContext, View paramView, int paramInt)
  {
    paramView = new SubMenuLogic.SubmnuLocation();
    paramContext = getDisplayMetrics(paramContext);
    paramView.marginLeft = (paramInt - 10);
    paramView.marginRight = (paramContext.widthPixels - (paramInt + 10));
    return paramView;
  }
  
  public static SubMenuLogic.SubmnuLocation calculateLocation(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    SubMenuLogic.SubmnuLocation localSubmnuLocation = new SubMenuLogic.SubmnuLocation();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    } else {
      localDisplayMetrics = getDisplayMetrics(paramContext);
    }
    int i = g.a(paramContext, 95);
    if (paramInt1 < i) {
      paramInt1 = i;
    }
    int j = 0;
    int k = 1;
    if (paramInt2 < 0) {
      localSubmnuLocation.marginLeft = 0;
    }
    int m;
    for (localSubmnuLocation.marginRight = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + paramInt1));; localSubmnuLocation.marginRight = (localDisplayMetrics.widthPixels - m))
    {
      paramInt1 = 1;
      paramInt2 = 0;
      break;
      i = localDisplayMetrics.widthPixels;
      m = paramInt2 + paramInt1;
      if (i - (paramInt5 * 2 + m) < 0)
      {
        localSubmnuLocation.marginLeft = (paramInt2 - paramInt1 - paramInt5);
        localSubmnuLocation.marginRight = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
        paramInt1 = 0;
        paramInt2 = 1;
        break;
      }
      localSubmnuLocation.marginLeft = paramInt2;
    }
    if (paramInt3 >= 0)
    {
      i = paramInt3;
      if (paramInt3 <= localDisplayMetrics.heightPixels) {}
    }
    else
    {
      i = (int)(localDisplayMetrics.heightPixels / 2.0F);
    }
    if (paramBoolean)
    {
      if (i < paramInt4 + paramInt5)
      {
        localSubmnuLocation.marginTop = (i - paramInt5);
        paramInt3 = k;
        paramInt4 = j;
        break label325;
      }
      localSubmnuLocation.marginTop = (i - paramInt5 - paramInt4);
    }
    else
    {
      if (localDisplayMetrics.heightPixels - i >= paramInt5 * 3 + paramInt4) {
        break label308;
      }
      localSubmnuLocation.marginTop = (i - paramInt5 - paramInt4);
    }
    paramInt4 = 1;
    paramInt3 = 0;
    break label325;
    label308:
    localSubmnuLocation.marginTop = (i - paramInt5);
    paramInt4 = j;
    paramInt3 = k;
    label325:
    if (paramInt4 != 0) {
      localSubmnuLocation.marginTop -= paramInt5 * 2;
    } else if (paramInt3 != 0) {
      localSubmnuLocation.marginTop += paramInt5 * 2;
    }
    if ((paramInt1 != 0) && (paramInt3 != 0))
    {
      localSubmnuLocation.animationStyle = 2131952227;
      return localSubmnuLocation;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      localSubmnuLocation.animationStyle = 2131952229;
      return localSubmnuLocation;
    }
    if ((paramInt1 != 0) && (paramInt4 != 0))
    {
      localSubmnuLocation.animationStyle = 2131952226;
      return localSubmnuLocation;
    }
    if ((paramInt2 != 0) && (paramInt4 != 0))
    {
      localSubmnuLocation.animationStyle = 2131952228;
      return localSubmnuLocation;
    }
    localSubmnuLocation.animationStyle = 2131952227;
    return localSubmnuLocation;
  }
  
  public static SubMenuLogic.SubmnuLocation calculateLocation(Context paramContext, TextPaint paramTextPaint, List<String> paramList, f paramf, int paramInt)
  {
    paramf = new SubMenuLogic.SubmnuLocation();
    DisplayMetrics localDisplayMetrics = getDisplayMetrics(paramContext);
    int i = getMaxWidth(paramContext, paramTextPaint, paramList);
    int j = g.a(paramContext, 95);
    if (i < j) {
      i = j;
    }
    int m = i / 2;
    j = paramInt - m;
    if (j < 0)
    {
      paramf.marginLeft = 0;
      paramf.marginRight = (localDisplayMetrics.widthPixels - (i + 0));
      return paramf;
    }
    int k = localDisplayMetrics.widthPixels;
    paramInt += m;
    if (k - paramInt < 0)
    {
      paramf.marginLeft = (localDisplayMetrics.widthPixels - (i + 0));
      paramf.marginRight = 0;
      return paramf;
    }
    paramf.marginLeft = j;
    paramf.marginRight = (localDisplayMetrics.widthPixels - paramInt);
    return paramf;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getResources().getDisplayMetrics();
    }
    return a;
  }
  
  public static int getMaxWidth(Context paramContext, TextPaint paramTextPaint, List<String> paramList)
  {
    paramList = paramList.iterator();
    float f1 = 0.0F;
    while (paramList.hasNext())
    {
      float f2 = paramTextPaint.measureText((String)paramList.next());
      if (f1 < f2) {
        f1 = f2;
      }
    }
    return (int)f1 + g.a(paramContext, 30) * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.SubMenuLogic
 * JD-Core Version:    0.7.0.1
 */