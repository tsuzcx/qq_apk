package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class SquareCornerTextImageView
  extends FrameLayout
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
  public SquareCornerTextImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramContext = new FrameLayout.LayoutParams(Utils.b(30.0D), Utils.b(18.0D));
    paramContext.gravity = 85;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
  }
  
  public void a(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo)
  {
    ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, SquareCornerTextImageView.PicInfo.a(paramPicInfo), getContext());
    float f = 1.0F * SquareCornerTextImageView.PicInfo.a(paramPicInfo) / SquareCornerTextImageView.PicInfo.b(paramPicInfo);
    if ((SquareCornerTextImageView.PicInfo.a(paramPicInfo)) && ((f < 0.455D) || (f > 2.2D)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131428500));
    }
    for (;;)
    {
      if (SquareCornerTextImageView.PicInfo.b(paramPicInfo))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131428502));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView
 * JD-Core Version:    0.7.0.1
 */