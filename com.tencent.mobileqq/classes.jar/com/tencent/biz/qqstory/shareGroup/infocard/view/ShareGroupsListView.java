package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import xeb;
import xel;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public xeb a;
  xel a;
  
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
  
  public void setListAdapter(xeb paramxeb)
  {
    super.setListAdapter(paramxeb);
    this.jdField_a_of_type_Xeb = paramxeb;
  }
  
  public void setUIEventListener(xel paramxel)
  {
    this.jdField_a_of_type_Xel = paramxel;
    this.jdField_a_of_type_Xeb.a(paramxel);
    super.setListener(paramxel, paramxel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */