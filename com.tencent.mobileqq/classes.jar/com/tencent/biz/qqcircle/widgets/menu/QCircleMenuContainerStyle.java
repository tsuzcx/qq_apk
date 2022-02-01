package com.tencent.biz.qqcircle.widgets.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.MenuContainerStyle;
import com.tencent.biz.qqcircle.utils.ViewUtils;

public class QCircleMenuContainerStyle
  implements MenuContainerStyle
{
  public int a()
  {
    return ViewUtils.a(4.0F);
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getResources().getColor(2131167096);
  }
  
  public int b()
  {
    return ViewUtils.a(90.0F);
  }
  
  public int b(Context paramContext)
  {
    return paramContext.getResources().getColor(2131167096);
  }
  
  public int c()
  {
    return ViewUtils.a(36.0F);
  }
  
  public View c(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setBackgroundColor(a(paramContext));
    View localView = new View(paramContext);
    localView.setBackgroundColor(paramContext.getResources().getColor(2131165576));
    paramContext = new LinearLayout.LayoutParams(ViewUtils.a(1.0F), ViewUtils.a(13.0F));
    paramContext.gravity = 16;
    localLinearLayout.addView(localView, paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.a(1.0F), -1));
    return localLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.menu.QCircleMenuContainerStyle
 * JD-Core Version:    0.7.0.1
 */