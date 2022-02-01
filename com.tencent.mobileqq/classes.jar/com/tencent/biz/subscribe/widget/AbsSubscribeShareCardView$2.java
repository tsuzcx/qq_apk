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
    localHttpNetReq.mReqUrl = ((String)this.b.get(this.jdField_a_of_type_Int));
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2
 * JD-Core Version:    0.7.0.1
 */