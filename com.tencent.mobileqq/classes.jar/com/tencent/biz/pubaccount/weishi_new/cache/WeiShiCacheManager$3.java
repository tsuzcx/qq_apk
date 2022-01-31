package com.tencent.biz.pubaccount.weishi_new.cache;

import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import sjv;
import snf;

public class WeiShiCacheManager$3
  implements Runnable
{
  public WeiShiCacheManager$3(sjv paramsjv, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= sjv.a(this.this$0))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > sjv.a(this.this$0)) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        int j = i - sjv.a(this.this$0);
        while (j < i)
        {
          localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
          j += 1;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > 0) {
          i = sjv.a(this.this$0);
        }
      }
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (sjv.a(this.this$0, localArrayList, sjv.a(this.this$0))) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", snf.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3
 * JD-Core Version:    0.7.0.1
 */