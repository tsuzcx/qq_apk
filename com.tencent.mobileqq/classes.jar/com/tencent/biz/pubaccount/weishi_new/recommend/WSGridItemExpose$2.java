package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WSGridItemExpose$2
  implements Runnable
{
  WSGridItemExpose$2(WSGridItemExpose paramWSGridItemExpose, int paramInt, List paramList, boolean paramBoolean) {}
  
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
        if (!WSGridItemExpose.a(this.this$0).containsKey(Integer.valueOf(i)))
        {
          WSGridItemExpose.a(this.this$0).put(Integer.valueOf(i), localstSimpleMetaFeed.id);
          WSLog.b("weishi-report", "put:" + i);
          localHashMap1.put(Integer.valueOf(i), localstSimpleMetaFeed);
          localHashMap2.put(Integer.valueOf(i), localstSimpleMetaFeed.id);
        }
        if (this.jdField_a_of_type_Boolean) {
          WSFallKeyPicMonitor.a(1, WeishiUtils.a(localstSimpleMetaFeed, true));
        }
      }
      i += 1;
    }
    WSGridItemExpose.a(this.this$0, localHashMap1, localHashMap2);
    WSGridItemExpose.a(localHashMap1, WSGridItemExpose.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridItemExpose.2
 * JD-Core Version:    0.7.0.1
 */