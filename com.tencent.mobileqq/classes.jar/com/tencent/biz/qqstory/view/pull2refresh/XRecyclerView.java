package com.tencent.biz.qqstory.view.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter;
import oqi;

public class XRecyclerView
  extends AbsPullToRefreshView2
{
  private int jdField_a_of_type_Int = 0;
  private LoadingMoreHelper jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper;
  private RecyclerViewWithHeaderFooter jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2130971744, this, true);
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131375558));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper = new LoadingMoreHelper(localLoadMoreLayout, getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.b(localLoadMoreLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setOnScrollListener(new oqi(this));
  }
  
  protected View a()
  {
    return LayoutInflater.from(getContext()).inflate(2130970817, this, false);
  }
  
  public LoadingMoreHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter;
  }
  
  @TargetApi(14)
  protected boolean a()
  {
    return !this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.canScrollVertically(-1);
  }
  
  protected View b()
  {
    return null;
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.a = paramBoolean;
  }
  
  @TargetApi(14)
  protected boolean b()
  {
    return !this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.canScrollVertically(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */