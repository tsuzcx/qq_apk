package com.tencent.biz.pubaccount.weishi_new.cache;

import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import rxc;
import sam;

public class WeiShiCacheManager$3
  implements Runnable
{
  public WeiShiCacheManager$3(rxc paramrxc, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= rxc.a(this.this$0))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > rxc.a(this.this$0)) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        int j = i - rxc.a(this.this$0);
        while (j < i)
        {
          localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
          j += 1;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > 0) {
          i = rxc.a(this.this$0);
        }
      }
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (rxc.a(this.this$0, localArrayList, rxc.a(this.this$0))) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", sam.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3
 * JD-Core Version:    0.7.0.1
 */