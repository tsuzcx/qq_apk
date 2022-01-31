package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import wbb;
import wbl;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public wbb a;
  wbl a;
  
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
  
  public void setListAdapter(wbb paramwbb)
  {
    super.setListAdapter(paramwbb);
    this.jdField_a_of_type_Wbb = paramwbb;
  }
  
  public void setUIEventListener(wbl paramwbl)
  {
    this.jdField_a_of_type_Wbl = paramwbl;
    this.jdField_a_of_type_Wbb.a(paramwbl);
    super.setListener(paramwbl, paramwbl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */