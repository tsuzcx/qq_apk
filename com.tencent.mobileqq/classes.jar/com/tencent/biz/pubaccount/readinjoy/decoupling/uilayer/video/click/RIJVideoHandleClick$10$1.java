package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class RIJVideoHandleClick$10$1
  implements Runnable
{
  RIJVideoHandleClick$10$1(RIJVideoHandleClick.10 param10, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$10.a).a().b() == 56) {}
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID, localJSONObject), false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.10.1
 * JD-Core Version:    0.7.0.1
 */