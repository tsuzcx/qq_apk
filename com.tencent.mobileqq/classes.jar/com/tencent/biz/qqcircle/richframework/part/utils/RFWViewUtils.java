package com.tencent.biz.qqcircle.richframework.part.utils;

import android.view.View;

public class RFWViewUtils
{
  public static Object a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Object localObject = paramView.getTag(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if ((paramView.getParent() instanceof View)) {
      return a(paramInt, (View)paramView.getParent());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.utils.RFWViewUtils
 * JD-Core Version:    0.7.0.1
 */