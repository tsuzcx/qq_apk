package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;

public class XRecyclerView
  extends FrameLayout
{
  private RecyclerViewWithHeaderFooter a;
  private LoadingMoreHelper b;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.b = new LoadingMoreHelper(localLoadMoreLayout, getContext());
    this.a.a(localLoadMoreLayout);
    this.a.setOnScrollListener(new XRecyclerView.1(this));
  }
  
  private void a(Context paramContext)
  {
    this.a = ((RecyclerViewWithHeaderFooter)LayoutInflater.from(paramContext).inflate(2131628133, this).findViewById(2131445167));
    a();
  }
  
  public LoadingMoreHelper getLoadMoreLayoutHelper()
  {
    return this.b;
  }
  
  public RecyclerViewWithHeaderFooter getRecyclerView()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */