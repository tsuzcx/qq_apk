package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import xsw;
import xtg;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  public xsw a;
  xtg a;
  
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
  
  public void setListAdapter(xsw paramxsw)
  {
    super.setListAdapter(paramxsw);
    this.jdField_a_of_type_Xsw = paramxsw;
  }
  
  public void setUIEventListener(xtg paramxtg)
  {
    this.jdField_a_of_type_Xtg = paramxtg;
    this.jdField_a_of_type_Xsw.a(paramxtg);
    super.setListener(paramxtg, paramxtg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */