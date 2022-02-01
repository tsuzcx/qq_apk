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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;

public class LoadMoreLayout
  extends FrameLayout
  implements ILoadMoreLayout
{
  protected int a;
  protected Context a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
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
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131706334);
    this.c = HardCodeUtil.a(2131706336);
    this.d = HardCodeUtil.a(2131706333);
    this.b = StoryApi.a(2131699915);
    this.e = HardCodeUtil.a(2131706335);
  }
  
  private boolean a(int paramInt)
  {
    if (!a(this.jdField_a_of_type_Int, paramInt)) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return true;
              }
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              return true;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            return true;
          }
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if ((paramInt1 == 5) && ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3))) {
                return true;
              }
            }
            else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3)) {
              return true;
            }
          }
          else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4) || (paramInt2 == 5)) {
            return true;
          }
        }
        else if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) {
          return true;
        }
      }
      else
      {
        if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
          break label145;
        }
        if (paramInt2 == 5) {
          return true;
        }
      }
      return false;
    }
    label145:
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561840, null));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373132));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378460));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    super.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    a(0);
  }
  
  public boolean checkState(int paramInt)
  {
    return a(this.jdField_a_of_type_Int, paramInt);
  }
  
  public int getState()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean setState(int paramInt)
  {
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */