package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.push.WSBasePushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.WSBaseStrategyInfo;

public abstract class WSBasePushBiz<MSG extends WSBasePushMsg, INFO extends WSBaseStrategyInfo>
{
  MSG a;
  
  public WSBasePushBiz(MSG paramMSG)
  {
    this.a = paramMSG;
  }
  
  public abstract boolean a(Context paramContext, INFO paramINFO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSBasePushBiz
 * JD-Core Version:    0.7.0.1
 */