package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.HashMap;

public class PTSLiteTapEventDispatcher$Builder
{
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ArticleInfo> b;
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(HashMap<String, Integer> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  public PTSLiteTapEventDispatcher a()
  {
    PTSLiteTapEventDispatcher localPTSLiteTapEventDispatcher = new PTSLiteTapEventDispatcher(null);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.jdField_a_of_type_JavaUtilHashMap);
    PTSLiteTapEventDispatcher.b(localPTSLiteTapEventDispatcher, this.b);
    return localPTSLiteTapEventDispatcher;
  }
  
  public Builder b(HashMap<String, ArticleInfo> paramHashMap)
  {
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteTapEventDispatcher.Builder
 * JD-Core Version:    0.7.0.1
 */