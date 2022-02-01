package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.util.Pair;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.PictureAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((List)localObject1).size();
    }
    localObject1 = new LinkedList();
    int j = this.jdField_a_of_type_Int;
    while (j < this.jdField_a_of_type_Int + this.jdField_b_of_type_Int)
    {
      if ((j < i) && (j >= 0))
      {
        if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {
          return;
        }
        try
        {
          DynamicInfo localDynamicInfo = (DynamicInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if (localDynamicInfo != null) {
            if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int == 2)
            {
              if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr != null) {
                if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.e == 1) {
                  ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.d), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
                } else {
                  ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
                }
              }
            }
            else if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr != null) {
              if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_Int == 1) {
                ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.b), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
              } else {
                ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_JavaLangString), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {
            return;
          }
        }
      }
      j += 1;
    }
    if (AccountDetailBaseAdapter.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AccountDetailBaseAdapter.PreloadImgInfo localPreloadImgInfo = (AccountDetailBaseAdapter.PreloadImgInfo)((Iterator)localObject2).next();
      if ((localPreloadImgInfo != null) && (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null))
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.jdField_a_of_type_JavaNetURL = localPreloadImgInfo.jdField_a_of_type_JavaNetURL;
        localImageRequest.jdField_a_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.first).intValue();
        localImageRequest.jdField_b_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.second).intValue();
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, null);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preloadImg size:");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append(" cost:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */