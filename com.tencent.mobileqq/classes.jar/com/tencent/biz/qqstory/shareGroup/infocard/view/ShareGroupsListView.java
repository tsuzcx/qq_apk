package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import ycq;
import yda;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public ycq a;
  yda a;
  
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
  
  public void setListAdapter(ycq paramycq)
  {
    super.setListAdapter(paramycq);
    this.jdField_a_of_type_Ycq = paramycq;
  }
  
  public void setUIEventListener(yda paramyda)
  {
    this.jdField_a_of_type_Yda = paramyda;
    this.jdField_a_of_type_Ycq.a(paramyda);
    super.setListener(paramyda, paramyda);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */