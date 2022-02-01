package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ReadInJoyTopicListAdapter;
import java.util.List;

class ReadInJoyTopicSelectionFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyTopicSelectionFragment$1(ReadInJoyTopicSelectionFragment paramReadInJoyTopicSelectionFragment) {}
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    if (paramList.size() == 0)
    {
      ReadInJoyTopicSelectionFragment.a(this.a).clear();
      ReadInJoyTopicSelectionFragment.a(this.a).addAll(paramList1);
      this.a.a.clear();
      this.a.a.addAll(ReadInJoyTopicSelectionFragment.a(paramList1));
      ReadInJoyTopicSelectionFragment.a(this.a).notifyDataSetChanged();
      ReadInJoyUtils.a(ReadInJoyTopicSelectionFragment.a(this.a), ReadInJoyTopicSelectionFragment.a(this.a), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment.1
 * JD-Core Version:    0.7.0.1
 */