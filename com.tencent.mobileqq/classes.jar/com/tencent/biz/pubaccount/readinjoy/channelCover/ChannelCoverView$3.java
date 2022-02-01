package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import olh;
import org.json.JSONObject;
import oxo;
import pkh;
import plh;
import prp;
import pvj;
import qez;

public final class ChannelCoverView$3
  implements Runnable
{
  public ChannelCoverView$3(ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    int i = 1;
    str = "";
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", prp.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) {
          ((JSONObject)localObject1).put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId);
        }
        ((JSONObject)localObject1).put("current_channel_id", 0);
        if (NetworkState.isWifiConn()) {
          i = 2;
        }
        ((JSONObject)localObject1).put("network_type", i);
        if (this.jdField_a_of_type_Int != oxo.jdField_a_of_type_Int) {
          continue;
        }
        ((JSONObject)localObject1).put("channel_type", "2");
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mColumnType != 0)) {
          continue;
        }
        ((JSONObject)localObject1).put("content_type", 1);
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1 = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
        localObject1 = str;
        continue;
        ((JSONObject)localObject1).put("content_type", 2);
        continue;
        ((JSONObject)localObject1).put("channelid_to_mainfeeds", 0);
        continue;
      }
      if (this.b != -1) {
        ((JSONObject)localObject1).put("reddot_status", this.b);
      }
      if (this.c != -1) {
        ((JSONObject)localObject1).put("location", this.c + 1);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) {
        ((JSONObject)localObject1).put("is_change", plh.a(pkh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId));
      }
      ((JSONObject)localObject1).put("style", 0);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId == 41695))
      {
        localObject2 = pvj.a().a();
        if (localObject2 != null)
        {
          localObject2 = ((SelectPositionModule)localObject2).a();
          if (localObject2 != null)
          {
            ((JSONObject)localObject1).put("channel_city", ((SelectPositionModule.PositionData)localObject2).city);
            if (QLog.isColorLevel()) {
              QLog.i("ChannelCoverView", 2, "reportRecommendEvent CHANNEL_ID_LOCAL r5Str = " + localObject1);
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null)
      {
        if ((qez.a() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId) || (qez.a() == 0)) {
          continue;
        }
        ((JSONObject)localObject1).put("channelid_to_mainfeeds", 1);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "reportRecommendEvent actionName =" + this.jdField_a_of_type_JavaLangString + "; reportString = " + (String)localObject1);
      }
      olh.a(null, "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", (String)localObject1, false);
      return;
      if (this.jdField_a_of_type_Int == oxo.b) {
        ((JSONObject)localObject1).put("channel_type", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.3
 * JD-Core Version:    0.7.0.1
 */