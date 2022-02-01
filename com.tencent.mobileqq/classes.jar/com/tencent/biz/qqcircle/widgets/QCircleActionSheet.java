package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class QCircleActionSheet
  extends ActionSheet
{
  public QCircleActionSheet(Context paramContext)
  {
    super(paramContext);
  }
  
  public static QCircleActionSheet c(Context paramContext)
  {
    paramContext = new QCircleActionSheet(paramContext);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131951622);
    }
    return paramContext;
  }
  
  protected int d()
  {
    return super.d();
  }
  
  protected int e()
  {
    return super.e();
  }
  
  protected int f()
  {
    return 2131626961;
  }
  
  protected int g(int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 8)) {
      return QCircleSkinHelper.getInstance().getColor(2131167084);
    }
    return super.g(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleActionSheet
 * JD-Core Version:    0.7.0.1
 */