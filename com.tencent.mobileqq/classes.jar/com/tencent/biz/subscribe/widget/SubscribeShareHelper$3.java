package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class SubscribeShareHelper$3
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDelFeedRsp>
{
  SubscribeShareHelper$3(SubscribeShareHelper paramSubscribeShareHelper) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(SubscribeShareHelper.a(this.a).a.id.get(), 3));
      this.a.a.finish();
      QQToast.a(this.a.a, HardCodeUtil.a(2131714442), 0).a();
      return;
    }
    QQToast.a(this.a.a, 1, HardCodeUtil.a(2131714446), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */