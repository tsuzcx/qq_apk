package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class ReadInJoyPicWaterFallFragment$NormalViewHolder$1
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$NormalViewHolder$1(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidContentContext, (String)localObject);
      localObject = GalleryReportedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.a(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      ((JSONObject)localObject).put("card_type", 8);
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localReportData.e = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localReportData.f = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localReportData.g = ((JSONObject)localObject).toString();
      localReportData.a = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localReportData.b = "0X8008E2F";
      localReportData.c = "0X8008E2F";
      GalleryReportedUtils.a(localReportData);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.1
 * JD-Core Version:    0.7.0.1
 */