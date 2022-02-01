package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

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
    setBackgroundResource(2130844070);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePlusFollowView
 * JD-Core Version:    0.7.0.1
 */