package com.tencent.biz.qqcircle.richframework.widget.menu;

import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.mobileqq.app.FontSettingManager;

public class QQCustomMenuItemPriorityHelper
{
  public static final int a;
  private static int b = 2147483647;
  
  static
  {
    int i;
    if ((DisplayUtil.a() > 1.5F) && (FontSettingManager.getFontLevel() <= 16.0F)) {
      i = 5;
    } else {
      i = 4;
    }
    a = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuItemPriorityHelper
 * JD-Core Version:    0.7.0.1
 */