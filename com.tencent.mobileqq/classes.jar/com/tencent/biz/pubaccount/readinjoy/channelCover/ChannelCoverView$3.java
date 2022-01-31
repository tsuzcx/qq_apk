package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import ndn;
import new;
import obz;
import org.json.JSONObject;
import qmv;

public final class ChannelCoverView$3
  implements Runnable
{
  public ChannelCoverView$3(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    str = "";
    try
    {
      localObject = new JSONObject();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) {
        ((JSONObject)localObject).put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId);
      }
      ((JSONObject)localObject).put("network_type", new.a());
      ((JSONObject)localObject).put("version", new.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("imei", obz.f());
      ((JSONObject)localObject).put("imsi", obz.g());
      ((JSONObject)localObject).put("kandian_mode_new", new.a());
      ((JSONObject)localObject).put("kandian_mode", obz.e());
      ((JSONObject)localObject).put("entrance", qmv.a(this.jdField_a_of_type_Int));
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
          localObject = str;
        }
      }
    }
    ndn.a(null, "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, this.b, this.c, this.d, (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.3
 * JD-Core Version:    0.7.0.1
 */