package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSExpPolicyManager$2
  implements IGetExperimentListener
{
  WSExpPolicyManager$2(WSExpPolicyManager paramWSExpPolicyManager) {}
  
  public void a(int paramInt, String paramString)
  {
    WSLog.d("WSExpPolicyManager", "[WSExpPolicyManager.java][onGetExperimentFailed] errorCode:" + paramInt + ", errMsg:" + paramString);
  }
  
  public void a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    WSLog.e("WSExpPolicyManager", "[WSExpPolicyManager.java][fetchExpDataFromService]");
    WSExpPolicyManager.a(this.a, paramWSExpPolicyEntities);
    WSExpFileCacheUtils.a(paramWSExpPolicyEntities);
    WSExpPolicyManager.b(this.a, paramWSExpPolicyEntities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager.2
 * JD-Core Version:    0.7.0.1
 */