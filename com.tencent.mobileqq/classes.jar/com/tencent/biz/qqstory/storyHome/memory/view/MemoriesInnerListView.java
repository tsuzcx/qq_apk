package com.tencent.biz.qqstory.storyHome.memory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import azvv;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import uhj;
import uhk;
import uhl;
import uhm;

@TargetApi(9)
public class MemoriesInnerListView
  extends HorizontalListView
{
  protected int a;
  public uhl a;
  private uhm a;
  protected int b;
  
  public MemoriesInnerListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MemoriesInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.b = azvv.a(paramContext, 82.0F);
    this.jdField_a_of_type_Uhm = new uhm(getContext());
    super.setAdapter(this.jdField_a_of_type_Uhm);
    super.setOnItemClickListener(this.jdField_a_of_type_Uhm);
    super.setOnScrollStateChangedListener(new uhk(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Uhm;
  }
  
  public void setDate(List<uhj> paramList, String paramString)
  {
    this.jdField_a_of_type_Uhm.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView
 * JD-Core Version:    0.7.0.1
 */