package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.AccountDetail.bean.PictureAttr;
import com.tencent.biz.pubaccount.AccountDetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class AccountDetailBaseAdapter$14
  implements Runnable
{
  AccountDetailBaseAdapter$14(AccountDetailBaseAdapter paramAccountDetailBaseAdapter, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label38:
    label80:
    label232:
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
        for (;;)
        {
          j += 1;
          break label38;
          i = this.jdField_a_of_type_JavaUtilList.size();
          break label25;
          if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            DynamicInfo localDynamicInfo = (DynamicInfo)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localDynamicInfo == null) {
              continue;
            }
            if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr == null) {
              continue;
            }
            if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.e != 1) {
              break label201;
            }
            localLinkedList.add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d), ReadInJoyDisplayUtils.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localException.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString), ReadInJoyDisplayUtils.a()));
            continue;
            if (localException.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr != null) {
              if (localException.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr.jdField_a_of_type_Int == 1) {
                localLinkedList.add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localException.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr.b), ReadInJoyDisplayUtils.e()));
              } else {
                localLinkedList.add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localException.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr.jdField_a_of_type_JavaLangString), ReadInJoyDisplayUtils.a()));
              }
            }
          }
        }
      } while (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        AccountDetailBaseAdapter.PreloadImgInfo localPreloadImgInfo = (AccountDetailBaseAdapter.PreloadImgInfo)localIterator.next();
        if ((localPreloadImgInfo != null) && (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null))
        {
          ImageRequest localImageRequest = new ImageRequest();
          localImageRequest.jdField_a_of_type_JavaNetURL = localPreloadImgInfo.jdField_a_of_type_JavaNetURL;
          localImageRequest.jdField_a_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localImageRequest.jdField_b_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.second).intValue();
          ImageManager.a().a(localImageRequest, null);
        }
      }
    } while (!QLog.isColorLevel());
    label201:
    QLog.d("AccountDetailBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */