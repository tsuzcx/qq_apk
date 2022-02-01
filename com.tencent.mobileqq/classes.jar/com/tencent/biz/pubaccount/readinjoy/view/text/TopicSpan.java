package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import swi;
import swk;
import swr;

public class TopicSpan
  extends ForegroundColorSpan
  implements swi, swk
{
  private final TopicInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo;
  private swr jdField_a_of_type_Swr;
  
  public TopicSpan(int paramInt, TopicInfo paramTopicInfo, swr paramswr)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo = paramTopicInfo;
    this.jdField_a_of_type_Swr = paramswr;
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
    if (this.jdField_a_of_type_Swr != null) {
      this.jdField_a_of_type_Swr.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */