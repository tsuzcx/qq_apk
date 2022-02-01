package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import java.util.List;

class ReadInJoyUgcSearchTopicFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyUgcSearchTopicFragment$1(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    ReadInJoyUgcSearchTopicFragment.a(this.a, paramList, paramList1);
    RIJDeliverUGCReportUtil.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment.1
 * JD-Core Version:    0.7.0.1
 */