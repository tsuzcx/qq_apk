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
  
  public void onGetQZoneNewestFeed(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed appRef==null");
      }
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed app == null || sessionInfo == nul");
    return;
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp))) {
      ChatActivityFacade.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (AIONewestFeedRsp)paramBundle, this.jdField_a_of_type_Boolean);
    }
    paramBundle = (QZoneNewestFeedObserver)ChatActivityFacade.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ChatActivityFacade.a().remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localQQAppInterface.unRegistObserver(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.QZoneNewestFeedObserver
 * JD-Core Version:    0.7.0.1
 */