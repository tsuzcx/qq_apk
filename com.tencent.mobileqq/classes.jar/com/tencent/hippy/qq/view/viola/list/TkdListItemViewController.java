package com.tencent.hippy.qq.view.viola.list;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.list.HippyListItemViewController;

@HippyController(isLazyLoad=true, name="tkdCell")
public class TkdListItemViewController
  extends HippyListItemViewController
{
  public static final String CLASS_NAME = "tkdCell";
  
  protected View createViewImpl(Context paramContext)
  {
    return new TkdListItemView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.list.TkdListItemViewController
 * JD-Core Version:    0.7.0.1
 */