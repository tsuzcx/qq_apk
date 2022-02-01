package com.tencent.biz.subscribe.utils;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import java.lang.ref.WeakReference;

class SubscribeFollowUserUtil$PublicAccountFollowObserver
  extends IPublicAccountObserver.OnCallback
{
  WeakReference<SubscribeFollowUserUtil.ResultListener> a;
  
  public SubscribeFollowUserUtil$PublicAccountFollowObserver(SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    this.a = new WeakReference(paramResultListener);
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    SubscribeFollowUserUtil.ResultListener localResultListener = (SubscribeFollowUserUtil.ResultListener)this.a.get();
    if (localResultListener != null) {
      localResultListener.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.PublicAccountFollowObserver
 * JD-Core Version:    0.7.0.1
 */