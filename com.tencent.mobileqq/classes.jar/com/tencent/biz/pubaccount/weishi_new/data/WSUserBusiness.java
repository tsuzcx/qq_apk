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
  
  private void b(String paramString, int paramInt)
  {
    FollowEvent localFollowEvent = new FollowEvent();
    localFollowEvent.setPersonId(paramString);
    if (paramInt == 1) {
      localFollowEvent.setIsFollow(1);
    } else {
      localFollowEvent.setIsFollow(2);
    }
    WSSimpleEventBus.a().a(localFollowEvent);
  }
  
  private IWeishiServiceListener c(String paramString, int paramInt)
  {
    return new WSUserBusiness.2(this, paramInt, paramString);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[actionBlockRecommendPerson] personID : ");
    localStringBuilder.append(paramString);
    WSLog.b("WSUserBusiness", localStringBuilder.toString());
    paramString = new WeishiTask(new BlockRecommendPersonRequest(paramString), null, new WSUserBusiness.1(this), 4006);
    WeishiBusinessLooper.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[actionChangeFollow] personID : ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("  followStatus:");
    localStringBuilder.append(paramInt);
    WSLog.b("WSUserBusiness", localStringBuilder.toString());
    b(paramString, paramInt);
    paramString = new WeishiTask(new ChangeFollowRequest(paramString, paramInt), null, c(paramString, paramInt), 4005);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness
 * JD-Core Version:    0.7.0.1
 */