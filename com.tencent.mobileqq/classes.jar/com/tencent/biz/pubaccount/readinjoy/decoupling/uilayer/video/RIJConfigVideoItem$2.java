package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.TextView;
import com.huawei.hms.common.internal.Objects;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;

final class RIJConfigVideoItem$2
  implements ValueCallback<Integer>
{
  RIJConfigVideoItem$2(VideoFeedsViewHolder paramVideoFeedsViewHolder, RIJDataManager paramRIJDataManager) {}
  
  public void a(Integer paramInteger)
  {
    if (Objects.equal(paramInteger, Integer.valueOf(5))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderVideoFeedsViewHolder.i.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().getString(2131693442));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.2
 * JD-Core Version:    0.7.0.1
 */