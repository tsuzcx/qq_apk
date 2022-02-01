package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.HardCodeUtil;

public class WebFastLikeDislikeCreator
  implements ItemCreator
{
  public static final String a;
  private static String b = "WebFastLikeDislikeCreator";
  private WebFastLikeDislikeCreator.ViewHolder a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716710);
  }
  
  public int a(BaseData paramBaseData)
  {
    return 19;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastLikeDislikeCreator$ViewHolder = new WebFastLikeDislikeCreator.ViewHolder(this, paramContext, LayoutInflater.from(paramContext).inflate(2131560298, null), paramBaseData);
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastLikeDislikeCreator$ViewHolder;
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.s == 21;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator
 * JD-Core Version:    0.7.0.1
 */