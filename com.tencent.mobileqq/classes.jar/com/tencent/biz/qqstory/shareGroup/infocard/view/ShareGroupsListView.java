package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import wfk;
import wfu;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public wfk a;
  wfu a;
  
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
  
  public void setListAdapter(wfk paramwfk)
  {
    super.setListAdapter(paramwfk);
    this.jdField_a_of_type_Wfk = paramwfk;
  }
  
  public void setUIEventListener(wfu paramwfu)
  {
    this.jdField_a_of_type_Wfu = paramwfu;
    this.jdField_a_of_type_Wfk.a(paramwfu);
    super.setListener(paramwfu, paramwfu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */