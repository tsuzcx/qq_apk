package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ocd;
import odr;
import org.json.JSONException;
import org.json.JSONObject;
import sel;
import sfh;

public class ReadInJoyBaseAdapter$29$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$1(sfh paramsfh, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sfh.a.c == 56) {}
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID);
        ocd.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", odr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID, localJSONObject), false);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.1
 * JD-Core Version:    0.7.0.1
 */