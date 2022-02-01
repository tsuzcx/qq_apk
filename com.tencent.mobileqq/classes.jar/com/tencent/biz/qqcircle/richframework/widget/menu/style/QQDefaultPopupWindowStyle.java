package com.tencent.biz.qqcircle.richframework.widget.menu.style;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.utils.RFThemeUtil;

public class QQDefaultPopupWindowStyle
  implements BubblePopupWindowStyle
{
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public Drawable a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i;
    if (RFThemeUtil.a()) {
      i = 2130851593;
    } else {
      i = 2130851594;
    }
    return paramContext.getDrawable(i);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public Drawable b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i;
    if (RFThemeUtil.a()) {
      i = 2130851589;
    } else {
      i = 2130851590;
    }
    return paramContext.getDrawable(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.style.QQDefaultPopupWindowStyle
 * JD-Core Version:    0.7.0.1
 */