package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import java.util.ArrayList;
import java.util.List;

public class FastWebRequestUtil$RecommendAndAd
{
  private FastWebRequestUtil.RecommendAndAdCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback;
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private List b = new ArrayList();
  
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
  
  public void a(List paramList)
  {
    this.b = paramList;
    a();
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.RecommendAndAd
 * JD-Core Version:    0.7.0.1
 */