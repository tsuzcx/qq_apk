package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import ziw;

public class OverScrollRecyclerView
  extends RecyclerView
{
  protected final ziw a = new ziw(this);
  
  public OverScrollRecyclerView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.a.a();
  }
  
  public void a()
  {
    this.a.c();
  }
  
  public void b()
  {
    this.a.b();
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
  
  public void setTouchDragRatio(float paramFloat1, float paramFloat2)
  {
    if (this.a.a != null)
    {
      this.a.a.a = paramFloat1;
      this.a.a.b = paramFloat2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */