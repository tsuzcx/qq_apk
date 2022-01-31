package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import bdaq;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import wgh;
import wgk;
import wgn;
import wnd;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  int a;
  public wgh a;
  public wgn a;
  int b;
  
  public StoryPickerHorizontalListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryPickerHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.b = bdaq.a(paramContext, 105.0F);
    this.jdField_a_of_type_Wgh = new wgh(getContext());
    super.setAdapter(this.jdField_a_of_type_Wgh);
    super.setOnItemClickListener(this.jdField_a_of_type_Wgh);
    super.setOnScrollStateChangedListener(new wgk(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Wgh;
  }
  
  public void setData(List<wnd> paramList, String paramString)
  {
    this.jdField_a_of_type_Wgh.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(wgn paramwgn)
  {
    this.jdField_a_of_type_Wgn = paramwgn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */