package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.widget.ThemeLabelTextView;

public class ThemeLabelTextViewApiImpl
  implements IThemeLabelTextViewApi
{
  public void setSupportMaskView(View paramView, boolean paramBoolean)
  {
    ((ThemeLabelTextView)paramView).setSupportMaskView(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.ThemeLabelTextViewApiImpl
 * JD-Core Version:    0.7.0.1
 */