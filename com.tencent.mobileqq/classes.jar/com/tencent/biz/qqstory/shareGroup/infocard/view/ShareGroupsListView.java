package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import umm;
import umw;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public umm a;
  umw a;
  
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
  
  public void setListAdapter(umm paramumm)
  {
    super.setListAdapter(paramumm);
    this.jdField_a_of_type_Umm = paramumm;
  }
  
  public void setUIEventListener(umw paramumw)
  {
    this.jdField_a_of_type_Umw = paramumw;
    this.jdField_a_of_type_Umm.a(paramumw);
    super.setListener(paramumw, paramumw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */