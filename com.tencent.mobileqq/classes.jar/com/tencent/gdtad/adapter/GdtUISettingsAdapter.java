package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.views.AdUISettingsAdapter;
import com.tencent.mobileqq.utils.QQTheme;

public class GdtUISettingsAdapter
  implements AdUISettingsAdapter
{
  public boolean isNightMode()
  {
    return QQTheme.isNowThemeIsNight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtUISettingsAdapter
 * JD-Core Version:    0.7.0.1
 */