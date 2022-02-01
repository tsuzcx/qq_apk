package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

class RIJPreloadImage$1
  implements Runnable
{
  RIJPreloadImage$1(RIJPreloadImage paramRIJPreloadImage, long paramLong1, List paramList, int paramInt1, int paramInt2, RIJDataManager paramRIJDataManager, long paramLong2) {}
  
  public void run()
  {
    if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label38:
    label80:
    do
    {
      do
      {
        return;
        int i;
        int j;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.jdField_a_of_type_Int;
          if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
            continue;
          }
          if ((j < i) && (j >= 0)) {
            break label80;
          }
        }
        do
        {
          for (;;)
          {
            j += 1;
            break label38;
            i = this.jdField_a_of_type_JavaUtilList.size();
            break label25;
            if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {
              break;
            }
            try
            {
              BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(j);
              this.this$0.a(localLinkedList, j, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (RIJPreloadImage.a(this.this$0) == this.jdField_a_of_type_Long);
        return;
      } while (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long);
      RIJPreloadImage.a(this.this$0, localLinkedList);
    } while (!QLog.isColorLevel());
    QLog.d("RIJPreloadImage", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage.1
 * JD-Core Version:    0.7.0.1
 */