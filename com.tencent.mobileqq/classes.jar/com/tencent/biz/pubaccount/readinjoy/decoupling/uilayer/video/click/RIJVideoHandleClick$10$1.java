package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import olh;
import omx;
import org.json.JSONException;
import org.json.JSONObject;
import pne;
import pnh;
import psf;
import psg;

public class RIJVideoHandleClick$10$1
  implements Runnable
{
  public RIJVideoHandleClick$10$1(psg parampsg, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (psf.a(this.jdField_a_of_type_Psg.a).a().b() == 56) {}
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID);
        olh.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", omx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID, localJSONObject), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.10.1
 * JD-Core Version:    0.7.0.1
 */