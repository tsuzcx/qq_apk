package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.biz.richframework.network.request.QzoneAioStoryFeedRequest;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ChatActivityFacade$QZoneNewestAioStoryFeedObserver
  extends QZoneObserver
{
  public SessionInfo a;
  public WeakReference<QQAppInterface> a;
  
  public void onGetNewestStoryFeed(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed appRef==null");
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
    QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed app == null || sessionInfo == nul");
    return;
    if (paramBoolean) {}
    try
    {
      paramBundle = (FromServiceMsg)paramBundle.getParcelable("KEY_FOR_AIO_STORY_FEED_DATA");
      if (paramBundle != null)
      {
        paramBundle = QzoneAioStoryFeedRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer()));
        if (paramBundle != null) {
          ChatActivityFacade.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBundle);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("UndealCount.QZoneObserver", 1, "call onGetNewestStoryFeed exception " + paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.QZoneNewestAioStoryFeedObserver
 * JD-Core Version:    0.7.0.1
 */