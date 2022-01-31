package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.List;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import rix;
import rmr;
import rno;

public class FastWebActivity$28$1
  implements Runnable
{
  final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Rix.a);
  final FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Rix.a);
  
  public FastWebActivity$28$1(rix paramrix, long paramLong, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    FastWebActivity localFastWebActivity = this.jdField_a_of_type_Rix.a;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = onh.a(localFastWebActivity, localArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("open_speed", this.jdField_a_of_type_Long);
        rno.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8008997", ((JSONObject)localObject).toString());
        FastWebActivity.j(this.jdField_a_of_type_Rix.a);
        FastWebActivity.a(this.jdField_a_of_type_Rix.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        rno.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaUtilList);
        rmr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.28.1
 * JD-Core Version:    0.7.0.1
 */