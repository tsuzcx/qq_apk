package com.tencent.biz.pubaccount.readinjoy.biu;

import com.tencent.biz.pubaccount.readinjoy.model.RIJUserApproveModule.UserApproveCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

class RIJNewBiuCardTransformManager$1
  implements RIJUserApproveModule.UserApproveCallback
{
  RIJNewBiuCardTransformManager$1(RIJNewBiuCardTransformManager paramRIJNewBiuCardTransformManager) {}
  
  public void a(int paramInt)
  {
    if ((RIJNewBiuCardTransformManager.a(this.a) != null) && (RIJNewBiuCardTransformManager.a(this.a).a != null))
    {
      if (RIJNewBiuCardTransformManager.a(this.a).a.mSocialFeedInfo == null) {
        RIJNewBiuCardTransformManager.a(this.a).a.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      RIJNewBiuCardTransformManager.a(this.a).a.mSocialFeedInfo.a.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager.1
 * JD-Core Version:    0.7.0.1
 */