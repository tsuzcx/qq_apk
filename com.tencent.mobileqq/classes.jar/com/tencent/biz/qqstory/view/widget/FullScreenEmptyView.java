package com.tencent.biz.qqstory.view.widget;

import actj;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import vzl;

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
    return vzl.d(super.getContext()) - actj.a(55.0F, super.getResources()) - vzl.e(super.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenEmptyView
 * JD-Core Version:    0.7.0.1
 */