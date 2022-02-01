package com.tencent.biz.pubaccount.weishi_new.data;

import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.BlockRecommendPersonRequest;
import com.tencent.biz.pubaccount.weishi_new.request.ChangeFollowRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSUserBusiness
{
  public static WSUserBusiness a()
  {
    return new WSUserBusiness();
  }
  
  private IWeishiServiceListener a(String paramString, int paramInt)
  {
    return new WSUserBusiness.2(this, paramInt, paramString);
  }
  
  private void b(String paramString, int paramInt)
  {
    FollowEvent localFollowEvent = new FollowEvent();
    localFollowEvent.setPersonId(paramString);
    if (paramInt == 1) {
      localFollowEvent.setIsFollow(1);
    }
    for (;;)
    {
      WSSimpleEventBus.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    WSLog.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new WeishiTask(new BlockRecommendPersonRequest(paramString), null, new WSUserBusiness.1(this), 4006);
    WeishiBusinessLooper.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    WSLog.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    b(paramString, paramInt);
    paramString = new WeishiTask(new ChangeFollowRequest(paramString, paramInt), null, a(paramString, paramInt), 4005);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness
 * JD-Core Version:    0.7.0.1
 */