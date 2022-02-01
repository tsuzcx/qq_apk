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
    if (!(paramWeishiTask.a instanceof stBlockRecommPersonRsp)) {
      WSLog.b("WSUserBusiness", "[actionBlockRecommendPerson] data error: " + paramWeishiTask.a);
    }
    do
    {
      return;
      paramWeishiTask = (stBlockRecommPersonRsp)paramWeishiTask.a;
    } while (paramWeishiTask == null);
    WSLog.b("WSUserBusiness", "[actionBlockRecommendPerson] data success resultBean.ret:" + paramWeishiTask.ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness.1
 * JD-Core Version:    0.7.0.1
 */