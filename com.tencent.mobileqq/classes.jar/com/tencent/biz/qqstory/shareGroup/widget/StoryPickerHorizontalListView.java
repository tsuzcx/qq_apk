package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import bhgr;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import ydn;
import ydq;
import ydt;
import ykj;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  int a;
  public ydn a;
  public ydt a;
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
    this.b = bhgr.a(paramContext, 105.0F);
    this.jdField_a_of_type_Ydn = new ydn(getContext());
    super.setAdapter(this.jdField_a_of_type_Ydn);
    super.setOnItemClickListener(this.jdField_a_of_type_Ydn);
    super.setOnScrollStateChangedListener(new ydq(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Ydn;
  }
  
  public void setData(List<ykj> paramList, String paramString)
  {
    this.jdField_a_of_type_Ydn.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(ydt paramydt)
  {
    this.jdField_a_of_type_Ydt = paramydt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */