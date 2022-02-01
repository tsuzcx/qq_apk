package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.mobileqq.widget.AutoFitTextView.OnGetMaxWidthCallback;

public class RIJStaticChannelGridViewAdapter$ChannelItemViewHolder
  implements AutoFitTextView.OnGetMaxWidthCallback
{
  private final Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  AutoFitTextView jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView;
  
  public RIJStaticChannelGridViewAdapter$ChannelItemViewHolder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJStaticChannelGridViewAdapter.ChannelItemViewHolder
 * JD-Core Version:    0.7.0.1
 */