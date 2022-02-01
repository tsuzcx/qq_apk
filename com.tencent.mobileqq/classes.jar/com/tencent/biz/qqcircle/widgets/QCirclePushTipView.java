package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class QCirclePushTipView
  extends TextView
{
  public QCirclePushTipView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePushTipView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePushTipView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setBackgroundDrawable(getResources().getDrawable(2130845216));
    setTextColor(getResources().getColor(2131168464));
    setTextSize(1, 14.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushTipView
 * JD-Core Version:    0.7.0.1
 */