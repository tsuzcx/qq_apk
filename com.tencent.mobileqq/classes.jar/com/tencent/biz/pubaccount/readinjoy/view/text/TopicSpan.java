package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;

public class TopicSpan
  extends ForegroundColorSpan
  implements DeleteAsAWholeSpan, ISpan
{
  private final TopicInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo;
  private TopicSpan.DeletedCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewTextTopicSpan$DeletedCallback;
  
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewTextTopicSpan$DeletedCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewTextTopicSpan$DeletedCallback.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */