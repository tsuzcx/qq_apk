package com.tencent.biz.qqcircle.immersive.utils;

import android.view.View;

public class QFSViewUtils
{
  public static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSViewUtils
 * JD-Core Version:    0.7.0.1
 */