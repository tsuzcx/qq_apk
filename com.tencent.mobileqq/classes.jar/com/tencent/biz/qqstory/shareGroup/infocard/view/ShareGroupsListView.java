package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import tzq;
import uaa;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public tzq a;
  uaa a;
  
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
  
  public void setListAdapter(tzq paramtzq)
  {
    super.setListAdapter(paramtzq);
    this.jdField_a_of_type_Tzq = paramtzq;
  }
  
  public void setUIEventListener(uaa paramuaa)
  {
    this.jdField_a_of_type_Uaa = paramuaa;
    this.jdField_a_of_type_Tzq.a(paramuaa);
    super.setListener(paramuaa, paramuaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */