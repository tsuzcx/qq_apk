package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import blqm;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import zps;

public class QQStoryOwnerInfoView
  extends ViewGroup
{
  private int jdField_a_of_type_Int = -1;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  StoryQIMBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
  StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private int jdField_b_of_type_Int = -1;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence = "";
  private int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private CharSequence jdField_c_of_type_JavaLangCharSequence = "";
  private int jdField_d_of_type_Int;
  private CharSequence jdField_d_of_type_JavaLangCharSequence = "";
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  
  public QQStoryOwnerInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a();
  }
  
  private void a()
  {
    blqm.a("QQStoryInfoView.init");
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131374596);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView = new StoryQIMBadgeView(getContext());
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561734, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561733, this, false));
    addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = new StoryUserBadgeView(getContext());
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561733, this, false));
    addView(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)LayoutInflater.from(getContext()).inflate(2131561732, this, false));
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131362134);
    addView(this.jdField_a_of_type_AndroidWidgetButton);
    blqm.a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_d_of_type_Int, 1073741824));
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.measure(View.MeasureSpec.makeMeasureSpec(this.g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
    }
    int i1 = paramInt1 - this.e - this.f - this.jdField_c_of_type_Int - this.p;
    paramInt1 = paramInt1 - this.e - this.f - this.jdField_c_of_type_Int - this.p;
    TextPaint localTextPaint;
    int i2;
    float f1;
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 8))
    {
      localTextPaint = this.jdField_a_of_type_AndroidWidgetButton.getPaint();
      this.jdField_c_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetButton.getText();
      this.m = ((int)localTextPaint.measureText(this.jdField_c_of_type_JavaLangCharSequence, 0, this.jdField_c_of_type_JavaLangCharSequence.length()) + this.jdField_a_of_type_AndroidWidgetButton.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetButton.getPaddingRight());
      this.jdField_a_of_type_AndroidWidgetButton.measure(View.MeasureSpec.makeMeasureSpec(this.m, 1073741824), View.MeasureSpec.makeMeasureSpec(this.n, 1073741824));
      i1 = i1 - this.m - this.p - this.o;
      paramInt1 = paramInt1 - this.m - this.p - this.o;
      i2 = i1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getVisibility() != 8)
      {
        i2 = i1 - this.i - this.k;
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.measure(View.MeasureSpec.makeMeasureSpec(this.i, 1073741824), View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
      }
      localTextPaint = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
      f1 = localTextPaint.measureText(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length());
      if (f1 <= i2) {
        break label564;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    for (;;)
    {
      i1 = paramInt1;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        i1 = paramInt1;
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8)
        {
          localTextPaint = this.jdField_c_of_type_AndroidWidgetTextView.getPaint();
          this.jdField_d_of_type_JavaLangCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
          i2 = (int)localTextPaint.measureText(this.jdField_d_of_type_JavaLangCharSequence, 0, this.jdField_d_of_type_JavaLangCharSequence.length());
          i1 = paramInt1 - i2 - this.r;
          this.jdField_c_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
        }
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8)
      {
        localTextPaint = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_b_of_type_AndroidWidgetTextView.getText();
        f1 = localTextPaint.measureText(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length());
        if (f1 <= i1) {
          break label587;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      return;
      this.m = 0;
      break;
      label564:
      this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    label587:
    this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
  }
  
  private void b()
  {
    this.jdField_c_of_type_Int = getContext().getResources().getDimensionPixelSize(2131298439);
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.f = getContext().getResources().getDimensionPixelSize(2131298444);
    this.e = getContext().getResources().getDimensionPixelSize(2131298440);
    this.g = getContext().getResources().getDimensionPixelSize(2131298441);
    this.h = this.g;
    this.q = getContext().getResources().getDimensionPixelSize(2131298443);
    this.i = getContext().getResources().getDimensionPixelSize(2131298438);
    this.j = this.i;
    this.l = getContext().getResources().getDimensionPixelSize(2131298437);
    this.k = getContext().getResources().getDimensionPixelSize(2131298436);
    this.r = zps.a(getContext(), 2.0F);
    this.o = zps.a(getContext(), 10.0F);
    this.p = zps.a(getContext(), 15.0F);
    this.n = getContext().getResources().getDimensionPixelSize(2131298442);
    this.m = 0;
  }
  
  @NonNull
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NonNull
  public StoryQIMBadgeView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
  }
  
  @NonNull
  public StoryUserBadgeView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.e;
    paramInt4 = (this.jdField_b_of_type_Int - this.jdField_d_of_type_Int) / 2;
    paramInt1 = this.jdField_c_of_type_Int + paramInt3;
    paramInt2 = this.jdField_d_of_type_Int + paramInt4;
    this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt3, paramInt4, paramInt1, paramInt2);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.getVisibility() != 8))
    {
      paramInt3 = this.g;
      paramInt4 = this.h;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.layout(paramInt1 - paramInt3, paramInt2 - paramInt4, paramInt1, paramInt2);
    }
    paramInt2 = paramInt1 + this.f;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8) {}
    for (paramInt1 = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight()) / 2;; paramInt1 = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() - this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredHeight() - this.q) / 2)
    {
      paramInt4 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + paramInt2;
      paramInt3 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() + paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1 + 0, paramInt4, paramInt3);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getVisibility() != 8))
      {
        paramInt4 += this.k;
        paramInt1 += this.l;
        int i1 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getMeasuredWidth();
        int i2 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getMeasuredHeight();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.layout(paramInt4, paramInt1, i1 + paramInt4, i2 + paramInt1);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8)
      {
        paramInt1 = this.q + paramInt3;
        paramInt3 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() + paramInt2;
        paramInt4 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredHeight();
        this.jdField_b_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1, paramInt3, paramInt4 + paramInt1);
        if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8))
        {
          paramInt2 = this.r + paramInt3;
          paramInt3 = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth();
          paramInt4 = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredHeight();
          this.jdField_c_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
        }
      }
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 8))
      {
        paramInt1 = this.jdField_a_of_type_Int - this.p;
        paramInt2 = this.m;
        paramInt3 = (this.jdField_b_of_type_Int - this.n) / 2;
        paramInt4 = this.n;
        this.jdField_a_of_type_AndroidWidgetButton.layout(paramInt1 - paramInt2, paramInt3, paramInt1, paramInt4 + paramInt3);
      }
      return;
    }
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    blqm.a("QQStoryInfoView.onLayout");
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
      blqm.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    blqm.a("QQStoryInfoView.onMeasure");
    try
    {
      this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
      this.jdField_b_of_type_Int = View.MeasureSpec.getSize(paramInt2);
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      throw new Error("do you know ,this is an error:" + localException);
    }
    finally
    {
      blqm.a();
    }
  }
  
  public void setAvatar(@NonNull Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setBadge(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setImageDrawable(paramDrawable);
  }
  
  public void setButtonTxt(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = paramString;
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
  }
  
  public void setName(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setOwnerInfoOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setQIMIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView = new StoryQIMBadgeView(getContext());
      addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.setImageDrawable(paramDrawable);
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangCharSequence = "";
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    this.jdField_b_of_type_JavaLangCharSequence = paramString;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setSubTitleSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_d_of_type_JavaLangCharSequence = "";
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_JavaLangCharSequence = paramString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView
 * JD-Core Version:    0.7.0.1
 */