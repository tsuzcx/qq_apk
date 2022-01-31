package com.tencent.biz.qqstory.storyHome.memory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import bawz;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import uuf;
import uug;
import uuh;
import uui;

@TargetApi(9)
public class MemoriesInnerListView
  extends HorizontalListView
{
  protected int a;
  public uuh a;
  private uui a;
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
    this.b = bawz.a(paramContext, 82.0F);
    this.jdField_a_of_type_Uui = new uui(getContext());
    super.setAdapter(this.jdField_a_of_type_Uui);
    super.setOnItemClickListener(this.jdField_a_of_type_Uui);
    super.setOnScrollStateChangedListener(new uug(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Uui;
  }
  
  public void setDate(List<uuf> paramList, String paramString)
  {
    this.jdField_a_of_type_Uui.a(paramList, paramString);
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