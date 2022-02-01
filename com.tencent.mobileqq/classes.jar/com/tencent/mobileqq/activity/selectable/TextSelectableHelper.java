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
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof SelectableComponent)) {
        return (SelectableComponent)paramView.getParent();
      }
    } while (!(paramView instanceof SelectableComponent));
    return (SelectableComponent)paramView;
  }
  
  void a(View paramView, CommonMenuWrapper paramCommonMenuWrapper)
  {
    SelectableComponent localSelectableComponent = a(paramView);
    if (localSelectableComponent == null) {}
    SelectableDelegate localSelectableDelegate;
    do
    {
      return;
      localSelectableDelegate = localSelectableComponent.delegate();
    } while ((localSelectableDelegate == null) || (!localSelectableDelegate.b()) || (localSelectableComponent.hasSelected()));
    if (this.a == 2)
    {
      localSelectableDelegate.c(d);
      localSelectableDelegate.b(e);
    }
    for (;;)
    {
      localSelectableDelegate.a(paramCommonMenuWrapper);
      localSelectableComponent.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localSelectableDelegate.c(b);
        localSelectableDelegate.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131167008).getDefaultColor();
        int j = paramView.getColorStateList(2131167010).getDefaultColor();
        localSelectableDelegate.c(i);
        localSelectableDelegate.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextSelectableHelper
 * JD-Core Version:    0.7.0.1
 */