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
import orc;
import rxv;

public class SquareCornerTextImageView
  extends FrameLayout
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public boolean a;
  TextView b;
  
  public SquareCornerTextImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559963, null);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378863));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidViewView, paramContext);
  }
  
  public void a(@NonNull rxv paramrxv)
  {
    orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, rxv.a(paramrxv), getContext());
    float f = 1.0F * rxv.a(paramrxv) / rxv.b(paramrxv);
    if ((rxv.a(paramrxv)) && ((f < 0.455D) || (f > 2.2D)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131719056));
    }
    for (;;)
    {
      if (rxv.b(paramrxv))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131719055));
      }
      if ((!rxv.c(paramrxv)) || (TextUtils.isEmpty(rxv.a(paramrxv)))) {
        break;
      }
      this.b.setText(rxv.a(paramrxv));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView
 * JD-Core Version:    0.7.0.1
 */