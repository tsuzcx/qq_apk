package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import java.util.ArrayList;
import java.util.List;

public class FastWebRequestUtil$RecommendAndAd
{
  private FastWebRequestUtil.RecommendAndAdCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback;
  private final String jdField_a_of_type_JavaLangString;
  private List<BaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<BaseData> b = new ArrayList();
  
  public FastWebRequestUtil$RecommendAndAd(String paramString, FastWebRequestUtil.RecommendAndAdCallback paramRecommendAndAdCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback = paramRecommendAndAdCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<BaseData> paramList)
  {
    this.b = paramList;
    ReadInJoyAdLog.a("REPORT_LINK", "requestAdData adDatas callback");
    a();
  }
  
  public void b(List<BaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    ReadInJoyAdLog.a("REPORT_LINK", "requestAdData recommendDatas callback");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.RecommendAndAd
 * JD-Core Version:    0.7.0.1
 */