package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.HashMap;
import java.util.List;
import unt;
import uya;
import uyo;

class WSRecommendFragment$7
  implements Runnable
{
  WSRecommendFragment$7(WSRecommendFragment paramWSRecommendFragment, int paramInt, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!WSRecommendFragment.a(this.this$0).containsKey(Integer.valueOf(i)))
        {
          WSRecommendFragment.a(this.this$0).put(Integer.valueOf(i), localstSimpleMetaFeed.id);
          uya.b("weishi-report", "put:" + i);
          localHashMap1.put(Integer.valueOf(i), localstSimpleMetaFeed);
          localHashMap2.put(Integer.valueOf(i), localstSimpleMetaFeed.id);
        }
        if (this.jdField_a_of_type_Boolean) {
          unt.a(1, uyo.a(localstSimpleMetaFeed, true));
        }
      }
      i += 1;
    }
    WSRecommendFragment.a(this.this$0, localHashMap1, localHashMap2);
    WSPublicAccReport.getInstance().reportFallList(localHashMap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.7
 * JD-Core Version:    0.7.0.1
 */