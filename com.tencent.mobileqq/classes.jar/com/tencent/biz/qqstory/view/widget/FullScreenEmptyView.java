package com.tencent.biz.qqstory.view.widget;

import aciy;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import vms;

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
  
  public int a()
  {
    return vms.d(super.getContext()) - aciy.a(55.0F, super.getResources()) - vms.e(super.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenEmptyView
 * JD-Core Version:    0.7.0.1
 */