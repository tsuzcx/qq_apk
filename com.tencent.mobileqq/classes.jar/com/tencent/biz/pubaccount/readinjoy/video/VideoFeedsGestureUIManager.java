package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoFeedsGestureUIManager
{
  private int jdField_a_of_type_Int = 0;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureProgressView jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  
  public void a()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    if (this.e != null) {
      this.e.setVisibility(8);
    }
  }
  
  public void a(int paramInt, float paramFloat, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      String str1 = VideoFeedsHelper.a(paramLong1);
      String str2 = VideoFeedsHelper.a(paramLong2);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + "/");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      if (paramFloat > 0.0F) {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840868);
      }
      while (this.c.getVisibility() == 8)
      {
        VideoFeedsHelper.a(this.c, 0, 300);
        break;
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840866);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView.setProgress(paramFloat);
      if (paramFloat == 0.0F) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840887);
      }
      while (this.e.getVisibility() == 8)
      {
        VideoFeedsHelper.a(this.e, 0, 300);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840888);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView.setProgress(paramFloat);
      if (this.d.getVisibility() == 8)
      {
        VideoFeedsHelper.a(this.d, 0, 300);
        continue;
        if (this.jdField_a_of_type_Int != 0) {
          if (this.jdField_a_of_type_Int == 3)
          {
            if (this.c.getVisibility() == 0) {
              VideoFeedsHelper.a(this.c, 8, 300);
            }
          }
          else if (this.jdField_a_of_type_Int == 2)
          {
            if (this.d.getVisibility() == 0) {
              VideoFeedsHelper.a(this.d, 8, 300);
            }
          }
          else if ((this.jdField_a_of_type_Int == 1) && (this.e.getVisibility() == 0)) {
            VideoFeedsHelper.a(this.e, 8, 300);
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130969670, paramViewGroup));
    this.c = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367384));
    this.d = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367388));
    this.e = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367391));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367386));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367387));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367393));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367385));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView = ((VideoFeedsGestureProgressView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367389));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureProgressView = ((VideoFeedsGestureProgressView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131367392));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureUIManager
 * JD-Core Version:    0.7.0.1
 */