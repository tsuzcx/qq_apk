package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.TraceUtils;

public class VideoListLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private StoryHomeHorizontalListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public VideoListLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = UIUtils.a(getContext(), 15.0F);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.j = UIUtils.a(getContext(), 2.0F);
    this.f = getContext().getResources().getDimensionPixelSize(2131560277);
    this.g = UIUtils.a(getContext(), 10.0F);
    this.d = UIUtils.a(getContext(), 205.0F);
    this.e = UIUtils.a(getContext(), 332.0F);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 252.0F);
    this.h = UIUtils.a(getContext(), 10.0F);
    this.i = UIUtils.a(getContext(), 2.0F);
    this.k = UIUtils.a(getContext(), 7.0F);
    this.m = UIUtils.a(getContext(), 10.0F);
    this.l = UIUtils.a(getContext(), 3.0F);
  }
  
  private void b()
  {
    TraceUtils.a("VideoListLayout.init");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2130970725, this, false));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843656);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    addView(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2130970733, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2130970733, this, false));
    addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)LayoutInflater.from(getContext()).inflate(2130970728, this, false));
    addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)LayoutInflater.from(getContext()).inflate(2130970735, this, false));
    addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView);
    TraceUtils.a();
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public LinearLayout a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130970721, this, false));
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public QQStoryAutoPlayView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  }
  
  public StoryHomeHorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    paramInt1 = this.g;
    paramInt2 = paramInt1;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramInt2 = paramInt1;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
        paramInt2 = paramInt1 + this.jdField_c_of_type_Int + this.h;
      }
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.getVisibility() != 8))
    {
      paramInt2 = paramInt2 + this.e + this.k;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.measure(View.MeasureSpec.makeMeasureSpec(this.d, 1073741824), View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(this.d, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        paramInt1 = paramInt2;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {}
      }
      else
      {
        paramInt1 = paramInt2 + this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      setMeasuredDimension(n, paramInt1);
      return;
      paramInt1 = paramInt2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView != null)
      {
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getVisibility() != 8)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.measure(View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
          paramInt1 = paramInt2 + this.jdField_a_of_type_Int;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.f;
    paramInt4 = this.g;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8))
    {
      paramInt3 = paramInt2 + this.jdField_b_of_type_Int;
      paramInt1 = this.jdField_c_of_type_Int + paramInt4;
      this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt2, paramInt4, paramInt3, paramInt1);
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8))
      {
        paramInt3 += this.i;
        int n = this.j;
        int i1 = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth();
        this.jdField_c_of_type_AndroidWidgetTextView.layout(paramInt3, paramInt4 - n, i1 + paramInt3, paramInt1);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.getVisibility() != 8))
      {
        paramInt3 = paramInt1;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
            paramInt3 = paramInt1;
          }
        }
        else
        {
          paramInt1 = this.d;
          paramInt4 = this.e + paramInt3;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.layout(paramInt2, paramInt3 + 0, paramInt1 + paramInt2, paramInt4);
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.layout(0, 0, 0, 0);
          }
          paramInt3 = paramInt4 + this.k;
          if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
            break label522;
          }
          paramInt4 = paramInt2 + this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
          paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() + paramInt3;
          this.jdField_a_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt3, paramInt4, paramInt1);
          paramInt2 = paramInt4;
        }
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8))
        {
          paramInt2 = this.l + paramInt2;
          paramInt4 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
          this.jdField_b_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt3, paramInt4 + paramInt2, paramInt1);
        }
        label331:
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8))
        {
          paramInt1 = getMeasuredWidth() - this.m;
          paramInt2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
          paramInt3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1 - paramInt2, 0, paramInt1, paramInt3);
        }
        label493:
        while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
        {
          return;
          paramInt3 = paramInt1 + this.h;
          break;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getVisibility() == 8)) {
            break label331;
          }
          paramInt2 = paramInt1;
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
              break label493;
            }
          }
          for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + this.h)
          {
            paramInt1 = getMeasuredWidth();
            paramInt3 = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.layout(0, paramInt2 + 0, paramInt1, paramInt3 + paramInt2);
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.layout(0, 0, 0, 0);
            break;
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(0, 0, 0, 0);
        return;
        label522:
        paramInt1 = paramInt3;
      }
      paramInt1 = paramInt4;
      paramInt3 = paramInt2;
    }
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TextView c()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceUtils.a("VideoListLayout.onLayout");
    try
    {
      a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      throw new Error("do you know ,this is an error:" + localException);
    }
    finally
    {
      TraceUtils.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    TraceUtils.a("VideoListLayout.onMeasure");
    try
    {
      a(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      throw new Error("do you know ,this is an error:" + localException);
    }
    finally
    {
      TraceUtils.a();
    }
  }
  
  public void setAddGroupGuide(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130970721, this, false));
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
  }
  
  public void setFailedTxt(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setHorizontalViewHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setSingleVideoSize(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout
 * JD-Core Version:    0.7.0.1
 */