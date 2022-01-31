package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import azvv;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import uan;
import uaq;
import uat;
import uhj;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  int a;
  public uan a;
  public uat a;
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
    this.b = azvv.a(paramContext, 105.0F);
    this.jdField_a_of_type_Uan = new uan(getContext());
    super.setAdapter(this.jdField_a_of_type_Uan);
    super.setOnItemClickListener(this.jdField_a_of_type_Uan);
    super.setOnScrollStateChangedListener(new uaq(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Uan;
  }
  
  public void setData(List<uhj> paramList, String paramString)
  {
    this.jdField_a_of_type_Uan.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(uat paramuat)
  {
    this.jdField_a_of_type_Uat = paramuat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */