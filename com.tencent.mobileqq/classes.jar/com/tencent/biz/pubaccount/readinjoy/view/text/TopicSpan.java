package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import tai;
import tak;
import tar;

public class TopicSpan
  extends ForegroundColorSpan
  implements tai, tak
{
  private final TopicInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo;
  private tar jdField_a_of_type_Tar;
  
  public TopicSpan(int paramInt, TopicInfo paramTopicInfo, tar paramtar)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicInfo = paramTopicInfo;
    this.jdField_a_of_type_Tar = paramtar;
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
    if (this.jdField_a_of_type_Tar != null) {
      this.jdField_a_of_type_Tar.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */