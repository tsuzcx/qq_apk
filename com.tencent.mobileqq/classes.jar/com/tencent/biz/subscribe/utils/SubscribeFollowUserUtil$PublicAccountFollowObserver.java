package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.app.PublicAccountObserver;
import java.lang.ref.WeakReference;

class SubscribeFollowUserUtil$PublicAccountFollowObserver
  extends PublicAccountObserver
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.PublicAccountFollowObserver
 * JD-Core Version:    0.7.0.1
 */