package com.tencent.biz.qqcircle.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.widget.StatusView;

public class QCircleComponentPageView
  extends ComponentPageView
{
  public QCircleComponentPageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public StatusView a(View paramView)
  {
    return new QCircleStatusView(getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.component.QCircleComponentPageView
 * JD-Core Version:    0.7.0.1
 */