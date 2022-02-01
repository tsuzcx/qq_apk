package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseNestHeaderLayout
  extends BaseLayout
  implements IHeaderView
{
  public BaseNestHeaderLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseNestHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getViewHeight()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.library.BaseNestHeaderLayout
 * JD-Core Version:    0.7.0.1
 */