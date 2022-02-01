package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  ShareGroupsListView.UIEventListener e;
  public ShareGroupsListAdapter f;
  
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
    this.f = paramShareGroupsListAdapter;
  }
  
  public void setUIEventListener(ShareGroupsListView.UIEventListener paramUIEventListener)
  {
    this.e = paramUIEventListener;
    this.f.a(paramUIEventListener);
    super.setListener(paramUIEventListener, paramUIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */