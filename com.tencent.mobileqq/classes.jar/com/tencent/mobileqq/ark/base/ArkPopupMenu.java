package com.tencent.mobileqq.ark.base;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

public class ArkPopupMenu
{
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, new ArkPopupMenu.1());
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(false);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.setSoftInputMode(1);
    localBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow.setTouchModal(false);
    localBubblePopupWindow.setAnchorOffset(paramInt3);
    localBubblePopupWindow.setAnimationStyle(0);
    localBubblePopupWindow.showAtLocation(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkPopupMenu
 * JD-Core Version:    0.7.0.1
 */