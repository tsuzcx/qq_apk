package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import obj;
import qvs;

public class SquareCornerTextImageView
  extends FrameLayout
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView b;
  
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
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131494297, null);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312453));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidViewView, paramContext);
  }
  
  public void a(@NonNull qvs paramqvs)
  {
    obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, qvs.a(paramqvs), getContext());
    float f = 1.0F * qvs.a(paramqvs) / qvs.b(paramqvs);
    if ((qvs.a(paramqvs)) && ((f < 0.455D) || (f > 2.2D)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131652760));
    }
    for (;;)
    {
      if (qvs.b(paramqvs))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131652759));
      }
      if ((!qvs.c(paramqvs)) || (TextUtils.isEmpty(qvs.a(paramqvs)))) {
        break;
      }
      this.b.setText(qvs.a(paramqvs));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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