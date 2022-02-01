package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stFollowRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.open.base.ToastUtil;

class WSUserBusiness$2
  implements IWeishiServiceListener
{
  WSUserBusiness$2(WSUserBusiness paramWSUserBusiness, int paramInt, String paramString) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if (!(paramWeishiTask.m instanceof stFollowRsp))
    {
      if (this.a == 2) {
        WSUserBusiness.a(this.c, this.b, 1);
      } else {
        WSUserBusiness.a(this.c, this.b, 2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getServiceListenerWrapper] data error: ");
      localStringBuilder.append(paramWeishiTask.m);
      WSLog.b("WSUserBusiness", localStringBuilder.toString());
      return;
    }
    int i = ((stFollowRsp)paramWeishiTask.m).isFollow;
    paramWeishiTask = new StringBuilder();
    paramWeishiTask.append("[getServiceListenerWrapper] isFollow : ");
    paramWeishiTask.append(i);
    WSLog.b("WSUserBusiness", paramWeishiTask.toString());
    if (this.a == 1)
    {
      if (i == 1)
      {
        ToastUtil.a().a(2131918109);
        return;
      }
      ToastUtil.a().a(2131918107);
      WSUserBusiness.a(this.c, this.b, 2);
      return;
    }
    if (i == 0)
    {
      ToastUtil.a().a(2131918111);
      return;
    }
    ToastUtil.a().a(2131918112);
    WSUserBusiness.a(this.c, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness.2
 * JD-Core Version:    0.7.0.1
 */