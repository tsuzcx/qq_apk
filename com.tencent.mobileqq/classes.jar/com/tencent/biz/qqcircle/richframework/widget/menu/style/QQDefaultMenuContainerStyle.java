package com.tencent.biz.qqcircle.richframework.widget.menu.style;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.utils.RFThemeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;

public class QQDefaultMenuContainerStyle
  implements MenuContainerStyle
{
  public int a()
  {
    return ViewUtils.a(8.0F);
  }
  
  public int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i;
    if (RFThemeUtil.a()) {
      i = 2131166456;
    } else {
      i = 2131166458;
    }
    return paramContext.getColor(i);
  }
  
  public int b()
  {
    return ViewUtils.a(62.0F);
  }
  
  public int b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i;
    if (RFThemeUtil.a()) {
      i = 2131166457;
    } else {
      i = 2131166459;
    }
    return paramContext.getColor(i);
  }
  
  public int c()
  {
    return ViewUtils.a(40.0F);
  }
  
  public View c(Context paramContext)
  {
    View localView = new View(paramContext);
    paramContext = paramContext.getResources();
    int i;
    if (RFThemeUtil.a()) {
      i = 2131166460;
    } else {
      i = 2131166462;
    }
    localView.setBackgroundColor(paramContext.getColor(i));
    localView.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.a(1.0F), -1));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.style.QQDefaultMenuContainerStyle
 * JD-Core Version:    0.7.0.1
 */