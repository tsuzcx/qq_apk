package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stBlockRecommPersonRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSUserBusiness$1
  implements IWeishiServiceListener
{
  WSUserBusiness$1(WSUserBusiness paramWSUserBusiness) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    StringBuilder localStringBuilder;
    if (!(paramWeishiTask.a instanceof stBlockRecommPersonRsp))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[actionBlockRecommendPerson] data error: ");
      localStringBuilder.append(paramWeishiTask.a);
      WSLog.b("WSUserBusiness", localStringBuilder.toString());
      return;
    }
    paramWeishiTask = (stBlockRecommPersonRsp)paramWeishiTask.a;
    if (paramWeishiTask != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[actionBlockRecommendPerson] data success resultBean.ret:");
      localStringBuilder.append(paramWeishiTask.ret);
      WSLog.b("WSUserBusiness", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness.1
 * JD-Core Version:    0.7.0.1
 */