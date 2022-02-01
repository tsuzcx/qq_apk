package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.presseffect.PressEffectSelectorDrawable;

class ReadInJoyPicWaterFallFragment$NormalViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HeadImageWithRing jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  
  ReadInJoyPicWaterFallFragment$NormalViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379134);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365396));
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372388);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372386));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372372));
    this.e = ((TextView)paramView.findViewById(2131372392));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131372273));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing = ((HeadImageWithRing)paramView.findViewById(2131369350));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setAttrs(AIOUtils.a(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setDrawRing(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setCorner(AIOUtils.a(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370362));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380511));
    this.d = ((TextView)paramView.findViewById(2131379713));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379704);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379703));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.2(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.3(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder
 * JD-Core Version:    0.7.0.1
 */