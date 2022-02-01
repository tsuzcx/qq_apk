package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.FollowRet;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.GetUserFollowListRet;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class PublicAccountObserverImpl
  implements IPublicAccountObserver, BusinessObserver
{
  private IPublicAccountObserver.OnCallback mOnCallback;
  
  public BusinessObserver getBusinessObserver()
  {
    return this;
  }
  
  public void onDestroy()
  {
    IPublicAccountObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.onDestroy();
    }
  }
  
  public void onDynamicListGet(boolean paramBoolean, int paramInt)
  {
    IPublicAccountObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.onDynamicListGet(paramBoolean, paramInt);
    }
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    IPublicAccountObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.onFollowPublicAccount(paramBoolean, paramString);
    }
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    IPublicAccountObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.onUnfollowPublicAccount(paramBoolean, paramString);
    }
  }
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    IPublicAccountObserver.OnCallback localOnCallback;
    if (100 == paramInt)
    {
      paramObject = (IPublicAccountObserver.GetUserFollowListRet)paramObject;
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onUpdateUserFollowList(paramObject.a, paramObject.c);
      }
    }
    else if (101 == paramInt)
    {
      if ((paramObject instanceof IPublicAccountObserver.FollowRet))
      {
        paramObject = (IPublicAccountObserver.FollowRet)paramObject;
        localOnCallback = this.mOnCallback;
        if (localOnCallback != null) {
          localOnCallback.onFollowPublicAccount(paramObject.b, (PublicAccountInfo)paramObject.a);
        }
      }
      else if ((paramObject instanceof Integer))
      {
        localOnCallback = this.mOnCallback;
        if (localOnCallback != null) {
          localOnCallback.onFollowPublicAccount(paramBoolean, ((Integer)paramObject).intValue());
        }
      }
      else
      {
        localOnCallback = this.mOnCallback;
        if (localOnCallback != null) {
          localOnCallback.onFollowPublicAccount(paramBoolean, String.valueOf(paramObject));
        }
      }
    }
    else if (102 == paramInt)
    {
      if ((paramObject instanceof IPublicAccountObserver.FollowRet))
      {
        paramObject = (IPublicAccountObserver.FollowRet)paramObject;
        localOnCallback = this.mOnCallback;
        if (localOnCallback != null) {
          localOnCallback.onUnfollowPublicAccount(paramObject.b, (PublicAccountInfo)paramObject.a);
        }
      }
      else
      {
        localOnCallback = this.mOnCallback;
        if (localOnCallback != null) {
          localOnCallback.onUnfollowPublicAccount(paramBoolean, String.valueOf(paramObject));
        }
      }
    }
    else if (103 == paramInt)
    {
      paramObject = this.mOnCallback;
      if (paramObject != null) {
        paramObject.onDownPublicAccount();
      }
    }
    else if (104 == paramInt)
    {
      paramObject = this.mOnCallback;
      if (paramObject != null) {
        paramObject.onUpdateRecommendList(paramBoolean);
      }
    }
    else if (105 == paramInt)
    {
      paramInt = ((Integer)paramObject).intValue();
      paramObject = this.mOnCallback;
      if (paramObject != null) {
        paramObject.onGetHistoryMsgRet(paramInt);
      }
    }
    else if (106 == paramInt)
    {
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onPublicAccountNotification(paramBoolean, ((Boolean)paramObject).booleanValue());
      }
    }
    else if (109 == paramInt)
    {
      paramObject = (IPublicAccountConfigAttr.PaConfigInfo)paramObject;
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onUpdateFunctionFlag(paramBoolean, paramObject);
      }
    }
    else if (108 == paramInt)
    {
      paramObject = (HashMap)paramObject;
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onSetPublicAccountSubscribeStatus(paramBoolean, ((Integer)paramObject.get("seq")).intValue(), ((Long)paramObject.get("uin")).longValue());
      }
    }
    else if (110 == paramInt)
    {
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onGetGuideFriends(paramBoolean, (ArrayList)paramObject);
      }
    }
    else if (111 == paramInt)
    {
      paramObject = (HashMap)paramObject;
      long l = 0L;
      paramInt = 0;
      if (paramObject != null)
      {
        l = ((Long)paramObject.get("uin")).longValue();
        paramInt = ((Integer)paramObject.get("status")).intValue();
      }
      paramObject = this.mOnCallback;
      if (paramObject != null) {
        paramObject.onGetPublicAccountSubscribeStatus(paramBoolean, l, paramInt);
      }
    }
    else if ((112 == paramInt) && ((paramObject instanceof SetRecvMsgStateRsp)))
    {
      paramObject = (SetRecvMsgStateRsp)paramObject;
      localOnCallback = this.mOnCallback;
      if (localOnCallback != null) {
        localOnCallback.onSetRecvMsgState(paramBoolean, paramObject);
      }
    }
  }
  
  public void setOnCallback(IPublicAccountObserver.OnCallback paramOnCallback)
  {
    this.mOnCallback = paramOnCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl
 * JD-Core Version:    0.7.0.1
 */