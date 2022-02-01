package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountObserver
  extends QRouteApi
{
  public static final int TYPE_ACCOUNT_DETAIL_DYNAMIC_LIST = 107;
  public static final int TYPE_ACCOUNT_DETAIL_FUNCTION_FLAG = 109;
  public static final int TYPE_DOWN_PUBLIC_ACCOUNT = 103;
  public static final int TYPE_FOLLOW_PUBLIC_ACCOUNT = 101;
  public static final int TYPE_GET_GUIDE_FRIENDS = 110;
  public static final int TYPE_GET_HISTORY_MESSAGE = 105;
  public static final int TYPE_GET_PUBLIC_NOTIFICATION = 106;
  public static final int TYPE_GET_RECOMMEND_LIST = 104;
  public static final int TYPE_GET_SUBSCRIBE_STATUS = 111;
  public static final int TYPE_GET_USER_FOLLOW_LIST = 100;
  public static final int TYPE_SET_KANDIAN_SUBSCRIBE = 108;
  public static final int TYPE_SET_RECVMSG_STATUS = 112;
  public static final int TYPE_UNFOLLOW_PUBLIC_ACCOUNT = 102;
  
  public abstract BusinessObserver getBusinessObserver();
  
  public abstract void onDynamicListGet(boolean paramBoolean, int paramInt);
  
  public abstract void onFollowPublicAccount(boolean paramBoolean, String paramString);
  
  public abstract void onUnfollowPublicAccount(boolean paramBoolean, String paramString);
  
  public abstract void onUpdate(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void setOnCallback(IPublicAccountObserver.OnCallback paramOnCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */