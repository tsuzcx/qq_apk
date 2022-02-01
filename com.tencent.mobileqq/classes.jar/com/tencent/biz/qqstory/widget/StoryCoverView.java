package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import wuq;
import wur;
import yuk;
import zps;

public class StoryCoverView
  extends FrameLayout
{
  public ImageView a;
  public InteractContainerLayout a;
  public PollContainerLayout a;
  
  public StoryCoverView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryCoverView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams1);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout = new PollContainerLayout(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.setClickable(false);
    addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout, localLayoutParams2);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout = new InteractContainerLayout(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.setClickable(false);
    addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout, localLayoutParams3);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 0 });
    int i = paramContext.getInt(0, -1);
    if (i >= 0)
    {
      paramAttributeSet = ImageView.ScaleType.values();
      if (paramAttributeSet.length > i) {
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(paramAttributeSet[i]);
      }
    }
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    yuk.a("StoryCoverView", "onLayout wh(%d, %d)", Integer.valueOf(paramInt3 - paramInt1), Integer.valueOf(paramInt4 - paramInt2));
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    zps.a(this.jdField_a_of_type_AndroidWidgetImageView, paramString, paramInt1, paramInt2, paramInt3, null, "Qim_Profile_Story" + paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setPollLayout(wur paramwur, int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(paramwur, paramInt, paramArrayOfInt);
  }
  
  public void setRateLayout(wuq paramwuq, int paramInt1, long paramLong, int paramInt2)
  {
    yuk.a("StoryCoverView", "setRateLayout, layout=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramwuq, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.a(paramwuq, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.StoryCoverView
 * JD-Core Version:    0.7.0.1
 */