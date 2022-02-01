package com.tencent.biz.qqstory.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;

@TargetApi(14)
public class FullScreenEmptyView
  extends AbsEmptyView
{
  public FullScreenEmptyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getViewHeight()
  {
    return UIUtils.e(super.getContext()) - AIOUtils.b(55.0F, super.getResources()) - UIUtils.f(super.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenEmptyView
 * JD-Core Version:    0.7.0.1
 */