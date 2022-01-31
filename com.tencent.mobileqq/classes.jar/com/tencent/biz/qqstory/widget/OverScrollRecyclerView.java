package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import wel;

public class OverScrollRecyclerView
  extends RecyclerView
{
  protected final wel a = new wel(this);
  
  public OverScrollRecyclerView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a.a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    this.a.a(paramLayoutManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */