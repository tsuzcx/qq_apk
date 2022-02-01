package com.tencent.mobileqq.app;

import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ThemeHandler$4
  extends ThemeSwitchCallback
{
  ThemeHandler$4(ThemeHandler paramThemeHandler) {}
  
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (!paramThemeLocator.d().equals(str)) {
      QQToast.makeText(ThemeHandler.b(this.this$0).getApplication(), HardCodeUtil.a(2131912225), 4000).show();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.4
 * JD-Core Version:    0.7.0.1
 */