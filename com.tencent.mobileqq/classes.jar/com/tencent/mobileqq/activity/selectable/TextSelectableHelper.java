package com.tencent.mobileqq.activity.selectable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class TextSelectableHelper
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private SelectableComponent a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() instanceof SelectableComponent)) {
      return (SelectableComponent)paramView.getParent();
    }
    if ((paramView instanceof SelectableComponent)) {
      return (SelectableComponent)paramView;
    }
    return null;
  }
  
  void a(View paramView, CommonMenuWrapper paramCommonMenuWrapper)
  {
    SelectableComponent localSelectableComponent = a(paramView);
    if (localSelectableComponent == null) {
      return;
    }
    SelectableDelegate localSelectableDelegate = localSelectableComponent.delegate();
    if ((localSelectableDelegate != null) && (localSelectableDelegate.b()) && (!localSelectableComponent.hasSelected()))
    {
      int i = this.a;
      if (i == 2)
      {
        localSelectableDelegate.c(d);
        localSelectableDelegate.b(e);
      }
      else if (i == 1)
      {
        localSelectableDelegate.c(b);
        localSelectableDelegate.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        i = paramView.getColorStateList(2131167031).getDefaultColor();
        int j = paramView.getColorStateList(2131167033).getDefaultColor();
        localSelectableDelegate.c(i);
        localSelectableDelegate.b(j);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("Load Select color, cursor=");
          paramView.append(i);
          paramView.append(", component=");
          paramView.append(j);
          QLog.d("ChatAdapterSelectableHelper", 0, paramView.toString());
        }
      }
      localSelectableDelegate.a(paramCommonMenuWrapper);
      localSelectableComponent.doSelecting(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextSelectableHelper
 * JD-Core Version:    0.7.0.1
 */