package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import bcwh;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import wby;
import wcb;
import wce;
import wiu;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  int a;
  public wby a;
  public wce a;
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
    this.b = bcwh.a(paramContext, 105.0F);
    this.jdField_a_of_type_Wby = new wby(getContext());
    super.setAdapter(this.jdField_a_of_type_Wby);
    super.setOnItemClickListener(this.jdField_a_of_type_Wby);
    super.setOnScrollStateChangedListener(new wcb(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Wby;
  }
  
  public void setData(List<wiu> paramList, String paramString)
  {
    this.jdField_a_of_type_Wby.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(wce paramwce)
  {
    this.jdField_a_of_type_Wce = paramwce;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */