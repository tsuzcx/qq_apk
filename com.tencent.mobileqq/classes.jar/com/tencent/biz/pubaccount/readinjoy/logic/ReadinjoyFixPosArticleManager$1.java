package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadinjoyFixPosArticleManager$1
  implements Runnable
{
  ReadinjoyFixPosArticleManager$1(ReadinjoyFixPosArticleManager paramReadinjoyFixPosArticleManager, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      if ((!ReadinjoyFixPosArticleManager.a(localBaseArticleInfo.mRecommendSeq)) && (!RIJDataFetchManager.a(localBaseArticleInfo))) {
        localArrayList.add(localBaseArticleInfo);
      }
    }
    RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_Int, localArrayList, localArrayList, 3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager.1
 * JD-Core Version:    0.7.0.1
 */