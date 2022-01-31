package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.HashMap;
import rzu;
import sam;

class WSRecommendFragment$7
  implements Runnable
{
  WSRecommendFragment$7(WSRecommendFragment paramWSRecommendFragment, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    if (!WSRecommendFragment.a(this.this$0).containsKey(Integer.valueOf(this.jdField_a_of_type_Int)))
    {
      WSRecommendFragment.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
      stReportItem localstReportItem = rzu.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Int);
      WSPublicAccReport.getInstance().feedsItemReport("gzh_exposure", sam.a(1), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, localstReportItem, 0);
      WSRecommendFragment.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      WSRecommendFragment.c(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
      if (WSRecommendFragment.b(this.this$0).size() == 8)
      {
        WSRecommendFragment.a(this.this$0, WSRecommendFragment.b(this.this$0), WSRecommendFragment.c(this.this$0));
        WSRecommendFragment.b(this.this$0).clear();
        WSRecommendFragment.c(this.this$0).clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.7
 * JD-Core Version:    0.7.0.1
 */