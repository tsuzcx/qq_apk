package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class SubscribePersonalDetailFragment$4
  implements Runnable
{
  SubscribePersonalDetailFragment$4(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveEvent  publishFeed.type.get()");
    ((StringBuilder)localObject).append(this.a.type.get());
    SLog.c("SubscribePersonalDetail", ((StringBuilder)localObject).toString());
    localObject = new ShareInfoBean();
    ((ShareInfoBean)localObject).f = (SubscribePersonalDetailFragment.g(this.this$0) ^ true);
    ((ShareInfoBean)localObject).a = 1;
    ((ShareInfoBean)localObject).b = this.a;
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = SubscribeLaucher.d(this.a.type.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveEvent  publishFeed.share.shortUrl");
    localStringBuilder.append(this.a.share.shorturl.get());
    SLog.c("SubscribePersonalDetail", localStringBuilder.toString());
    if (!TextUtils.isEmpty(this.a.share.shorturl.get()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveEvent  publishFeed.share.shortUrl");
      localStringBuilder.append(this.a.share.shorturl.get());
      SLog.c("SubscribePersonalDetail", localStringBuilder.toString());
    }
    ((ShareInfoBean)localObject).e = localExtraTypeInfo;
    ((ShareInfoBean)localObject).d = this.a.share;
    new SubscribeQRCodeShareHelper(this.this$0.getBaseActivity()).a((ShareInfoBean)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */