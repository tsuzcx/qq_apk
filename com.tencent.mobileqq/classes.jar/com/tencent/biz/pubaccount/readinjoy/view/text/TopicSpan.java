package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import tnq;
import tns;
import tnz;

public class TopicSpan
  extends ForegroundColorSpan
  implements tnq, tns
{
  private final TopicInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo;
  private tnz jdField_a_of_type_Tnz;
  
  public TopicSpan(int paramInt, TopicInfo paramTopicInfo, tnz paramtnz)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo = paramTopicInfo;
    this.jdField_a_of_type_Tnz = paramtnz;
  }
  
  public TopicSpan(TopicInfo paramTopicInfo)
  {
    super(-15504151);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo = paramTopicInfo;
  }
  
  public TopicInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tnz != null) {
      this.jdField_a_of_type_Tnz.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */