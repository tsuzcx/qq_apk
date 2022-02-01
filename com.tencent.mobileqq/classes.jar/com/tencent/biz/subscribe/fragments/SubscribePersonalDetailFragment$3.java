package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;

class SubscribePersonalDetailFragment$3
  implements OnTaskListener<Object>
{
  SubscribePersonalDetailFragment$3(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      VSDispatchObserver.onVSRspCallBack localonVSRspCallBack = this.a;
      if (localonVSRspCallBack != null) {
        localonVSRspCallBack.onReceive(null, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (CertifiedAccountRead.StGetMainPageRsp)paramVarArgs[3]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */