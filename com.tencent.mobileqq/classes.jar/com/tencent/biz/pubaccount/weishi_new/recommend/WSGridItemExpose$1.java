package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import java.util.Map;

class WSGridItemExpose$1
  implements Runnable
{
  WSGridItemExpose$1(WSGridItemExpose paramWSGridItemExpose, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    if (!WSGridItemExpose.a(this.this$0).containsKey(Integer.valueOf(this.jdField_a_of_type_Int)))
    {
      WSGridItemExpose.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
      stReportItem localstReportItem = UserActionReportPresenter.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_type == 9)
      {
        WSGridItemExpose.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Int, WSGridItemExpose.a(this.this$0));
        return;
      }
      WSGridItemExpose.a(this.this$0, localstReportItem, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridItemExpose.1
 * JD-Core Version:    0.7.0.1
 */