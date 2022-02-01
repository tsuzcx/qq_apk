package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$BiuObserver
  extends ReadInJoyObserver
{
  final String a;
  final int b;
  
  public PublicAccountH5AbilityPluginImpl$BiuObserver(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    super.a(paramLong, paramInt, paramString);
    paramString = new StringBuilder();
    paramString.append("[onBiuResult] ");
    paramString.append(paramLong);
    paramString.append(" ");
    paramString.append(paramInt);
    paramString.append(" errorMsg");
    QLog.d("PublicAccountH5AbilityPlugin", 2, paramString.toString());
    try
    {
      paramString = new JSONObject();
      paramString.put("feedsId", String.valueOf(paramLong));
      paramString.put("retCode", paramInt);
      paramString.put("feedsType", this.b);
      this.c.callJs(this.a, new String[] { paramString.toString() });
      ThreadManager.getUIHandler().post(new PublicAccountH5AbilityPluginImpl.BiuObserver.1(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PublicAccountH5AbilityPlugin", 1, "[onBiuResult] ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.BiuObserver
 * JD-Core Version:    0.7.0.1
 */