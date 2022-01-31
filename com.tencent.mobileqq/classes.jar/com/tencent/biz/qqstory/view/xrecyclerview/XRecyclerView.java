package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import wde;
import wef;

public class XRecyclerView
  extends FrameLayout
{
  private RecyclerViewWithHeaderFooter jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter;
  private wde jdField_a_of_type_Wde;
  
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
    this.jdField_a_of_type_Wde = new wde(localLoadMoreLayout, getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.a(localLoadMoreLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setOnScrollListener(new wef(this));
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)LayoutInflater.from(paramContext).inflate(2131561346, this).findViewById(2131375517));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */