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
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed appRef==null");
      }
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      if (paramBoolean) {}
      try
      {
        paramBundle = (FromServiceMsg)paramBundle.getParcelable("KEY_FOR_AIO_STORY_FEED_DATA");
        if (paramBundle != null)
        {
          paramBundle = QzoneAioStoryFeedRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer()));
          if (paramBundle != null) {
            ChatActivityFacade.a((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBundle);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetNewestStoryFeed exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("UndealCount.QZoneObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed app == null || sessionInfo == nul");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.QZoneNewestAioStoryFeedObserver
 * JD-Core Version:    0.7.0.1
 */