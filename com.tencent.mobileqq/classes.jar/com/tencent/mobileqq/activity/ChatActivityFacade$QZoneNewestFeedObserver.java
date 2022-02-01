package com.tencent.mobileqq.activity;

import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class ChatActivityFacade$QZoneNewestFeedObserver
  extends QZoneObserver
{
  public WeakReference<QQAppInterface> a;
  public SessionInfo b;
  public boolean c;
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed appRef==null");
      }
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if ((localObject != null) && (this.b != null))
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp))) {
        ChatActivityFacade.a((QQAppInterface)localObject, this.b, (AIONewestFeedRsp)paramBundle, this.c);
      }
      paramBundle = (QZoneNewestFeedObserver)ChatActivityFacade.b().get(this.b.b);
      ChatActivityFacade.b().remove(this.b.b);
      ((QQAppInterface)localObject).unRegistObserver(paramBundle);
      this.b = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed app == null || sessionInfo == nul");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.QZoneNewestFeedObserver
 * JD-Core Version:    0.7.0.1
 */