package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class QCirclePlusFollowView
  extends QCircleFollowView
{
  public QCirclePlusFollowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    super.a();
    setVisibility(0);
    setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845313));
    setText("");
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(8);
  }
  
  protected void b()
  {
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePlusFollowView
 * JD-Core Version:    0.7.0.1
 */