package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInJoyPicWaterFallFragment$ActiveViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  ReadInJoyPicWaterFallFragment$ActiveViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.b = ((URLImageView)paramView.findViewById(2131365396));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362706));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    AIOUtils.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362008));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.ActiveViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */