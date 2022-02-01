package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class WeishiGridTwoItemViewHolder
  extends ViewHolder
{
  public TextView a;
  public BaseArticleInfo a;
  public KandianUrlImageView a;
  public TextView b;
  public BaseArticleInfo b;
  public KandianUrlImageView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  
  public WeishiGridTwoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560504, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368055));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370301));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370306));
    this.c = ((TextView)paramViewGroup.findViewById(2131370276));
    this.d = ((TextView)paramViewGroup.findViewById(2131370300));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368057));
    this.e = ((TextView)paramViewGroup.findViewById(2131377106));
    this.f = ((TextView)paramViewGroup.findViewById(2131377112));
    this.g = ((TextView)paramViewGroup.findViewById(2131377085));
    this.h = ((TextView)paramViewGroup.findViewById(2131377105));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.WeishiGridTwoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */