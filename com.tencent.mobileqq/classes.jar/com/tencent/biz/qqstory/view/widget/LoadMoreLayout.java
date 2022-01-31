package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;

public class LoadMoreLayout
  extends FrameLayout
{
  public int a;
  protected Context a;
  protected LinearLayout a;
  protected ProgressBar a;
  public TextView a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  
  public LoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = "加载更多";
    this.c = "正在加载...";
    this.d = "已加载全部";
    this.b = StoryApi.a(2131432120);
    this.e = "加载失败，点击重试";
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
                break;
              }
            } while (paramInt2 != 5);
            return true;
            if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
              break;
            }
          } while (paramInt2 != 5);
          return true;
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4)) {
            break;
          }
        } while (paramInt2 != 5);
        return true;
        if ((paramInt2 == 0) || (paramInt2 == 1)) {
          break;
        }
      } while (paramInt2 != 3);
      return true;
      if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {
        break;
      }
    } while (paramInt2 != 3);
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970907, null));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363562));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363632));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    super.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    c(0);
  }
  
  private boolean c(int paramInt)
  {
    if (!a(this.jdField_a_of_type_Int, paramInt)) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  public boolean a(int paramInt)
  {
    return c(paramInt);
  }
  
  public boolean b(int paramInt)
  {
    return a(this.jdField_a_of_type_Int, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */