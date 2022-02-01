package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stUserConfigRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

final class WSUserAuthDialog$1
  implements IWeishiServiceListener
{
  public void a(WeishiTask paramWeishiTask)
  {
    if (paramWeishiTask.a())
    {
      if ((paramWeishiTask.a instanceof stUserConfigRsp))
      {
        paramWeishiTask = (stUserConfigRsp)paramWeishiTask.a;
        WSLog.a("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramWeishiTask.code);
        return;
      }
      WSLog.a("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    WSLog.a("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.1
 * JD-Core Version:    0.7.0.1
 */