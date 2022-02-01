package com.tencent.biz.pubaccount.weishi_new.download.wsapp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class WSFallKeyPicMonitor$DownloadHandler
  extends Handler
{
  WeakReference<WSFallKeyPicMonitor> jdField_a_of_type_JavaLangRefWeakReference;
  
  WSFallKeyPicMonitor$DownloadHandler(WSFallKeyPicMonitor paramWSFallKeyPicMonitor1, WSFallKeyPicMonitor paramWSFallKeyPicMonitor2)
  {
    WSLog.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWSFallKeyPicMonitor2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    WSLog.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (WSFallKeyPicMonitor.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor) != 4) {
        break label46;
      }
      WSFallKeyPicMonitor.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor.b();
      return;
      label46:
      WSFallKeyPicMonitor.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor.DownloadHandler
 * JD-Core Version:    0.7.0.1
 */