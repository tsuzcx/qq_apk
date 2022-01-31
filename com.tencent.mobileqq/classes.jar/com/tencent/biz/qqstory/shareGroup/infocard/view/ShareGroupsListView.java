package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import umj;
import umt;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public umj a;
  umt a;
  
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
  
  public void setListAdapter(umj paramumj)
  {
    super.setListAdapter(paramumj);
    this.jdField_a_of_type_Umj = paramumj;
  }
  
  public void setUIEventListener(umt paramumt)
  {
    this.jdField_a_of_type_Umt = paramumt;
    this.jdField_a_of_type_Umj.a(paramumt);
    super.setListener(paramumt, paramumt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */