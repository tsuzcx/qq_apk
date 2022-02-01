package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;

class WSFollowPlayerStatusListenerImpl$1
  implements Runnable
{
  WSFollowPlayerStatusListenerImpl$1(WSFollowPlayerStatusListenerImpl paramWSFollowPlayerStatusListenerImpl, WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void run()
  {
    WSFollowBeaconReport.a(this.a, this.b);
    WSReportDc00898.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPlayerStatusListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */