package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.util.LiuHaiUtils;

public class StoryGuideLineView
  extends LinearLayout
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private View jdField_c_of_type_AndroidViewView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  
  public StoryGuideLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131562862, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)findViewById(2131374482));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374586));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378289));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368752));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374526));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374527);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131374535);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374532);
    setViewAlpha(this.jdField_c_of_type_AndroidWidgetLinearLayout);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setVisibility(0);
        if (paramBoolean) {
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
    }
  }
  
  public void b()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void d()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void e()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void f()
  {
    c();
    e();
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChild(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramInt1, paramInt2);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
    jdField_b_of_type_Int = localDisplayMetrics.widthPixels - this.jdField_c_of_type_AndroidViewView.getMeasuredWidth();
    jdField_c_of_type_Int = 0;
    d = localDisplayMetrics.heightPixels - this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
    if (LiuHaiUtils.b()) {
      d = localDisplayMetrics.heightPixels - this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - LiuHaiUtils.e - LiuHaiUtils.jdField_a_of_type_Int;
    }
  }
  
  public void setUserHead(Bitmap paramBitmap)
  {
    PressDarkImageView localPressDarkImageView = this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
    if (localPressDarkImageView != null) {
      localPressDarkImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setUserName(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setViewAlpha(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    if (j == 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        setViewAlpha((ViewGroup)localView);
      }
      if (localView.getBackground() != null) {
        localView.getBackground().mutate().setAlpha(60);
      }
      localView.setAlpha(0.6F);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView
 * JD-Core Version:    0.7.0.1
 */