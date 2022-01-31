package com.tencent.biz.qqstory.view.widget;

import aekt;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import xod;

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
    return xod.d(super.getContext()) - aekt.a(55.0F, super.getResources()) - xod.e(super.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenEmptyView
 * JD-Core Version:    0.7.0.1
 */