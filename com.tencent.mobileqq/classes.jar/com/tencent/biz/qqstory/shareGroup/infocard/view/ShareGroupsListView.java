package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public ShareGroupsListAdapter a;
  ShareGroupsListView.UIEventListener a;
  
  public ShareGroupsListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShareGroupsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShareGroupsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {}
  
  public void setListAdapter(ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    super.setListAdapter(paramShareGroupsListAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
  }
  
  public void setUIEventListener(ShareGroupsListView.UIEventListener paramUIEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener = paramUIEventListener;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a(paramUIEventListener);
    super.setListener(paramUIEventListener, paramUIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */