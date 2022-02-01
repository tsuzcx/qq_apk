package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionMenuItem;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheetHelper;
import java.util.List;

public class QCircleActionSheetHelper
  extends ActionSheetHelper
{
  public static QCircleActionSheet a(Context paramContext, View paramView)
  {
    paramContext = QCircleActionSheet.c(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static QCircleActionSheet a(Context paramContext, QCircleActionSheet paramQCircleActionSheet, List<ActionMenuItem> paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    if ((paramContext != null) && (paramList != null))
    {
      if (paramList.size() <= 0) {
        return null;
      }
      if (paramQCircleActionSheet == null)
      {
        paramQCircleActionSheet = a(paramContext, null);
      }
      else
      {
        paramQCircleActionSheet.c();
        paramQCircleActionSheet.a();
      }
      int i = 0;
      while (i < paramList.size())
      {
        paramContext = (ActionMenuItem)paramList.get(i);
        if (paramContext.e == 0) {
          if (paramContext.a == 1) {
            paramQCircleActionSheet.a(paramContext, 0);
          } else if (paramContext.a == 2) {
            paramQCircleActionSheet.a(paramContext, 3);
          }
        }
        i += 1;
      }
      paramQCircleActionSheet.a(paramOnButtonClickListener);
      return paramQCircleActionSheet;
    }
    return null;
  }
  
  public static QCircleActionSheet a(Context paramContext, List<ActionMenuItem> paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    return a(paramContext, null, paramList, paramOnButtonClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */