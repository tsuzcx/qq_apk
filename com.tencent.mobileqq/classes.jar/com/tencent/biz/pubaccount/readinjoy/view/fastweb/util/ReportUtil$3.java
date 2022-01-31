package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import sdn;

public final class ReportUtil$3
  implements Runnable
{
  public ReportUtil$3(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong) {}
  
  public void run()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = ors.a(localContext, localArticleInfo, i, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("sojourn_time", this.jdField_a_of_type_Long);
        sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800A854", ((JSONObject)localObject).toString());
        return;
        localObject = "1";
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3
 * JD-Core Version:    0.7.0.1
 */