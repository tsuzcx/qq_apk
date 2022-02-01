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
  public SessionInfo a;
  public WeakReference<QQAppInterface> a;
  public boolean a;
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed appRef==null");
      }
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp))) {
        ChatActivityFacade.a((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (AIONewestFeedRsp)paramBundle, this.jdField_a_of_type_Boolean);
      }
      paramBundle = (QZoneNewestFeedObserver)ChatActivityFacade.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ChatActivityFacade.a().remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((QQAppInterface)localObject).unRegistObserver(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed app == null || sessionInfo == nul");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.QZoneNewestFeedObserver
 * JD-Core Version:    0.7.0.1
 */