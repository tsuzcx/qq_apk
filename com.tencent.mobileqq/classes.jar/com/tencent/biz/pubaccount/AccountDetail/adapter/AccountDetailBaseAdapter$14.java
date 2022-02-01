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
    if (AccountDetailBaseAdapter.c(this.this$0) != this.a) {
      return;
    }
    Object localObject1 = this.b;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((List)localObject1).size();
    }
    localObject1 = new LinkedList();
    int j = this.c;
    while (j < this.c + this.d)
    {
      if ((j < i) && (j >= 0))
      {
        if (AccountDetailBaseAdapter.c(this.this$0) != this.a) {
          return;
        }
        try
        {
          DynamicInfo localDynamicInfo = (DynamicInfo)this.b.get(j);
          if (localDynamicInfo != null) {
            if (localDynamicInfo.d.d == 2)
            {
              if (localDynamicInfo.f != null) {
                if (localDynamicInfo.f.h == 1) {
                  ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.f.i), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
                } else {
                  ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.f.b), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
                }
              }
            }
            else if (localDynamicInfo.e != null) {
              if (localDynamicInfo.e.b == 1) {
                ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.e.c), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
              } else {
                ((List)localObject1).add(AccountDetailBaseAdapter.PreloadImgInfo.a(new URL(localDynamicInfo.e.a), ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (AccountDetailBaseAdapter.c(this.this$0) != this.a) {
            return;
          }
        }
      }
      j += 1;
    }
    if (AccountDetailBaseAdapter.c(this.this$0) != this.a) {
      return;
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AccountDetailBaseAdapter.PreloadImgInfo localPreloadImgInfo = (AccountDetailBaseAdapter.PreloadImgInfo)((Iterator)localObject2).next();
      if ((localPreloadImgInfo != null) && (localPreloadImgInfo.a != null))
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.a = localPreloadImgInfo.a;
        localImageRequest.b = ((Integer)localPreloadImgInfo.b.first).intValue();
        localImageRequest.c = ((Integer)localPreloadImgInfo.b.second).intValue();
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, null);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preloadImg size:");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append(" cost:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.e);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */