package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.content.Context;
import android.view.View.OnClickListener;

public class BubbleContextMenu
{
  public static boolean a = false;
  
  public static QQCustomMenuLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenuList paramQQCustomMenuList, View.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomMenuLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow);
    paramContext.setMenuList(paramQQCustomMenuList);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.BubbleContextMenu
 * JD-Core Version:    0.7.0.1
 */