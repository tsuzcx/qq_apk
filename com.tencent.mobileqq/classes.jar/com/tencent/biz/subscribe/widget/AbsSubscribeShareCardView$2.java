package com.tencent.biz.subscribe.widget;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;

class AbsSubscribeShareCardView$2
  implements Runnable
{
  AbsSubscribeShareCardView$2(AbsSubscribeShareCardView paramAbsSubscribeShareCardView, ArrayList paramArrayList1, int paramInt, String paramString, ArrayList paramArrayList2, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AbsSubscribeShareCardView.2.1(this);
    localHttpNetReq.mReqUrl = ((String)this.d.get(this.b));
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.c;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.k().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2
 * JD-Core Version:    0.7.0.1
 */