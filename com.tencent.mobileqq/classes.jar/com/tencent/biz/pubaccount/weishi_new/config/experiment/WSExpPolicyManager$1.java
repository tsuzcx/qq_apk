package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WSExpPolicyManager$1
  implements Runnable
{
  WSExpPolicyManager$1(WSExpPolicyManager paramWSExpPolicyManager) {}
  
  public void run()
  {
    WSLog.e("WSExpPolicyManager", "[WSExpPolicyManager.java][asyncReadExpDataFromFile]");
    WSExpPolicyEntities localWSExpPolicyEntities = WSExpFileCacheUtils.a(WeishiUtils.a());
    WSExpPolicyManager.a(this.this$0, localWSExpPolicyEntities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager.1
 * JD-Core Version:    0.7.0.1
 */