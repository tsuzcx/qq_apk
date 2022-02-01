package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import xyv;
import xzf;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public xyv a;
  xzf a;
  
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
  
  public void setListAdapter(xyv paramxyv)
  {
    super.setListAdapter(paramxyv);
    this.jdField_a_of_type_Xyv = paramxyv;
  }
  
  public void setUIEventListener(xzf paramxzf)
  {
    this.jdField_a_of_type_Xzf = paramxzf;
    this.jdField_a_of_type_Xyv.a(paramxzf);
    super.setListener(paramxzf, paramxzf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */