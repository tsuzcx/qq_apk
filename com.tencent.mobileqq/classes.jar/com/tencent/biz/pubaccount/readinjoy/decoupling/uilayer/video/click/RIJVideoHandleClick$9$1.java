package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import odq;
import ofe;
import org.json.JSONException;
import org.json.JSONObject;
import ped;
import peg;
import phl;
import phx;

public class RIJVideoHandleClick$9$1
  implements Runnable
{
  public RIJVideoHandleClick$9$1(phx paramphx, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (phl.a(this.jdField_a_of_type_Phx.a).a().b() == 56) {}
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID);
        odq.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", ofe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID, localJSONObject), false);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.9.1
 * JD-Core Version:    0.7.0.1
 */